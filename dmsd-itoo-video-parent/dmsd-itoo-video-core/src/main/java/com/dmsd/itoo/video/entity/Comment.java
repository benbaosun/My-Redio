package com.dmsd.itoo.video.entity;

import com.dmsd.itoo.base.entity.TimeBaseEntity;
import org.springframework.cache.annotation.*;

import javax.persistence.*;
import javax.persistence.Cacheable;
import java.util.Date;

/**
 * Created by 徐露
 *
 * @Date 2016/8/115:41
 */
@Entity
@Table(name = "tv_comment")

@Cacheable                   //=======这个注解的作用？？？？？
public class Comment extends TimeBaseEntity {

    private String userID;
    private String userName;
    private String videoID;
    private String commentContent;
    private Date commentTime;


    @Column(name = "userID", unique = true, nullable = false, length = 22)
    public String getUserID() {
        return this.userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Column(name = "userName")
    public String getUserName(){
        return  this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name="videoID")
    public  String getVideoID(){
        return  this.videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    @Column(name="commentContent")
    public String getCommentContent(){
        return this.commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
    @Column(name ="commentTime")
    public Date getCommentTime(){
        return this.getCreateTime();
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}
