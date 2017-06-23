<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>一级分类管理</title>
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
  
  <script>
    function addCategoryPage(){
       
       window.location.href = "${pageContext.request.contextPath}/adminCategory_addPage.action";
       
    }
    
    function deletee(cid){
      window.location.href = "${pageContext.request.contextPath}/adminCategory_delete.action?cid="+cid;
    
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
    <button class="btn btn-primary" id="add" name="add" onclick="addCategoryPage()"><i class="icon-plus"></i>添加一级分类</button>
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
         
          <th>一级分类名称</th>
          <th style="width: 26px;"></th>
        </tr>
      </thead>
        
      <tbody>
         <s:iterator var="c" value="cList">
         
        <tr>
          <td><s:property value="#c.cid"/></td>
          
          <td><s:property value="#c.cname"/></td>    
          <td>
              <a href="${pageContext.request.contextPath}/adminCategory_editPage.action?cid=<s:property value="#c.cid"/>"><i class="icon-pencil"></i></a>
              <a href="#myModal<s:property value="#c.cid"/>" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
          </td>
        </tr>
        
<div class="modal small hide fade" id="myModal<s:property value="#c.cid"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">提示信息</h3>
    </div>
    <div class="modal-body">
        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>你确定要删除这个一级分类吗?</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
        <!-- <a href="${pageContext.request.contextPath}/adminCategory_delete.action?cid=<s:property value="#c.cid"/>"  ><font color="black">删除</font></a> -->
        <button class="btn btn-danger" type="button" data-dismiss="modal" onclick="deletee(<s:property value="#c.cid"/>)">删除<s:property value="#c.cid"/></button>
    </div>
</div>
        </s:iterator>
      </tbody>
      
    </table>
</div>
<div class="pagination">
    <ul>
        <li><a href="#">Prev</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">Next</a></li>
    </ul>
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


