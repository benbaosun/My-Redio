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
		<title>我的地盘--个人中心</title>
	</head>
	<body>		
		<jsp:include page="maintop.jsp"/>
	
		<div class="container">
			<div class="row clearfix">
				<div class="mainCol">
					<div class="uploadHot" style="background:url(${pageContext.request.contextPath}/images/backpicture1.jpg);margin-top:100px;" onclick="file.click()" >	
						<input id="file" type="file" name="file" onchange="uploadfile(this)"  style="visibility:hidden"/>
						<input type="hidden" id="imageType" name="imageType">					
					</div>	
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">		
		//上传图片
		function uploadfile(){
			
			$.ajaxFileUpload({
				url : '<%=basePath%>'+"personalCenter/upload",
				type:"Post",
				async:false,
				dataType:'json',
				fileElementId : "file",// 文件选择框的id属性
				success : function(data) {									
					var headPicture=data.headPicture;	
					console.info("上传的图片路径"+headPicture);				
					sessionStorage.setItem("headPicture", headPicture);					
					console.info("图片上传成功！");	
					save();				
				},
				error : function() {
					console.info("图片上传失败！");					
				}
			});
		}	
		function save(){	
								
			var headPicture=sessionStorage.getItem("headPicture");							
			$.ajax({
				url: '<%=basePath%>'+"personalCenter/save",
				async:false,
				type:"POST",				
				data:{"headPicture":headPicture},
				success:function(data){					
					console.info("保存成功！");
				},
				error:function(){
					console.info("保存失败！");
				}
			});
		}		

	</script>
</html>