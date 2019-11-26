<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>服务器繁忙</title>
</head>
<body>
<h3>对不起，服务器繁忙，请明天再试！</h3>
<a href="../index.jsp">返回首页</a>

<p>
    ${pageContext.exception.message}
</p>
</body>
</html>
