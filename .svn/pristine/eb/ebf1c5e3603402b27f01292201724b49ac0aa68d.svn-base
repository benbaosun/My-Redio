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
 * Created by 丁国华
 *
 * @Date 2016年8月20日 16:27:52
 */
@Repository("myVideoDaoImpl")
public class MyVideoDaoImpl extends BaseHibernateDaoSupport<Video>{
	
	/**
	 * 分页查询--丁国华--2016年8月20日 16:39:12
	 * @param pageEntity
	 * @param map1
	 * @param userId
	 * @return
	 */
	
	public PageEntity<Video> queryMyVideoInfo(PageEntity<Video> pageEntity, Map<String, String> map1,String userId ){
		
		//分页查询全部
		StringBuffer hql = new StringBuffer();
		hql.append("from Video v where v.isDelete=0 and v.userID=:userID order by uploadTime desc");
		pageEntity.setHql(hql.toString());
		Map<Object,Object> map=new HashMap();
		map.put("userID", userId);
		pageEntity.setMap(map);
		PageEntity<Video> listMyVideo = this.queryPageEntityByHql(pageEntity);		
		return listMyVideo;
	}
	
	
	
	/**
	 * 删除视频信息-丁国华--2016年8月21日 20:22:03
	 * @param ids
	 */
	public void deleteMyVideoInfo(String videoid){
		
		this.delete(videoid);
		
	}
	
	/**
	 * 查询全部--丁国华--2016年8月22日 14:41:27
	 * @param userId
	 * @return
	 */
	
	public List<Video>  queryAllMyVideoInfo(String userId){
		List<Video> listAllMyVideoInfo = new ArrayList<Video>();
		StringBuffer hql = new StringBuffer();
		hql.append("from Video v where v.isDelete=0 and v.userID=:userID order by uploadTime desc");
		Map<String,Object> map=new HashMap<>();
		map.put("userID",userId);		
		listAllMyVideoInfo=this.query(hql.toString(), map);
		return listAllMyVideoInfo;		
	}
	/**
	 * 根据id查询相关视频-丁国华--2016年8月27日 20:12:49
	 * @param id
	 * @return
	 */
	public List<Video> queryVideoInfoById(String id){
		List<Video> listQueryVideoInfoById = new ArrayList<Video>();
		StringBuffer hql = new StringBuffer();
		hql.append("from Video v where v.isDelete = 0 and v.id=:id");
		Map<String,Object> map = new HashMap<>();
		map.put("id",id);
		listQueryVideoInfoById = this.query(hql.toString(), map);
		return listQueryVideoInfoById;
	}
	
	/**
	 * 根据videoType分页查询查询相关视频
	 * @param pageEntity
	 * @param map1
	 * @param videoType
	 * @return
	 */
	public PageEntity<Video> queryVideoInfoByVideoType(PageEntity<Video>pageEntity,Map<String,String>map1,String videoType){
		//分页查询全部信息
		StringBuffer hql = new StringBuffer();
		hql.append("from Video v where v.isDelete = 0 and v.videoType=:videoType order by uploadTime asc");
		pageEntity.setHql(hql.toString());
		Map<Object,Object>map = new HashMap();
		map.put("videoType", videoType);
		pageEntity.setMap(map);
		PageEntity<Video>listQueryVideoInfoByVideoType = this.queryPageEntityByHql(pageEntity);
		return listQueryVideoInfoByVideoType;
	}
	
}

