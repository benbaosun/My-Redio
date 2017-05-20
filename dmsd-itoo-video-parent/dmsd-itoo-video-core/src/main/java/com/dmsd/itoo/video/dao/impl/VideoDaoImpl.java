package com.dmsd.itoo.video.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dmsd.itoo.base.dao.hibernate.BaseHibernateDaoSupport;
import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.video.entity.Video;

/**
 * Created by 徐露
 *
 * @Date 2016/8/117:39
 */
@Repository("videoDaoImpl")
public class VideoDaoImpl extends BaseHibernateDaoSupport<Video> {

	/**
	 * 根据查询条件分页查询视频信息 + 王荣晓 + 2016-8-24 21:35:40
	 * @param pageEntity  分页实体
	 * @param querytxt  查询条件
	 * @param collegename  未使用
	 * @return
	 */
	public PageEntity<Video> queryCollegeVideoInfo(PageEntity pageEntity,String querytxt,String collegename) {
		StringBuffer hql = new StringBuffer();
		hql.append("from Video v where v.isDelete=0 and v.videoType=:videoType order by uploadTime desc");
		
		Map<Object, Object> map = new HashMap<>();
		map.put("videoType", querytxt);
		//map.put("videoName","物理与电子信息学院");
		
		pageEntity.setHql(hql.toString());
		pageEntity.setMap(map);
		
		PageEntity<Video> querypageEntity=new PageEntity<Video>();
		querypageEntity=this.queryPageEntityByHql(pageEntity);
		
		return querypageEntity;
	}
	
	
	//改用mybatis
	/**
	 * 登录后的首页中的“实战推荐”内容加载 + 王荣晓 + 2016年8月25日11:54:33
	 */
	/*public List<Video> findRecommended(Video videoEntity,Map<String, Object> map){
		String hql = "FROM Video WHERE videoType=:videoType and isDelete=0";
		map.put("videoType", "建工学院");
		List<Video> listVideo=new ArrayList<Video>();
		listVideo=  this.query(hql, map);
		
		return listVideo;
	}*/
	
	/**
	 * 扩展学习首页面加载，查询登录学生所在学院的所有视频 + 王荣晓 + 2016年8月27日17:39:11
	 * @param videoEntity
	 * @param map
	 * @return
	 */
	public List<Video> allvideoincollege(Video videoEntity, Map<String, Object> map,String collegename){
		String hql = "FROM Video WHERE videoType=:videoType and isDelete=0";
				map.put("videoType",collegename);
		List<Video> videolist = new ArrayList<Video>();
		
		return videolist = this.query(hql, map);
	}
}
