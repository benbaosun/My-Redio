package com.dmsd.itoo.video.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dmsd.itoo.tool.tojson.JacksonJsonUntil;
import com.dmsd.itoo.video.entity.Address;
import com.dmsd.itoo.video.entity.Personal;
import com.dmsd.itoo.video.service.PersonalCenterService;
import com.dmsd.itoo.video.service.UserInfoService;

/**
 * 
 * @author wrx
 *
 */

@RequestMapping("/userInfo")
@Controller
public class UserInfoController {

	 @Autowired
	 private UserInfoService userInfoService;
	 
	 @Autowired
	 PersonalCenterService personalCenterService;
	 
	 @RequestMapping(value={"/login"})
	 public String login(){
		 return "login";
	 }
	  
	 
	 // 暂时不用，添加是注释  调用基础表，查询用户基本信息和学院 - 王荣晓 - 2016-10-2 10:26:11
/*	 *//**
	  * 根据用户id查询用户信息
	  * @param userId
	  * @param request
	  * @param response
	  *//*
	 @RequestMapping(value="/checkUserInfo",method = RequestMethod.POST)
	 public void checkUserInfo(String userId,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		JacksonJsonUntil jacksonJsonUntil = new JacksonJsonUntil();
	
		List<UserInfo> listUserInfo = new ArrayList<UserInfo>();
		
		//切库，查询基础表
    	MyDataSource.setDefineBeans(new DatabaseDefineBean("jdbc:mysql://192.168.22.181:8066/itoo_basic", "video", "video"));
    	
		listUserInfo = userInfoService.checkUserInfo(userId);
		
		//切库，切回视频库
   	    MyDataSource.setDefineBeans(new DatabaseDefineBean("jdbc:mysql://192.168.22.181:8066/itoo_video", "video", "video"));
   	
		//將查詢到的用戶信息存放到session中
		HttpSession session = request.getSession();
		session.setAttribute("userName",listUserInfo.get(0).getName());
		session.setAttribute("colleagueId",listUserInfo.get(0).getInstitutionId());
		
		//将用户名放在cookie中，在js中获取
		Cookie cookie=new Cookie(listUserInfo.get(0).getName(), "userName"); 
		cookie.setMaxAge(10);   //存活期为10秒 
		response.addCookie(cookie); 
		
		session.setAttribute("userId",userId);
//		model.addAttribute("userName", listUserInfo.get(0).getName());
		
	    jacksonJsonUntil.beanToJson(response, listUserInfo);
	 }
	 
	 *//**
	  * 根據學院id查詢學院名稱 - 王榮曉 - 2016-9-28 20:40:00
	  * @param colleagueId
	  * @param request
	  * @param response
	  *//*
	 @RequestMapping(value="/checkUserColleague",method = RequestMethod.POST)
	 public void checkUserColleague(HttpServletRequest request,HttpServletResponse response){
		 JacksonJsonUntil jacksonJsonUntil = new JacksonJsonUntil();
		 HttpSession session = request.getSession();
		 String colleagueId=session.getAttribute("colleagueId").toString();
		 //切库，查询基础表
    	 MyDataSource.setDefineBeans(new DatabaseDefineBean("jdbc:mysql://192.168.22.181:8066/itoo_basic", "video", "video"));
   
    	 List<UserInfo> listColleague = userInfoService.checkUserColleague(colleagueId);

    	//切库，切回视频库
    	 MyDataSource.setDefineBeans(new DatabaseDefineBean("jdbc:mysql://192.168.22.181:8066/itoo_video", "video", "video"));
    	
 		 
 		 session.setAttribute("colleagueName",listColleague.get(0).getRemark());
		 jacksonJsonUntil.beanToJson(response, listColleague);
	 }*/
	
/*	 
	 *//**
	  * 将新用户信息插入video的用户表,此方法查询的基础表的信息 - 王荣晓 - 2016-10-2 11:28:35
	  * @param userID
	  * @param map
	  * @param request
	  * @param response
	  * @throws SQLException
	  *//*
	 @RequestMapping(value="/insertUserInfo",method = RequestMethod.POST)
	 public void insertUserInfo(String userID, Map<String, Object> map,HttpServletRequest request,HttpServletResponse response) throws SQLException{
//		 JacksonJsonUntil jacksonJsonUntil = new JacksonJsonUntil();

		 HttpSession session = request.getSession();
		 String userName=session.getAttribute("userName").toString();
		 Personal personal=new Personal();
		 personal.setUserID(userID);
		 personal.setUserName(userName);
		  
//		//切库，查询视频表
//    	 MyDataSource.setDefineBeans(new DatabaseDefineBean("jdbc:mysql://192.168.22.181:8066/itoo_video", "video", "video"));
    	
		 userInfoService.insertUserInfo(personal, map);
//		 jacksonJsonUntil.beanToJson(response, personal);
	 }*/
	 
	 /**
	  * 在personal表中查询所登录用户名 - 王荣晓 - 2016-10-2 17:19:33
	  * @param userId
	  * @param request
	  * @param response
	  */
	 @RequestMapping(value="/queryUserInfoIsExist",method = RequestMethod.POST)
	public void queryUserInfoIsExist(String userId,HttpServletRequest request,HttpServletResponse response){
		JacksonJsonUntil jacksonJsonUntil = new JacksonJsonUntil();
		 List<Personal> listPersonal = new ArrayList<Personal>();
		 
		 listPersonal=userInfoService.queryUserInfoIsExist(userId);
		 
		 jacksonJsonUntil.beanToJson(response, listPersonal);
	}
	 
	 
	/**
	  * 将新用户信息插入video的用户表,此方法查询的基础表的信息 - 王荣晓 - 2016-10-2 11:28:35
	  * @param userID
	  * @param map
	  * @param request
	  * @param response
	  * @throws SQLException
	  */
	 @RequestMapping(value="/insertUserInfo",method = RequestMethod.POST)
	 public void insertUserInfo( Map<String, Object> map,HttpServletRequest request,HttpServletResponse response) throws SQLException{
		 HttpSession session = request.getSession();
		 
		 //从session中获取登录用户的用户名和用户姓名
		 String userName=session.getAttribute("userName").toString();
		 String userID=session.getAttribute("userId").toString();
		 
		 
		 Personal personal=new Personal();
		 personal.setUserID(userID);
		 personal.setUserName(userName);
	
		 userInfoService.insertUserInfo(personal, map);
	 }
	 
	 /**
	  * 在视频系统的address表中查询登录用户信息 - 王荣晓 - 2016-10-2 11:25:42
	  * @param userId
	  * @param request
	  * @param response
	  */
	 @RequestMapping(value="/queryUserInfo",method = RequestMethod.POST)
	 public void queryUserInfo(String userId,HttpServletRequest request,HttpServletResponse response){
		 JacksonJsonUntil jacksonJsonUntil = new JacksonJsonUntil();
		 List<Address> listUserInfo = new ArrayList<Address>();
		 
		 listUserInfo=userInfoService.queryUserInfo(userId);
		 
		 if(listUserInfo.size() != 0){
			//將查詢到的用戶信息存放到session中
			 HttpSession session = request.getSession();
			 session.setAttribute("userName",listUserInfo.get(0).getName());
			 session.setAttribute("userId",userId);
			 session.setAttribute("colleagueName", "提高班之家");
		 }
		 
		 jacksonJsonUntil.beanToJson(response, listUserInfo);
	 }
	 
	 /**
	  * 根据用户id查询用户头像 - 王荣晓 - 2016-10-2 22:23:21
	  * @param userId
	  * @param request
	  * @param response
	  */
	 @RequestMapping(value="/queryUserPicture",method = RequestMethod.POST)
	 public void queryUserPicture(String userId,HttpServletRequest request,HttpServletResponse response){
		 JacksonJsonUntil jacksonJsonUntil = new JacksonJsonUntil();
		 List<Personal> listPersonal = new ArrayList<Personal>();
		 HttpSession session = request.getSession();
		
		 listPersonal=personalCenterService.queryPersionInfo(userId);
		 if(listPersonal.get(0).getHeadPicture()==null){
			 listPersonal.get(0).setHeadPicture("/dmsd-itoo-video-web/images/rose.jpg");
		 }
		 session.setAttribute("loginPic",listPersonal.get(0).getHeadPicture());
		 jacksonJsonUntil.beanToJson(response, listPersonal);
	 }
}
