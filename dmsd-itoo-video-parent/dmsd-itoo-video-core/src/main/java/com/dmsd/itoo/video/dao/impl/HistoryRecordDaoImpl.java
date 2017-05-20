package com.dmsd.itoo.video.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dmsd.itoo.base.dao.hibernate.BaseHibernateDaoSupport;
import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.video.entity.History;
import com.dmsd.itoo.video.entity.Video;

/**
 * Created by 丁国华
 * @Date 2016年8月28日 11:10:21
 *
 */
@Repository("HistoryRecordDaoImpl")
public class HistoryRecordDaoImpl extends BaseHibernateDaoSupport<History> {
	/**
	 * 分页查询历史记录--丁国华--2016年8月31日 09:07:17
	 * @param pageEntity
	 * @param map1
	 * @param userId
	 * @return
	 */
public PageEntity<History> queryHistoryRecordInfo(PageEntity<History> pageEntity,String userId ){
		

		String hql="from History h where h.isDelete=0 and h.userID=:userID order by watchTime desc";
		pageEntity.setHql(hql);
		Map<Object,Object> map = new HashMap<>();
		map.put("userID", userId);
		pageEntity.setMap(map);
		PageEntity<History> listHistoryRecord = this.queryPageEntityByHql(pageEntity);		
		return listHistoryRecord;
	}

	/**
	 * 查询全部历史记录信息--丁国华--2016年8月28日 11:17:40
	 * @param userId
	 * @return
	 */

	public List<History>  queryAllMyHistoryRecordInfo(String userId){
		List<History> listAllMyHistoryRecordInfo = new ArrayList<History>();
		StringBuffer hql = new StringBuffer();
		hql.append("from History h where h.isDelete=0 and h.userID=:userID order by watchTime desc");
		Map<String,Object> map=new HashMap<>();
		map.put("userID",userId);
		 
		listAllMyHistoryRecordInfo=this.query(hql.toString(), map);
		return listAllMyHistoryRecordInfo;		
	}
	
	/**
	 * 插入历史记录
	 * @param history
	 */
	public void saveHistory(History history){
		this.saveOrUpdate(history);
	}
		

}
