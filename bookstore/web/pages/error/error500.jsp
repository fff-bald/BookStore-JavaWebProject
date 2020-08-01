<%--
  Created by IntelliJ IDEA.
  User: 10600
  Date: 2020/8/1
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>500</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
    <div style="margin: 0 auto; font-size: 30px;" align="center">
        不好意思，网站出现了错误，程序猿小哥正在为您加紧抢修
    </div>
    <div align="center">
        <img id="500" src="static/img/500错误页面.jpg">
    </div>

    <script type="text/javascript">
        $(function () {
            $("#500").click(function () {
                location.href="${basePath}"
            })
        })
    </script>

</body>
</html>
