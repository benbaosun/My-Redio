package com.dmsd.itoo.video.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.dmsd.itoo.video.dto.ColleagueInfo;
import com.dmsd.itoo.video.entity.Video;
import com.dmsd.itoo.video.service.VideoService;

/**
 * Created with IntelliJ IDEA.
 * Description: 扩展学习页面加载
 * User: 徐露    王荣晓修改
 * Date: 2016/8/9 
 * Time: 9:29
 * To change this template use File | Settings | File Templates.
 */

@RequestMapping("/showmore")
@Controller
public class ShowmoreController {

    @Autowired
    VideoService videoService;

    /**
     * 扩展学习界面向导
     * @param name
     * @return
     */
    @RequestMapping(value={"{name}"},method= RequestMethod.GET)
    public String showmore(@PathVariable("name")String name){
        return "showmore";
    }

    /**
     * 扩展学习首页面加载，根据学院名称查询所有视频 + 王荣晓 + 2016年8月27日17:39:11
     * @return
     */
    @RequestMapping(value="/allvideoincollege",method = RequestMethod.POST)
    public void allvideoincollege(HttpServletRequest request,HttpServletResponse response,String collegename){
    	JacksonJsonUntil jacksonJsonUntil = new JacksonJsonUntil();
    	//获取学院名称，如果没有则默认“建筑工程学院”
//    	collegename=collegename==null?"建筑工程学院":collegename;
    	
    	Video videoEntity=new Video();
    	List<Video> listVideo = new ArrayList<Video>();
    	Map<String, Object> map = new HashMap<>();
    	
    	//切库，查询视频表
    	MyDataSource.setDefineBeans(new DatabaseDefineBean("jdbc:mysql://192.168.22.181:8066/itoo_video", "video", "video"));
   	
    	listVideo=videoService.allvideoincollege(videoEntity,map,collegename);
    	
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
    	String collegename="建筑工程学院";
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

    /**
     * 调用基础查询所有学院
     * @param request
     * @param response
     */
    @RequestMapping(value={"/findAllColleague"},method= RequestMethod.POST)
    public void findAllColleague(HttpServletRequest request,HttpServletResponse response){
    	
    	List<ColleagueInfo> listColleague=new ArrayList<ColleagueInfo>();
    	JacksonJsonUntil jacksonJsonUntil = new JacksonJsonUntil();
    	
    	//切库，查询基础表
    	MyDataSource.setDefineBeans(new DatabaseDefineBean("jdbc:mysql://192.168.22.181:8066/itoo_basic", "graduatedissertation", "graduatedissertation"));
    	listColleague=videoService.findAllColleague();
    	jacksonJsonUntil.beanToJson(response, listColleague);
    }
    
    /**
     * 徐露师姐写的方法，暂未使用
     * @param institutionName
     * @return
     */
    @RequestMapping(value="/queryInstitutionShowItems",method = RequestMethod.GET)
    public String queryInstitutionShowItems(@PathVariable("institutionName") String institutionName){

        String institutionNametest ="建工学院";
        List<Video> videoList=videoService.queryInstitutionShowItems(institutionNametest);

        System.out.println("根据学院名称，查询该学院下所有的视频信息" + videoList);

        return "showmore";
    }


}
