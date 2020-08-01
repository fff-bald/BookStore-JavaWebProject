<%--
  Created by IntelliJ IDEA.
  User: 10600
  Date: 2020/8/1
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
    <div align="center" style="margin: 0 auto;font-size: 30px;">
       您所访问的页面不存在或已经删除。
    </div>
    <div align="center">
        <img id="404" src="static/img/404错误页面.jpg">
    </div>
<script type="text/javascript">
    $(function () {
        $("#404").click(function () {
            location.href="${basePath}"
        })
    })
</script>

</body>
</html>
