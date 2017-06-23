
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<title>Account</title>
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
<div class="container">
	
	 <div class="registration">
		 <div class="registration_left">
			 <h2>新用户? <span> 先注册一个账号吧 </span></h2>
			 <!-- [if IE] 
				< link rel='stylesheet' type='text/css' href='ie.css'/>  
			 [endif] -->  
			  
			 <!-- [if lt IE 7]>  
				< link rel='stylesheet' type='text/css' href='ie6.css'/>  
			 <! [endif] -->  
			 <script>
				(function() {
			
				// Create input element for testing
				var inputs = document.createElement('input');
				
				// Create the supports object
				var supports = {};
				
				supports.autofocus   = 'autofocus' in inputs;
				supports.required    = 'required' in inputs;
				supports.placeholder = 'placeholder' in inputs;
			
				// Fallback for autofocus attribute
				if(!supports.autofocus) {
					
				}
				
				// Fallback for required attribute
				if(!supports.required) {
					
				}
			
				// Fallback for placeholder attribute
				if(!supports.placeholder) {
					
				}
				
				// Change text inside send button on submit
				var send = document.getElementById('register-submit');
				if(send) {
					send.onclick = function () {
						this.innerHTML = '...Sending';
					}
				}
			
			 })();
			
			      
			 </script>
			 
			  <script>  //前台校验
			   
			   function clickform(){
			   
			   		var sex1 = document.getElementById("sexboy");
			 		var sex2 = document.getElementById("sexgirl");
			 		var boy = "男";
			 		var girl = "女";
			 		if(sex1.checked == true){
			 			sex1.value = boy;
			 		}else{
			 			sex2.value = girl;
			 		}
			   
			   
			   
			       //用户名为空，不给注册
			      var username = document.getElementById("username").value;
			      if(username == null ||username == ''){
			          alert("用户名不能为空"); 
			          return false;
			      }
			      
			       //真实姓名为空，不给注册
			      var name = document.getElementById("name").value;
			      if(name == null ||name == ''){
			          alert("真实姓名不能为空"); 
			          return false;
			      }
			      
			       //手机号码为空，不给注册
			      var addr = document.getElementById("addr").value;
			      if(addr == null ||addr == ''){
			          alert("地址不能为空"); 
			          return false;
			      }
			      //地址为空，不给注册
			      var addr = document.getElementById("addr").value;
			      if(addr == null ||addr == ''){
			          alert("地址不能为空"); 
			          return false;
			      }
			      
			      //手机号码为空，不给注册
			      var phone = document.getElementById("phone").value;
			      if(phone == null ||phone == ''){
			          alert("手机号码不能为空"); 
			          return false;
			      }
			      //邮箱为空，不给注册
			      var email = document.getElementById("email").value;
			      if(email == null ||email == ''){
			          alert("邮箱不能为空"); 
			          return false;
			      }
			      //密码为空，不给注册
			      var password = document.getElementById("password").value;
			      if(password == null ||password == ''){
			          alert("密码不能为空"); 
			          return false;
			      }
			        //点击确定注册时，当密码和确定密码不相同的时候不给注册
			         var repassword =  document.getElementById("repassword").value;
			         var password =  document.getElementById("password").value;
			         if(repassword != password){
			             alert("密码和确定密码不相同"); 
			             return false;			            
			         }
			   
			   
			       
			   }
			 
			   function checkform(){
			          //校验用户名是否为空 
			          //获取用户名文本框的值
			         var abc1 = "用户名不能为空";
			         var username =  document.getElementById("username").value;
			         if(username == null || username == ''){
			             document.getElementById("span123").innerHTML = abc1;
			         }else {
			          
			          
			         //校验用户名是否存在
			         //1.创建异步对象
			         var xhr = createXmlHttp();
			         //2.设置监听
			         xhr.onreadystatechange = function(){
			             if(xhr.readyState == 4){
			                 if(xhr.status == 200){
			                 
			                     document.getElementById("span123").innerHTML = xhr.responseText;
			                 }
			             }
			         }
			         //3.打开连接
			         xhr.open("GET","${pageContext.request.contextPath}/user_findByName.action?time="+new Date().getTime()+"&username="+username,true);
			         //4.发送
			         xhr.send(null);
						
					}
			      
			   }
			   
			 	function createXmlHttp(){
				   var xmlHttp;
				   try{ // Firefox, Opera 8.0+, Safari
				        xmlHttp=new XMLHttpRequest();
				    }
				    catch (e){
					   try{// Internet Explorer
					         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
					      }
					    catch (e){
					      try{
					         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
					      }
					      catch (e){}
					      }
				    }
		
					return xmlHttp;
				 }
			   
			   function checkform1(){
			   
			       //校验用户姓名是否为空
			         var abc1 = "真实姓名不能为空";
			         var name =  document.getElementById("name").value;
			         if(name == null || name == ''){
			             document.getElementById("span124").innerHTML = abc1;
			             }
			             else {
						document.getElementById("span124").innerHTML = null;
					}
			         
			   
			   }
			   
			    function checkform2(){ 
			          //校验地址是否为空
			         var abc1 = "地址不能为空";
			         var addr =  document.getElementById("addr").value;
			         if(addr == null || addr == ''){
			             document.getElementById("span125").innerHTML = abc1;			            
			         }else {
						document.getElementById("span125").innerHTML = null;
					}
			   
			   }
			    function checkform3(){ 
			          //校验手机号码是否为空
			         var abc1 = "手机号码不能为空";
			         var phone =  document.getElementById("phone").value;
			         if(phone == null || phone == ''){
			             document.getElementById("span126").innerHTML = abc1;			            
			         }else {
						document.getElementById("span126").innerHTML = null;
					}
			   
			   }
			   function checkform4(){ 
			          //校验邮箱是否为空
			         var abc1 = "邮箱不能为空";
			         var email =  document.getElementById("email").value;
			         if(email == null || email == ''){
			             document.getElementById("span127").innerHTML = abc1;			            
			         }else {
						document.getElementById("span127").innerHTML = null;
					}
			   
			   }
			   function checkform5(){ 
			          //校验密码是否为空
			         var abc1 = "密码不能为空";
			         var password =  document.getElementById("password").value;
			         if(password == null || password == ''){
			             document.getElementById("span128").innerHTML = abc1;			            
			         }else {
						document.getElementById("span128").innerHTML = null;
					}
			   
			   }
			  function checkform6(){ 
			          //校验密码与确定密码是否相同
			         var abc1 = "密码与确定密码不相同";
			         var abc2 = "确定密码不能为空";
			         var repassword =  document.getElementById("repassword").value;
			         var password =  document.getElementById("password").value;
			        if(repassword == null || repassword == ''){ 
			        
			            document.getElementById("span129").innerHTML = abc2;
			          
					}else{
					    if(repassword != password){
			             document.getElementById("span129").innerHTML = abc1;			            
			           }else {
						 document.getElementById("span129").innerHTML = null;
					   }
					   
					}
			   
			   }
			 	function sex(){
			 		
			 	}
			 
			 </script>
			 <div class="registration_form" >
			 <!-- Form -->
				<form id="registerform" action="${pageContext.request.contextPath}/user_regist.action" novalidate="novalidate" method="post" onsubmit="return clickform();">
					<div>
						<label>
							<input name="username" id="username" placeholder="用户名:" type="text" tabindex="1" required  onblur="checkform()">
							<span id="span123"></span>
							<span><s:fielderror fieldName="username"/></span>
						</label>
					</div>
					
					<div>
						<label>
							<input name="name" id="name" placeholder="真实名字：" type="text" tabindex="2" required onblur="checkform1()">
							<span id="span124"></span>
							<span><s:fielderror fieldName="name"/></span>
						</label>
					</div>
					<div>
						<label>
							<input name="addr" id="addr" placeholder="地址：" type="text" tabindex="3" required onblur="checkform2()">
							<span id="span125"></span>
							<span><s:fielderror fieldName="addr"/></span>
						</label>
					</div>
					<div>
						<label>
							<input name="phone" id="phone" placeholder="手机号码：" type="text" tabindex="4" required onblur="checkform3()">
							<span id="span126"></span>
						</label>
					</div>
					<div>
						<label>
							<input id="email" name="email" placeholder="邮箱:" type="email" tabindex="5" required onblur="checkform4()">
							<span id="span127"></span>
							<span><s:fielderror fieldName="email"/></span>
						</label>
					</div>					
						<div class="sky_form1">
							<ul>
								<li><label class="radio left"><input id="sexboy" type="radio" name="sex" checked><i></i>先生</label></li>
								<li><label class="radio"><input id="sexgirl" type="radio" name="sex"><i></i>女士</label></li>
								<div class="clearfix"></div>
							</ul>
						</div>					
					<div>
						<label>
							<input name="password" id="password" placeholder="密码" type="password" tabindex="6" required onblur="checkform5()">
							<span id="span128"></span>
							<span><s:fielderror fieldName="password"/></span>
						</label>
					</div>						
					<div>
						<label>
							<input id="repassword" placeholder="确定密码" type="password" tabindex="7" required onblur="checkform6()">
							<span id="span129"></span>
						</label>
					</div>	
					<div> 
						<input type="submit" value="确定注册" id="register-submit">
						<input type="submit" value="重&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp置"  onClick="" type="reset">
					</div>
					<div class="sky-form">
						<label class="checkbox"><input type="checkbox" name="checkbox" ><i></i>我已经详细阅读并同意 &nbsp;<a class="terms" href="#"> terms of service</a> </label>
					</div>
				</form>
		
			 </div>
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<!---->
<%@include file="foot.jsp" %>>	 
</body>
</html>
