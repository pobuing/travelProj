<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/webbase.css">
    <link rel="stylesheet" href="css/pages-weixinpay.css">
    <title>微信支付</title>

</head>
<body>
<!--引入头部-->
<jsp:include page="header.jsp"></jsp:include>
<script>
    $(function () {
        var queryState = setInterval(function () {
            var url = "${pageContext.request.contextPath}/order"
            var param = {
                "action": "queryPayState",
                "oid": "${order.oid}"
            }
            $.post(url, param, function (data) {
                if (data.code == 0) {
                    clearInterval("queryState");
                    window.location.href = "${pageContext.request.contextPath}/pay_success.jsp?price=${order.total}"
                }
            }, "json")
        }, 5000);
        setTimeout(function () {
            clearInterval("queryState");
            window.location.href = "${pageContext.request.contextPath}/pay_fail.jsp"
        }, 1 * 60 * 1000)
    })
</script>
<div class="container-fluid">
    <div class="cart py-container">
        <!--主内容-->
        <div class="checkout py-container  pay">
            <div class="checkout-tit">
                <h4 class="fl tit-txt"><span class="success-icon"></span><span
                        class="success-info">订单提交成功，请您及时付款！订单号：${order.oid}</span></h4>
                <span class="fr"><em class="sui-lead">应付金额：</em><em class="orange money">￥${order.total}</em>元</span>
                <div class="clearfix"></div>
            </div>
            <div class="checkout-steps">
                <div class="fl weixin">微信支付</div>
                <div class="fl sao">
                    <p class="red" style="padding-bottom: 40px">二维码已过期，刷新页面重新获取二维码。</p>
                    <div class="fl code">
                        <%--                        <img src="img/erweima.png" alt="">--%>
                        <img id="qrious"/>
                        <script src="js/qrious.min.js"></script>
                        <script>
                            var qr = new QRious({
                                element: document.getElementById('qrious'),
                                size: 250,
                                level: 'L',
                                value: '${codeUrl}'
                            });
                        </script>
                        <div class="saosao">
                            <p>请使用微信扫一扫</p>
                            <p>扫描二维码支付</p>
                        </div>
                    </div>
                    <div class="fl"
                         style="background:url(./img/phone-bg.png) no-repeat;width:350px;height:400px;margin-left:40px">

                    </div>

                </div>
                <div class="clearfix"></div>
            </div>
        </div>

    </div>
</div>
<!--引入尾部-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
