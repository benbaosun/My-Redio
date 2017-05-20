package com.dmsd.itoo.video.service;

import java.util.List;
import java.util.Map;

import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.video.entity.Comment;


public interface CommentService {
	
	/**
	 * 添加评论--丁国华--2016年8月17日 15:43:37
	 * @param comment
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public void addComment(Comment comment) throws NoSuchMethodException, SecurityException;
	
	/**
	 * 分页查询--丁国华--2016年8月17日 15:45:06
	 * @param pageEntity
	 * @param conditions
	 */
	public PageEntity<Comment> queryAllCommentInfo(PageEntity<Comment> pageEntity, String conditions);
	
	

	

}
