package com.dmsd.itoo.video.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.dmsd.itoo.video.entity.Video;
import com.dmsd.itoo.video.service.CommentService;
import com.dmsd.itoo.video.service.MyVideoService;

/**
 * Created by 丁国华
 *
 * @Date 2016年8月10日 15:16:16
 */
@RequestMapping("/comment")
@Controller
public class CommentController {

	/**
	 * 注入CommentService
	 */
	@Autowired
	private CommentService commentService;
	
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
		String name = request.getParameter("user");
		String commentContent = new String(request.getParameter("commentContent").getBytes("ISO-8859-1"),"UTF-8");
//		new String(“数据库查处来的中文”.getBytes("ISO-8859-1"),"UTF-8")
		Date date = new Date();	

		String commentTime = request.getParameter("commentTime");		
		System.out.println("user: "+name);
		Comment comment = new Comment();
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		comment.setCommentContent(commentContent);
		comment.setCommentTime(date);
		comment.setDataBaseName("itoo_video");
		comment.setIsDelete(0);
		comment.setOperator("menghaibin");
		comment.setUserID("123");
		comment.setUserName("123");
		comment.setVideoID("123");
		commentService.addComment(comment);		
		
		StringBuffer sb = new StringBuffer();

		sb.append("<dl ");
		String strId = "comment_item_" + comment.getId();
		sb.append(" class=\"comment_item comment_topic\">");
		sb.append("<dt class=\"comment_head\" floor=\"" +  "\">");
		sb.append("<span class=\"user\"><table width=\"100%\"><tr>");
		sb.append("<td><a class=\"username\" target=\"_blank\">"+ comment.getUserName() + "</a></td>");
		String strCreatTime=df.format(comment.getCreateTime());
		sb.append("<td align=\"right\"><span class=\"ptime\">" + strCreatTime
				+ "</span></td>");
		sb.append("</tr></table></span></dt>");
		sb.append("<dd class=\"comment_body\">"+ comment.getCommentContent() + "</dd>");
		sb.append("</dl>");
		sb.append("<hr style='height:1px;border:none;border-top:1px dashed #0066CC;' />");
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
		 String conditions = (String)request.getAttribute("conditions");
		 
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

	            pageEntity =commentService.queryAllCommentInfo(pageEntity, conditions);
	            
	            
	            StringBuffer sb=new StringBuffer();
	            
	            if(pageEntity.getRows().size()==0){
	            	sb.append("<div class='page-header' align='center'>");
		    		sb.append("<p style='font-size:30px'>暂时没有评论，快去抢沙发吧！</p>");
		    		sb.append("</div>");
	            }else{
	            	
	            
	            
	            for (int i = 0; i < pageEntity.getRows().size(); i++) {	
	            	sb.append("<dl ");
	  	            String strId="comment_item_"+pageEntity.getRows().get(i).getId();
	  	            sb.append(" class=\"comment_item comment_topic\">");
	  	            sb.append("<dt class=\"comment_head\" floor=\""+pageNum*pageSize+i +"\">");
	  	            sb.append("<span class=\"user\"><table width=\"100%\"><tr>");
	  	            sb.append("<td><a class=\"username\" target=\"_blank\">"+pageEntity.getRows().get(i).getUserName()+"</a></td>");
	  	            String strCreatTime=pageEntity.getRows().get(i).getCreateTime().toString();
	  	            strCreatTime=strCreatTime.substring(0,strCreatTime.length()-2);
	  	            sb.append("<td align=\"right\"><span class=\"ptime\">"+strCreatTime+"</span></td>");
	  	            sb.append("</tr></table></span></dt>");
	  	            sb.append("<dd class=\"comment_body\">"+pageEntity.getRows().get(i).getCommentContent()+"</dd>");
	  	            sb.append("</dl>");
	  	            sb.append("<hr style='height:1px;border:none;border-top:1px dashed #0066CC;' />");
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
		 String id = "USNNXmayaR1D17qGR3vEkC";
		
		 JacksonJsonUntil jackJsonUtil =new JacksonJsonUntil ();
		 List<Video> listQueryVideoInfoById = new ArrayList<Video>();
		 listQueryVideoInfoById = myVideoService.queryVideoInfoById(id);
		 jackJsonUtil.beanToJson(response,listQueryVideoInfoById);
	 }
	 


	


}
