package com.dmsd.itoo.video.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dmsd.itoo.base.dao.hibernate.BaseHibernateDaoSupport;
import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.video.entity.Comment;

/**
 * Created by 丁国华
 *
 * @Date 2016年8月10日 20:10:26
 */
@Repository("commentDaoImpl")
public class CommentDaoImpl extends BaseHibernateDaoSupport<Comment> {

	/**
	 * 添加评论--2016年8月13日--丁国华
	 * @param comment 评论实体
	 */
	public void addComment(Comment comment){
		this.save(comment);
	}
	
	/**
	 * 评论功能的分页查询--丁国华--2016年8月17日 09:34:38
	 * @param pageNum
	 * @param pageSize
	 *
	 */
	
	public PageEntity<Comment> queryCommentInfo(PageEntity<Comment> pageEntity,String videoID){
		//查询全部
		String hql="FROM Comment c where c.isDelete=0 and c.videoID=:videoID order by update_time desc";
		pageEntity.setHql(hql);
		Map<Object,Object> map=new HashMap<>();
        map.put("videoID",videoID);		
        pageEntity.setMap(map);
		PageEntity<Comment> listComment =this.queryPageEntityByHql( pageEntity);
		return listComment;
	}
	
	

}


	
	
	
	


