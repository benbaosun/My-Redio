<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String id = request.getParameter("id");
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>我的地盘-播放</title>
<base href="<%=basePath%>">
<meta charset="UTF-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel='stylesheet' type='text/css' media="all" />
<!-- bootstrap -->
<link href="${pageContext.request.contextPath}/css/dashboard.css"
	rel="stylesheet">
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/css/style.css"
	rel='stylesheet' type='text/css' media="all" />
<!-- circular -->
<%-- <link href="${pageContext.request.contextPath}/css/circular.css" rel="stylesheet" type="text/css"/> --%>

<%@ include file="/bootstrap.jsp"%>
<%@ include file="/common.jsp"%>


<style type="text/css">
.imgCicular {
	margin: 10px 5px;
	overflow: hidden;
}

.list_ul figcaption p {
	font-size: 12px;
	color: #aaa;
}

.imgCicular figure div {
	display: inline-block;
	margin: 5px auto;
	width: 100px;
	height: 100px;
	border-radius: 100px;
	border: 2px solid #fff;
	overflow: hidden;
	-webkit-box-shadow: 0 0 3px #ccc;
	box-shadow: 0 0 3px #ccc;
}

.imgCicular img {
	width: 100%;
	min-height: 100%;
	
}
</style>

<body style="background-color:#EEEEEE">
	<jsp:include page="maintop.jsp" />
	
	<div class="container">

		<div id="videoDiv">
			<div id="videoName" style="font-size: 14px; font-weight: bold;"></div>
			<br>
		</div>
		
		<!-- 视频分类 -->
		<div class="container" id="">
			
			<label style="margin-top:70px;margin-left:15px;align:left;background-color:white;height:30px;width:296px">接下来播放</label>			
			<div id="videoType_list" style="margin-top:-50px">			
			</div>
			<input type="button"  id="pageNum" name="pageNum" value="1" style="display:none" />
		 	<input type="button"  id="pageSize" name="pageSize" value="4"  style="display:none"/>
		</div>

	<!-- 下载和评论区域 -->
	<div style="margin-top: 150px;">
		<!-- 	<button type="button" class="btn btn-default btn-lg btn-block" -->
		<!-- 		class="btn btn-info">下载</button> -->
	
		<!-- 圆角头像的制作 -->
		<div class="imgCicular" style="margin-top: -120px;">
			<figure>
			<div id="headpicture">
<!-- 				<img src="/dmsd-itoo-video-web/images/rose.jpg" style="widht: 100px; height: 100px; margin-top: 1px; float: left; margin-right: 25px;"> -->
			</div>
			</figure>
		<div style="margin-left:-70px;">
	
		<!-- 评论区域 -->
		<textarea style="margin-left:16%;margin-top:-7.5%;margin-bottom:1%; width: 680px; height: 80px;" rows="5" class="form-control" id="commentContent"></textarea></div>
		<!-- 提交按钮 -->
		<div class="pull-right" >
			<a style="margin-right:53%; margin-top:-35%;margin-bottom:5%; width: 150px; height: 80px; font-size: 25px; padding-top: 20px;" onclick="addComment()" class="btn btn-large btn btn-info">发表评论</a>
	
		</div>
	</div>
	</div>

	<!-- 评论列表 -->
	<div id="comment_list" style="margin-top: 30px;">
		<dl id="comment_item_6044655" class="comment_item comment_topic">
			<dt class="comment_head" floor="3">
	
				<span class="user">
					<table width="100%">
	
					</table>
				</span>
			</dt>
	
	
			<dl id="comment_item_6085876" class="comment_item comment_reply">
				<dt class="comment_head" floor="131">
			</dl>
		</dl>
	</div>
	<div>
		<button id="queryMoreBtn" type="button" class="btn btn-info" onclick="appendComment()" style="margin-left:355px;margin-right:auto;position:relative;width:400px;" value="查看更多">查看更多</button>
		 <input type="hidden" id="pageNum" name="pageNum" value="1" style="display:none" />
		 <input type="hidden" id="pageSize" name="pageSize" value="10" style="display:none"/>
	</div>

</body>

<script type="text/javascript">

/**
 * 自动加载评论的方法--丁国华--2016年8月28日 09:48:46
 */
// window.onload=appendComment;

/**
 * 根据视频id查询视频信息的方法--丁国华--2016年8月28日 09:49:43
 */

$(function(){
	$(".btn-info").css("display:none");
 	appendComment();
	queryVideoInfoById();
	queryVideoInfoByVideoType();
	queryHeadPicture();
})

	/*
	 * 查询当前用户的头像
	 */
	function queryHeadPicture(){		
		$.ajax( {   
		    type : "GET",   
		    url:'<%=basePath%>'+"comment/queryHeadPicture",		    
		    dataType: "json",   
		    success : function(data) {   
		    	document.getElementById("headpicture").innerHTML += data;				
		    	console.info("查询成功");
		    }
		});   
	}


/**
 * 查看更多评论的方法--丁国华--2016年8月28日 09:48:46
 */
function appendComment(){
	//默认查看更多按钮为隐藏
	$("#queryMoreBtn").hide();	
	var str = $("#pageNum").val();
	var str1 = $("#pageSize").val();

	var videoId='<%=id%>';	
	
	
	$.ajax( {   
	    type : "GET",   
	    url:'<%=basePath%>'+"comment/CommentList",
	    data:{"page":str,"rows":str1,"videoId":videoId},
	    dataType: "json",   
	    success : function(data) {   
	    	document.getElementById("comment_list").innerHTML += data;
	    	var n=(data.split('暂时没有评论')).length-1; //查询数据库里有多少条评论
	    	if (n != 0)
		    {
	    		var pageNum = $("#pageNum").val()*1 + 1;
				console.info(pageNum);		
		    	$("#pageNum").attr("value",pageNum);//填充内容
		    	
		    	if(n >=pageSize*1){
		    		$("#queryMoreBtn").show();
				}
		    	
				if(n < pageSize*1){
					$("#queryMoreBtn").hide();	
				}
		    }
	    	
	    	console.info("查询成功");
	    }, 
	    error :function(){   
	       
	    }   
	});   
	}  
	
	
/**
 * 添加评论--丁国华--2016年8月23日 21:01:45
 */


function addComment(){	 
	var commentContent = $("#commentContent").val();

    //添加用POST提交方式，提交路径中为名词
    $.ajax({
        type:"GET",
        datatype:"json",
        data:{"commentContent":commentContent},
        url:'<%=basePath%>'+"comment/addComment",
        success:function(data){        
            var oldComments = document.getElementById("comment_list").innerHTML;

            $("#comment_list").children().remove();
   
          	var newComments = data + oldComments;

          	document.getElementById("comment_list").innerHTML +=newComments;
			$(".page-header").remove();
			
          	$("#commentContent").val("");
				console.info("addComment方法成功");
            },
        	error:function(err){
		
            }
      
           
            
    })
    //
}
// /**
//  * 查询评论--丁国华--2016年8月25日 21:02:06
//  */
// function queryCommentList(){
<%-- 	 var videoId='<%=id%>'; --%>
// 	$.ajax({
//         type:"GET",        
//         data:{"videoId":videoId},
//         datatype:"json",
<%--         url:'<%=basePath%>'+"comment/CommentList", --%>
//         success:function(data){
// 			console.info("方法执行成功");
// 			document.getElementById("comment_list").innerHTML += data;
// 			//刷新
//             },     
//     });
	
// }

function add()
{
	
    //添加用POST提交方式，提交路径中为名词
    $.ajax({
        type:"POST",
        url:'<%=basePath%>'+"comment/course1"
    })
}

/**
 * 根据视频id查询商品的相关信息--丁国华--2016年8月27日 21:03:24
 */

 function queryVideoInfoById(id){
	 	$.ajax({
	        type:"GET",
	        datatype:"json",	 
	        url:'<%=basePath%>'+"comment/queryVideoByid",
	        success:function(data){
		        var videoName = data[0].videoName ;
	        	document.getElementById("videoName").innerHTML+=videoName;
				document.getElementById("videoDiv").innerHTML+="<video id='really-cool-video' class='video-js vjs-default-skin' controls preload='auto' style='float:left;margin-top:-5px;width:800px;height:600px' poster='http://video-js.zencoder.com/oceans-clip.png' data-setup='{}'><source id='path' src='"+data[0].videoPath+"' type='video/mp4' /><p class='vjs-no-js'>To view this video please enable JavaScript, and consider upgrading to a web browser that <a href='http://videojs.com/html5-video-support/' target='_blank'>supports HTML5 video</a></p></video>"
				
	         },
	        error:function(err){
			    console.info("视频查询失败" + error);
             }
	      
	           
	            
	    })
		
	}

 /**
  * 根据videoType分页查询相关视频信息--丁国华--2016年9月23日 16:12:40
  */


  function queryVideoInfoByVideoType(){	
	  	var strPageNum = $("#pageNum").val();
		var strpageSize = $("#pageSize").val();
		$.ajax({
			type:"GET",
			url:'<%=basePath%>' + "comment/queryVideoInfoByVideoType",
			data:{"page":strPageNum,"rows":strpageSize},
			datatype : "json",
			success : function(data) {
				console.info(data);			
				document.getElementById("videoType_list").innerHTML=data;		 				
			},
			error : function() {	
				console.info("error");
			}

	});
}



</script>

</html>