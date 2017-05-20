package com.dmsd.itoo.video.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.tool.tojson.JacksonJsonUntil;
import com.dmsd.itoo.video.entity.Video;
import com.dmsd.itoo.video.service.MyVideoService;

/**
 * Created by 丁国华
 *
 * @Date 2016年8月20日 16:04:13
 */

@RequestMapping("/editInfo")
@Controller
public class MyVideoController {

	
	JacksonJsonUntil jackJsonUtil =new JacksonJsonUntil ();
	/**
	 * 注入VideoBean
	 */
	@Autowired
	private MyVideoService myVideoService;
	
	@RequestMapping(value = { "/showMyVideo" }, method = RequestMethod.GET)
	public String showCourse() {
		return "editVideo";
	}
	
	
	
	
	
	/**
	 * 分页查询编辑页面的信息+丁国华 + 2016年8月20日 20:57:19
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 */

	@RequestMapping(value = "/queryMyVideo", method = RequestMethod.GET)
	public void queryMyVideoInfo(String page,String rows,HttpServletRequest request,HttpServletResponse response) {
		String userId = "why";
		String conditions = (String)request.getAttribute("conditions");
		String str = page;		
		String dataBaseName = "itoo_video";		
		
		
		try{
			//获取前台easyui分页工具的属性，page为当前页面，rows为每页显示的行数
			int pageNum=(Integer.parseInt(page)>0)?(Integer.parseInt(page)):1;
	        int pageSize=(Integer.parseInt(rows)>0)?(Integer.parseInt(rows)):1;
	        
	        
	        //构造分页实体
	        PageEntity<Video> pageEntity = new PageEntity();
	        pageEntity.setPageNum(pageNum);
	        pageEntity.setPageSize(pageSize);
	        pageEntity.setDataBaseName(dataBaseName);
	        
	        pageEntity = myVideoService.queryMyVideoInfo(pageEntity, conditions,userId);
	        
	      //获取当前项目的所在路径，从而获取本地images里的图片
			String url = "";
			url = request.getScheme() +"://" + request.getServerName()+ ":" +request.getServerPort()+ request.getContextPath();
	        
	        StringBuffer sb = new StringBuffer();
	        List<Video> voidlist = pageEntity.getRows();
	        
	        
	        if(pageEntity.getRows().size()==0){
	        	sb.append("<div class='page-header' align='center'>");
	    		sb.append("<p style='font-size:30px'>暂时没有相关视频信息，赶快去上传吧！</p>");
	    		sb.append("</div>");
	        }else{
	        	
	        	
	        for (int i = 0; i < pageEntity.getRows().size(); i++) {		        	
				
				sb.append("<div class='row clearfix' style='float:left'>");
				sb.append("<div class='col-md-12 column' style='width:230px;margin-left:50px'>");

				sb.append("<table class='table table-bordered'>");
				sb.append("<tbody>");
				sb.append("<tr>");
				sb.append("<td width='200' height='80'>");
				//图片路径
				sb.append("<img id='videopicture"+(i+1)+"' onmouseenter='showdelete(this)' width='200' height='200' src='"+voidlist.get(i).getPicturePath()+"'>");				
				sb.append("</td>");
				sb.append("<tr><td>");
				//视频名称
				sb.append("视频名称: "+voidlist.get(i).getVideoName()+"<a id='videoid"+(i+1)+"' style='display:none'>"+voidlist.get(i).getId()+"</a>");
				sb.append("</td>");
				sb.append("</tr>");
				
				sb.append("<tr><td>");
				//上传时间
				/**
				 * 1、如果查出来的日期为空，则直接new出来一个date,进行格式转换
				 * 2、如果不为空，把查出来的数据进行显示即可
				 */

				
				if(voidlist.get(i).getUploadTime()== null){
					 Date date = new Date();
					 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					 String dateString = formatter.format(date);
					 sb.append("上传时间: "+dateString+"");	
					
				}else
				{
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dateString = sdf.format(voidlist.get(i).getUploadTime());
					sb.append("上传时间: "+dateString+"");	
					
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
	 * 删除视频信息--丁国华 -- 2016年8月20日 20:57:19
	 * @param request
	 * @param reponse
	 */
	
	@RequestMapping(value={"/delete"},method=RequestMethod.GET)
	public void deleteMyVideoInfo(HttpServletRequest request,HttpServletResponse reponse){
		String videoid = request.getParameter("videoid");		
		myVideoService.deleteMyVideoInfo(videoid);
		
	}
	
	
	/**
	 *  查询全部--丁国华--2016年8月22日 15:49:43
	 * @param request
	 * @param response
	 */
	@RequestMapping(value={"/queryAllMyVideo"},method=RequestMethod.GET)
	public void allMyVideoInfo(HttpServletRequest request,HttpServletResponse response){
		String userId = "why";
		
		List<Video> listAllMyVideoInfo = new ArrayList<Video>();
		listAllMyVideoInfo=myVideoService.queryAllMyVideoInfo(userId);
		
		
		StringBuffer sb = new StringBuffer();
		
		if(listAllMyVideoInfo.size()==0){
			sb.append("<div class='page-header' align='center'>");
    		sb.append("<p style='font-size:30px'>暂时没有相关视频信息，赶快去上传吧！</p>");
    		sb.append("</div>");
		}else{			
		
		for (int i = 0; i < listAllMyVideoInfo.size(); i++) {	
	
			
			sb.append("<div class='row clearfix'>");
			sb.append("<div class='col-md-12 column'>");

			sb.append("<table class='table table-bordered'>");
			sb.append("<tbody>");
			sb.append("<tr>");
			sb.append("<td rowspan='3' width='200' height='80'> ");
			//图片路径
			sb.append("<img height='100' width='100' src='"+listAllMyVideoInfo.get(i).getPicturePath()+"'>");
			sb.append("</td>");
			sb.append("<td>");
			//视频名称
			sb.append("视频名称: "+listAllMyVideoInfo.get(i).getVideoName()+"");
			sb.append("</td>");
			sb.append("</tr>");
			
			sb.append("<td>");
			//上传时间
			
			
			if(listAllMyVideoInfo.get(i).getUploadTime()== null){
				 Date date = new Date();
				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 String dateString = formatter.format(date);
				 sb.append("上传时间: "+dateString+"");	
				
			}else
			{
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = sdf.format(listAllMyVideoInfo.get(i).getUploadTime());
				sb.append("上传时间: "+dateString+"");	
				
			}
			sb.append("</td>");
			sb.append("</tr>");
			
			
			sb.append("<tr class='success'>");
			sb.append("<td>");
			sb.append("<input type='button'  class='btn btn-info' onclick='deleteById("+listAllMyVideoInfo.get(i).getId()+")'  value='删除'></button>");
			
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
		jackJsonUtil.beanToJson(response,result);
	}
	
	
}
	
	
	

	


