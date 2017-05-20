
//从视频表中直接查询登录用户
function queryUserInfo(){
	var userId=document.getElementById("loginusername").value;
	var userPassword=document.getElementById("loginpassword").value;
	console.info(userId);
	console.info(userPassword);
	if(userId == userPassword){
		$.ajax({
			type:"POST",
			async:false,
			datetype:"JSON",
			data : {"userId" : userId},
			url: '../userInfo/queryUserInfo',
			success : function(result){
				if(result==null || result.length == 0){
					alert("用户名不存在，请重新输入！");
				}else
				{
					queryUserInfoIsExist();
					//進入首頁
					window.location.href="/dmsd-itoo-video-web/videohomepage/1";
				}
			},
			error : function(error) {
				console.info("this method error");
			}
		});
	}else{
		alert("您输入的用户名或密码有误，请重新输入！");
	}
}

//在personal表中查询所登录用户名
function queryUserInfoIsExist(){
	var userId=document.getElementById("loginusername").value;
	$.ajax({
		type:"POST",
		async:false,
		datetype:"JSON",
		data : {"userId" : userId},
		url: '../userInfo/queryUserInfoIsExist',
		success : function(result){
			//如果personal表中没有所登陆用户，执行插入方法；否则直接进入首页
			if(result==null || result.length == 0){
				insertUserInfo();
				
				//進入首頁
				window.location.href="/dmsd-itoo-video-web/videohomepage/1";
				
				queryUserPicture(userId);
			}else
			{
				
				//進入首頁
				window.location.href="/dmsd-itoo-video-web/videohomepage/1";
				queryUserPicture(userId);
			}
		},
		error : function(error) {
			console.info("this method error");
		}
	});
}

//将从address中查询到的用户信息插入到personal表中
function insertUserInfo(){
	$.ajax({
		type:"POST",
		async:false,
		datetype:"JSON",
		url: '../userInfo/insertUserInfo',
		success : function(result){
			console.info(result);
		},
		error : function(error) {
			console.info("this method error");
		}
	});
}

//查询登录用户头像 - 王荣晓 - 2016-10-2 19:19:13
function queryUserPicture(userId){
	var tempUserInfo;
	$.ajax({
		type:"POST",
		async:false,
		datetype:"JSON",
		data : {"userId" : userId},
		url: '../userInfo/queryUserPicture',
		success : function(result){
			tempUserInfo=result;
			if(result[0].headPicture==null){
			
//				$("#userImage").attr("src","/dmsd-itoo-video-web/images/rose.jpg");
			}else
			{
				console.info(result[0].headPicture);
//				document.getElementById("userImage").src="http://192.168.22.252/group1/M00/00/05/wKgW_Ffty1mAfLrXAAAeFEvlXt4621.jpg";
			}
		},
		error : function(error) {
			console.info("this method error");
		}
	});

}


/*//调用基础表，根据用户代码查询用户信息
function checkUserInfo(){
	//写死的登录用户id
//	var userId="2210685";
	var userId=document.getElementById("loginusername").value;
	var password=document.getElementById("loginpassword").value;
	console.info(userId + password);
	$.ajax({
		type:"POST",
		async:false,
		datetype:"JSON",
		data : {"userId" : userId},
		url: '../userInfo/checkUserInfo',
		success : function(result){
			console.info(result[0].name);
			//给头界面赋值用户名
//			$('#userName').val(result[0].name);
//		    var sessionuserId=session.getAttribute("userId");
//			$('#userId').val(userId);
			//获取用户所在学院代码
			var colleagueId=result[0].institutionId;
			//调用查询用户学院名称的方法
			checkUserColleague();
		},
		error : function(error) {
			console.info("this method error");
		}
	});
}

//根据学院代码查询学院名称
function checkUserColleague(){
	$.ajax({
		type:"POST",
		async:false,
		datetype:"JSON",
//		data : {"colleagueId" : colleagueId},
		url: '../userInfo/checkUserColleague',
		success : function(result){
			var colleagueName=result[0].remark;
//			$('#colleagueName').val(colleagueName);
			insertUserInfo();
			//進入首頁
			window.location.href="/dmsd-itoo-video-web/videohomepage/1";
			
//			homepageload(colleagueName);
			
			console.info(result[0].remark);
		},
		error : function(error) {
			console.info("this method error");
		}
	});
}*/

/*//根据用户输入id查询用户是否存在
function queryUser(){
	var userID = document.getElementById("loginusername").value;
	$.ajax({
		type:"POST",
		async:false,
		datetype:"JSON",
		data : {"userID" : userID},
		url: '../userInfo/insertUserInfo',
		success : function(result){
			console.info("this method success");
		},
		error : function(error) {
			console.info("this method error");
		}
	});
}*/

/*//向視頻表中插入用戶名和id
function insertUserInfo(){
	var userID = document.getElementById("loginusername").value;
//	var userName ='<%=Session["userName"] %>';
	var userName=${ sessionScope.userName};
	var userName="高虎";
	$.ajax({
		type:"POST",
		async:false,
		datetype:"JSON",
		data : {"userID" : userID},
		url: '../userInfo/insertUserInfo',
		success : function(result){
			console.info("this method success");
		},
		error : function(error) {
			console.info("this method error");
		}
	});
}*/

/*
//调用基础表，根据用户代码查询用户信息
function checkUserInfoKuoZhan(){
	//写死的登录用户id
	var userId="2210685";
	$.ajax({
		type:"POST",
		async:false,
		datetype:"JSON",
		data : {"userId" : userId},
		url: '../userInfo/checkUserInfo',
		success : function(result){
			console.info(result[0].name);
			//给头界面赋值用户名
//			$('#userName').val(result[0].name);
			//获取用户所在学院代码
			var colleagueId=result[0].institutionId;
			//调用查询用户学院名称的方法
			checkUserColleagueKuoZhan(colleagueId);
		},
		error : function(error) {
			console.info("this method error");
		}
	});
}

//根据学院代码查询学院名称
function checkUserColleagueKuoZhan(colleagueId){
	
	$.ajax({
		type:"POST",
		async:false,
		datetype:"JSON",
		data : {"colleagueId" : colleagueId},
		url: '../userInfo/checkUserColleague',
		success : function(result){
			var colleagueName=result[0].remark;
			$('#colleagueName').val(colleagueName);
			console.info(colleagueName);
			findVideoByCollege(colleagueName);
//			console.info(result[0].remark);
		},
		error : function(error) {
			console.info("this method error");
		}
	});
}*/