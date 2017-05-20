package com.dmsd.itoo.video.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmsd.itoo.video.dao.impl.PersonalCenterDaoImpl;
import com.dmsd.itoo.video.entity.Personal;
import com.dmsd.itoo.video.service.PersonalCenterService;


@Service
@Repository("personalCenterServiceImpl")
@Transactional
public class PersonalCenterServiceImpl implements PersonalCenterService {
	
	@Autowired
	private PersonalCenterDaoImpl personalCenterDaoImpl;

	/**
	 * 保存个人中心的相关个人信息--丁国华--2016年9月25日 15:59:15
	 */
	@Override
	public void savePersonalInfo(Personal personal) {
		personalCenterDaoImpl.savePersonalInfo(personal);
		
	}
	
	/**
	 * 查询个人中心信息-王虹芸-2016年9月28日17:24:34
	 * @param userId
	 * @return
	 */
	public List<Personal> queryPersionInfo(String userId){
		List<Personal> personallist = new ArrayList<Personal>();
		personallist=personalCenterDaoImpl.queryPersionInfo(userId);
		
		return personallist;
	}
	
}
