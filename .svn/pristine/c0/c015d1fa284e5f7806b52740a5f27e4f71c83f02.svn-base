package com.dmsd.itoo.video.controller;

import java.io.IOException;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.tool.tojson.JacksonJsonUntil;
import com.dmsd.itoo.video.entity.History;
import com.dmsd.itoo.video.entity.Video;
import com.dmsd.itoo.video.service.HistoryRecordService;
import com.dmsd.itoo.video.service.VideoService;



/**
 * Created by 丁国华
 *
 * @Date 2016年8月20日 16:04:13
 */

@RequestMapping("/historyRecord")
@Controller
public class HistoryRecordController {

	
	JacksonJsonUntil jackJsonUtil =new JacksonJsonUntil ();
	/**
	 * 注入VideoBean
	 */
	@Autowired
	private HistoryRecordService historyRecordService;
	@Autowired
	private VideoService videoService;
	
	@RequestMapping(value = { "/historyRecordInfo" }, method = RequestMethod.GET)
	public String showHistoryRecord() {
		return "historyRecord";
	}
	
	
		
	/**
	 * 分页查询历史记录的信息+丁国华 + 2016年8月20日 20:57:19
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 */

	@RequestMapping(value = "/queryMyHistoryRecord", method = RequestMethod.GET)
	public void queryMyHistoryRecordInfo(String page,String rows,HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		String userId = session.getAttribute("userId").toString();
		
		//获取当前项目的所在路径，从而获取本地images里的图片
		String url = "";
		url = request.getScheme() +"://" + request.getServerName()+ ":" +request.getServerPort()+ request.getContextPath();

		String dataBaseName = "itoo_video";		
		
		try{
			//获取前台easyui分页工具的属性，page为当前页面，rows为每页显示的行数
			int pageNum=(Integer.parseInt(page)>0)?(Integer.parseInt(page)):1;
	        int pageSize=(Integer.parseInt(rows)>0)?(Integer.parseInt(rows)):1;
	        
	        List<History> voidlist=historyRecordService.queryHistoryRecord(userId, pageNum, pageSize);
	        
	        System.out.println(voidlist);
	        
//	        //构造分页实体
//	        PageEntity<History> pageEntity = new PageEntity<History>();
//	        pageEntity.setPageNum(pageNum);
//	        pageEntity.setPageSize(pageSize);
//	        pageEntity.setDataBaseName(dataBaseName);
	        
	        
//	        //分页查询历史记录
//	        pageEntity = historyRecordService.queryHistoryRecordInfo(pageEntity, userId);
	        
//	        //根据用户id查询历史记录——暂时不用
//	        List<History> voidlist=historyRecordService.queryHistoryRecord(userId);
	       	
//	        //查询历史记录表里数据
//        	List<History> voidlist = pageEntity.getRows();
        	
	        StringBuffer sb = new StringBuffer();
	        
	        if(voidlist.size()==0){
	        
	        	sb.append("<div class='page-header' align='center'>");
	    		sb.append("<p style='font-size:30px'>暂时没有历史记录!</p>");
	    		sb.append("</div>");    		
	    		
	    
	        }else{	     
	        	
	        	for (int i = 0; i < voidlist.size(); i++) {       	
	        		//获取当前历史记录里的videoid,并根据videoid查询视频名称
	        		String videoID=voidlist.get(i).getVideoID();
	        		List<Video> listVideo=videoService.findVideoInfobyid(videoID);
	        		String videoName=listVideo.get(0).getVideoName();
	        		String videoType=listVideo.get(0).getVideoType();
	        		
					sb.append("<div class='row clearfix'>");

					sb.append("<div class='col-md-12 column' style='margin-top:10px;margin-left:120px;width:930px;height:120px'>");

					sb.append("<table style='background-color:white' class='table' cellspacing='0' cellpadding='0' rules='none'>");
					sb.append("<tbody>");
					sb.append("<tr>");
					sb.append("<td rowspan='3' style='width:220px'>");
					//图片路径
					sb.append("<a href=" + "/dmsd-itoo-video-web/comment/1?id="+videoID+"><img width='200' height='100' src='"+voidlist.get(i).getPicturePath()+"'>");
					sb.append("</td>");

					sb.append("<td style='font-size:16px;color:black;'>"+videoName+"<a id='videoid"+(i+1)+"' style='display:none'>"+videoID+"</a>"+"</td>");
					sb.append("<td rowspan='3'><a id='delete' target='_blank' data-original-title title><img id='deleterecord"+(i+1)+"' class='img' src='"+url+"/images/u49.png'  style='margin-top:30px;' onclick='deleterecord(this)'/></a></td>");					
					sb.append("</tr>");
					sb.append("<tr><td style='color:#D5D5D5'>"+ videoType +"</td></tr><tr><td style='color:#D5D5D5'>");					
	
					//观看时间						
					if(voidlist.get(i).getWatchTime()== null){
						 Date date = new Date();
						 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						 String dateString = formatter.format(date);
						 sb.append("上次观看到: "+dateString+"");	
						
					}else
					{
						
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String dateString = sdf.format(voidlist.get(i).getWatchTime());
						sb.append("上次观看到: "+dateString+"");	
						
					}
					sb.append("</td>");					
					sb.append("</tr>");				
					sb.append("</tbody>");
					sb.append("</table>");
					sb.append("<br>");
					sb.append("</div>");
					sb.append("</div>");
					
			}
	        	
	        }
	        
	        

	        
			String result = sb.toString();
			
			jackJsonUtil.beanToJson(response, result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 查询全部历史记录信息--丁国华--2016年8月22日 15:49:43
	 * @param request
	 * @param response
	 */
	@RequestMapping(value={"/queryAllMyHistoryRecord"},method=RequestMethod.GET)
	public void allMyVideoInfo(HttpServletRequest request,HttpServletResponse response){
		String userId = "12";
		
		List<History> listAllMyVideoHistoryRecordInfo = new ArrayList<History>();
		listAllMyVideoHistoryRecordInfo=historyRecordService.queryAllMyHistoryRecordInfo(userId);
		
		
		StringBuffer sb = new StringBuffer();
		if(listAllMyVideoHistoryRecordInfo.size()==0){
			sb.append("<div class='page-header' align='center'>");
    		sb.append("<p style='font-size:30px'>暂时没有历史记录!</p>");
    		sb.append("</div>");			
		}else{
			
		for (int i = 0; i < listAllMyVideoHistoryRecordInfo.size(); i++) {	
	        	
				
				sb.append("<div class='row clearfix'>");
				sb.append("<div class='col-md-12 column'>");

				sb.append("<table class='table table-bordered'>");
				sb.append("<tbody>");
				sb.append("<tr>");
				sb.append("<td rowspan='1' width='200' height='80'>");
				//图片路径
				sb.append("<img width='200' height='100' src='"+listAllMyVideoHistoryRecordInfo.get(i).getPicturePath()+"'>");
				sb.append("</td>");
				sb.append("<td>");
				sb.append("<br/><br/>");


				//观看时间	
				if(listAllMyVideoHistoryRecordInfo.get(i).getWatchTime()== null){
					 Date date = new Date();
					 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					 String dateString = formatter.format(date);
					 sb.append("上次观看到: "+dateString+"");	
					
				}else
				{
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dateString = sdf.format(listAllMyVideoHistoryRecordInfo.get(i).getWatchTime());
					sb.append("上次观看到: "+dateString+"");					        
				}

				sb.append("</td>");
				sb.append("<td>");			
				sb.append("<img id=\"u49_img\" class=\"img\" src=\"$"+"{{"+"pageContext.request.contextPath"+"}}"+"/images/u49.png\" />");				
				sb.append("</td></tr>");
				
			

				sb.append("</tbody>");
				sb.append("</table>");
				sb.append("<br>");
				sb.append("</div>");
				sb.append("</div>");
				
		}
	}
		
		String result = sb.toString();
		jackJsonUtil.beanToJson(response,result);
	}
	
	/*
	 * 根据videoid删除历史记录
	 */
	@RequestMapping(value={"/deleteHistoryByVideoid"})
	public void deleteHistoryByVideoid(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		String userid=session.getAttribute("userId").toString();
		String videoid=request.getParameter("videoid");
		historyRecordService.deleteHistoryRecordByid(userid,videoid);		
	}
	
	/*
	 * 清空当前用户的历史记录
	 */
	@RequestMapping(value={"/clearAllHistory"},method=RequestMethod.POST)
	public void clearAllHistory(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		String userid=session.getAttribute("userId").toString();
		historyRecordService.clearAllHistory(userid);
	}
}
	
	
	

	


