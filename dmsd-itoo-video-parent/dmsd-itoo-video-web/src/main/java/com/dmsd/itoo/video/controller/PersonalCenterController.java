package com.dmsd.itoo.video.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dmsd.itoo.tool.tojson.JacksonJsonUntil;
import com.dmsd.itoo.video.entity.Personal;
import com.dmsd.itoo.video.entity.Video;
import com.dmsd.itoo.video.service.HistoryRecordService;
import com.dmsd.itoo.video.service.PersonalCenterService;

/**
 * 保存个人信息--丁国华--2016年9月25日 16:06:09
 *
 */
@RequestMapping("/personalCenter")
@Controller
public class PersonalCenterController {
	
	
	JacksonJsonUntil jackJsonUtil =new JacksonJsonUntil ();
	/**
	 * 注入VideoBean
	 */
	@Autowired
	private PersonalCenterService  personalCenterService;
	
	@RequestMapping(value = { "/personalCenterInfo" })
	public String showPersonalCenterInfo() {
		return "personalCenter";
	}
	/*
	 * 上传文件
	 */
	@RequestMapping(value={"/upload"})
	@ResponseBody
	public void upload( MultipartFile file, HttpServletRequest request,HttpServletResponse response,ModelMap model){		
		
		String ext_Name = file.getOriginalFilename().split("\\.")[1];
		String videoName=file.getOriginalFilename().split("\\.")[0];
		
        byte[] bytes = null;
		try {
			bytes = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		String headPicture=uploadFile(bytes,ext_Name);		
					
		JacksonJsonUntil jackJsonUtil =new JacksonJsonUntil ();
	
		Personal personal=new Personal();
		personal.setHeadPicture(headPicture);		
		
		jackJsonUtil.beanToJson(response,personal);
	} 
	/*
	 * 利用字节流上传
	 */
	public String uploadFile(byte[] byteFile, String ext_file) {
		// 拼接服务区的文件路径
		StringBuffer sbPath = new StringBuffer();
		sbPath.append("http://192.168.22.252");
		try {
			//获取服务器里项目所有路径，找到配置文件fdfs_clinet.conf的位置
			String classPath=new File(UploadController.class.getResource("/").getFile()).getCanonicalPath();
			String configFilePath=classPath + File.separator + "fdfs_client.conf";
 			
			// 初始化文件资源
			ClientGlobal
					.init(configFilePath);
				
			// 链接FastDFS服务器，创建tracker和Stroage
			TrackerClient trackerClient = new TrackerClient();
			TrackerServer trackerServer = trackerClient.getConnection();
			StorageServer storageServer = null;
			StorageClient storageClient = new StorageClient(trackerServer,
					storageServer);
			
			//利用字节流上传文件
			String[] strings = storageClient.upload_file(byteFile, ext_file, null);

			for (String string : strings) {
				sbPath.append("/" + string);
				System.out.println(string);
			}
			// 全路径
			System.out.println(sbPath);
		} catch (IOException | MyException e) {
			e.printStackTrace();
		}
		return sbPath.toString();
	}
	/**
	 * 保存用户信息
	 * @param request
	 * @param response
	 */
	@RequestMapping(value={"/save"})
	public void save(HttpServletRequest request,HttpServletResponse response){		
			
		String headPicture=request.getParameter("headPicture");
		
		JacksonJsonUntil jackJsonUtil =new JacksonJsonUntil ();
		
		String dataBaseName = "itoo_video";
	
		HttpSession session=request.getSession();
		Personal personal=new Personal();	
		personal.setUserID(session.getAttribute("userId").toString());		
		personal.setHeadPicture(headPicture);
		personal.setId(session.getAttribute("userId").toString());

		personal.setUserName(session.getAttribute("userName").toString());
		
		personalCenterService.savePersonalInfo(personal);		
		
        jackJsonUtil.beanToJson(response,personal);
		
	}
	

}
