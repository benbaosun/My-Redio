package com.dmsd.itoo.video.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dmsd.itoo.video.dto.UserInfo;
import com.dmsd.itoo.video.entity.Address;
import com.dmsd.itoo.video.entity.Personal;

/**
 * 用户信息类
 * @author 王荣晓
 *
 */
@Repository("userInfoDao")
public interface UserInfoDao {

	/**
	 * 根据用户id查询用户信息 + 王荣晓 + 2016年9月27日16:36:19
	 * @param userId
	 * @return
	 */
	List<UserInfo> checkUserInfo(String userId);
	
	/**
	 * 根据学院id查询用户学院 + 王荣晓 + 2016年9月27日19:36:14
	 * @param colleagueId
	 * @return
	 */
	List<UserInfo> checkUserColleague(String colleagueId);
	
	/**
	 * 插入用户信息    mybtis方式
	 * @param personal
	 * @param map
	 */
	void insertUserInfo(Map<String, Object> map);
	
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
