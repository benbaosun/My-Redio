/**
 * 导入音频，图片
 * 十一期 谭倩倩
 */

/**
 * 上传图片文件（step.js中需要用的方法）
 * 十一期 谭倩倩
 * @param formTag
 * 
 */

function upLoad(){
		document.getElementById("imageType").value = "headPicture"; //图片分类，自定义类型，是海报还是个人头像
		$("#fileCoursePoster").click();
	}
function uploadCoursePoster() {
		var getQuestionMainId=GetCookie("questionMainId");	
		var imageType = document.getElementById("imageType").value;
		var guid = new GUID();
		var pictureID=guid.newGUID();
//		var studentId=$("#studentId").val();
		$.ajaxFileUpload({
			url : ctx+"/media/uploadImages",		
//			secureuri : false,//安全
			type:"Post",
			dataType:'json',
			data : {
				"questionMainId" : getQuestionMainId,
				"imageType" : imageType,
				"pictureID" :pictureID
			},
			fileElementId : "fileCoursePoster",// 文件选择框的id属性
			success : function(data, status) {
				//data.innerText;
				
				data=data.replace(/\"/g, "");
				$("#answerIMG").attr("src",data);
			    
				 //复制一个当前控件，并且放到获取的位置上
				var sourceNode=document.getElementById("answerIMG");
				var i="#";
				var cloneNode=sourceNode.cloneNode(true);
				cloneNode.setAttribute("id",i);
				var addNode=document.getElementById(getQuestionMainId);
				addNode.appendChild(cloneNode);
				$('#headPic').val(data);
				alert("上传成功！");
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("上传失败！");
			}
		});
	}

//Object.prototype.clone=function(){
//	var objClone;
//	if(this.constructor==Object){
//		objClone=new this.constructor();
//	}else{
//		objClone=new this.constructor(this.valueOf());
//	}
//	
//
//}
	 /**
	  * 上传音频文件（step.js中需要用的方法）
	  * @param formTag 
	  */
	 function uploadFile(formTag){
		 var paperMainId=document.getElementById("paperMainId").value;
		 var filename = formTag.value;
		 var url = document.getElementById("file").value;		   
         var filename=document.getElementById("file").value;
		 if(filename.length > 1) {       
		        var ldot = filename.lastIndexOf(".");
		        var type = filename.substring(ldot + 1);
		         
		        if(type != "mp3") {	            
		            $.alert({
		                title: '温馨提示',
		                content: '<font size=\'1\'  >'+filename+'不是mp3格式的音频请选择合适的音频添加！</font>',
		                confirmButton:'确定',
		                confirmButtonClass: 'btn-primary',
		                animation: 'scale'
		            });
		            //清除当前所选文件
		            formTag.outerHTML=formTag.outerHTML.replace(/(value=\").+\"/i,"$1\"");
		            return ; 
		        }       
		    } 
		 
		 $.ajaxFileUpload({
				url : ctx+"/media/uploadVideo",		
//				secureuri : false,//安全
				type:"Post",
				dataType:'json',
				data : {
					"paperMainId" : paperMainId
				},
				fileElementId : "file",// 文件选择框的id属性
				success : function(data, status) {
					
					alert("上传成功！");
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("上传失败！");
				}
			});
//		 $.ajaxFileUpload({ 
//		         url:ctx + "/media/uploadVideo",            //需要链接到服务器地址
//		         type:"Post",
//				  dataType:'json',
//					data : {
//						"filename" : filename
//					},
//		         //secureuri:true,  
//		         fileElementId:'file',                        //文件选择框的id属性 
//		         success: function(data, status){ 
//		        	 msg:'添加音频成功!';
//		         },error: function (data, status, e){ 
//		        	 msg:'error';
//		         }  
//		     });
		 }
	 
function getPath(obj) {
	  if (obj) {
	    if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
	     obj.select();
	    return document.selection.createRange().text;
	   } else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
	    if (obj.files) {
	     return obj.files.item(0).getAsDataURL();
	    }
	    return obj.value;
	   }
	   return obj.value;
	  }
	 }