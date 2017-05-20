package com.dmsd.itoo.video.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.video.dao.HistoryDao;
import com.dmsd.itoo.video.dao.impl.HistoryRecordDaoImpl;
import com.dmsd.itoo.video.entity.History;
import com.dmsd.itoo.video.entity.Video;
import com.dmsd.itoo.video.service.HistoryRecordService;

@Service("historyRecorderviceImpl")
@Transactional
public class HistoryRecordServiceImpl implements HistoryRecordService {
	
	@Autowired
	private HistoryRecordDaoImpl historyRecordDaoImpl;
	@Autowired
	private HistoryDao historyDao;
	/**
	 * 分页查询所有历史信息--丁国华--2016年8月28日 11:22:02
	 * @param pageEntity
	 * @param conditions
	 * @param userId
	 */
	@Override
	public PageEntity<History> queryHistoryRecordInfo(PageEntity<History> pageEntity, String userId) {
		PageEntity<History> list = new PageEntity<History>();		
		list=historyRecordDaoImpl.queryHistoryRecordInfo(pageEntity, userId);
		return list;
	}
	
	/**
	 * 查询全部历史记录信息--丁国华--2016年8月28日 11:23:36
	 * @param userId
	 */


	@Override
	public List<History> queryAllMyHistoryRecordInfo(String userId) {
		List<History> listAllHistoryRecordInfo= new ArrayList<History>();
		listAllHistoryRecordInfo = historyRecordDaoImpl.queryAllMyHistoryRecordInfo(userId);
		return listAllHistoryRecordInfo;
	
	}
	/**
	 * 根据用户id查询历史记录-王虹芸-2016年9月24日19:52:31
	 * @param userid
	 * @return
	 */
	@Override
	public List<History> queryHistoryRecord(String userid,Integer pageNum,Integer pageSize){
		
		List<History> historylist=historyDao.queryHistoryRecord(userid,pageNum, pageSize);
		return historylist;		
	}	
	/**
	 * 根据videoid删除历史记录-王虹芸-2016年9月23日20:36:47
	 * @param videoid
	 */
	public void deleteHistoryRecordByid(String userID,String videoid){
		historyDao.deleteHistoryRecordByid(userID,videoid);
	}
	/**
	 * 清除当前用户的所有的历史记录
	 */
	public void clearAllHistory(String userid){
		historyDao.clearAllHistory(userid);
	}
	/**
	 * 插入历史记录
	 */
	public void saveHistory(History history){
		historyRecordDaoImpl.saveHistory(history);
	}
}
