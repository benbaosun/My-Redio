/**
 * 扩展学习导向页面内容，其他学院的视频，默认加载第一个学院 + 王荣晓 + 2016年8月25日
 */
//根据学院名称查询学校视频
function findVideoByCollege(colleagueName){
	var collegename=colleagueName;
	console.info(colleagueName);
	$("#extendstudy").children().remove();
	$.ajax({
		type:"POST",
		async:false,
		datetype:"JSON",
		data : {"collegename" : collegename},	
		url:'allvideoincollege',	
		success : function(result){
			console.info(result);
			var htmltitle="";
			htmltitle=htmltitle+"<h3>"+collegename+"</h3>";
			$("#title").append(htmltitle);
			//替换内容标题title
			document.getElementById("title").innerHTML=htmltitle;
			if(result==null || result.length==0){
				//console.info("没有数据");
				var htmlDiv="";
				htmlDiv=htmlDiv+"<div style='width:100%;height:300px;'><h4 style='text-align:center;padding:100px;color:gray;'>抱歉，没有找到相关视频！"+ "</h4></div>";
				$("#extendstudy").append(htmlDiv);
			}else
			{
				$.each(result, function(i, value) {
					var htmlDiv="";
					htmlDiv=htmlDiv+"<div class=" + "col-sm-3" + ">";
		            htmlDiv=htmlDiv+"<div class=" + "thumbnail" + " style='float:right;'>";
		            htmlDiv=htmlDiv+"<div><a href=" + "/dmsd-itoo-video-web/comment/1?id=" + value.id + ">" +"<img style='width:300px; height:120px;' id=" + "collegeimg" + value.id + " src" + "" + "/></a>";
		            //htmlDiv=htmlDiv+"<div style='margin-top:-15px;color:#fff;text-align:right;'>"+ value.videoTime+"</div></div>";
		            htmlDiv=htmlDiv+"</div>";
		            htmlDiv=htmlDiv+"<div id=" +"videoDesc" + value.id + ">"+"<h5>" 
				                	+ value.videoName + "</h5>"+
					                "<div style='float:left;color: gray;font-size:11px;'><p>" 
					                + value.videoType + "</p></div>"
					                +"<div style='float:right;'><a float=right style='color:gray;font-size:12px'>"
//					                + value.comment +"views</a></p></div>";
		            				+ "</a></p></div>"; 	
		            htmlDiv=htmlDiv+"</div></div></div>";
		            $("#extendstudy").append(htmlDiv);
		            //console.info(value.picturePath);
		            //$("#collegeimg"+value.id).attr("src",'/dmsd-itoo-video-web/'+value.videoPath); 
		            $("#collegeimg"+value.id).attr("src",value.picturePath); 
		            console.info("this method success");
				});
			}
		},
		error : function(error) {
			console.info("this method error");
		}
	});
}

/*//根据查询条件查询数据，并将查询结果动态拼接 + 王荣晓 + 2016年8月24日21:30:14
function search1(){
	var querytxt=$("#querytxt").val();
//	$("#findmore").show();
	var str = $("#pageNum").val();
	var str1 = $("#pageSize").val();
	$("#kuozhanjiemian").children().remove();
	$.ajax({
		type : "POST",
		async : false,
		data:{"page":str,"rows":str1,"querytxt":querytxt},
		dataType:"JSON",
		url:'queryCollegeVideoInfo',
		success : function(result) {
			var pageNum = $("#pageNum").val()*1 + 1;
			//console.info(pageNum);	
			$("#pageNum").attr("value",pageNum);//填充内容
			var videos = result.rows
			if(result.rows.length==0){
				//console.info("没有数据");
				//$("#findmore").remove();
				$("#youlike").children().remove();
				var htmlDiv="";
				htmlDiv=htmlDiv+"<div style='width:100%;height:300px;'><h4 style='text-align:center;padding:100px;color:gray;'>抱歉，没有找到相关视频！"+ "</h4></div>";
				$("#youlike").append(htmlDiv);
			}else
			{
				$("#findmore").show();
				//$("#youlike").children().remove();
				$.each(videos, function(i, value) {
					//拼接界面循环显示图片
					var htmlDiv="";
	                htmlDiv=htmlDiv+"<div class=" + "col-sm-3" + ">";
	                htmlDiv=htmlDiv+"<div class=" + "thumbnail" + " style='float:right;'>";
	                htmlDiv=htmlDiv+"<div><a href=" + "/dmsd-itoo-video-web/comment/1?id=" + value.id + ">" +"<img style='width:300px; height:120px;' id=" + "youLikeImg" + value.id + " src" + "" + "/></a>";
	                //htmlDiv=htmlDiv+"<div style='margin-top:-15px;color:#fff;text-align:right;'>"+ value.videoTime+"</div></div>";
		            htmlDiv=htmlDiv+"</div>";
	                htmlDiv=htmlDiv+"<div id=" +"videoDesc" + value.id + ">"+"<h5>" 
				                	+ value.videoName + "</h5>"+
					                "<div style='float:left;color: gray;font-size:11px;'><p>" 
					                + value.videoType + "</p></div>"
				                	+"<div style='float:right;'><a float=right style='color:gray;font-size:12px'>"
//				                	+ value.comment +"views</a></p></div>";
				                	+ "</a></p></div>";
	                htmlDiv=htmlDiv+"</div></div></div>";
	                $("#youlike").append(htmlDiv);
	                //图片路径添加
	                $("#youLikeImg"+value.id).attr("src",value.picturePath); 
				});
			}
		},
		error : function(error) {
			console.info("doSearch() method error")
		}
	});
	return;
}*/

/*//查询基础的所有学院
function findAllColleague(){
//	$("#colleaguedaohang").children().remove();
	$.ajax({
		type : "POST",
		async : false,
		dataType:"JSON",
		url:'findAllColleague',
		success : function(result) {
			var colleaguestring="";
			if(result.length==0){
				colleaguestring=colleaguestring+"<div style='width:100%;height:300px;'><h4 style='text-align:center;padding:100px;color:gray;'>抱歉，没有找到学院！"+ "</h4></div>";
			}else
			{
				$.each(result, function(i, value) {
					colleaguestring=colleaguestring
						         +"<a style='margin-left:-20px;'><img src='/dmsd-itoo-video-web/images/tv.png'/></a>"
						         +"<a id=" + value.institutionCode +" href='javascript:void(0);' onclick=findVideoByCollege('" + value.institutionName + "')>&nbsp;&nbsp;" 
						         + value.institutionName 
						         + "</a>"
						         +"<hr style='width:100%;border-top:1px solid #D5D5D5; margin-top: 2px;margin-left:-20px;'>";
					
				});
				colleaguestring="<ul id='sss' style='width: 220px;top: 40px;'>"+colleaguestring;
				$("#colleaguedaohang").popover({ 
			    	trigger:'click',//manual 触发方式
			        placement : 'bottom',  
			         title : '<div style="text-align:center; color:red; text-decoration:underline; font-size:14px;"> Muah ha ha</div>', 
			        title:'<div style="text-align:center; color:gray;font-size:14px;">所有学院</div>',
			        html: 'true', 
			        content : colleaguestring,  //这里可以直接写字符串，也可以 是一个函数，该函数返回一个字符串；
			        animation: false
			    });
			}
			
		},
		error : function(error) {
			console.info("doSearch() method error")
		}
	});
}*/

