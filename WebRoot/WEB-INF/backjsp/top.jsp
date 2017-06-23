 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                    <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">设置</a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i>  <s:property value="#session.existadmin.username"/>
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="#">我的账号</a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="sign-in.html">Logout</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="${pageContext.request.contextPath}/admin_index.action"><span class="first"></span> <span class="second">管理员页面</span></a>
        </div>
    </div>
    
        <div class="sidebar-nav">


        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse" id="top1"><i class="icon-dashboard"></i>分类管理 </a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li ><a href="${pageContext.request.contextPath}/adminCategory_findAll.action">一级分类</a></li> 
            <li ><a href="${pageContext.request.contextPath}/adminCategorySecond_findAll.action?page=1">二级分类</a></li>
            
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>商品管理</a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="${pageContext.request.contextPath}/adminProduct_findAll.action?page=1">商品</a></li>
        </ul>

        <a href="#legal-menu" class="nav-header" data-toggle="collapse"><i class="icon-legal"></i>订单管理</a>
        <ul id="legal-menu" class="nav nav-list collapse">
            <li ><a href="${pageContext.request.contextPath}/adminOrder_findAll.action?page=1">订单</a></li>
        </ul>

        <a href="help.html" class="nav-header" ><i class="icon-question-sign"></i>Help</a>
        <a href="faq.html" class="nav-header" ><i class="icon-comment"></i>Faq</a>
    </div>