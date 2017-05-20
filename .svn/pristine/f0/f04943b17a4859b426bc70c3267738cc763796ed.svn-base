package com.dmsd.itoo.video.entity;

import com.dmsd.itoo.base.entity.TimeBaseEntity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by 徐露
 *
 * @Date 2016/8/116:35
 */
@Entity
@Table(name="tv_history")
@Cacheable
public class History extends TimeBaseEntity {


    private String userID;
    private String videoID;
    private String watchAcount;
    private Date watchTime;
    private String picturePath;
    



	@Column(name = "userID", unique = true, nullable = false, length = 22)
    public String getUserID() {
        return this.userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Column(name="videoID")
    public  String getVideoID(){
        return  this.videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    @Column(name = "watchAcount")
    public String getWatchAcount(){
        return this.watchAcount;
    }

    public void setWatchAcount(String watchAcount) {
        this.watchAcount = watchAcount;
    }

    @Column(name="watchTime")
    public Date getWatchTime(){
        return  this.watchTime;
    }

    public void setWatchTime(Date watchTime) {
        this.watchTime = watchTime;
    }
    
    
    
    @Column(name="picturePath")
    public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
}
