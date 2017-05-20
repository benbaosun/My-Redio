package com.dmsd.itoo.video.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.tool.tojson.JacksonJsonUntil;
import com.dmsd.itoo.video.entity.Comment;
import com.dmsd.itoo.video.entity.History;
import com.dmsd.itoo.video.entity.Personal;
import com.dmsd.itoo.video.entity.Video;
import com.dmsd.itoo.video.service.CommentService;
import com.dmsd.itoo.video.service.HistoryRecordService;
import com.dmsd.itoo.video.service.MyVideoService;
import com.dmsd.itoo.video.service.PersonalCenterService;

/**
 * Created by 丁国华
 *
 * @Date 2016年8月10日 15:16:16
 */
@RequestMapping("/comment")
@Controller
public class CommentController {
	

	/**	 * 注入CommentService
	 */
	@Autowired
	private CommentService commentService;
	@Autowired
	private HistoryRecordService historyRecordService;
	@Autowired
	private PersonalCenterService  personalCenterService;
	/**
	 * 注入MyvideoService
	 */
	@Autowired
	private MyVideoService myVideoService;

	/**
	 * 首页向导
	 * @param name
	 * @return
	 */
	@RequestMapping(value = { "{name}" }, method = RequestMethod.GET)
	public String showCourse(@PathVariable("name") String name) {
		return "comment";
	}
	
	

	@RequestMapping(value={"/course1"},method=RequestMethod.POST)
	public void addCourse(){ 
		String a="a";
		String b="b";
		String c="c";
		
		if (a.equals(b)) {
			c=a;
		}
	}
	
	@RequestMapping(value = { "/upload/{name}" }, method = RequestMethod.GET)
	@ResponseBody
	public Object upload() {

		String filePath = uploadFile("G:\\项目\\rose.jpg",
				"jpg");
		return filePath;
	}

	/**
	 * 上传文件--孟海滨--2016年8月5日
	 * 
	 * @param filePath
	 *            文件的全路径
	 * @param ext_file
	 *            文件的扩展名
	 */
	public String uploadFile(String filePath, String ext_file) {
		// 拼接服务区的文件路径
		StringBuffer sbPath = new StringBuffer();
		sbPath.append("http://192.168.22.252");
		try {
			// 初始化文件资源
			ClientGlobal
					.init("G:\\项目\\video\\dmsd-itoo-video-parent\\dmsd-itoo-video-web\\src\\main\\resources\\fdfs_client.conf");

			// 链接FastDFS服务器，创建tracker和Stroage
			TrackerClient trackerClient = new TrackerClient();
			TrackerServer trackerServer = trackerClient.getConnection();
			StorageServer storageServer = null;
			StorageClient storageClient = new StorageClient(trackerServer,
					storageServer);

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

	/**
	 * 添加评论 +丁国华 + 2016年8月10日 16:07:24
	 * @throws UnsupportedEncodingException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */

	// @RequestMapping("/addComment")
	@RequestMapping(value = { "/addComment" }, method = RequestMethod.GET)
	public void addComment(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException, NoSuchMethodException, SecurityException {
		JacksonJsonUntil jackJsonUtil =new JacksonJsonUntil ();	
		HttpSession session=request.getSession();
		String userID=session.getAttribute("userId").toString();
		String userName = session.getAttribute("userName").toString();
//		String videoID=request.getParameter("videoID");
		String videoID=session.getAttribute("videoId").toString();
		
		session.setAttribute("videoID", videoID);
		
		String commentContent = new String(request.getParameter("commentContent").getBytes("ISO-8859-1"),"UTF-8");
//		new String(“数据库查处来的中文”.getBytes("ISO-8859-1"),"UTF-8")
		Date date = new Date();	

		String commentTime = request.getParameter("commentTime");		
		System.out.println("userName: "+userName);
		Comment comment = new Comment();
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		comment.setCommentContent(commentContent);
		comment.setCommentTime(date);
		comment.setDataBaseName("itoo_video");
		comment.setIsDelete(0);		
		comment.setUserID(userID);
		comment.setUserName(userName);
		comment.setVideoID(videoID);
		
		commentService.addComment(comment);		
		
		StringBuffer sb = new StringBuffer();

		//获取当前项目的所在路径，从而获取本地images里的图片
		String url = "";
		url = request.getScheme() +"://" + request.getServerName()+ ":" +request.getServerPort()+ request.getContextPath();
		 		
		sb.append("<dl ");
//    	String UserID="comment_item_"+comment.getId();
    	List<Personal> personallist=personalCenterService.queryPersionInfo(userID);
	    sb.append(" class='comment_item comment_topic'>");
	    sb.append("<dt class='comment_head' floor='" +  "'>");
	    sb.append("<span class='user'><table width='100%'>");
	    sb.append("<hr style='height:1px;border:none;border-top:1px dashed #0066CC;width:1035px;margin-left:120px'/>");
	    sb.append("<tr><td style='width:20px'>");
	    
	    if (personallist.size()==0){
	    	sb.append("<div class='imgCicular' style='margin-top: -120px;'><figure><div id='headpicture' style='margin-top: 150px;'>");
	    	sb.append("<img src='"+url+"/images/rose.jpg' style='height: 100px; margin-top: 1px; float: left; margin-right: 25px;width:120px'>");
	    	sb.append("</div></figure><div style='margin-left:-70px;'>");
	    }else{
	    	String headPicture=personallist.get(0).getHeadPicture();	
	    	sb.append("<div class='imgCicular' style='margin-top: -120px;'><figure><div id='headpicture' style='margin-top: 150px;'>");
	      	sb.append("<img src='"+headPicture+"' style='height: 100px; margin-top: 1px; float: left; margin-right: 25px;width:120px'>");
	      	sb.append("</div></figure><div style='margin-left:-70px;'>");
	    }
	    
	    sb.append("</td><td>");		  	            
        sb.append("<a class='username' target='_blank'>"+comment.getUserName() + "</a>");
		
        sb.append("<br/><dd class='comment_body' style='font'>"+ comment.getCommentContent() + "</dd>");
        sb.append("<br/><span class='ptime' style='margin-left:10px;'></span>");
        sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
		sb.append("<br>");

        String strCreatTime=df.format(comment.getCreateTime());
        strCreatTime=strCreatTime.substring(0,strCreatTime.length());
        sb.append("<span class='ptime'>"+strCreatTime+"</span>");		  	           
        sb.append("</td></tr></table></dt>");
         
        sb.append("</dl>");
        sb.append("<br>");
        
        String result=sb.toString();
        jackJsonUtil.beanToJson(response,result);
 
		
	}
	
	/**
	 * 分页查询+丁国华 + 2016年8月10日 16:07:24
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 */
	 @RequestMapping(value={"/CommentList"})
	 public void QueryAllCommentInfo(String page,String rows,HttpServletRequest request, HttpServletResponse response){
		 HttpSession session= request.getSession();
		 String UserID=session.getAttribute("userId").toString();
		 String videoId=request.getParameter("videoId");
		 
		 session.setAttribute("videoId", videoId);
		 //获取当前项目的所在路径，从而获取本地images里的图片
		 String url = "";
		 url = request.getScheme() +"://" + request.getServerName()+ ":" +request.getServerPort()+ request.getContextPath();
		 
		 JacksonJsonUntil jackJsonUtil =new JacksonJsonUntil ();
		 String dataBaseName = "itoo_video";
		 try{
			 //获取前台easyui分页工具的属性，page为当前页面，rows为每页显示的行数
			 int pageNum=(Integer.parseInt(page)>0)?(Integer.parseInt(page)):1;
	         int pageSize=(Integer.parseInt(rows)>0)?(Integer.parseInt(rows)):1;
			 
	            //构造分页实体
	            PageEntity<Comment > pageEntity =new PageEntity();
	            pageEntity.setPageNum(pageNum);
	            pageEntity.setPageSize(pageSize);
	            pageEntity.setDataBaseName(dataBaseName);

	            pageEntity =commentService.queryAllCommentInfo(pageEntity, videoId);
	            
	            System.out.println(pageEntity.getRows().size());
	            
	            StringBuffer sb=new StringBuffer();
	            
	            if(pageEntity.getRows().size()==0){
	            	sb.append("<div class='page-header' align='center'>");
		    		sb.append("<p style='font-size:30px'>暂时没有评论，快去抢沙发吧！</p>");
		    		sb.append("</div>");
	            }
	            else{
	            	
		            for (int i = 0; i < pageEntity.getRows().size(); i++) {	
		            	sb.append("<dl ");
//		            	String UserID="comment_item_"+pageEntity.getRows().get(i).getUserID();
		            	List<Personal> personallist=personalCenterService.queryPersionInfo(UserID);
		  	            sb.append(" class='comment_item comment_topic'>");
		  	            sb.append("<dt class='comment_head' floor='"+pageNum*pageSize+i +"'>");
		  	            sb.append("<span class='user'><table width='100%'>");
		  	            sb.append("<hr style='height:1px;border:none;border-top:1px dashed #0066CC;width:1035px;margin-left:120px'/>");
		  	            sb.append("<tr><td style='width:20px'>");
		  	           
		  	          if (personallist.size()==0){
		  	            	sb.append("<div class='imgCicular' style='margin-top: -120px;'><figure><div id='headpicture' style='margin-top: 150px;'>");
		  	            	sb.append("<img src='"+url+"/images/rose.jpg' style='widht: 20px;width:120px; height: 100px; margin-top: 1px; float: left; margin-right: 25px;'>");
		  	            	sb.append("</div></figure><div style='margin-left:-70px;'>");
		  	            }else{
		  	            	String headPicture=personallist.get(0).getHeadPicture();			            	
		  	            	sb.append("<div class='imgCicular' style='margin-top: -120px;'><figure><div id='headpicture' style='margin-top: 150px;' >");
		  	            	sb.append("<img src='"+headPicture+"' style='widht: 20px; width:120px; height: 100px; margin-top: 1px; float: left; margin-right: 25px;'>");
		  	            	sb.append("</div></figure><div style='margin-left:-70px;'>");
		  	            }
		  	            
		  	            sb.append("</td><td>");		  	            
		  	            sb.append("<a class='username' target='_blank'>"+pageEntity.getRows().get(i).getUserName()+"</a>");
		  	            sb.append("<br/><dd class='comment_body' style='font'>"+pageEntity.getRows().get(i).getCommentContent()+"</dd>");
		  	            sb.append("<br/><span class='ptime'></span>");		  	          
		  	            //查询创建时间
		  	            String strCreatTime=pageEntity.getRows().get(i).getCreateTime().toString();
			  	        strCreatTime=strCreatTime.substring(0,strCreatTime.length()-2);
		  	            sb.append("<span class='ptime'>"+strCreatTime+"</span>");		  	           
		  	            sb.append("</td></tr></table></dt>");
		  	            
		  	            sb.append("</dl>");
		  	           
		  	            sb.append("<br>");
		  	         	  	            					
					}
	            }
	                        
	            String result=sb.toString();
	            jackJsonUtil.beanToJson(response,result);
	            

		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 
	 }
	
	/**
	 * 根据id查询相关视频-丁国华--2016年8月27日 20:43:29
	 * @param request
	 * @param response
	 */
	
	 @RequestMapping(value={"/queryVideoByid"},method=RequestMethod.GET)
	 public void queryInfoById(HttpServletRequest request,HttpServletResponse response){
//		 String id = request.getParameter("id");
//		 String id = "USNNXmayaR1D17qGR3vEkC";
		 HttpSession session=request.getSession();
		 String userid=session.getAttribute("userId").toString();
		 String videoid=session.getAttribute("videoId").toString();
		 JacksonJsonUntil jackJsonUtil =new JacksonJsonUntil ();
		 List<Video> listQueryVideoInfoById = new ArrayList<Video>();
		 if(videoid==null)
		 {
			 videoid="Kwm8JsB5aAjvwRxvhZVsyu";
			 listQueryVideoInfoById = myVideoService.queryVideoInfoById(videoid);
		 }else{
			 listQueryVideoInfoById = myVideoService.queryVideoInfoById(videoid);
		 }
		 
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date watchTime=null;
			try {
				watchTime = formatter.parse(formatter.format(new Date()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	 
		 
		 String picturePath=listQueryVideoInfoById.get(0).getPicturePath();
		 
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}	
		 History history=new History();
		 history.setUserID(userid);
		 history.setVideoID(videoid);
		 history.setWatchTime(watchTime);
		 history.setPicturePath(picturePath);
		 
		 historyRecordService.saveHistory(history);
		 
		 jackJsonUtil.beanToJson(response,listQueryVideoInfoById);
	 }
	 
	 /**
	  * 根据VideoType分页查询相关视频信息--丁国华--2016年9月23日 15:32:46
	  * @param request
	  * @param response
	  */
	 @RequestMapping(value={"/queryVideoInfoByVideoType"},method=RequestMethod.GET)
	 public void queryVideoInfoByVideoType(String page,String rows,HttpServletRequest request,HttpServletResponse response){
		 JacksonJsonUntil jackJsonUtil =new JacksonJsonUntil ();
		 HttpSession session=request.getSession();
		 String videoType=session.getAttribute("colleagueName").toString();
		 String videoID=session.getAttribute("videoId").toString();
		 
		 String conditions = (String)request.getAttribute("conditions");
		 String str = page;		
		 String dataBaseName = "itoo_video";	
		 
		 
		 try{
			 //获取前台easyui分页工具的属性，page为当前页面，row为每页显示的行数
			 int pageNum=(Integer.parseInt(page)>0)?(Integer.parseInt(page)):1;
		     int pageSize=(Integer.parseInt(rows)>0)?(Integer.parseInt(rows)):1;
		     
		     //构造分页实体
		     PageEntity<Video> pageEntity = new PageEntity();
		     pageEntity.setPageNum(pageNum);
		     pageEntity.setPageSize(pageSize);
		     pageEntity.setDataBaseName(dataBaseName);
		     
		     pageEntity = myVideoService.queryVideoInfoByVideoType(pageEntity, conditions, videoType);
		     
		     StringBuffer sb = new StringBuffer();
		     for(int i = 0;i < pageEntity.getRows().size(); i++){
		    	 List<Video> voidlist = pageEntity.getRows();
		 		
				 sb.append("<div style='float: left; margin-left:30px;height:120px'>");
				 sb.append("<div class='row clearfix'style='margin-top: 10px width:300px; height: 120px;'>");
				 sb.append("<div class='col-md 4 column' style='background-color:white;height:118px'>");
				 sb.append("<table class='table table-bordered' style='margin-top: 45px;width:298px'>");
				 sb.append("<tbody>");
				 sb.append("<tr>");							
				 sb.append("<td width='50' height='80' rowspan='2'>");
				 //视频图片
				 sb.append("<a href=" + "/dmsd-itoo-video-web/comment/1?id="+voidlist.get(i).getId()+"><img width='100' height='100' src='"+voidlist.get(i).getPicturePath()+"'>");
				 sb.append("</td>");
				 //视频名称
				 sb.append("<td>");			
				 sb.append("视频名称: "+voidlist.get(i).getVideoName()+"");
				 sb.append("</td>");
				 
				 sb.append("</tr>");
				 sb.append("<tr>");
				 //视频分类
				 sb.append("<td>");			
				 sb.append("视频分类: "+voidlist.get(i).getVideoType()+"");
				 sb.append("</td>");
				 
				 sb.append("</tr>");
				 sb.append("</tbody>");
				 sb.append("</table>");
				 sb.append("<br>");
				 sb.append("</div>");
				 sb.append("</div>");
				 sb.append("</div>");
		 
		     }
		 String result = sb.toString();
		 jackJsonUtil.beanToJson(response,result);
			
	 } catch (Exception e) {
			e.printStackTrace();	
			
	 	}
		 
	 }
	 
	 /**
	  * 根据用户id查询头像
	  */
	 @RequestMapping(value={"/queryHeadPicture"})
	 public void queryHeadPicture(HttpServletRequest request,HttpServletResponse response){
		 JacksonJsonUntil jackJsonUtil =new JacksonJsonUntil ();
		 HttpSession session = request.getSession();	
		 String userId=session.getAttribute("userId").toString();
		 List<Personal> personallist=personalCenterService.queryPersionInfo(userId);
		 
		 StringBuffer sb = new StringBuffer();
		 //获取当前项目的所在路径，从而获取本地images里的图片
		 String url = "";
		 url = request.getScheme() +"://" + request.getServerName()+ ":" +request.getServerPort()+ request.getContextPath();
		 //如果没有头像，设置默认头像
		 if(personallist.size()==0){
			 sb.append("<img src='"+url+"/images/rose.jpg'");
			 sb.append("style='widht: 100px; height: 100px; margin-top: 1px; float: left; margin-right: 25px;'>");
		 }
		 else
		 {
			 String headPicture=personallist.get(0).getHeadPicture();
			 sb.append("<img src='"+headPicture+"'");
			 sb.append(" style='widht: 100px; height: 100px; margin-top: 1px; float: left; margin-right: 25px;'>");
		 }
		 
		 String result = sb.toString();
		 jackJsonUtil.beanToJson(response,result);
	 }
}
	 

	 


