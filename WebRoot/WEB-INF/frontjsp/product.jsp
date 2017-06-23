<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<title>商品显示</title>
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

</head>
<body> 
<!--header-->	
<%@ include file="top.jsp" %>
<!---->
<!--header//-->
<div class="product-model">	 
	 <div class="container">
			<h2>商品列表</h2>			
		 <div class="col-md-9 product-model-sec">
		     <s:iterator var="p" value="pageBean.list">
					 <a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid"/>"><div class="product-grid love-grid">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="${pageContext.request.contextPath}/<s:property value="#p.image"/>" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns"><span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>点击查看详细信息</button>
							</h4>
							</div>
						</div></a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust prt_name">
								<h4><s:property value="#p.ppname" /></h4>
								<p>ID: <s:property value="#p.pid"/></p>
								<h4>商城价格</h4>
								<span class="item_price">￥<s:property value="#p.shop_price"/></span>								
							</div>													
							<div class="clearfix"> </div>
						</div>
						
					</div>	
					</s:iterator>
					               						<!-- 分页 -->
				<div class="pagination">
				
				       <span>第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页</span>
				       <s:if test="cid != 0">
				          <s:if test="pageBean.page != 1">
				             <a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=1" class="firstPage">&nbsp;</a>
				             <a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>
				           </s:if>
				        
				       <s:iterator var="i" begin="1" end="pageBean.totalPage">		
				           <s:if test="pageBean.page != #i">    
				              <a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="#i"/>"><s:property value="#i"/></a>
				           </s:if>	 
				           <s:else>
				              <span class="currentPage"><s:property value="#i"/></span>
				           </s:else>
				       </s:iterator>
				       
					       <s:if test="pageBean.page != pageBean.totalPage">
					           <a class="nextPage" href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
					           <a class="lastPage" href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
					       </s:if>
				       </s:if >
				       <s:if test="csid != 0">
				         <s:if test="pageBean.page != 1">
				             <a href="${pageContext.request.contextPath}/product_findByCsid.action?csid=<s:property value="csid"/>&page=1" class="firstPage">&nbsp;</a>
				             <a href="${pageContext.request.contextPath}/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>
				           </s:if>
				        
				       <s:iterator var="i" begin="1" end="pageBean.totalPage">		
				           <s:if test="pageBean.page != #i">    
				              <a href="${pageContext.request.contextPath}/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="#i"/>"><s:property value="#i"/></a>
				           </s:if>	 
				           <s:else>
				              <span class="currentPage"><s:property value="#i"/></span>
				           </s:else>
				       </s:iterator>
				       
					       <s:if test="pageBean.page != pageBean.totalPage">
					           <a class="nextPage" href="${pageContext.request.contextPath}/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
					           <a class="lastPage" href="${pageContext.request.contextPath}/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
					       </s:if>
				       </s:if>
				       
				       
				</div>
				
               
				
			</div>

			<div class="rsidebar span_1_of_left">
				 <section  class="sky-form">
					 <div class="product_right">					 	
						 <h4 class="m_2"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>种类</h4>
						 <s:iterator var="c" value="#session.cList">
						 <div class="tab<s:property value="#c.cid"/>">
							 <ul class="place">								
								 <li class="sort"><a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a></li>
								 <li class="by"><img src="${pageContext.request.contextPath}/images/do.png" alt=""></li>
									<div class="clearfix"> </div>
							  </ul>
								 
								 <div class="single-bottom">
								        <s:iterator var="cs" value="#c.categorySeconds">						
										<li><a href="${pageContext.request.contextPath}/product_findByCsid.action?csid=<s:property value="#cs.csid"/>&page=1"><s:property value="#cs.csname"/></a></li>
										</s:iterator>
							     </div>
							     
					      </div>						  
						  </s:iterator>
						  </div>						  
			  
						  <!--script-->
						<script>
							$(document).ready(function(){
								$(".tab1 .single-bottom").hide();
								$(".tab2 .single-bottom").hide();
								$(".tab3 .single-bottom").hide();
								$(".tab4 .single-bottom").hide();
								$(".tab5 .single-bottom").hide();
								
								$(".tab1 ul").click(function(){
									$(".tab1 .single-bottom").slideToggle(300);
									$(".tab2 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab4 .single-bottom").hide();
									$(".tab5 .single-bottom").hide();
								})
								$(".tab2 ul").click(function(){
									$(".tab2 .single-bottom").slideToggle(300);
									$(".tab1 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab4 .single-bottom").hide();
									$(".tab5 .single-bottom").hide();
								})
								$(".tab3 ul").click(function(){
									$(".tab3 .single-bottom").slideToggle(300);
									$(".tab4 .single-bottom").hide();
									$(".tab5 .single-bottom").hide();
									$(".tab2 .single-bottom").hide();
									$(".tab1 .single-bottom").hide();
								})
								$(".tab4 ul").click(function(){
									$(".tab4 .single-bottom").slideToggle(300);
									$(".tab5 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab2 .single-bottom").hide();
									$(".tab1 .single-bottom").hide();
								})	
								$(".tab5 ul").click(function(){
									$(".tab5 .single-bottom").slideToggle(300);
									$(".tab4 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab2 .single-bottom").hide();
									$(".tab1 .single-bottom").hide();
								})	
							});
						</script>
						<!-- script -->					 
				 </section>
				 				 
				   <section  class="sky-form">
						<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>价格</h4>
							<ul class="dropdown-menu1">
								 <li><a href="">								               
								<div id="slider-range"></div>							
								<input type="text" id="amount" style="border: 0; font-weight: NORMAL;   font-family: 'Arimo', sans-serif;" />
							 </a></li>			
						  </ul>
				   </section>
				   <!---->
					 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
					 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery-ui.css">
					<script type='text/javascript'>//<![CDATA[ 
					$(window).load(function(){
					 $( "#slider-range" ).slider({
								range: true,
								min: 0,
								max: 400000,
								values: [ 8500, 350000 ],
								slide: function( event, ui ) {  $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
								}
					 });
					$( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) + " - $" + $( "#slider-range" ).slider( "values", 1 ) );

					});//]]> 
					</script>
					 <!---->			
			 </div>	
			 			 
	      </div>
	      
		</div>
		
</div>
<%@ include file="foot.jsp" %>	
</body>
</html>