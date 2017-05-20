package com.dmsd.itoo.video.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dmsd.itoo.base.dao.hibernate.BaseHibernateDaoSupport;
import com.dmsd.itoo.video.entity.Address;
import com.dmsd.itoo.video.entity.Personal;

/**
 * 插入基礎查詢的數據 - 王榮曉 - 2016-9-28 20:32:51
 * @author wrx
 *
 */
@Repository("UserInfoDaoImpl")
public class UserInfoDaoImpl extends BaseHibernateDaoSupport<Personal>{
	
	/**
	 * 将新登录的用户插入到视频库的个人表中 - 王荣晓 - 2016-10-2 10:22:58
	 * @param personal
	 * @param map
	 * @throws SQLException
	 */
	public void insertUserInfo(Personal personal, Map<String, Object> map) throws SQLException{
		this.save(personal);
		
	}
	
	public List<Address> queryUserInfo(String userId){
		
		return null;
	}
}
