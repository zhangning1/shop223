<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>添加商品</title>
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
 
 <form action="${pageContext.request.contextPath}/adminProduct_save.action" method="post"  enctype="multipart/form-data">                
<div class="btn-toolbar">                                                                 
    <button class="btn btn-primary" type="submit"><i class="icon-save"></i>确定添加</button>
  <div class="btn-group">
  </div>
</div>
<div class="well">
    <ul class="nav nav-tabs">
      <li class="active"><a data-toggle="tab">商品</a></li>

      <li class="active"><a data-toggle="tab">所属的二级分类</a></li>
              <select name="categorySecond.csid">
	         <s:iterator var="cs" value="csList">
	           <option value="<s:property value="#cs.csid"/>"><s:property value="#cs.csname"/></option>
	         </s:iterator>
	      </select>
      
    </ul>
    
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
    <form id="tab">
               
        <label>商品名称</label>
        <input id="ppname" name="ppname" type="text" placeholder="请输入你要添加的商品的名称：" class="input-xlarge">
         <label>商品详细名称</label>
        <input id="pname" name="pname" type="text" placeholder="请输入你要添加的商品的详细名称：" class="input-xlarge">
         <label>市场价格</label>
        <input id="market_price" name="market_price" type="text" placeholder="请输入你要添加的商品的市场价格：" class="input-xlarge">
         <label>商城价格</label>
         <input id="shop_price" name="shop_price" type="text" placeholder="请输入你要添加的商品的商城价格：" class="input-xlarge">
         <label>是否热门</label>
        <select id="is_hot" name="is_hot" class="input-xlarge">
             <option value="1">是</option>
             <option value="0">否</option>
        </select>
         <label>商品描述</label>
        <textarea rows="5" cols="28"placeholder="请输入你要添加的商品的描述：" id="pdesc" name="pdesc"  class="input-xlarge"></textarea>
         <label>商品图片</label>  
         <input type="file" name="upload" id="upload"/>
    </form>
      </div>
      <div class="tab-pane fade" id="profile">

      </div>
  </div>

</div>

</form>  
 




                    
                    <footer>
                        <hr>
                        
                        

                    </footer>
                    
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
