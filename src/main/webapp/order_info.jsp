<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/webbase.css">
    <link rel="stylesheet" type="text/css" href="css/pages-getOrderInfo.css">

    <title>结算页</title>

</head>
<body>
<!--引入头部-->
<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid">
    <!-- 头部 end -->
    <div class="cart py-container">
        <!--主内容-->
        <div class="checkout py-container">
            <div class="step-tit">
                <h4 style="font-weight: bold">填写并核对订单信息</h4>
            </div>
            <div class="checkout-steps">
                <div class="payshipInfo">
                    <div class="step-tit">
                        <h5>支付方式</h5>
                    </div>
                    <div class="step-cont">
                        <ul class="payType">
                            <li class="selected">微信付款</li>
                        </ul>
                    </div>
                    <div class="hr"></div>
                    <div class="step-tit">
                        <h5>订单详情</h5>
                    </div>
                    <div class="step-cont">
                        <ul class="send-detail">
                            <c:forEach items="${cart.cartItems}" var="entry">
                                <c:set var="cartItem" value="${entry.value}"/>
                                <li>

                                    <div class="sendGoods">

                                        <ul class="yui3-g">
                                            <li class="yui3-u-1-6">
                                                <span><img src="${cartItem.route.rimage}"/></span>
                                            </li>
                                            <li class="yui3-u-7-12" style="padding-left: 10px">
                                                <div class="desc">${cartItem.route.rname}</div>
                                                <div class="seven">7天无理由退货</div>
                                            </li>
                                            <li class="yui3-u-1-12">
                                                <div class="price">￥${cartItem.route.price}</div>
                                            </li>
                                            <li class="yui3-u-1-12">
                                                <div class="num">X${cartItem.num}</div>
                                            </li>
                                            <li class="yui3-u-1-12">
                                                <div class="exit">有货</div>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                            </c:forEach>

                            <li></li>
                            <li></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="clearfix trade">
            <div class="fc-price">应付金额:　<span class="price">¥${cart.cartPrice}</span></div>
        </div>
        <div class="submit">
            <a class="sui-btn btn-danger btn-xlarge" href="${pageContext.request.contextPath}/order?action=createOrder">提交订单</a>
        </div>
    </div>
</div>
<!-- 底部栏位 -->
<!--引入尾部-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
