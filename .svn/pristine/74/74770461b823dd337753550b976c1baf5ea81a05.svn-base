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
 * @Date 2016/8/116:09
 */
@Entity
@Table(name = "tv_video")
@Cacheable
public class Document extends TimeBaseEntity {


    private String userID;
    private String userName;
    private String videoID;
    private String documentName;
    private String documentPath;
    private String documentSize;
    private String documentType;
    private Date uploadTime;



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

    @Column(name = "videoID")
    public String getVideoID() {
        return this.videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
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
    @Column(name="documentSize")
    public String getDocumentSize(){
        return this.documentSize;
    }

    public void setDocumentSize(String documentSize) {
        this.documentSize = documentSize;
    }

    @Column(name = "documentType")
    public String getDocumentType(){
        return this.documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Column(name="uploadTime")
    public Date getUploadTime(){
        return this.uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}
