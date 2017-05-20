package com.dmsd.itoo.video.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmsd.itoo.video.dao.UserInfoDao;
import com.dmsd.itoo.video.dao.impl.UserInfoDaoImpl;
import com.dmsd.itoo.video.dto.UserInfo;
import com.dmsd.itoo.video.entity.Address;
import com.dmsd.itoo.video.entity.Personal;
import com.dmsd.itoo.video.service.UserInfoService;

/**
 * 用户信息类
 * @author 王荣晓
 *
 */
@Service("userInfoServcieImpl")
@Transactional
public class UserInfoServcieImpl implements UserInfoService {

	 @Autowired
	 UserInfoDao userInfoDao;
	 

	 @Autowired
	 UserInfoDaoImpl userInfoDaoImpl;
	
	/**
	 * 根据用户id查询用户信息 + 王荣晓 + 2016-9-27 16:36:50
	 * @param userId
	 * @param request
	 * @param response
	 */
	public List<UserInfo> checkUserInfo(String userId){
		List<UserInfo> listUserInfo = userInfoDao.checkUserInfo(userId);
		return listUserInfo;
	}
	
	/**
	 * 根据学院id查询学院名称 + 王荣晓 + 2016-9-27 19:36:33
	 * @param colleagueId
	 * @return
	 */
	public List<UserInfo> checkUserColleague(String colleagueId){
		List<UserInfo> listColleague = userInfoDao.checkUserColleague(colleagueId);
		return listColleague;
	}
	
	/**
	 * 插入用户信息    hibernate方式
	 *//*
	public void insertUserInfo(Personal personal, Map<String, Object> map) throws SQLException{
		userInfoDaoImpl.insertUserInfo(personal, map);
	}*/
	
	/**
	 * 插入用户信息    mybtis方式
	 */
	public void insertUserInfo(Personal personal, Map<String, Object> map) throws SQLException{
		String userID=personal.getUserID();
		String userName=personal.getUserName();
//		Integer id = Integer.parseInt( personal.getUserID());
		String id = personal.getUserID();
		map.put("userID", userID);
		map.put("userName", userName);
		map.put("id", id);
		
		userInfoDao.insertUserInfo(map);
	}
	
	/**
	 * 根据登录账号在视频系统的address表中查询用户信息 - 王荣晓 - 2016-10-2 16:07:13
	 */
	public List<Address> queryUserInfo(String userId){
		List<Address> listUserInfo = new ArrayList<Address>();
		listUserInfo=userInfoDao.queryUserInfo(userId);
		
		return listUserInfo;
	}
	
	/**
	 * 在personal表中查询所登录用户名 - 王荣晓 - 2016-10-2 17:19:33
	 */
	public List<Personal> queryUserInfoIsExist(String userId){
		List<Personal> listPersonal=new ArrayList<Personal>();
		listPersonal=userInfoDao.queryUserInfoIsExist(userId);
		return listPersonal;
	}
}
