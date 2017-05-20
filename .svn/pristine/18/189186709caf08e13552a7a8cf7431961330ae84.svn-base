 <%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>ITOO-云端登录 </title>

	<!--- CSS --->
<%-- 	<link rel="stylesheet" href="${pageContext.request.contextPath}/mobile_css/style.css" type="text/css" /> --%>

   <style type="text/css">
   /* -------------------------------------------------------

	Description: Web 2.0 Login Form
	Version: 1.0
	Author: Anli Zaimi
	Author URI: http://azmind.com

------------------------------------------------------- */


/* ------- This is the CSS Reset ------- */

html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, 
abbr, acronym, address, big, cite, code, del,
dfn, em, img, ins, kbd, q, s, samp, small,
strike, strong, sub, sup, tt, var, u, i, center,
dl, dt, dd, ol, ul, li, fieldset, form, label,
legend, table, caption, tbody, tfoot, thead, tr,
th, td, article, aside, canvas, details, embed,
figure, figcaption, footer, header, hgroup, menu,
nav, output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}

/* ------- HTML5 display-role reset for older browsers ------- */

article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section {
	display: block;
}
body {
	line-height: 1;
}
ol, ul {
	list-style: none;
}
blockquote, q {
	quotes: none;
}
blockquote:before, blockquote:after, q:before, q:after {
	content: '';
	content: none;
}
table {
	border-collapse: collapse;
	border-spacing: 0;
}


/* ------- Remove Chrome's border around active fields ------- */

*:focus {
	outline: none;
}

/* ------- Disable background and border for input fields ------- */

input {
	background: transparent;
	border: 0;
}



/* --------------------------------------------------------------- */

/* ------- Body ------- */

body {
	background: #eeeeee url("${pageContext.request.contextPath}/images/bg.jpg") top left repeat;
}


/* ------- Container ------- */

#container {
	margin: auto;
	margin-top: 180px;
	width: 524px;
	height: 262px;
	text-align: left;
	font-family: Verdana, Arial;
	font-weight: normal;
	font-size: 12px;
	color: #ffffff;
}


/* ------- Login Form ------- */

form, .welcome {
	background: url("${pageContext.request.contextPath}/images/form-bg.png") top left no-repeat;
	width: 524px;
	height: 262px;
	padding-top: 1px;
}

.login, .welcome-user {
	width: 470px;
	float: left;
	margin-top: 33px;
	margin-left: 40px;
	font-size: 20px;
}

.username-text {
	width: 190px;
	float: left;
	margin-top: 35px;
	margin-left: 40px;
}

.password-text {
	width: 290px;
	float: left;
	margin-top: 35px;
	margin-left: 0px;
}

.welcome-text {
	width: 360px;
	float: left;
	margin-top: 50px;
	margin-left: 40px;
	line-height: 16px;
}

.username-field {
	width: 168px;
	height: 38px;
	float:left;
	margin-top: 10px;
	margin-left: 35px;
	background: url("${pageContext.request.contextPath}/images/username-field.png") center left no-repeat;
}

.username-field:hover {
	background: url("${pageContext.request.contextPath}/images/username-field-hover.png") center left no-repeat;
}

.password-field {
	width: 280px;
	height: 38px;
	float:left;
	margin-top: 10px;
	margin-left: 22px;
	background: url("${pageContext.request.contextPath}/images/password-field.png") center left no-repeat;
}

.password-field:hover {
	background: url("${pageContext.request.contextPath}/images/password-field-hover.png") center left no-repeat;	
}

input[type="text"], input[type="password"] {
	width: 120px;
	height: 16px;
	margin-top: 10px;
	margin-left: 10px;
	font-family: Verdana, Arial;
	font-size: 16px;
	color: #2d2d2d;
}

/* ------------ Custom Checkbox ------------------------------- */

/* Works for browsers with CSS3 support (with or without Javascript) */
/* Works for Internet Explorer 6-8 (without CSS3 support) with Javascript */
/* If Javascript isn't available this doesn't work for Internet Explorer 6-8 */

input[type="checkbox"] {
	position: absolute;
	left: -999px;
}

input[type="checkbox"] + label {
	width: 132px;
	height: 24px;
	float: left;
	margin-top: 26px;
	margin-left: 37px;
	padding-left: 28px;
	display: block;
	position: relative;
	line-height: 24px;
	background: url("${pageContext.request.contextPath}/images/checkbox-off.png") top left no-repeat;
}

input[type="checkbox"]:checked + label {
	background: url("${pageContext.request.contextPath}/images/checkbox-on.png") top left no-repeat;
}

input[type="checkbox"]:checked:hover + label, input[type="checkbox"]:checked:focus + label {
	background: url("${pageContext.request.contextPath}/images/checkbox-on-hover.png") top left no-repeat;
}

input[type="checkbox"]:not(:checked):hover + label, input[type="checkbox"]:not(:checked):focus + label {
	background: url("${pageContext.request.contextPath}/images/checkbox-off-hover.png") top left no-repeat;
}

/* -------------------------------------------------------------------------- */

.forgot-usr-pwd {
	width: 220px;
	float: left;
	margin-top: 26px;
	margin-left: 0;
	color: #cccccc;
	line-height: 24px;
}

.forgot-usr-pwd a {
	color: #cccccc;
	text-decoration: none;
	font-style: italic;
}

.forgot-usr-pwd a:hover, .forgot-usr-pwd a:focus {
	text-decoration: underline;
}

input[type="button"] {
	width: 95px;
	height: 73px;
	margin-top: 12px;
	margin-left: 410px;
	font-family: Verdana, Arial;
	font-size: 26px;
	color: #ffffff;
}

input[type="submit"]:hover, input[type="submit"]:focus {
	background: url("${pageContext.request.contextPath}/images/go-hover.png") top left no-repeat;
}

.home {
	width: 70px;
	height: 73px;
	float: left;
	margin-top: 122px;
	margin-left: 21px;
	font-size: 20px;
	padding: 25px 0 0 15px;
}

.home:hover, .home:focus {
	background: url("${pageContext.request.contextPath}/images/go-hover.png") top left no-repeat;
}

.home a, .home a:hover, .home a:focus {
	color: #ffffff;
	text-decoration: none;
}

#footer {
	margin: auto;
	margin-top: 50px;
	width: 500px;
	height: 30px;
	background: url("${pageContext.request.contextPath}/images/footer-bg.png") bottom center no-repeat;
	text-align: center;
	font-family: "Times New Roman", Times, Georgia;
	font-weight: normal;
	font-size: 16px;
	color: #8d8d8d;
}

#footer a {
	text-decoration: none;
	color: #8d8d8d;
}

#footer a:hover, #footer a:focus {
	text-decoration: none;
	color: #2d2d2d;
}

   
   </style>
	<!--- Javascript libraries (jQuery and Selectivizr) used for the custom checkbox --->

	<!--[if (gte IE 6)&(lte IE 8)]>
		<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="selectivizr.js"></script>
		<noscript><link rel="stylesheet" href="fallback.css" /></noscript>
	<![endif]-->
		<script src="${pageContext.request.contextPath}/js/userinfo.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	</head>

	<body>
		<div id="container">
			<form >
				<div class="login">用户登录</div>
				<c:if test="${not empty param.error}">
					<font size="3" color="red">用户名或密码错误！！！</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				
			
			<div class="username-text">用户名:</div>
				<div class="password-text">密　码:</div>
				<div class="username-field">
					<input type="text" name="username" id="loginusername"/>
				</div>
				<div class="password-field">
					<input type="password" name="password" id="loginpassword"/>
				</div>
				<%-- <input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">记住我</label> 
				<div class="forgot-usr-pwd">忘记 <a href="${pageContext.request.contextPath}/mobile_back/repassword">密码</a>?</div> --%>
				<input type="button" name="submit" value="GO" onclick="queryUserInfo()"/>
			</form>
		</div>
		
		<div id="footer">
			Web 5.0 Leader <a href="http://baike.baidu.com/link?url=63poDQrfyFsn0yHZf34Bd0sM-GKYhK8vFUbPAvAJQ6oRZmq_QuXLSAhO54IWQtU75eFN9Mp2lRhnSwNLU4l8r_" target="_blank" title="米新江">Introduction</a>
		</div>
		
	</body>
</html>
