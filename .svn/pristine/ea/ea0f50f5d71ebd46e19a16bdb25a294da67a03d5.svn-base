<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%-- <%@ page import="com.dmsd.itoo.video.controller.UserInfoController" %> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%-- <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel='stylesheet' type='text/css' media="all"/> --%>
    
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/userinfo.js"></script>
	<script src="${pageContext.request.contextPath}/js/showmore.js"></script>
    <script src="${pageContext.request.contextPath}/js/videohomepage.js"></script>
    
<html>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel='stylesheet' type='text/css' media="all"/>
<!-- //bootstrap -->
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' media="all"/>


<nav class="navbar navbar-inverse navbar-fixed-top" style="padding-bottom: 0px; height: 117px; padding-top: 0px; z-index:1;">

	<!-- 添加背景图片 -->
	<div style="background-image:  url('http://img2.3lian.com/2014/f3/10/50.jpg');height:70px;width:100%">
<!-- 	<div style="height:70px;width:100%;" img src="/dmsd-itoo-video-web/src/main/webapp/images/homePicture.png/"> -->
		
    <div class="container-fluid" >
        <div class="navbar-header">
            <a class="navbar-brand" href="/dmsd-itoo-video-web/videohomepage/1"><h1><img src="${pageContext.request.contextPath}/images/topleftlogo.png" alt=""/></h1></a>
        </div>
        
        <div id="navbar" class="navbar-collapse collapse" style="margin-top:10px;">
            <div class="top-search">
               <!--  <form class="navbar-form navbar-right">
                    <input type="text" class="form-control" placeholder="Search...">
                    <button type="submit" id="searchtxt" value="" onClick="doSearch()"></button>
                    <button class="search-submit" type="submit"></button>
                </form> -->
                
                <form class="navbar-form navbar-right" style="margin-left:20%;">
 						<div style="float:right">
							<input id="querytxt" class="form-control" type="text" style="width:250px;margin-right:13px" placeholder="打造扛得住的MySQL数据库"/>
 							<button onclick="search1()" class="btn btn-default" type="button" id="searchtxt" style="margin-left: -18px; padding: 0px; height: 33px; width: 43px;"><img src="/dmsd-itoo-video-web/images/search.png"></button>  
 							<!-- <button style="margin-left:-20px;" id="searchtxt" type="submit" class="btn btn-default" onClick="search1()">查询</button> -->
<!-- 							bilibili的例子 -->
<!-- 							<button type="submit" id="searchtxt" value=" " onClick="doSearch()"></button> -->
							
 						</div>          
				</form>
            </div>
            
            <div style="font-size:14px;margin-top:3px;">
<!--             id="userName" -->
<%-- 				<input style="width:40px;background-color:transparent ;border:none;color:white">${ sessionScope.userName}<span style="color:white;">：您好！</span> --%>
				<font size="3" color="white" id="userName">${ sessionScope.userName}</font><span style="color:white;">：您好！</span>
				<a id="topdaohang" target="_blank" ><img id="userImage" src="${ sessionScope.loginPic}" alt="" style="width:3.5%;height:3.5%;margin-left:1%;">
 				<input type="hidden" id="userId" text="">
<%--  				<font size="3" color="white" id="userId">${ sessionScope.userId}</font> --%>
 				</a>
<!--  				弹出页样式，function中已经拼接 -->
				<!-- <ul style=" background-color: #fff;
		                    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.16);
		                    display: block;
		                    right: 0;
		                    top: 50px;
		                    width: 150px;
		                    float:right;
		                    z-index: 15;
		                    transition: all 0.2s ease 0s;
		                    position: absolute;
		                    margin-left: -50px; 
		                    left: 1224px;
		                    visibility: hidden;"><br>
					<a href="/dmsd-itoo-video-web/personalCenter/personalCenterInfo" style="margin-left:-20px;"><img src="/dmsd-itoo-video-web/images/gerenzhongxin.png">个人中心</a><br>
	 				<hr style="width:100%;border-top:1px solid #D5D5D5; margin-top: 2px;margin-left:-20px;">
					<a href="/dmsd-itoo-video-web/upload/showPage" style="margin-left:-20px;"><img src="/dmsd-itoo-video-web/images/shangchuanshipin.png">上传视频</a><br>
	   				<hr style="width:100%;border-top:1px solid #D5D5D5; margin-top: 2px;margin-left:-20px;">
					<a href="/dmsd-itoo-video-web/historyRecord/historyRecordInfo" style="margin-left:-20px;"><img src="/dmsd-itoo-video-web/images/guankanjilu.png">观看记录</a><br>
	  				<hr style="width:100%;border-top:1px solid #D5D5D5; margin-top: 2px;margin-left:-20px;">
				</ul> -->
            
            <div class="header-top-right">
                    <script type="text/javascript">

                    $(function (){ 
                        var ulstring="<ul id='sss' style='width:150px;top: 50px;'>"
                            +"<a href='/dmsd-itoo-video-web/personalCenter/personalCenterInfo' style='margin-left:-20px;'><img src='/dmsd-itoo-video-web/images/gerenzhongxin.png'>个人中心</a><br>"
                            +"<hr style='width:100%;border-top:1px solid #D5D5D5; margin-top: 2px;margin-left:-20px;'>"
                            +"<a href='/dmsd-itoo-video-web/upload/showPage' style='margin-left:-20px;'><img src='/dmsd-itoo-video-web/images/shangchuanshipin.png'>上传视频</a><br>"
                            +"<hr style='width:100%;border-top:1px solid #D5D5D5; margin-top: 2px;margin-left:-20px;'>"
                            +"<a href='/dmsd-itoo-video-web/historyRecord/historyRecordInfo' style='margin-left:-20px;'><img src='/dmsd-itoo-video-web/images/guankanjilu.png'>观看记录</a><br>"
                            +"<hr style='width:100%;border-top:1px solid #D5D5D5; margin-top: 2px;margin-left:-20px;'>"
                            +"</ul>";
                    	$("#topdaohang").popover({ 
                        	trigger:'manual',//manual 触发方式
            	            placement : 'bottom',  
            	          /*   title : '<div style="text-align:center; color:red; text-decoration:underline; font-size:14px;"> Muah ha ha</div>', */
            	            title:'<div style="text-align:center; color:gray; font-size:12px;">用户名称</div>',
            	            html: 'true', 
            	            content : ulstring,  //这里可以直接写字符串，也可以 是一个函数，该函数返回一个字符串；
            	            animation: false
            	        }) .on("mouseenter", function () {
            	                    var _this = this;
            	                    $(this).popover("show");
            	                    $(this).siblings(".popover").on("mouseleave", function () {
            	                        $(_this).popover('hide');
            	                    });
            	                }).on("mouseleave", function () {
            	                    var _this = this;
            	                    setTimeout(function () {
            	                        if (!$(".popover:hover").length) {
            	                            $(_this).popover("hide")
            	                        }
            	                    }, 100);
            	                    });  
                    });
                    
                        function SercherInfo()
                        {
                        	   window.location.ref="http://localhost:8080/dmsd-itoo-video-web/Index/video/1";  
                        }
                   </script>
                  
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
    
    <div style="margin-top:10px;width:100%;">
  		<hr style="height: 2px; border-top: 2px solid rgb(33, 222, 239); margin-top: 10px;">
  	</div>    
 
  
  	<div style="width:100%;height:20px;">
		<a href="/dmsd-itoo-video-web/videohomepage/1" class="home-icon">
			<h4 style="float: left; text-align: center; margin-left: 45%; margin-top: -10px;">首页
      			<hr style="border-top: 5px solid #00CCFF; margin-top: 2px;">
      		</h4>
      	</a>
      
      	<a href="/dmsd-itoo-video-web/showmore/1" class="user-icon">
	  		<h4 style="float: left; margin-left: 50px; margin-top: -10px;">扩展学习
        		<hr style="border-top: 5px solid #00CCFF; margin-top: 2px;">
      		</h4>
      	</a>
  	</div>
  	</div>
  	<!-- <div style="width:100%;">
  		<hr style=" height:2px;;border-top:2px solid gray;">
	</div>  --> 
</nav>

