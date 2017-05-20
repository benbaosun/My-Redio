package com.dmsd.itoo.video.service.impl;



import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.video.dao.impl.CommentDaoImpl;
import com.dmsd.itoo.video.entity.Comment;
import com.dmsd.itoo.video.service.CommentService;


@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {
    private static Logger logger = (Logger) LoggerFactory.getLogger(CommentServiceImpl.class);


	
	@Autowired
	private CommentDaoImpl commentDaoImpl;
	
	
	@Override
	public void addComment(Comment comment) throws NoSuchMethodException, SecurityException {
		commentDaoImpl.addComment(comment);
		
	}

	/**
	 * 分页查询--丁国华--2016年8月17日 15:45:06
	 * @param videoID
	 * @param pageNum
	 * @param pageSize
	 */         
	@Override
	public PageEntity<Comment> queryAllCommentInfo(PageEntity<Comment> pageEntity, String videoID) {
		PageEntity<Comment> list = new PageEntity<Comment>();		
		list = commentDaoImpl.queryCommentInfo(pageEntity,videoID);		
		return list;
		
	}




	

}
