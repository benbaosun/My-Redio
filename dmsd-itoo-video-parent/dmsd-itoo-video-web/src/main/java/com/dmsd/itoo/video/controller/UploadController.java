package com.dmsd.itoo.video.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Convert;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dmsd.itoo.tool.tojson.JacksonJsonUntil;
import com.dmsd.itoo.video.entity.Video;
import com.dmsd.itoo.video.service.UploadFileService;

/**
 * 上传文件
 * 
 * @author 王虹芸
 *
 */
@RequestMapping("/upload")
@Controller
public class UploadController {
	//service注入
	@Autowired
	private UploadFileService uploadFileService;
	
	
	public UploadFileService getUploadFileService() {
		return uploadFileService;
	}

	public void setUploadFileService(UploadFileService uploadFileService) {
		this.uploadFileService = uploadFileService;
	}

	@RequestMapping("/showPage")
	public String showPage(){		
		return "upload";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(){			
		return "startupload";
	}
	
	@RequestMapping("/save")
	public void save(HttpServletRequest request,HttpServletResponse response){		
		//删除自动生成的图片
		File filePicture=new File("D://eclipse//images//myVideo.jpg");
		
		if (filePicture.isFile() && filePicture.exists()) {  
			filePicture.delete();				
		}
		
		String videoName=request.getParameter("videoName");
		String videoType=request.getParameter("videoType");
		String videoDesc=request.getParameter("videoDesc");
		String videoPath=request.getParameter("videoPath");
		String picturePath=request.getParameter("picturePath");
		
		HttpSession session =request.getSession();
		String userId=session.getAttribute("userId").toString();
		String userName=session.getAttribute("userName").toString();
		

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date uploadTime=null;
		try {
			uploadTime = formatter.parse(formatter.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JacksonJsonUntil jackJsonUtil =new JacksonJsonUntil ();
		
		String dataBaseName = "itoo_video";
	
		Video video=new Video();
		video.setUserName(userName);
		video.setUserID(userId);		
		video.setVideoName(videoName);
		video.setVideoPath(videoPath);
		video.setVideoType(videoType);
		video.setVideoDesc(videoDesc);	
		video.setDataBaseName(dataBaseName);
		video.setPicturePath(picturePath);
		video.setUploadTime(uploadTime);
		
		uploadFileService.save(video);		
		
        jackJsonUtil.beanToJson(response,video);
		
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
		
		String videoPath=uploadFile(bytes,ext_Name);
		
		
		//获取服务器里项目所有路径，找到配置文件fdfs_clinet.conf的位置
		String classPath=null;
		try {
			classPath = new File(UploadController.class.getResource("/").getFile()).getCanonicalPath();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String configFilePath=classPath + File.separator + "ffmpeg.exe";
		
		//从上传的视频中截取图片，作为首页图片
		List<String> command=new java.util.ArrayList<String>();

		command.add(configFilePath);  //视频提取工具的位置 
		command.add("-i");
		command.add(videoPath);
		command.add("-y");
		command.add("-f");
		command.add("image2");
		command.add("-ss");
		command.add("08.001");
		command.add("-t");
		command.add("0.001");
		command.add("-s");
		command.add("352x240");
		command.add("D://eclipse//images//myVideo.jpg");

		String picturePath=null;
		try {

			Process videoProcess = new ProcessBuilder(command).redirectErrorStream(true).start();
			new PrintStream(videoProcess.getInputStream()).start();
			
			try {
				videoProcess.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//获取本地截取的图片并上传
			String picture="D://eclipse//images//myVideo.jpg";
			File picturepath=new File(picture);
			if (picturepath.isFile() && picturepath.exists()) {  
				picturePath=uploadFile(picture,"jpg");
			}			
			System.out.println(picturePath);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
					
		JacksonJsonUntil jackJsonUtil =new JacksonJsonUntil ();
		
		model.addAttribute("picturePath", picturePath);
		
		Video video=new Video();
		video.setVideoPath(videoPath);
		video.setVideoName(videoName);	
		video.setPicturePath(picturePath);
	
		jackJsonUtil.beanToJson(response,video);
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
	/*
	 * 利用文件路径上传
	 */
	public String uploadFile(String filePath, String ext_file) {
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

			//利用文件路径上传
			String[] strings = storageClient.upload_file(filePath, ext_file,
					null);
			
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
	
	public class PrintStream extends Thread 
	{
	    java.io.InputStream __is = null;
	    public PrintStream(java.io.InputStream is) 
	    {
	        __is = is;
	    } 

	    public void run() 
	    {
	        try 
	        {
	            while(this != null) 
	            {
	                int _ch = __is.read();
	                if(_ch != -1) 
	                    System.out.print((char)_ch); 
	                else break;
	            }
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        } 
	    }
	}
}
