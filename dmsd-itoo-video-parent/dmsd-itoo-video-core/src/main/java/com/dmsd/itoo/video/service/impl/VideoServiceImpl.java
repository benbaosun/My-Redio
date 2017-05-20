package com.dmsd.itoo.video.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.video.dao.VideoDao;
import com.dmsd.itoo.video.dao.impl.VideoDaoImpl;
import com.dmsd.itoo.video.dto.ColleagueInfo;
import com.dmsd.itoo.video.dto.Videodto;
import com.dmsd.itoo.video.entity.Video;
import com.dmsd.itoo.video.service.VideoService;

/**
 * Created by 徐露
 *
 * @Date 2016/8/11 7:43
 */
@Service("videoService")
@Transactional
public class VideoServiceImpl implements VideoService{

	 @Autowired
	 VideoDao videoDao;

	 @Autowired
	 VideoDaoImpl videoDaoImpl;

	 /**
	  * 根据查询条件分页查询视频信息 + 王荣晓 + 2016-8-24 21:35:40
	  */
	 @Override
	 public PageEntity<Video> queryCollegeVideoInfo(PageEntity pageEntity,String querytxt,String collegename) {
		 //List<Video> videoList =videoDaoImpl.doSearch(pageEntity,map,DataBaseName);
		 pageEntity=videoDaoImpl.queryCollegeVideoInfo(pageEntity,querytxt,collegename);
		 
	     return pageEntity;
	  }
	 
	 /**
	  * 登录后的首页中的“实战推荐”内容加载 + 王荣晓 + 2016年8月25日11:50:53
	  */
	 public List<Videodto> findRecommended(String colleagueName){
//		 HashMap<String,Object> hashmap=new HashMap<String,Object>();
//		 hashmap.put("videoType",videoEntity.getVideoType()==null?"物理与电子信息学院":videoEntity.getVideoType().toString());
	     
		 List<Videodto> listVideo=videoDao.findRecommended(colleagueName);
		 return listVideo;
	 }

	 /**
	  * 扩展学习首页面加载，查询登录学生所在学院的所有视频 + 王荣晓 + 2016年8月27日17:53:15
	  */
	 public List<Video> allvideoincollege(Video videoEntity, Map<String, Object> map,String collegename){
		 List<Video> listvideo=videoDaoImpl.allvideoincollege(videoEntity,map,collegename);
		 return listvideo;
	 }
	 
	 
	 /**
	  * 调用基础表查询所有学院
	  */
	 public List<ColleagueInfo> findAllColleague(){
		 List<ColleagueInfo> listColleague=videoDao.findAllColleague();
		 return listColleague;
	 }
	 
	 /**
	  * 徐露师姐写的方法，暂未使用
	  */
	 @Override
	 public List<Video> queryInstitutionShowItems(String institutionName) {

	     String hql = "FROM Video WHERE videoType=:institutionName and isDelete=0";
	     Map<String, Object> map = new HashMap<>();
	     map.put("videoType", "建工学院");
	     map.put("isDelete", "0");
	     List<Video> videoList = videoDaoImpl.query(hql, map);
	     return videoList;
	 }
	 /**
	  * 根据videoid查询视频信息-王虹芸-2016年9月26日17:44:49
	  */
	 @Override
	 public List<Video> findVideoInfobyid(String videoid){
		 List<Video> listVideo=videoDao.findVideoInfobyid(videoid);
		 return listVideo;
	 }
}
