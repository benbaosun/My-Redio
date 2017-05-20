package com.dmsd.itoo.video.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.video.entity.Comment;


/**
 * Created by 丁国华
 *
 * @Date 2016年8月10日 20:25:29
 */
@Repository("commentDao")
public interface CommentDao {
	  

	/**
	 * 添加评论--2016年8月13日--丁国华
	 * @param comment 评论实体
	 */
	public void addComment(Comment comment);
	
  
	
	
	
	
	

}
