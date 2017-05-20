package com.dmsd.itoo.video.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.video.entity.Video;

public interface MyVideoService {


	/**
	 * 分页查询--丁国华--2016年8月20日 16:39:12
	 * @param pageEntity
	 * @param conditions
	 * @param id
	 */
	public PageEntity<Video> queryMyVideoInfo(PageEntity<Video> pageEntity,String conditions,String id);

	
	
	/**
	 *  删除视频信息-丁国华--2016年8月21日 20:22:03
	 * @param ids
	 */
	public void deleteMyVideoInfo(String videoid);
	

	/**
	 * 查询全部--丁国华--2016年8月22日 15:18:33
	 * @param id
	 */
	public List<Video>  queryAllMyVideoInfo(String id);
	
	
	/**
	 * 根据id查询相关视频--丁国华--2016年8月27日 20:36:32
	 * @param id
	 */
	public List<Video> queryVideoInfoById(String id);
	
	
	/**
	 * 根据videoType分页查询查询相关视频--丁国华--2016年9月23日 14:57:53
	 * @param pageEntity
	 * @param conditions
	 * @param videoType
	 * @return
	 */
	public PageEntity<Video> queryVideoInfoByVideoType(PageEntity<Video>pageEntity,String conditions,String videoType);

}


