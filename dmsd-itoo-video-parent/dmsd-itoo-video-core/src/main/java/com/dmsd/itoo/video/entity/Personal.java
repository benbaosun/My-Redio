package com.dmsd.itoo.video.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.dmsd.itoo.base.entity.TimeBaseEntity;

/**
 * 个人实体相关内容--丁国华--2016年9月25日 15:02:06
 * @author 丁国华
 *
 */
@Entity
@Table(name = "tv_personal")
@Cacheable
public class Personal extends TimeBaseEntity {

	private String userID;
	private String userName;
	private String nickName;
	private String email;
	private String phoneNum;
	private String headPicture;
	
	@Column(name = "userID", unique = true, nullable = false, length = 22)
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	@Column(name = "userName")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "nickName")
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	

	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "phoneNum")
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	@Column(name = "headPicture")
	public String getHeadPicture() {
		return headPicture;
	}
	public void setHeadPicture(String headPicture) {
		this.headPicture = headPicture;
	}
	
	
	
	
}
