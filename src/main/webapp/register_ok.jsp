<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册成功</title>

</head>
<body>
<!--引入头部-->
<jsp:include page="header.jsp"></jsp:include>
<script>
    $(function () {
        var num = 4;
        setInterval(function () {
            if (num == 0) {
                window.location.href = "${pageContext.request.contextPath}/index.jsp"
            }
            $("#time").text(num--);
        }, 1000)
    })
</script>
<!-- 头部 end -->
<div style="text-align:center;height: 290px;margin-top: 50px">
    <span style="font-size: 30px">恭喜您，注册成功！</span>
    <div><span style="color: red" id="time">5</span>秒后，跳转到 <a href="./index.jsp">首页</a></div>
</div>
<!--引入尾部-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
