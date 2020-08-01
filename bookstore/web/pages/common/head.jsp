<%--
  Created by IntelliJ IDEA.
  User: 10600
  Date: 2020/7/30
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /**
     * request中有方法：
     * getScheme()方法获得协议名称
     * getServerName()方法获得服务器的IP地址
     * getServerPort()方法获得服务器端口号
     * 方法获得服务器工程名称
     */
    String basePath = request.getScheme()
            +"://"+request.getServerName()
            +":"+request.getServerPort()
            +request.getContextPath()
            +"/";
%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>