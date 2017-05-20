package com.dmsd.itoo.video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmsd.itoo.video.dao.impl.UploadFileDaoImpl;
import com.dmsd.itoo.video.entity.Video;
import com.dmsd.itoo.video.service.UploadFileService;

/**
 * 上传文件的service-王虹芸
 * @author why_768
 *
 */
@Service
@Repository("uploadFileServiceImpl")
@Transactional
public class UploadFileServiceImpl implements UploadFileService{
	
	@Autowired
	private UploadFileDaoImpl uploadFileDaoImpl;

	@Override
	public void save(Video video) {
		
		uploadFileDaoImpl.save(video);
		
	}
}
	

