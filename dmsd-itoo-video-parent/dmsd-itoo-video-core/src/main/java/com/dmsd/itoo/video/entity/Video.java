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
 * @Date 2016/8/116:44
 */
@Entity
@Table(name = "tv_video")
@Cacheable
public class Video extends TimeBaseEntity {


    private String userID;
    private String userName;
    private String documentID;
    private String videoName;
    private String videoPath;
    private String videoSize;
    private Date videoTime;
    private Date uploadTime;   
	private String videoType;
    private String videoDesc;
    private String documentName;
    private String documentPath;
    private String picturePath;

	@Column(name = "userID", unique = true, nullable = false, length = 22)
    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Column(name = "userName")
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "documentID")
    public String getDocumentID() {
        return this.documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    @Column(name="videoName")
    public String getVideoName(){
        return this.videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }


    @Column(name = "videoPath")
    public String getVideoPath(){
        return this.videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    @Column(name="videoSize")
    public String getVideoSize(){
        return this.videoSize;
    }

    public void setVideoSize(String videoSize) {
        this.videoSize = videoSize;
    }

    @Column(name="videoTime")
    public Date getVideoTime(){
        return this.videoTime;
    }

    public void setVideoTime(Date videoTime) {
        this.videoTime = videoTime;
    }

    @Column(name = "uploadTime")
    public Date getUploadTime(){
        return this.uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Column(name = "videoType")
    public String getVideoType(){
        return  this.videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    @Column(name = "videoDesc")
    public String getVideoDesc(){
        return this.videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    @Column(name = "documentName")
    public String getDocumentName() {
        return this.documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    @Column(name = "documentPath")
    public String getDocumentPath() {
        return this.documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }
    
    @Column(name="picturePath")
    public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

}
