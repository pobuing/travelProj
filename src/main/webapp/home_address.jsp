<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/webbase.css">
    <link rel="stylesheet" href="css/pages-seckillOrder.css">
    <title>地址管理</title>
    <script>

    </script>
</head>
<body>
<!--引入头部-->
<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid">
    <!--header-->
    <div id="account">
        <div class="py-container">
            <div class="yui3-g home">
                <!--左侧列表-->
                <div class="yui3-u-1-6 list">
                    <div class="person-info">
                        <div class="person-photo" style="text-align: center">
                            <img src="${pageContext.request.contextPath}/${loginUser.pic}" width="180px"
                                 class="img-circle" alt="">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="list-items">
                        <dl>
                            <dt><i>·</i> 设置</dt>
                            <dd><a href="${pageContext.request.contextPath}/user?action=userInfo">个人信息</a></dd>
                            <dd><a href="${pageContext.request.contextPath}/user?action=findAddress"
                                   class="list-active">地址管理</a></dd>
                        </dl>
                        <dl>
                            <dt><i>·</i> 订单中心</dt>
                            <dd><a href="home_orderlist.jsp">我的订单</a></dd>
                            <dd><a href="javascript:">待付款</a></dd>
                            <dd><a href="javascript:">待发货</a></dd>
                            <dd><a href="javascript:">待收货</a></dd>
                            <dd><a href="javascript:">待评价</a></dd>
                        </dl>
                        <dl>
                            <dt><i>·</i> 我的中心</dt>
                            <dd><a href="javascript:">我的收藏</a></dd>
                            <dd><a href="javascript:">我的足迹</a></dd>
                        </dl>
                        <dl>
                            <dt><i>·</i> 物流消息</dt>
                        </dl>

                    </div>
                </div>
                <!--右侧主内容-->
                <div class="yui3-u-5-6 order-pay">
                    <div class="body userAddress">
                        <div class="address-title">
                            <span class="title">地址管理</span>
                            <a data-toggle="modal" data-target="#addressModel" data-keyboard="false"
                               class="sui-btn  btn-info add-new">添加新地址</a>
                            <span class="clearfix"></span>
                        </div>
                        <div class="address-detail">
                            <table class="sui-table table-bordered">
                                <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>地址</th>
                                    <th>联系电话</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${addressList}" var="address">
                                    <tr>
                                        <td>${address.contact}</td>
                                        <td>${address.address}</td>
                                        <td>${address.telephone}</td>
                                        <td>
                                            <a href="javascript:void(0)" onclick="editAddress(this)">编辑</a>
                                            <a href="${pageContext.request.contextPath}/user?action=delAddressById&addressId=${address.aid}">删除</a>
                                            <a href="#">设为默认</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>

                        <!-- 地址模态框 -->
                        <div class="modal fade" id="addressModel" tabindex="-1" role="dialog"
                             aria-labelledby="loginModelLable">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="tab-pane fade in active" id="pwdReg">
                                        <form action="${pageContext.request.contextPath}/user" method="post">
                                            <input type="hidden" name="action" value="addAddress">
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label>联系人</label>
                                                    <input type="text" class="form-control" name="contact"
                                                           placeholder="请输入联系人">
                                                </div>
                                                <div class="form-group">
                                                    <label>地址</label>
                                                    <input type="text" class="form-control" name="address"
                                                           placeholder="请输入地址">
                                                </div>
                                                <div class="form-group">
                                                    <label>联系电话</label>
                                                    <input type="text" class="form-control" name="telephone"
                                                           placeholder="联系电话">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <input type="submit" class="btn btn-primary" value="保存"/>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!--引入尾部-->
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="js/plugins/citypicker/distpicker.data.js"></script>
<script type="text/javascript" src="js/plugins/citypicker/distpicker.js"></script>
</body>
</html>
