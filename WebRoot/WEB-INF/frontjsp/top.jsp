<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="top_bg">
	<div class="container">
		<div class="header_top-sec">
			<div class="top_right">
				<ul>
					<li><a href="#">帮助</a></li>|
					<li><a href="#">联系</a></li>
				</ul>
			</div>
			<div class="top_left">
				<ul>
				<s:if test="#session.existUser == null">
					<li class="top_link"><a href="${pageContext.request.contextPath}/user_registPage.action">注册</a></li>|
					<li class="top_link"><a href="${pageContext.request.contextPath}/user_loginPage.action">登录</a></li>	
				</s:if>
				<s:else>
				   <li class="top_link"> <s:property value="#session.existUser.name"/>  </li>|
					<li class="top_link"><a href="${pageContext.request.contextPath }/order_findByUid?page=1">我的订单</a></li>	
					<li class="top_link"><a href="${pageContext.request.contextPath}/user_quit.action">退出</a></li>	
				</s:else>				
				</ul>
			</div>
				<div class="clearfix"> </div>
		</div>

	</div>

</div>
<div class="header-top">
	 <div class="header-bottom">
		 <div class="container">			
				<div class="logo">
					<a href="${pageContext.request.contextPath}/index.action"><h1>电器商城</h1></a>
				</div>
			 <!---->
		 
			 <div class="top-nav">
				 <ul class="memenu skyblue">
					   <s:iterator var="c" value="#session.cList">
						<li class="grid">
						<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a>
						<div class="mepanel">
							<div class="row">
								<div class="col1 me-one">
									<ul>
									 <s:iterator var="cs" value="#c.categorySeconds">
										<li><a href="${pageContext.request.contextPath}/product_findByCsid.action?csid=<s:property value="#cs.csid" />&page=1"><s:property value="#cs.csname" /></a>
										</li>
								     </s:iterator>
									</ul>
								</div>
							</div>
						</div>
						</li>
				        </s:iterator>
					</ul>	
			 </div>
			<div class="clearfix"> </div>
	        </div> 
	         <!---->
			 <div class="cart box_1">
				 <a href="${pageContext.request.contextPath }/cart_myCart.action">
					<h3>购物车 <div class="total"></div>
					<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></h3>
				</a>
			 	<div class="clearfix"> </div>
			 </div>
			 <div class="clearfix"> </div>
			 <!---->
</div>
</div>
