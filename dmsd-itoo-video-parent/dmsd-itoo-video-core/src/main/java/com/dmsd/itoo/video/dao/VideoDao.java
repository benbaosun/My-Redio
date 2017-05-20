package com.dmsd.itoo.video.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dmsd.itoo.video.dto.ColleagueInfo;
import com.dmsd.itoo.video.dto.Videodto;
import com.dmsd.itoo.video.entity.PageEntity;
import com.dmsd.itoo.video.entity.Video;

/**
 * Created by 徐露
 *
 * @Date 2016/8/117:37
 */
@Repository("videoDao")
public interface VideoDao {
	/**
	 * 根据查询条件分页查询视频信息 + 王荣晓 + 2016-8-24 21:35:40
	 * @param pageEntity
	 * @param map
	 * @param DataBaseName
	 * @return
	 */
	PageEntity<Video> queryCollegeVideoInfo(PageEntity pageEntity,String collegename);
	
	/**
	 * 登录后的首页中的“实战推荐”内容加载 + 王荣晓 + 2016年8月25日11:50:53
	 * @param map
	 * @return
	 */
	List<Videodto> findRecommended(String colleagueName);
	
	/**
	 * 扩展学习首页面加载，查询登录学生所在学院的所有视频 + 王荣晓 + 2016年8月27日17:53:15
	 * @param videoEntity
	 * @param map
	 * @return
	 */
	List<Video> allvideoincollege(Video videoEntity, Map<String, Object> map,String querytxt,String collegename);
	/**
	 * 根据videoid查询商品信息
	 * @param videoid
	 * @return
	 */
	List<Video> findVideoInfobyid(String videoid);
	/**
	 * 调用基础表查询所有学院
	 * @return
	 */
	List<ColleagueInfo> findAllColleague();
}
