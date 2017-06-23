<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<title>购物车</title>
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
<%@include file="top.jsp"%>
<!---->
<div class="checkout">	 
	 <div class="container">	
		 <div class="col-md-9 product-price1">
			 <div class="check-out">
			 
					
			 <s:if test="#session.cart.cartItems.size() != 0">			
				 <div class=" cart-items">
					 <h3>我的购物车</h3>
						<script>$(document).ready(function(c) {
							$('.close1').on('click', function(c){
								$('.cart-header').fadeOut('slow', function(c){
									$('.cart-header').remove();
								});
								});	  
							});
					   </script>
					<script>$(document).ready(function(c) {
							$('.close2').on('click', function(c){
								$('.cart-header1').fadeOut('slow', function(c){
									$('.cart-header1').remove();
								});
								});	  
							});
					   </script>
						
					 <div class="in-check" >
						  <ul class="unit">
							<li><span>商品</span></li>	
							<li><span>商品价格</span></li>
							<li><span>商品数量</span></li>
							<li><span>小&nbsp;&nbsp;计</span></li>
							<li> </li>
							<div class="clearfix"> </div>
						  </ul>
						  
						  <s:iterator var="cartItem" value="#session.cart.cartItems">
							  <ul class="cart-header">
							   <a href="${pageContext.request.contextPath}/cart_removeCart.action?pid=<s:property value="#cartItem.product.pid"/>"> <div class="close1"> </div></a>
								<li class="ring-in"><a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#cartItem.product.pid"/>" ><img src="${pageContext.request.contextPath}/<s:property value="#cartItem.product.image"/>" class="img-responsive1" alt=""></a>
								</li>
								<li><span>￥<s:property value="#cartItem.product.shop_price"/></span></li>
								<li><span><s:property value="#cartItem.count"/></span></li>
								<li><span><s:property value="#cartItem.subtotal"/></span></li>
								
								<li> <a href="#" class="add-cart cart-check">ADD TO CART</a></li>
								<div class="clearfix"> </div>
								</ul>
                            </s:iterator>
					 </div>
					   
				  </div>	
				</s:if> 
				<s:else>
				    <h3>亲，购物车空空的，不如先去商城购物吧</h3>
						<script>$(document).ready(function(c) {
							$('.close1').on('click', function(c){
								$('.cart-header').fadeOut('slow', function(c){
									$('.cart-header').remove();
								});
								});	  
							});
							
							
					   </script>
				</s:else> 
				  				  
			 </div>
		 </div>
		 <div class="col-md-3 cart-total">
			 <a class="continue" >商品总计</a>
			 <div class="price-details">
				 <h3>商品名字</h3>
				  <s:iterator var="cartItem" value="#session.cart.cartItems">
				  <li><s:property value="#cartItem.product.ppname"/></li>
				  </s:iterator> 
				 <div class="clearfix"></div>				 
			 </div>	
			 <h4 class="last-price">总金额</h4>
			 <span class="total final">￥<s:property value="#session.cart.total"/></span>
			 <div class="clearfix"></div>
			 
			  <s:if test="#session.cart.cartItems.size() != 0">	
			 <a class="order" href="${pageContext.request.contextPath}/order_save.action">提交订单</a>
			 </s:if>
			 
			 <a class="order" href="${pageContext.request.contextPath}/cart_clearCart.action" id="clear">清空购物车</a>
			 
			 
			 <div class="total-item">
				 <p>&nbsp;&nbsp;我已详细阅读<a href="#">用户购买协议书</a></p>   
			 </div>
			</div>
			
			
	 </div>
</div>
<!---->
<%@include file="foot.jsp" %>		 
</body>
</html>