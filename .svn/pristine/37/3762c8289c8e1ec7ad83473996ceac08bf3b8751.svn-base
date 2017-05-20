package com.dmsd.itoo.video.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.video.entity.History;
import com.dmsd.itoo.video.entity.Video;

public interface HistoryRecordService {
	

	/**
	 * 分页查询所有历史信息--丁国华--2016年8月28日 11:22:02
	 * @param pageEntity
	 * @param conditions
	 * @param userId
	 */
	public PageEntity<History> queryHistoryRecordInfo(PageEntity<History> pageEntity,String userId );

	/**
	 * 查询全部历史记录信息--丁国华--2016年8月28日 11:23:36
	 * @param userId
	 */

	public List<History>  queryAllMyHistoryRecordInfo(String userId);
	/**
	 * 根据videoid删除历史记录-王虹芸-2016年9月23日20:36:47
	 * @param videoid
	 */
	public void deleteHistoryRecordByid(String userid,String videoid);
	/**
	 * 根据用户id查询历史记录
	 * @param userid	
	 */
	public List<History>  queryHistoryRecord(String userid,Integer pageNum,Integer pageSize);
	/**
	 * 清除当前用户的所有的历史记录
	 */
	public void clearAllHistory(String userid);
	/**
	 * 插入历史记录
	 */
	public void saveHistory(History history);
}
