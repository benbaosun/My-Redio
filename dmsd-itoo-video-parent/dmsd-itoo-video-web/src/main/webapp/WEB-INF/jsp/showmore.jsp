<%--
  Created by IntelliJ IDEA.
  User: 徐露    王荣晓修改
  Date: 2016/8/8  2016-8-27
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"  import="java.util.*" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>校园视频</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="My Play Responsive web template, Bootstrap Web Templates, 
    	Flat Web Templates, Andriod Compatible web template,Smartphone Compatible web template, 
    	free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <script type="application/x-javascript"> 
    	addEventListener("load", function () {
        	setTimeout(hideURLbar, 0);}, false);
    	function hideURLbar() {
        	window.scrollTo(0, 1);
    	}

    </script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/userinfo.js"></script>
	<script src="${pageContext.request.contextPath}/js/showmore.js"></script>
    <script src="${pageContext.request.contextPath}/js/videohomepage.js"></script>
    
</head>

<body onload="findVideoByCollege('${ sessionScope.colleagueName}')">
	<jsp:include page="maintop.jsp"/>      

	<div class="main-grids" style="margin-top:80px;width:80%;margin-left:16%;position:positive;">
        	
        	<div class="col-sm-10 show-grid-left main-grids">
        		<div id="kuozhanjiemian">
<!--         		<div style="width:97%;height:35px;margin-left:10px;border-style:solid;border-width:1px;border-color:#DDDDDD;background-color:#F7F7F7;"> -->
<!-- 	            	<div style="float:left;width:10%;height:032px;background-color:#FFFFFF;border-right: 1px solid #DDDDDD;font-size:18px;text-align:center;">全部课程</div> -->
<!-- 	                <div style="float:left;margin-top:5px;font-size:14px;margin-left:3%;"> -->
<!-- 	                	学院&nbsp;&nbsp; -->
<!-- 	                	<a id="colleaguedaohang" target="_blank" ><img src="/dmsd-itoo-video-web/images/colleaguedown.png" alt="" onclick="findAllColleague()">  -->
<!-- 		                </a> -->
<!-- 	                </div> -->
<!-- 	              	<div style="float:left;margin-top:5px;font-size:14px;margin-left:3%;"> -->
<!-- 	              		课程类型&nbsp;&nbsp; -->
<!-- 	              		<img src="/dmsd-itoo-video-web/images/colleaguedown.png" alt="">  -->
<!-- 	              	</div> -->
<!-- 	              	<div style="float:left;margin-top:5px;font-size:14px;margin-left:3%;"> -->
<!-- 	              		难度等级&nbsp;&nbsp; -->
<!-- 	              		<img src="/dmsd-itoo-video-web/images/colleaguedown.png" alt="">  -->
<!-- 	              	</div> -->
<!-- 	            </div> -->

				<jsp:include page="videotype.jsp"/>  
			
	            <div  class="recommended">
	                <div id="extendstudycenter" class="recommended-grids english-grid">
	                	  
	                    <div class="recommended-info" style="width: 100%; height: 30px;">
	                        <div id="title" class="heading" style="height: 25px;margin-left:15px;">
	                        </div>
	                    </div>
	                    <!-- <div>
            				<hr style=" height:2px;border-top:2px solid #C4C4C4;width:97%;margin-left:1%;position:positive; margin-bottom: 5px;margin-top: 0px;">
            			</div> -->
	                    <div id="top" class="callbacks_container">
		                    <div id="extendstudy">
		                    </div>
	                	</div>
	                    <div class="clearfix"></div>
	                	<div class="clearfix"></div>
	                
            		</div>
        		</div>
        		</div>
        		<div id="queryresult">		
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
    		</div>
        
	<div class="clearfix"></div>
	

	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	
	<script type="text/javascript">
		
	</script>
	
</body>
</html>
