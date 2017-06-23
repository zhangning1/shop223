<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>登录</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Wedding Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<script src="${pageContext.request.contextPath}/js/simpleCart.min.js"> </script>
<!-- start menu -->
<link href="${pageContext.request.contextPath}/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!-- /start menu -->
</head>
<body> 
<!--header-->	
<%@include file="top.jsp" %>
<!---->

<script>  //前台校验
   function clickform(){
      
     var username = document.getElementById("username").value;
     var password = document.getElementById("password").value;
     //用户名为空不能登录
     if(username == null ||username == ''){
        alert("用户名不能为空");
        return false;
     }
     //密码为空不能登录
     if(password == null ||password == ''){
        alter("密码不能为空");
        return false;
     }
   }
   function checkform(){
   
     
	  //校验用户名是否为空
		var username = document.getElementById("username").value;
		var a = "用户名不能为空";
		if (username == null || username == '') {
			document.getElementById("1").innerHTML = a
			
		} else {

			document.getElementById("1").innerHTML = null;

	}

	function checkform1() {
		var password = document.getElementById("password").value;
		var a = "密码不能为空";
		if (password == null || password == '') {
			document.getElementById("2").innerHTML = a
		} else {

			document.getElementById("2").innerHTML = null;
		}
	}
</script>
<div class="login_sec">
	 <div class="container">
		 </ol>
		 <h2>登录</h2>
		 <div class="col-md-6 log">			 
				<div > <s:actionerror/>  </div>
				 <form action="${pageContext.request.contextPath}/user_login.action" onsubmit="clickform()">
					 <h5>用户名:</h5>	
					<span id="1"></span>
					 <input id="username" name="username" type="text" value="" onblur="checkform()" > 
					  
					 <h5>密码:</h5>
					 <span id="2"></span> 		
					 <input id="password" name="password" type="password" value="" onblur="checkform1()">
					 						 	
					 <input type="submit" value="登录">					 
					  <a class="acount-btn" href="${pageContext.request.contextPath}/user_registPage.action">注册一个账号</a>
				 </form>
				 <a href="#">忘记密码 ?</a>
					
		 </div>	
				
		 <div class="clearfix"></div>
	 </div>
</div>
<!---->
<%@include file="foot.jsp" %> 
</body>
</html>
