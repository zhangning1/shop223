<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<title>商品详情</title>
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
<link href="${pageContext.request.contextPath}/css/form.css" rel="stylesheet" type="text/css" media="all" />

<script>
  function saveCart(){ 
	  var count = document.getElementById("count").value;
	  if(count == null ||count ==''){
	        alert("请输入加入购物车的数量");
	        return false;
	      
	  }else{
	  
	        if(count < 0 || count == 0 || parseInt(count) != count){
	          alert("请输入正整数");
	          return false;
	        }else{
	        
	           count = parseInt(count);
	        }
	  }
    
  }
   
  function buy(pid){
     var count = document.getElementById("count").value;
     if(count == null ||count ==''){
	        alert("请输入加入购物车的数量");
	        return false;
	  }else{
	  
	        if(count < 0 || count == 0 || parseInt(count) != count){
	          alert("请输入正整数");
	          return false;
	        }else{
	           count = parseInt(count);
	        }
	  }
     window.location.href="${pageContext.request.contextPath}/order_buy.action?pid="+pid+"&count="+count;
  
  }

</script>
</head>
<body> 
<!--header-->	
<%@ include file="top.jsp" %>
<!---->
<div class="single-sec">
	 <div class="container">
		 
		 <!-- start content -->	
		 <div class="col-md-9 det">
				 <div class="single_left">
					 <div class="flexslider">					
								<li >
									<img src="${pageContext.request.contextPath}/<s:property value="model.image"/>" />
								</li>
						</div>
						<!-- FlexSlider -->
						  <script defer src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script>
						<link rel="stylesheet" href="${pageContext.request.contextPath}/css/flexslider.css" type="text/css" media="screen" />

							<script>
						// Can also be used with $(document).ready()
						$(window).load(function() {
						  $('.flexslider').flexslider({
							animation: "slide",
							controlNav: "thumbnails"
						  });
						});
						</script>
				 </div>
				  <div class="single-right">
					 <h3><s:property value="model.pname"/></h3>
					 <div class="id"><h4>编号:<s:property value="model.pid"/> </h4></div>
					  <div class="cost">
					  
					   <form action="${pageContext.request.contextPath}/cart_addCart.action" id="cartForm" method="post" onsubmit="return saveCart();">
					   
					      <input type="hidden" name="pid"   value="<s:property value="model.pid"/>">
					  
						  <div class="prdt-cost">  
							     <ul>
								    <li>市场价格: <del><s:property value="model.market_price"/></del></li>								 
								    <li>商城价格:</li>
								    <li class="active"><s:property value="model.shop_price"/></li>
								    <li></li>
								    <li></li>
								    <li></li>
								    <li></li>
								    <input id="count" name="count"  type="text" placeholder="输入购买数量：" >
								    <input id="addCart" type="submit"  class="item_add items"  value="加入购物车">
							     </ul>
							 			  
						  </div>
						 
						</form>
								   	<input id="buy" type="button"  class="item_add iitems" value="购买" onclick="buy(<s:property value="model.pid"/>) ">   
						
						   
						 
						 <div class="clearfix"></div>
						  
					  </div>
					  
					  <div class="single-bottom1">
					 </div>					 
				  </div>
				  <div class="clearfix"></div>
					<div class="sofaset-info">
						 <h4>商品参数</h4>
						 <ul>
							 <li><s:property value="model.pdesc"/></li>						 
						 </ul>
				  </div>
		  <!---->
		  <div class="product-table">
				 <h3>Specifications of American Diamond Famina Ruby Copper, Brass Jewel Set</h3>
				 <div class="item-sec">
					 <h4>Features</h4>
					 <table class="table table-bordered">
					 <tbody>
							<tr>
								<td><p>Pearl Type</p></td>
								<td><p>Plastic</p></td>
							</tr>
							<tr>
								<td><p>Color</p></td>
								<td><p>Gold</p></td>
							</tr>														
						</tbody>
						</table>
				 </div>		
				 <div class="item-sec">
					 <h4>General</h4>
					 <table class="table table-bordered">
					 <tbody>
							<tr>
								<td><p>Base Material</p></td>
								<td><p>Alloy</p></td>
							</tr>
							<tr>
								<td><p>Brand</p></td>
								<td><p>Ethnic Jewels</p></td>
							</tr>
							<tr>
								<td><p>Precious/Artificial Jewellery</p></td>
								<td><p>Fashion Jewellery</p></td>
							</tr>
							<tr>
								<td><p>Model Number</p></td>
								<td><p>ID 4523</p></td>
							</tr>
							<tr>
								<td><p>Occasion</p></td>
								<td><p>Wedding & Engagement</p></td>
							</tr>
							<tr>
								<td><p>Type</p></td>
								<td><p>Earring & Necklace Set</p></td>
							</tr>
							<tr>
								<td><p>Ideal For</p></td>
								<td><p>Women</p></td>
							</tr>							
						</tbody>
						</table>
				 </div>	
			</div>
		 <div class="arrivals">	
			</div>			
			<!---->
		    </div>
		  
				<%@ include file="menu.jsp" %>
							 				 
				   
				 </div>
				 
</div>
<%@include file="foot.jsp" %>
</body>
</html>