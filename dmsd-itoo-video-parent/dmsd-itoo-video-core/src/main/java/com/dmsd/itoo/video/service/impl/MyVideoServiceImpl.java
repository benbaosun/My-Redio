package com.dmsd.itoo.video.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.video.dao.impl.MyVideoDaoImpl;
import com.dmsd.itoo.video.entity.Video;
import com.dmsd.itoo.video.service.MyVideoService;


@Service("myVideoServiceImpl")
@Transactional
public class MyVideoServiceImpl implements MyVideoService {
	
	@Autowired
	private MyVideoDaoImpl myVideoDaoImpl;
	
	/**
	 * 分页查询--丁国华--2016年8月20日 16:39:12
	 * @param pageEntity
	 * @param conditions
	 * @param id
	 */
	@Override
	public PageEntity<Video> queryMyVideoInfo(PageEntity<Video> pageEntity,String conditions,String id) {
		PageEntity<Video> list = new PageEntity<Video>();
		Map<String,String> map = new HashMap();
		map.put("conditions", conditions);
		list=myVideoDaoImpl.queryMyVideoInfo(pageEntity, map,id);
		return list;
	}


	/**
	 *  删除视频信息-丁国华--2016年8月21日 20:22:03
	 * @param ids
	 */

	@Override
	public void deleteMyVideoInfo(String videoid) {
		
		myVideoDaoImpl.deleteMyVideoInfo(videoid);
	}


	/**
	 * 查询全部--丁国华--2016年8月22日 15:18:33
	 * @param id
	 */
	@Override
	public List<Video> queryAllMyVideoInfo(String userId) {
		
		List<Video> listAllMyVideoInfo = new ArrayList<Video>();
		listAllMyVideoInfo=myVideoDaoImpl.queryAllMyVideoInfo(userId);
		return listAllMyVideoInfo;
	}

	/**
	 * 根据id查询相关视频--丁国华--2016年8月27日 20:36:32
	 * @param id
	 */
	@Override
	public List<Video> queryVideoInfoById(String id) {
		List<Video> listQueryVideoInfoById = new ArrayList<Video>();
		listQueryVideoInfoById = myVideoDaoImpl.queryVideoInfoById(id);
		return listQueryVideoInfoById;
	}

	/**
	 * 根据videoType分页查询查询相关视频--丁国华--2016年9月23日 14:57:53
	 * @param pageEntity
	 * @param conditions
	 * @param videoType
	 * @return
	 */
	@Override
	public PageEntity<Video> queryVideoInfoByVideoType(PageEntity<Video> pageEntity, String conditions, String videoType) {
		PageEntity<Video>list = new PageEntity<Video>();
		Map<String,String>map = new HashMap();
		map.put("conditions", conditions);
		list=myVideoDaoImpl.queryVideoInfoByVideoType(pageEntity, map, videoType);
		return list;
	}


	

	
	


	



	
	
	

}
