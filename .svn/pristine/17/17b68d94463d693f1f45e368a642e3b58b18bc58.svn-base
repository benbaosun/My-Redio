package com.dmsd.itoo.video.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dmsd.itoo.video.dto.UserInfo;
import com.dmsd.itoo.video.entity.Address;
import com.dmsd.itoo.video.entity.Personal;

/**
 * 用户信息
 * @author 王荣晓
 *
 */
public interface UserInfoService {
	
	/**
	 * 根据用户id查询用户信息 + 王荣晓 + 2016年9月27日16:35:56
	 * @param userId
	 * @param request
	 * @param response
	 * @return
	 */
	List<UserInfo> checkUserInfo(String userId);
	
	/**
	 * 根据学院id查询学院名称 + 王荣晓 + 2016-9-27 19:35:50
	 * @param colleagueId
	 * @return
	 */
	List<UserInfo> checkUserColleague(String colleagueId);
	
	/**
	 * 将新登录的用户插入到视频库的个人表中 - 王荣晓 - 2016-10-2 10:22:58
	 * @param personal
	 * @param map
	 * @throws SQLException
	 */
	void insertUserInfo(Personal personal, Map<String, Object> map) throws SQLException;
	
	/**
	 * 根据登录账号在视频系统的address表中查询用户信息 - 王荣晓 - 2016-10-2 16:07:13
	 * @param userId
	 * @return
	 */
	List<Address> queryUserInfo(String userId);
	
	/**
	 * 在personal表中查询所登录用户名 - 王荣晓 - 2016-10-2 17:19:33
	 * @param userId
	 * @return
	 */
	List<Personal> queryUserInfoIsExist(String userId);
}
