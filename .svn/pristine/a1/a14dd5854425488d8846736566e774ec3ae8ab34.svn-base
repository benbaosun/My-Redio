package com.dmsd.itoo.video.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dmsd.itoo.base.dao.hibernate.BaseHibernateDaoSupport;
import com.dmsd.itoo.video.entity.Personal;
import com.dmsd.itoo.video.entity.Video;

/**
 * 个人中心的dao层--丁国华--2016年9月25日 15:37:56
 *
 */

@Repository("PersonalCenterDaoImpl")
public class PersonalCenterDaoImpl extends BaseHibernateDaoSupport<Personal> {

	/**
	 * 保存个人中心的相关个人信息--丁国华--2016年9月25日 15:43:56
	 * @param personal
	 */
	public void savePersonalInfo(Personal personal){
		this.update(personal);
	}
	
	/**
	 * 查询个人中心信息-王虹芸-2016年9月28日17:24:34
	 * @param userId
	 * @return
	 */
	public List<Personal> queryPersionInfo(String userId){		
		String hql="from Personal p where p.userID=:userID";
		Map<String,Object> map=new HashMap<>();
		map.put("userID",userId);
		List<Personal> personallist = new ArrayList<Personal>();		
		personallist=this.query(hql, map);
		return personallist;	
	}
	
}
