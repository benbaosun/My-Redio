/**
 * Created by 王荣晓
 *
 * @Date 2016-8-24 21:31:39
 */
addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
 
function hideURLbar() {
    window.scrollTo(0, 1);
} 
    

//根据查询条件查询数据，并将查询结果动态拼接 + 王荣晓 + 2016年8月24日21:30:14
function search1(){
	var querytxt=$("#querytxt").val();
	var str = $("#pageNum").val();
	var str1 = $("#pageSize").val();

	$.ajax({
		type : "POST",
		async : false,
		data:{"page":str,"rows":str1,"querytxt":querytxt},
		dataType:"JSON",
		url : 'Index/queryCollegeVideoInfo',
		success : function(result) {
			//查询页码加一
			var pageNum = $("#pageNum").val()*1 + 1;
			$("#pageNum").attr("value",pageNum);//填充内容
	 
			var videos = result.rows
			//循环拼接界面
			$.each(videos, function(i, value) {
				 var htmlDiv="";
	             htmlDiv=htmlDiv+"<div class=" + "col-sm-3" + ">";
	             htmlDiv=htmlDiv+"<div class=" + "thumbnail" + " style='float:right;'>";
	             htmlDiv=htmlDiv+"<div><a href=" + "single.html" +">" +"<img id=" + "youLikeImg" + value.id + " src" + "" + "/></a>";
	             //htmlDiv=htmlDiv+"<div style='margin-top:-15px;color:#fff;text-align:right;'>"+ value.videoTime+"</div></div>";
		         htmlDiv=htmlDiv+"</div>";
	             htmlDiv=htmlDiv+"<div id=" +"videoDesc" + value.id + ">"+"<h5><a>" 
				                	+ value.videoName + "</a></h5>"+
				                	"<div style='float:left;'><p><a style='color: #21deef;font-size:12px'>" 
				                	+ value.videoType + "</a></p></div>"
				                	+"<div style='float:right;'><a float=right style='color:gray;font-size:12px'>"
				                	+ value.comment +"views</a></p></div>";
				                 	
	             htmlDiv=htmlDiv+"</div></div></div>";
	             $("#youlike").append(htmlDiv);
	             $("#youLikeImg"+value.id).attr("src",value.videoPath); 
			});
		},
		error : function(error) {
			console.info("doSearch() method error")
		}
	});
	return;
}

