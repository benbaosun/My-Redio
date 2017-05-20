<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>




<div class="header">
    <c:if test="${studentId != null}">
        <div class="clearfix container">
            <a class="logo"><img
                    src="${pageContext.request.contextPath}/css/images/logo.png"
                    alt="校园视频" /></a>
            <div class="city-wrap">
                <!-- <span>北京</span><a href="javascript" class="change">[切换城市]</a><input ></input> -->
                <span id="cityName" name="cityName"></span>
            </div>
            <ul class="nav-bar">
            </ul>
            <!--点击input时为search-wrap 添加class focus-->

            <div class="login-wrap">
                <a href="/itoo-jrkj-student-web/stuPersonalInfo/${sessionId}"
                   style="display: black;">${student.nickName}的个人中心</a>
                <input type="hidden" id = "sessionId" value="${sessionId}"/>
                <input id="oldPhoneNum" type="hidden"/>

                <!-- header的消息提示 -->
                <c:choose>
                <c:when  test="${student.noReadMessageNum == 0}">
                <!-- 无信息时 -->
                <a href="/itoo-jrkj-message-web/message/${sessionId}">
                    <span></span>
                    </c:when >
                    <c:otherwise>
                    <!--有信息时 -->
                    <a href="/itoo-jrkj-message-web/message/${sessionId}">
                        <span class="current">${student.noReadMessageNum}</span></a>
                    </c:otherwise>
                    </c:choose>

                    <a href="javascript:;" id="jq-link-outSystem"
                       onclick="outSystem()" style="display: black;">退出</a>
            </div>

            <div class="search-wrap focus" style="float: left; width: 500px;">
                <!-- 				<a href="/itoo-jrkj-teacher-web/findTeacherByNames" -->
                <!-- 					class="change" onclick="saveStrName()" > -->
                <a href="javascript:;" class="change" onclick="saveStrName()" >
                    <i class="icon-search"></i></a>
                <div>
                    <input id="searchcontent" type="text" placeholder="通过昵称/讲师姓名查询讲师" onkeydown="globelQuery(event)">
                </div>
            </div>
        </div>
    </c:if>


    <c:if test="${studentId == null}">
        <div class="clearfix container">

            <a class="logo"><img
                    src="${pageContext.request.contextPath}/css/images/logo.png"
                    alt="校园视频" /></a>
            <div class="city-wrap">
                <span id="cityName" name="cityName">北京</span>
            </div>
            <ul class="nav-bar">
            </ul>
            <!--点击input时为search-wrap 添加class focus-->

            <div class="login-wrap">
                <a id="jq-link-login" href="javascript:;" style="display: black;">登录</a>
                <a id="jq-link-register" href="javascript:;" style="display: black;">注册</a>
                <input id="oldPhoneNum" type="hidden"/>
            </div>

            <div class="search-wrap focus" style="float: left; width: 500px;">
                <!-- 				<a href="/itoo-jrkj-teacher-web/findTeacherByNames" -->
                <!-- 					class="change" onclick="saveStrName()"><i class="icon-search"></i></a> -->
                <a href="javascript:;"  class="change" onclick="saveStrName()" ><i class="icon-search"></i></a>

                <div>
                    <input id="searchcontent" type="text" placeholder="通过昵称/讲师姓名查询讲师" onkeydown="globelQuery(event)" />
                </div>
            </div>
        </div>
    </c:if>
</div>



<div id="jq-dialog" class="ui-dialog">
    <div class="ui-overcurtainDiv"></div>
    <div class="dialog-wrap register">
        <form>
            <div class="dialog-top">
                <img
                        src="${pageContext.request.contextPath}/css/images/dialog-logo.png"
                        alt="今日开讲" /><span>注册账号</span> <i class="icon-close icon20"
                                                          title="关闭"></i>
            </div>
            <div class="dialog-middle form-horizontal">
                <div class="form-group">
                    <div class="col-sm-2 control-label">+86</div>
                    <div class="col-sm-10">
                        <input id="phoNum" name="phoNum" type="text" class="form-control"
                               onblur="checkPhone(),checkPhoneIsExit()" onfocus="numberclear()"
                               placeholder="填写常用手机号"> <span class="error"
                                                            style="color: red; width: 200px;"><label id="checkPh"
                                                                                                     name="checkPhone"></label></span> <span class="error"
                                                                                                                                             style="color: red; width: 200px;"><label id="checkPh2"
                                                                                                                                                                                      name="checkPhoneIsExit"></label></span>
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-sm-12">
                        <input id="nickName" name="nickName" type="text"
                               class="form-control" onblur="checknickName()"
                               onfocus="clearCheckName()" placeholder="昵称（2-20位中/英文，数字，下划线）">
                        <!-- 我写的 -->
						<span class="error" style="color: red; width: 200px;"><label
                                id="checknickNa" name="checknickName"></label></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-12">
                        <input id="password" name="password" type="password"
                               class="form-control" onblur="checkPassword()"
                               onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"
                               onfocus="clearPWD()" placeholder="登录密码（8-16位字母和数字）"> <span
                            class="error" style="color: red; width: 200px;"><label
                            id="rightPass" name="rightPassword"></label></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-7">
                        <input id="verifycode" name="verifycode" type="text"
                               class="form-control" onblur="checkCode()" disabled="disabled"
                               placeholder="手机接收到的验证码"> <span class="error"
                                                              style="color: red; width: 200px;"><label
                            id="phoneVerifyCo" name="phoneVerifyCode"></label></span>
                    </div>
                    <div class="col-sm-5">
                        <input type="button" id="verifycodebutton"
                               class="btn form-control btn-verify btn-info btn-purple"
                               value="获取验证码" onclick="getVerifycode()" /> <span class="error"
                                                                                id="verify-code-error"
                                                                                style="position: absolute; width: 200px; left: 100px; top: -50px;"><label
                            id="errorCheckCode" name="errorCheckCode"></label></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8">
                        <label class="radio-inline "><input id="raduocheck"
                                                            name="readService" type="checkbox" value="2" name="type"
                        ></label><a
                            href="/itoo-jrkj-course-web/readservice"
                            style="color: #01080f;" target="_blank">《服务协议》</a>
                        <label class="error" style="color: red; width: 200px;"
                               id="readservice11" name="readservice11"></label>
                    </div>

                    <div class="col-sm-4 text-right">
                        <div class="text-content">
                            <!-- <a href="/itoo-jrkj-student-web/confirmAccount" style="color: #01080f;">忘记密码</a> -->
                        </div>
                    </div>
                    <div class="col-sm-12">
                        <input type="button" class="btn form-control" value="注册"
                               onclick="registerStudent()" />
                    </div>
                    <div class="col-sm-12 text-right green">
                        <div class="text-content">
                            已有账号，点击<a id="dialog-link-login" href="javascript:;">登录</a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div class="dialog-wrap login">
        <form>
            <div class="dialog-top">
                <img
                        src="${pageContext.request.contextPath}/css/images/dialog-logo.png"
                        alt="今日开讲" /><span>欢迎登录</span> <i class="icon-close icon20"
                                                          title="关闭"></i>
            </div>
            <div class="dialog-middle form-horizontal">
                <div class="form-group">
                    <div class="col-sm-12">
                        <input id="inputPhoNum" name="phoNum" type="text"
                               class="form-control login-input-phone" onblur="checkPhonea()"
                               onfocus="numberclear()" placeholder="请输入手机号"> <span
                            class="error" style="color: red; width: 200px;"><label
                            id="checkPhonea1" name="checkPhonea"></label></span> <span class="error"
                                                                                       style="color: red; width: 200px;"><label
                            id="checkPhoneIsExita1" name="checkPhoneIsExita"></label></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-12">
                        <input id="inputPassword" name="password" type="password"
                               onblur="checkPassword()"
                               onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"
                               class="form-control login-input-pwd" placeholder="请输入密码" onkeydown="globelQuery2(event)">
						<span class="error" style="color: red; width: 200px;"><label
                                id="rightPassword1" name="rightPassword"></label></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8">
                        <!-- 						<label class="radio-inline selected"><input -->
                        <!-- 							type="checkbox" value="2" name="autologin" checked="checked"><span>一个月内自动登录</span></label> -->
                    </div>
                    <div class="col-sm-4 text-right">
                        <div class="text-content">
                            <a href="/itoo-jrkj-student-web/confirmAccount">忘记密码</a>
                        </div>
                    </div>
                    <div class="col-sm-12">
                        <input type="button" onclick="login()" class="btn form-control"
                               value="登录">
                        </button>
                    </div>
                    <div class="col-sm-12 text-right green">
                        <div class="text-content">
                            没有账号，马上<a id="dialog-link-register" href="javascript:;">注册</a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>


