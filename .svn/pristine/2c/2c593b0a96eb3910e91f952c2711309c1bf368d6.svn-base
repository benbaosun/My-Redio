<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
	<title>校园视频</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="keywords" content="My Play Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design">
 
    <script src="${pageContext.request.contextPath}/js/videohomepage.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/userinfo.js"></script>
	<script src="${pageContext.request.contextPath}/js/showmore.js"></script>
    <base href="<%=basePath%>">
    
</head>

<body onload="homepageload('${ sessionScope.colleagueName}')">

	<!-- 首页界面头样式 -->
	<jsp:include page="maintop.jsp"/>     
	
	<!-- 测试查询基础数据写的内容 -->
	<!-- <div style="width:100%;height:20%;margin-top:10%">
		<form class="navbar-form navbar-right" style="margin-left:20%;">
			<div style="float:right">
				<button onclick="checkUserInfo()" class="btn btn-default" type="button" id="searchtxt" style=" width:80px;height:30px; padding: 5px 10px 4px;">查询</button> 
			</div>
		</form>
	</div> -->
	
	 <div id="videohomepagetop" class="main-grids" style="margin-top:80px;width:80%;margin-left:10%;position:positive;">
	        <div class="top-grids">
	            <div style="width:100%;height:30px;" class="recommended-info">
	                <h3 style="float: left;margin-left:15px;">实战推荐</h3>
	                
                  	<h5 style="float: left; margin-left: 50px;width:50px;heigh:30px; text-align: center; margin-left: 83%;margin-top:8px;">更多&gt;&gt;</h5>
                 
        		
	            </div>
	            <div >
	            	<hr style=" height:2px;border-top:2px solid #C4C4C4;width:97%;margin-left:-7.5%;position:positive; margin-bottom: 5px;margin-top: 8px;">
	            </div>
	            
	            <div id="top" class="callbacks_container">
                    <div id="mainshizhan"></div>
                </div>
	            
	        	<div class="clearfix"></div>
        	</div>
        	
        	
   
   			<div class="recommended">
	            <div class="recommended-grids">
	                <div style="width:100%;height:30px;" class="recommended-info">
		                <h3 style="float: left;margin-left:15px;">热门推荐</h3>
	                  	<h5 style="float: left; margin-left: 50px;heigh:100px; text-align: center; margin-left: 83%;margin-top:8px;">更多&gt;&gt;</h5>
		            </div>
		            <div >
		            	<hr style=" height:2px;border-top:2px solid #C4C4C4;width:97%;margin-left:-7.5%;position:positive; margin-bottom: 5px;margin-top: 8px;">
		            </div>
                	<div id="top" class="callbacks_container">
                    	<div id="mainremen"></div>
                	</div>
                	<div class="clearfix"></div>
            	</div>
       		</div>
   
	        <div class="recommended">
	            <div class="recommended-grids">
	                <div style="width:100%;height:30px;" class="recommended-info">
		                <h3 style="float: left;margin-left:15px;">猜你喜欢</h3>
	                  	<h5 style="float: left; margin-left: 50px;heigh:100px; text-align: center; margin-left: 83%;margin-top:8px;">更多&gt;&gt;</h5>
		            </div>
		            <div >
		            	<hr style=" height:2px;border-top:2px solid #C4C4C4;width:97%;margin-left:-7.5%;position:positive; margin-bottom: 5px;margin-top: 8px;">
		            </div>
	                <div id="top" class="callbacks_container">
	                    <div id="mainyoulike">
	                    </div>
	                </div>
				</div>                
        		<div class="clearfix" ></div>
     		</div>
  		</div> 

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">		
        <div class="recommended">
           <div id="youlike"></div>
        </div>                
	    <!-- 分页查询显示 -->
	    <div class="container" id="myVideo_list"></div>
	    <button type="button" id="findmore" style="display:none;" class="btn btn-info" style="margin-left:50px" onclick="search1()" value="查看更多" >查看更多</button>
		<button type="button" style="display:none;" class="btn btn-info"  onclick="queryAllMyVideo()" value="查看全部" >查看全部</button>
		<input type="hidden" id="pageNum" name="pageNum" value="1" />
		<input type="hidden" id="pageSize" name="pageSize" value="4"/>
    </div>
</body>

<style>
	a.descr{
		background: rgba(0, 0, 0, 0) url("./images/u12.png") no-repeat scroll 0 1px;
	    color: #21deef;
	    padding-left: 1.8em;
	    text-decoration: none;
	    font-size:14px;
	}
</style> 
</html>