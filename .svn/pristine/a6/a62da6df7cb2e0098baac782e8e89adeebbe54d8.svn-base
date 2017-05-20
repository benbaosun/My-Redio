<%@ page language="java"  import="java.util.*" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<script type="text/javascript">
	$(function(){
		findAllColleague();
	})
	
	
	//查询基础的所有学院
function findAllColleague(){
//	$("#colleaguedaohang").children().remove();
	$.ajax({
		type : "POST",
		async : false,
		dataType:"JSON",
		url:'findAllColleague',
		success : function(result) {
			var htmlDiv="";
			if(result.length==0){
				htmlDiv=htmlDiv+"<div style='width:100%;height:300px;'><h4 style='text-align:center;padding:100px;color:gray;'>抱歉，没有找到学院！"+ "</h4></div>";
			}else
			{
				$.each(result, function(i, value) {
					htmlDiv=htmlDiv
						    +"<a id=" + value.institutionCode +" href='javascript:void(0);' onclick=findVideoByCollege('" + value.institutionName + "')>&nbsp;&nbsp;" 
						    + value.institutionName 
						    + "</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					
				});
				
				htmlDiv="<div style='font-size:14px;font-color:black;'>"+htmlDiv
				htmlDiv=htmlDiv+"<hr style=' height:1px;border-top:1px solid #C4C4C4;width:107%;margin-left:-10%;position:positive; margin-bottom: 5px;margin-top: 8px;'>"
				htmlDiv=htmlDiv+"</div>";
				$("#colleaguetype").append(htmlDiv);
			}
			
		},
		error : function(error) {
			console.info("doSearch() method error")
		}
	});
}
	
</script>


<div style="width:90%;margin-left:10px;margin-top:0px;">
	<div style="width:15%;margin-top:0px;">
		<h4>所有学院</h4>
	</div>
	<div id="colleaguetype" style="width:100%;margin-left:10%;margin-top:-30px;">
		
  	</div>
</div>