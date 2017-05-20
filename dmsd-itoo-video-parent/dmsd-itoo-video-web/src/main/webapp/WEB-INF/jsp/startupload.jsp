<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	<head>
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	    <meta name="keywords" content="My Play Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
	    <script type="application/x-javascript"> addEventListener("load", function () {
	        setTimeout(hideURLbar, 0);
	    }, false);
	    function hideURLbar() {
	        window.scrollTo(0, 1);
	    } </script>
		<link href="../css/upload.css" rel="stylesheet" type="text/css">
		<link href="../css/bootstrap.css" rel="stylesheet" type="text/css">	
		<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
	    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxfileupload.js">
		</script>	
		<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel='stylesheet' type='text/css' media="all"/>
	    <!-- //bootstrap -->
	    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
	    <!-- Custom Theme files -->
	    <link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' media="all"/>	
		<title>校园视频</title>
	</head>
	<body>
		
		<jsp:include page="maintop.jsp"/>
		
		<div class="uploadTitle">
			<h3 style="margin-top: 50px">上传视频</h3>
		</div>		
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
						
					<div class="form-group">
						 <label for="exampleInputEmail1" style="margin-top:20px">视频上传进度</label>
						 <div class="progress active">
							  <div class="progress-bar progress-success" role="progressbar" aria-valuenow="60" 
							  aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
							  <span class="sr-only">100% 完成</span>
						 </div>
					</div>
					</div>
					
					<div class="form-group">						
						 <label for="exampleInputEmail1"  style="font-size:20px">视频名称</label>
						 <input class="form-control" style="font-size:26px;height:40px" id="videoname" type="text" value="456"/>
					</div>
					<div class="form-group">
<!-- 						 <label for="videodesc" hidden="true">视频描述</label><textarea id="videodesc" class="form-control" name="txt" style="width:1112" clos="1000" rows="5" warp="virtual"></textarea> -->
					</div>

					<div class="form-group">
						 <label for="videotype">视频分类</label>

						  <select id="videotype" class="form-control" style="height:40px"> 
							  <option selected="true">物理与电子信息学院</option> 
							  <option>数学</option> 
							  <option>汉语言</option> 
							  <option>大学英语</option> 
							  <option>化学</option> 
						  </select>
					</div>		
					<form action="" method="post" enctype="multipart/form-data" >			
						<div >
							<label for="exampleInputFile">上传图片</label>
							<input id="file" type="file" name="file" onchange="uploadfile(this)"/>
<!-- 							<input type="submit" value="上传图片"/> -->
							<p  class="help-block">
								该图片信息将会出现在主页上。
							</p>
							<input type="hidden" id="imageType" name="imageType">
						</div>
						
						<button type="submit" class="btn btn-default" style="background-color: #21aEEF;color:white;width:200px" onclick="save()">提交</button>
					</form>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		window.onload=function(){
			var videoName=getQueryString("videoname");
			console.info("上传的视频名称"+videoName);
 			$("#videoname").val(videoName);
		}
		//上传图片
		function uploadfile(){
			
			$.ajaxFileUpload({
				url : '<%=basePath%>'+"upload/upload",
				type:"Post",
				async:false,
				dataType:'json',
				fileElementId : "file",// 文件选择框的id属性
				success : function(data) {									
					var videopath=data.videoPath;	
					console.info("上传的图片路径"+videopath);				
					sessionStorage.setItem("picturePath", videopath);					
					console.info("图片上传成功！");					
				},
				error : function() {
					console.info("图片上传失败！");					
				}
			});
		}	
		function save(){			
			var videoType=$("#videotype").val();
			console.info("上传的视频类型"+videoType);
			var videoDesc=$("#videodesc").val();
			console.info("上传的视频描述"+videoDesc);			
			var videoPath=getQueryString("videopath");
			console.info("上传的视频服务器路径"+videoPath);			
			var videoName=getQueryString("videoname");	
			console.info("上传的视频名称"+videoName);			
			var picturePath=sessionStorage.getItem("picturePath");
			console.info("上传的图片服务器路径"+picturePath);						
			$.ajax({
				url: '<%=basePath%>'+"/upload/save",
				type:"Post",
				data:{"videoName":videoName,"videoType":videoType,"videoDesc":videoDesc,"videoPath":videoPath,"picturePath":picturePath},
				success:function(data){
					console.info(data);
					console.info("保存成功！");
				},
				error:function(){
					console.info("保存失败！");
				}
			});
		}	
		function getQueryString(name) { 
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
			var r = window.location.search.substr(1).match(reg); 
			if (r != null) return unescape(r[2]); return null; 
		}
		
	 	function submitform(){			
	 		this.form.submit(); //提交表单
		}
	</script>
</html>