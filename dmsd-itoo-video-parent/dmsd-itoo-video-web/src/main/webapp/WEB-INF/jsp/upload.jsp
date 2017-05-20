<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.dmsd.itoo.video.controller.UploadController" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>	
	<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	<head> 		 		
		<title>我的地盘--上传</title>
		<link href="${pageContext.request.contextPath}/css/upload.css"	rel="stylesheet" type="text/css">		
		<link rel="stylesheet" type="text/css" href="http://222.222.124.77:9001/themes/default/easyui.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js">
		</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js">
		</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-confirm.js">
		</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/uploadfile.js">
		</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxfileupload.js">
		</script>	
		<script type="text/javascript" src="http://222.222.124.77:9001/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="http://222.222.124.77:9001/script/EasyUIValidator.js"></script>
		<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel='stylesheet' type='text/css' media="all"/>
	    <!-- //bootstrap -->
	    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
	    <!-- Custom Theme files -->
	    <link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' media="all"/>	
	</head>
	
	<body>		
		
		<jsp:include page="maintop.jsp"/>	
			  
	
		<form id="uploadvideo" action="" style="margin-top:100px;" method="post" enctype="multipart/form-data">                                  
			<div class="mainCol">
				<div class="uploadHot" style="background:url(${pageContext.request.contextPath}/images/backpicture.jpg);margin-top:20px;" onclick="file1.click()" >	
					<input id="file1" type="file" name="file" onchange="uploadfile(this)"  style="visibility:hidden"/>
					<input type="hidden" id="imageType" name="imageType">					
				</div>	
			</div>
			<p align="center" style="margin-top:50px;font-size:16px;">上传校园视频，即表示您已同意相关服务条款，请勿上传色情，发动等违法视频</p>	
		</form>		
		<div id="addvideoinfo" class="container" style="display:none">
			<div class="row clearfix">
				<div class="col-md-12 column">		
					<div class="from-group" style="margin-top:80px">
						<label id="progress" for="exampleInputEmail1" style="font-size:16px;margin-top:20px">视频上传进度</label>			
						<div id="progressNumber" class="easyui-progressbar" style="width:400px;"></div>					
					</div>
					<div class="form-group">						
						 <label for="exampleInputEmail1"  style="font-size:16px;margin-top:20px">视频名称</label>
						 <input class="form-control" style="font-size:26px;height:50px" id="videoname" type="text"/>
					</div>					
					<div class="form-group" style="margin-top:20px">
						 <label for="videotype" style="font-size:16px;">视频分类</label>		
						 <input class="form-control" id="videotype" style="font-size:16px;height:40px" type="text" value="提高班之家"/>				 
					</div>
					<div class="form-group" style="margin-top:20px">
						  <label id="showmore" onclick="showmore()" href="#" style="color:blue;TEXT-DECORATION: underline;font-size:16px">>>更多</label>						 
					</div>	
					
					<div id="videoDesc" class="form-group" style="margin-top:20px;display:none">
						 <label style="font-size:16px;">视频描述</label><textarea id="videodesc" class="form-control" name="txt" style="width:1112" clos="1000" rows="5" warp="virtual"></textarea>
					</div>	
					<div id="warn"style="display:none">
						<div  class="easyui-window" data-options="title:'视频上传提示',inline:true" style="width:250px;height:150px;left:500px;top:80px;padding:10px;">
							视频提交成功！
						</div>
					</div>
					<button type="submit" class="btn btn-default" style="background-color: #21aEEF;color:white;width:200px" onclick="save()">提交</button>
					<button type="submit" class="btn btn-default" style="background-color: #21aEEF;color:white;width:200px" onclick="window.location.reload()">继续上传</button>
					<input id="videopath" hidden=true/>
					<input id="picturepath" hidden=true/>
					</div>
			</div>
		</div>
		
	</body>
	<script type="text/javascript">

	window.onload=function(){
		$.ajax({
			type:"Post",
			url:'<%=basePath%>'+"userInfo/checkUserColleague",
			datatype:'json',
			success:function(data){ 				
// 				$("#videotype").val(data[0].remark);
			}
		});
	}
	function showmore(){

		//显示视频描述信息		
		var videoDesc=document.getElementById("videoDesc");
		if(videoDesc.style.display=="block"){
			document.getElementById("showmore").innerHTML="<<收回";
			videoDesc.style.display="none";	
		}else{
			document.getElementById("showmore").innerHTML=">>更多";
			videoDesc.style.display="block";
		}
	}
	var xhr;  
	function createXMLHttpRequest() {  
	    try {  
	    	xhr = new ActiveXObject("Msxml2.XMLHTTP");//IE高版本创建XMLHTTP  
	    }  
	    catch(E) {  
	        try {  
	        	xhr = new ActiveXObject("Microsoft.XMLHTTP");//IE低版本创建XMLHTTP  
	        }  
	        catch(E) {  
	        	xhr = new XMLHttpRequest();//兼容非IE浏览器，直接创建XMLHTTP对象  
	        }  
	    }  
	  
	}
	function uploadfile(obj){
		//自动隐藏上传按钮，显示上传的具体信息
		var upload=document.getElementById("uploadvideo");
		upload.style.display="none";
		var addvideoinfo=document.getElementById("addvideoinfo");
		addvideoinfo.style.display="block";	

		//进度条设置
		var file=document.getElementById("file1").files[0];
		var fileName=file.name;
		var fileSize=(Math.round(file.size * 100 /1024) / 100).toString() + "KB";
		$("#videoname").val(fileName);


		var fd=new FormData();
		fd.append("file",file);
		  
	    createXMLHttpRequest();                                //创建XMLHttpRequest对象  
	    xhr.open("post",'<%=basePath%>'+"/upload/upload", true);  
	    xhr.upload.addEventListener("progress",uploadProgress,false);
	    xhr.onreadystatechange = processResponse; //指定响应函数  
	    xhr.send(fd); 

	}
	//回调函数  
	function processResponse() {  
	    if (xhr.readyState == 4) {  
	        if (xhr.status == 200) {  
	            var text = xhr.responseText;	            
				var str=text.split(",")[13];
				var str2=text.split(",")[21];				
				var videoPath=str.split("\"")[3];					
				var picturePath=str2.split("\"")[3];
// 				var picturePath1=${picturePath};
				
				document.getElementById("videopath").value=videoPath;
				document.getElementById("picturepath").value=picturePath;
	        }  
	    }  
	  
	} 

	function uploadProgress(evt){
		if (evt.lengthComputable) {
			 var percentComplete = Math.round(evt.loaded * 100 / evt.total);
			 $('#progressNumber').progressbar('setValue', percentComplete);

		    //隐藏进度条
		    var progressNumber=document.getElementById("progressNumber");
		    var progress=document.getElementById("progress");
		    if (percentComplete == 100){	
		    	progressNumber.style.display="none";
		    	progress.style.display="none";
			}
		}
	}

	function save(){			
		var videoType=$("#videotype").val();
		console.info("上传的视频类型"+videoType);
		var videoDesc=$("#videodesc").val();
		console.info("上传的视频描述"+videoDesc);			
		var videoPath=document.getElementById("videopath").value;
		console.info("上传的视频服务器路径"+videoPath);			
		var videoName=document.getElementById("videoname").value;	
		console.info("上传的视频名称"+videoName);			
		var picturePath=document.getElementById("picturepath").value;
		console.info("上传的图片路径"+picturePath);
		$.ajax({
			url: '<%=basePath%>'+"/upload/save",
			type:"Post",
			data:{"videoName":videoName,"videoType":videoType,"videoDesc":videoDesc,"videoPath":videoPath,"picturePath":picturePath},
			success:function(data){
				console.info(data);
				console.info("视频保存成功！");
				document.getElementById("warn").style.display="block";			
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
	</script>
</html>
