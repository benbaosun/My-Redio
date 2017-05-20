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
<title>我的地盘--观看记录</title>
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
<style type="text/css">
	html{
	 
	/*针对此实例的代码*/
	  display: table;
	  min-width:100%;
	  height: 100%;/*为什么不给html一个min-height:100%，而是height，因为通过min-height给的高度，子元素无法对其做高度百分比计算*/
	}
	
	body{
	  /*针对此实例的代码*/
	  display: table-cell;
	  /*针对此实例的代码 End*/
	  background-color:#ff4400;
	}

</style>

</head>
	<body style="background-color:#EEEEEE;height:100%">
		<jsp:include page="maintop.jsp"/>		
		<div style="height:1000px;background-color:#EEEEEE;">
			<div id="u3" class="ax_paragraph" style="margin-top:68px;position:relative">
		        <img id="u3_img" class="img " style="background-color:white" src="${pageContext.request.contextPath}/images/transparent.gif"/>
		        
		        <div id="u4" class="text" >
		         	<p style="background-color:white;width:900px;margin-left:auto;margin-right:auto;margin-top:20px"><span style="margin-left:5px;font-family: '华文隶书 Regular', '华文隶书';font-size:20px;color:#00CCFF">观看记录</span></p>
		        </div>
	     	</div>      	
			<div id="u2" class="ax_horizontal_line" style="margin-left:auto;margin-right:auto;background-color:white;width:900px;margin-top:-10px;position:relative">	        
		        <img id="u2_line" class="img " style="margin-left:5px" src="${pageContext.request.contextPath}/images/line1_u36_line.png" alt="u2_line"/>
	    		<img id="u27_line" class="img " style="margin-left: -10px" src="${pageContext.request.contextPath}/images/line2_u39_line.png" alt="u27_line"/>
	      	</div>	
	      	<div style="margin-left:auto;margin-right:auto;margin-top:5px;width:900px;background-color:white;height:40px;position:relative">
	      		<input type="button" id="clearall" style="margin-top:10px;margin-left:5px;" value="清除所有观看记录" onclick="clearallhistory()"/>	      		
	      	</div>	      		
			<div class="container" id="myHistoryRecord_list">	
						
			</div>
			<button type="button"class="btn btn-info"  style="margin-left:450px;margin-right:auto;position:relative;width:400px;" onclick="queryHistoryRecord()" value="查看更多" >查看更多</button>
<!-- 				<button type="button" class="btn btn-info"  onclick="queryAllMyHistoryRecord()" value="查看全部" >查看全部</button> -->
			<input type="hidden" id="pageNum" name="pageNum" value="1"/>
			<input type="hidden" id="pageSize" name="pageSize" value="5"/>
			<div id="btnInfo">
			 
			</div>		
	<%-- 		<img id="u49_img" class="img" src="${pageContext.request.contextPath}/images/u49.png" /> --%>
		
	   </div> 	
	</body>
	
<script type="text/javascript">

 	window.onload=queryHistoryRecord;

/**
 * 分页查询编辑页面的信息+丁国华 + 2016年8月20日 20:57:19
 */
	function queryHistoryRecord(){
//  	window.onload=function(){ 
		$(".btn-info").hide();
		var pageNum = $("#pageNum").val();
		var pageSize = $("#pageSize").val();	

		$.ajax({
			tyep:"GET",
			url:'<%=basePath%>'+"historyRecord/queryMyHistoryRecord",
			data:{"page":pageNum,"rows":pageSize},
			datatype:"json",
			success:function(data){				
				var n=(data.split('上次观看到')).length-1; //查询数据库里有多少条历史记录
				console.info(n);
				document.getElementById("myHistoryRecord_list").innerHTML += data;
				if(n >0){
// 					document.getElementById("myHistoryRecord_list").innerHTML += data;
					console.info(data);
					//设置分页的页码
					//向下整除
					var pageNum = $("#pageNum").val();
					var pageSize = $("#pageSize").val();
					console.info(pageNum);
					console.info(pageSize);
			
					var num=parseInt(pageNum / pageSize);
					for (var i=1;i<=num+1;i++){
						pageNum=1;
						var pageNum = pageNum*i*pageSize;
					}
					
					console.info(pageNum);		
			    	$("#pageNum").attr("value",pageNum);//填充内容

					if(n >=pageSize*1){
						$(".btn-info").show();
					}
			    	
					if(n < pageSize*1){
						$(".btn-info").hide();
					}
			    	
				}else {
					$(".btn-info").hide();
					
				}
				
			},
			error:function(){
				console.info("error");
			}     
		})
	}


	/**
	 * 查看全部信息+丁国华 + 2016年8月20日 20:57:19
	 */
	function queryAllMyHistoryRecord(){
		$.ajax({
			tyep:"GET",
			url:'<%=basePath%>' + "historyRecord/queryAllMyHistoryRecord",
			datetype : "json",
			success : function(data) {
				console.info(data);
				document.getElementById("myHistoryRecord_list").innerHTML = data;
				$(".btn-info").remove();
				return;
			},
			error : function() {
				console.info("error");
			}

		});
	}	 

	$("#delete").popover({
		trigger:'manual',
		placement:'bottom',
		title:'<div style="text-align:left;color:black;font-size:12px;">从观看记录中移除</div>',
		html:'true',		
		animation:false
	});
	
	function deleterecord(obj){	
		//获取当前触发的控件id
		var deleteid=$(obj).attr("id");
		var videoidnum=deleteid.substring(deleteid.length-1,deleteid.length);		
		var videoid=$("#videoid"+videoidnum).text();
		
		$.ajax({
			type:"GET",
			url:'<%=basePath%>' + "historyRecord/deleteHistoryByVideoid",
			datatype : "json",
			data:{"videoid":videoid},
			success : function(data) {
				window.location.reload();
				console.info("历史记录删除成功！");
			}
		});
			
	}

	//清除所有的历史记录
	function clearallhistory(){
		$.post('<%=basePath%>historyRecord/clearAllHistory',function(){
			window.location.reload();
		});
		
	}
</script>




