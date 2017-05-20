
/**
 * 
 * 首页加载内容，所登陆用户所属学院视频 + 王荣晓 + 2016年8月20日
 */
function homepageload(colleagueName){
//	console.info(colleagueName);
	//拼接“实战推荐”模块内容
	$.ajax({
		type:"GET",
		async:false,
		datatype:"JSON",
		data : {"colleagueName" : colleagueName},
		url: 'videohomepage/findRecommended',
		success : function(result){
			console.info(result);
			if(result==null){
				//console.info("没有数据");
				var htmlDiv="";
				htmlDiv=htmlDiv+"<div style='width:100%;height:100px;'><h4 style='text-align:center;padding:50px;color:gray;'>抱歉，没有找到相关视频！"+ "</h4></div>";
				$("#mainshizhan").append(htmlDiv);
				mainremen(colleagueName);
				mainyoulike(colleagueName);
			}else
			{
				$.each(result, function(i, value) {
					 var htmlDiv="";
					 htmlDiv=htmlDiv+"<div class=" + "col-sm-3" + ">";
		             htmlDiv=htmlDiv+"<div class=" + "thumbnail" + " style='float:right;'>";
		             htmlDiv=htmlDiv+"<div><a href=" + "/dmsd-itoo-video-web/comment/1?id=" + value.id + ">" +"<img style='width:300px; height:120px;' id=" + "mainrecommendedimg" + value.id + " src" + "" + "/></a>";
		             //htmlDiv=htmlDiv+"<div style='margin-top:-15px;color:#fff;text-align:right;'>"+ value.videoTime+"</div></div>";
		             htmlDiv=htmlDiv+"</div>";
		             htmlDiv=htmlDiv+"<div id=" +"videoName" + value.id + " >"+"<h5>" 
					                + value.videoName + "</h5>"+
					                "<div style='float:left;color: gray;font-size:11px;'><p>" 
					                + value.videoType + "</p></div>"
					                +"<div style='float:right;'><a float=right style='color:gray;font-size:12px'>"
					                + "</a></p></div>";
						             //value.comment +"views  	
		             htmlDiv=htmlDiv+"</div></div></div>";
		             $("#mainshizhan").append(htmlDiv);
		             $("#mainrecommendedimg"+value.id).attr("src",value.picturePath); 
				});
				console.info("this method success");
				mainremen(colleagueName);
				mainyoulike(colleagueName);
			}
		},
		error : function(error) {
			console.info("this method error");
		}
	});
}

//拼接“热门推荐”模块内容 
function mainremen(colleagueName){
	$.ajax({
		type:"GET",
		async:false,
		datetype:"JSON",
		url: 'videohomepage/findRecommended',
		data : {"colleagueName" : colleagueName},
		success : function(result){
			//console.info("sss");
			if(result==null){
				//console.info("没有数据");
				var htmlDiv="";
				htmlDiv=htmlDiv+"<div style='width:100%;height:100px;'><h4 style='text-align:center;padding:50px;color:gray;'>抱歉，没有找到相关视频！"+ "</h4></div>";
				$("#mainremen").append(htmlDiv);
			}else
			{
				$.each(result, function(i, value) {
					 var htmlDiv="";
					 htmlDiv=htmlDiv+"<div class=" + "col-sm-3" + ">";
		             htmlDiv=htmlDiv+"<div class=" + "thumbnail" + " style='float:right;'>";
		             htmlDiv=htmlDiv+"<div><a href=" + "/dmsd-itoo-video-web/comment/1?id=" + value.id + ">" +"<img style='width:300px; height:120px;' id=" + "mainhotimg" + value.id + " src" + "" + "/></a>";
		             //htmlDiv=htmlDiv+"<div style='margin-top:-15px;color:#fff;text-align:right;'>"+ value.videoTime+"</div></div>";
		             htmlDiv=htmlDiv+"</div>";
		             htmlDiv=htmlDiv+"<div id=" +"videoName" + value.id + " >"+"<h5>" 
					                + value.videoName + "</h5>"+
					                "<div style='float:left;color: gray;font-size:11px;'><p>" 
					                + value.videoType + "</p></div>"
					                +"<div style='float:right;'><a float=right style='color:gray;font-size:12px'>"
					                + "</a></p></div>";
						             //value.comment +"views  	
		             htmlDiv=htmlDiv+"</div></div></div>";
		             $("#mainremen").append(htmlDiv);
		             $("#mainhotimg"+value.id).attr("src",value.picturePath); 
				});
				console.info("this method success");
			}
		},
		error : function(error) {
			console.info("this method error");
		}
	});
}



//拼接“猜你喜欢”模块内容 
function mainyoulike(colleagueName){
	$.ajax({
		type:"GET",
		async:false,
		datetype:"JSON",
		url: 'videohomepage/findRecommended',
		data : {"colleagueName" : colleagueName},
		success : function(result){
			if(result==null){
				//console.info("没有数据");
				var htmlDiv="";
				htmlDiv=htmlDiv+"<div style='width:100%;height:100px;'><h4 style='text-align:center;padding:50px;color:gray;'>抱歉，没有找到相关视频！"+ "</h4></div>";
				$("#mainyoulike").append(htmlDiv);
			}else
			{
				$.each(result, function(i, value) {
					 var htmlDiv="";
					 htmlDiv=htmlDiv+"<div class=" + "col-sm-3" + ">";
		             htmlDiv=htmlDiv+"<div class=" + "thumbnail" + " style='float:right;'>";
		             htmlDiv=htmlDiv+"<div><a href=" + "/dmsd-itoo-video-web/comment/1?id=" + value.id + ">"+"<img style='width:300px; height:120px;' id=" + "mainyoulikeimg" + value.id + " src" + "" + "/></a>";
		             //htmlDiv=htmlDiv+"<div style='margin-top:-15px;color:#fff;text-align:right;'>"+ value.videoTime+"</div></div>";
		             htmlDiv=htmlDiv+"</div>";
		             htmlDiv=htmlDiv+"<div id=" +"videoName" + value.id + " >"+"<h5>" 
					                + value.videoName + "</h5>"+
					                "<div style='float:left;color: gray;font-size:11px;'><p>" 
					                + value.videoType + "</p></div>"
					                +"<div style='float:right;'><a float=right style='color:gray;font-size:12px'>"
					                + "</a></p></div>";
		             //value.comment +"views               	
		             htmlDiv=htmlDiv+"</div></div></div>";
		             $("#mainyoulike").append(htmlDiv);
		             $("#mainyoulikeimg"+value.id).attr("src",value.picturePath); 
				});
				console.info("this method success");
			}
		},
		error : function(error) {
			console.info("this method error");
		}
	});
}

//根据查询条件查询数据，并将查询结果动态拼接 + 王荣晓 + 2016年8月24日21:30:14
function search1(){
	var querytxt=$("#querytxt").val();
	//console.info(querytxt);
//	$("#findmore").show();
	var str = $("#pageNum").val();
	var str1 = $("#pageSize").val();
	$("#videohomepagetop").children().remove();
	$.ajax({
		type : "POST",
		async : false,
		data:{"page":str,"rows":str1,"querytxt":querytxt},
		dataType:"JSON",
		url : 'videohomepage/queryCollegeVideoInfo',
		success : function(result) {
			var pageNum = $("#pageNum").val()*1 + 1;
			//console.info(pageNum);	
			$("#pageNum").attr("value",pageNum);//填充内容
			//console.info(result.rows)
			var videos = result.rows
			if(result.rows.length==0){
				//console.info("没有数据");
				var htmlDiv="";
				htmlDiv=htmlDiv+"<div style='margin-left:-8%;width:100%;height:100px;'><h4 style='text-align:center;padding:50px;color:gray;'>抱歉，没有找到相关视频！"+ "</h4></div>";
				$("#youlike").append(htmlDiv);
			}else
			{
				$("#findmore").show();
				$.each(videos, function(i, value) {
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
				                	+ value.comment +"views</a></p></div>";
				                 	
	                htmlDiv=htmlDiv+"</div></div></div>";
	                $("#youlike").append(htmlDiv);
	                $("#youLikeImg"+value.id).attr("src",value.picturePath); 
				});
			}
		},
		error : function(error) {
			console.info("doSearch() method error")
		}
	});
	return;
}


