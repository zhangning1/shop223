<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<title>电器商城</title>
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
<%@ include file="top.jsp" %>
<!---->
<div class="banner">
	 <div class="container">
	 </div>
</div>
<!---->
<div class="welcome">

</div>
<!---->

<!---->
<div class="featured">
	 <div class="container">
		 <h3>最热商品</h3>
			<div class="feature-grids">
					<s:iterator var="p" value="hList" >
				<div class="col-md-3 feature-grid jewel">
						<a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid"/>"><img src="${pageContext.request.contextPath}/<s:property value="#p.image"/> " /></a>
							<div class="arrival-info">
								<h4><s:property value="#p.pname"/></h4>
								<p><a>商城价格：</a><s:property value="#p.shop_price"/></p>
								<span class="pric1"><del><a>市场价格：</a><s:property value="#p.market_price"/></del></span>
							</div>
				</div>
					</s:iterator>
				<div class="clearfix"></div>
			</div>
			<div class="feature-grids">

			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>
<!---->
<div class="arrivals">
	 <div class="container">	
		 <h3>最新商品</h3>
		 <div class="arrival-grids">			 
			 <ul id="flexiselDemo1">
			 
			   <s:iterator var="p" value="nList">	
			  
			    <li>
					 <a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid"/>"><img src="${pageContext.request.contextPath}/<s:property value="#p.image"/> " /></a>
					 <div class="arrival-info">
						 <h4><s:property value="#p.pname"/></h4>
						 <p><a>商城价格：</a><s:property value="#p.shop_price"/></p>
						 <span class="pric1"><del><a>市场价格：</a><s:property value="#p.market_price"/></del></span>
					 </div>
				 </li>
				 
			   </s:iterator>
			</ul>
				
				<script type="text/javascript">
				 $(window).load(function() {			
				  $("#flexiselDemo1").flexisel({
					visibleItems: 4,
					animationSpeed: 1000,
					autoPlay: true,
					autoPlaySpeed: 3000,    		
					pauseOnHover:true,
					enableResponsiveBreakpoints: true,
					responsiveBreakpoints: { 
						portrait: { 
							changePoint:480,
							visibleItems: 1
						}, 
						landscape: { 
							changePoint:640,
							visibleItems: 2
						},
						tablet: { 
							changePoint:768,
							visibleItems: 3
						}
					}
				});
				});
				</script>
				<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.flexisel.js"></script>			 
		  </div>
	 </div>
</div>
<!---->
<%@ include file="foot.jsp" %>
</body>
</html>
