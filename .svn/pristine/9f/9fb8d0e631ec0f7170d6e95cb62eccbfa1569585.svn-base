package com.dmsd.itoo.video.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dmsd.itoo.video.entity.History;


@Repository("historyDao")
public interface HistoryDao {
	/*
	 * 根据视频id删除历史记录
	 */
	void deleteHistoryRecordByid(String userID,String videoid);
	/**
	 * 根据用户id查询历史记录
	 * @param userid
	 * @return
	 */
	List<History> queryHistoryRecord(String userid,Integer pageNum,Integer pageSize);
	/**
	 * 清除当前用户的所有的历史记录
	 */
	void clearAllHistory(String userid);	
}
