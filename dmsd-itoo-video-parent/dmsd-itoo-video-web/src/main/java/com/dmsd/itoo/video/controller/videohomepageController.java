
package com.dmsd.itoo.video.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dmsd.itoo.base.dao.changedb.DatabaseDefineBean;
import com.dmsd.itoo.base.dao.changedb.MyDataSource;
import com.dmsd.itoo.tool.pageModel.PageEntity;
import com.dmsd.itoo.tool.tojson.JacksonJsonUntil;
import com.dmsd.itoo.video.entity.Video;
import com.dmsd.itoo.video.dto.Videodto;
import com.dmsd.itoo.video.service.VideoService;

/**
 * 
 * @author wrx
 * @Date 2016-8-25 10:14:41
 */
@RequestMapping("/videohomepage")
@Controller
public class videohomepageController {
	/**
	 * 首页向导
	 * @param name
	 * @return
	 */
	@RequestMapping(value={"{name}"},method= RequestMethod.GET)
    public String showCourse(@PathVariable("name")String name){
        return "videohomepage";
    } 
    
    @Autowired
    VideoService videoService;
    
    /**
     * 登录后的首页中的“实战推荐”内容加载 + 王荣晓 + 2016年8月25日11:50:53
     * @param request
     * @param response
     * @throws UnsupportedEncodingException 
     */
    @RequestMapping(value={"/findRecommended"},method= RequestMethod.GET)
    public void findRecommended(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
    	String colleagueName =new String(request.getParameter("colleagueName").getBytes("iso-8859-1"), "utf-8");
    	JacksonJsonUntil jacksonJsonUntil = new JacksonJsonUntil();
    	
    	List<Videodto> listVideo = new ArrayList<Videodto>();
	    
    	//切库，查询基础表
    	MyDataSource.setDefineBeans(new DatabaseDefineBean("jdbc:mysql://192.168.22.181:8066/itoo_video", "video", "video"));
   	
    	listVideo=videoService.findRecommended(colleagueName);
    	if(listVideo.size()==0){
    		listVideo=null;
    	}
    	jacksonJsonUntil.beanToJson(response, listVideo);
    }
    
    /**
     * 根据查询条件分页查询视频信息 + 王荣晓 + 2016-8-24 21:35:40
     * @param page  页数
     * @param rows  每页条数
     * @param querytxt  查询条件
     * @param request
     * @param response
     */
    @RequestMapping(value={"/queryCollegeVideoInfo"},method= RequestMethod.POST)
    public void queryCollegeVideoInfo(String page,String rows,String querytxt,HttpServletRequest request,HttpServletResponse response){
    	String collegename="物理与电子信息学院";
    	String dataBaseName = "itoo_video";
    	
    	JacksonJsonUntil jacksonJsonUntil = new JacksonJsonUntil();
    	PageEntity<Video> pageEntity = new PageEntity();
    	try {
    		//获取前台easyui分页工具的属性，page为当前页面，rows为每页显示的行数
			int pageNum=(Integer.parseInt(page)>0)?(Integer.parseInt(page)):1;
	        int pageSize=(Integer.parseInt(rows)>0)?(Integer.parseInt(rows)):1;
	        
	        //构造分页实体
	        pageEntity.setPageNum(pageNum);
	        pageEntity.setPageSize(pageSize);
	        pageEntity.setDataBaseName(dataBaseName);
	        
	        pageEntity = videoService.queryCollegeVideoInfo(pageEntity,querytxt,collegename);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	jacksonJsonUntil.beanToJson(response, pageEntity);
    }
}





	
