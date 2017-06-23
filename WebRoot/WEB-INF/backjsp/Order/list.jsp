<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>订单管理</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">

    <script src="${pageContext.request.contextPath}/lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body class=""> 
  <!--<![endif]-->
	<script type="text/javascript">
		function showDetail(oid){
				var but = document.getElementById("but"+oid);
				var div1 = document.getElementById("div"+oid);
				if(but.value == "订单详情"){
					// 1.创建异步对象
					var xhr = createXmlHttp();
					// 2.设置监听
					xhr.onreadystatechange = function(){
						if(xhr.readyState == 4){
							if(xhr.status == 200){
								
								div1.innerHTML = xhr.responseText;
							}
						}
					}
					// 3.打开连接
					xhr.open("GET","${pageContext.request.contextPath}/adminOrder_findOrderItem.action?oid="+oid+"&time="+new Date().getTime(),true);
					// 4.发送
					xhr.send(null);
					but.value = "关闭";
				}else{
					div1.innerHTML = "";
					but.value="订单详情";
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
	</script>


	<%@ include file="../top.jsp" %>
    
    
    <div class="content">

		<div class="header">

			<h1 class="page-title"></h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="index.html"></a> <span class="divider">/</span>
			</li>
			<li class="active"></li>
		</ul>

		<div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn">Import</button>
    <button class="btn">Export</button>
  <div class="btn-group">
  </div>
</div>
<div class="well">
    <table class="table" >
      <thead>
        <tr>
			<th>编号</th>
            <th>总金额</th>
            <th>收货人</th>
            <th>订单状态</th>
            <th>订单详情</th>
			<th style="width: 26px;"></th>
        </tr>
      </thead>
        
      <tbody>
         <s:iterator var="order" value="pageBean.list" status="status">
         
        <tr>
          <td><s:property value="#order.oid"/></td>
          <td><s:property value="#order.total"/></td>
          <td><s:property value="#order.name"/></td>
          <td>
          <s:if test="#order.state == 1">未付款</s:if>
          <s:if test="#order.state == 2">
                   <a href="${pageContext.request.contextPath}/adminOrder_updateState.action?oid=<s:property value="#order.oid"/>"><font color="red">发货</font></a>
          </s:if>
          <s:if test="#order.state == 3">未确认收货</s:if>
           <s:if test="#order.state == 4">交易完成</s:if>
          </td>
          
          <td>
              <!-- <a href="${pageContext.request.contextPath}/adminProduct_editPage.action?pid=<s:property value="#product.pid"/>"><i class="icon-pencil"></i></a> -->
              <input id="but<s:property value="#order.oid"/>" type="button" class="icon-pencil" value="订单详情" onclick="showDetail(<s:property value="#order.oid"/>)"/>
              <div id="div<s:property value="#order.oid"/>"></div>
          </td>
          
          
        </tr>
        

        </s:iterator>
        
        <tr align="center">
          <td>
                                 第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页&nbsp;&nbsp;&nbsp;&nbsp;
           <s:if test="pageBean.page != 1">                     
               <a href="${pageContext.request.contextPath}/adminOrder_findAll?page=1">首页</a>  
               <a href="${pageContext.request.contextPath}/adminOrder_findAll?page=<s:property value="pageBean.page-1"/>">上一页</a>
           </s:if>  
           <s:if test="pageBean.page != pageBean.totalPage">  
               <a href="${pageContext.request.contextPath}/adminOrder_findAll?page=<s:property value="pageBean.page+1"/>">下一页</a> 
               <a href="${pageContext.request.contextPath}/adminOrder_findAll?page=<s:property value="pageBean.totalPage"/>">尾页</a>   
           </s:if>      
          </td>
        </tr>
        
      </tbody>
      
    </table>
</div>


                    
            </div>
        </div>
    </div>
    


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>


