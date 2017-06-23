<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
 <title>我的订单页面</title>
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
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>
<!-- /start menu -->
</head>
  
<body>
<%@ include file="top.jsp" %>
   	

<div class="container cart">

		<div class="span24">
		
			<div class="step step1">
				<ul>
					
					<li  class="current"></li>
					<h2>我的订单显示</h2> 
				</ul>
			</div>
	
		       
				<table>
				    <s:iterator var="order" value="pageBean.list">
					<tbody>
					<tr>
						<th colspan="5">订单编号:<s:property value="#order.oid"/>&nbsp;&nbsp;&nbsp;&nbsp;
						   订单状态：
						   <s:if test="#order.state == 1">
						       <a href="${pageContext.request.contextPath}/order_findByOid?oid=<s:property value="#order.oid"/>"><font class="red">付款</font></a>
						   </s:if>
						   <s:if test="#order.state == 2">
						                已发货
						   </s:if>
						   <s:if test="#order.state == 3">
						        <a href="${pageContext.request.contextPath}/order_updateState.action?oid=<s:property value="#order.oid"/>"><font class="red">确认收货</font></a>
						   </s:if>
						   <s:if test="#order.state == 4">
						                  交易完成
						   </s:if>&nbsp;&nbsp;&nbsp;&nbsp;
						          订单时间：<s:property value="#order.ordertime"/>&nbsp;&nbsp;&nbsp;&nbsp;
						        
						      总金额：<s:property value="#order.total"/>    
						</th>
					</tr>
					
					<tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
					</tr>
					<s:iterator var="orderItem" value="#order.orderItems">
						<tr>
							<td width="60">
							    <a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#orderItem.product.pid"/>" >
								<img src="${ pageContext.request.contextPath }/<s:property value="#orderItem.product.image"/>"/>
								</a>
							</td>
							<td>
								<s:property value="#orderItem.product.ppname"/>
							</td>
							<td>
								<s:property value="#orderItem.product.shop_price"/>
							</td>
							<td class="quantity" width="60">
								<s:property value="#orderItem.count"/>
							</td>
							<td width="140">
								<span class="subtotal">￥<s:property value="#orderItem.subtotal"/></span>
							</td>
							
						</tr>
						</s:iterator>
						 </s:iterator>
						<tr>
						    <td colspan="5">
						    					               <!-- 分页 -->
				<div class="pagination">
				
				       <span>第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页</span>
				       
				          <s:if test="pageBean.page != 1">
				             <a href="${pageContext.request.contextPath}/order_findByUid.action?&page=1" class="firstPage">&nbsp;</a>
				             <a href="${pageContext.request.contextPath}/order_findByUid.action?&page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>
				           </s:if>
				        
				       <s:iterator var="i" begin="1" end="pageBean.totalPage">		
				           <s:if test="pageBean.page != #i">    
				              <a href="${pageContext.request.contextPath}/order_findByUid.action?&page=<s:property value="#i"/>"><s:property value="#i"/></a>
				           </s:if>	 
				           <s:else>
				              <span class="currentPage"><s:property value="#i"/></span>
				           </s:else>
				       </s:iterator>
				       
					       <s:if test="pageBean.page != pageBean.totalPage">
					           <a class="nextPage" href="${pageContext.request.contextPath}/order_findByUid.action?&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
					           <a class="lastPage" href="${pageContext.request.contextPath}/order_findByUid.action?&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
					       </s:if>
				      
				       				       
				</div>
						    
						     </td>
						</tr>
						
				</tbody>
				    
			</table>

		</div>
		
	</div>

   
   <%@ include file="foot.jsp" %>
  </body>
</html>
