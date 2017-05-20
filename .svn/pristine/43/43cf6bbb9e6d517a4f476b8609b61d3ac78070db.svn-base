<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path =request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>我的地盘--编辑视频</title>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel='stylesheet' type='text/css' media="all"/>
<!-- //bootstrap -->
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' media="all"/>

<%@ include file="/bootstrap.jsp"%>
<%@ include file="/common.jsp"%>


</head>
	<body>
		<jsp:include page="maintop.jsp"/>	
		
		<div class="container" id="myVideo_list" style="margin-top:100px;">
			
		</div>
		
		<button type="button" class="btn btn-info" style="margin-left:470px;width:400px;" onclick="queryMyVideo()" value="查看更多" >查看更多</button>
<!-- 		<button type="button" class="btn btn-info"  onclick="queryAllMyVideo()" value="查看全部" >查看全部</button> -->
		<input type="hidden" id="pageNum" name="pageNum" value="1"/>
		<input type="hidden" id="pageSize" name="pageSize" value="8"/>
		
	</body>
	
<script type="text/javascript">

/**
 * 自动加载查询的方法-丁国华-2016年8月31日 09:58:24
 */
window.onload=queryMyVideo;

/**
 * 分页查询编辑页面的信息-丁国华 - 2016年8月20日 20:57:19
 */
	function queryMyVideo(){
		var str = $("#pageNum").val();
		var str1 = $("#pageSize").val();

		$.ajax({
			tyep:"GET",
			url:'<%=basePath%>'+"editInfo/queryMyVideo",
			data:{"page":str,"rows":str1},
			datetype:"json",
			success:function(data){
				document.getElementById("myVideo_list").innerHTML += data;
				var pageNum = $("#pageNum").val()*1 + 1;
				console.info(pageNum);		
		    	$("#pageNum").attr("value",pageNum);//填充内容
									
			},
			error:function(){
				console.info("error");
			}     
		})
	}


	/**
	 * 查看全部信息+丁国华 + 2016年8月20日 20:57:19
	 */
		function queryAllMyVideo(){

			$.ajax({
				tyep:"GET",
				url:'<%=basePath%>' + "editInfo/queryAllMyVideo",
			datetype : "json",
			success : function(data) {
				console.info(data);
				document.getElementById("myVideo_list").innerHTML = data;
					 				
			},
			error : function() {

				console.info("error");
			}

		});

	

	}

	/**
	 * 删除视频信息-丁国华--2016年8月21日 20:22:03
	 */
	function deleteById() {		

		var videoid=localStorage.getItem("videoid");		
			
		$.messager.confirm('提示', '确定要删除所选记录吗？删除之后，将不能恢复！', function(r) {
			if (r) {
				$.ajax({
					type : "GET",
					dataType : "json",
					data : {"videoid" : videoid},
					url : '<%=basePath%>'+"editInfo/delete",
					success:function(){
						$.messager.alert('提示', '删除成功!');
						document.getElementById("myVideo_list").innerHTML="";
						window.location.reload();
					},
					error : function() {			
						$.messager.alert('提示', '删除成功!');
						document.getElementById("myVideo_list").innerHTML="";
						window.location.reload();
					}
				});
						
			}
		});

		}

	 function showdelete(obj){
		//获取当前触发的控件id
		var videopicture=$(obj).attr("id");
		var deletenum=videopicture.substring(videopicture.length-1,videopicture.length);		
		//获取当前的videoid的id
		var video="videoid" +deletenum;
		var videoid=$("#"+video).text();
		localStorage.setItem("videoid",videoid);		
		
		$("#"+videopicture).popover({ 
        	trigger:'manual',//manual 触发方式
            placement : 'bottom',  
            title : '<div onclick="deleteById()" style="text-align:center; color:red; text-decoration:underline; font-size:14px;"> 删除此项观看记录</div>', 
//             title:'删除此项观看记录',
            html: 'false', 
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
		
	 }

</script>

	
</html>


