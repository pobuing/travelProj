<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/webbase.css">
    <link rel="stylesheet" href="css/pages-seckillOrder.css">
    <title>个人信息</title>

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
							<img src="${pageContext.request.contextPath}/${currentUser.pic}" width="180px" class="img-circle" alt="">
						</div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="list-items">
                        <dl>
                            <dt><i>·</i> 设置</dt>
                            <dd><a href="home_index.jsp" class="list-active">个人信息</a></dd>
                            <dd><a href="home_address.jsp">地址管理</a></dd>
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
                    <div class="body userInfo">
                        <ul class="sui-nav nav-tabs nav-large nav-primary ">
                            <li class="active"><a href="#one" data-toggle="tab">基本资料</a></li>
                            <li><a href="#two" data-toggle="tab">头像照片</a></li>
                        </ul>
                        <form action="" method="post" enctype="multipart/form-data">
                            <div class="tab-content ">
                                <div id="one" class="tab-pane active">
                                    <div class="sui-form form-horizontal">
                                        <input type="hidden" name="action" value="updateInfo"/>
                                        <div class="control-group">
                                            <label for="inputName" class="control-label">昵称：</label>
                                            <div class="controls">
                                                <input type="text" id="inputName" name="nickname" value="" placeholder="昵称">
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label">性别：</label>
                                            <div class="controls">

                                                <input type="radio"  name="sex" value="1" checked /> <b>男</b>
                                                &nbsp;&nbsp;
                                                <input type="radio" name="sex" value="0"  /><b>女</b>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label">生日：</label>
                                            <div class="controls">
                                                <input type="text" name="birthday" value="" placeholder="生日">
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label">邮箱：</label>
                                            <div class="controls">
                                                <input type="text" name="email" value="" placeholder="邮箱">
                                            </div>
                                        </div>
                                        <div class="control-group">

                                            <div class="controls">
                                                <button type="submit" class="sui-btn btn-primary">更新</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id="two" class="tab-pane">

                                    <div class="new-photo">
                                        <p>当前头像：</p>
                                        <div class="upload">
                                            <img id="imgShow_WU_FILE_0" width="100" height="100" src="img/photo_icon.png" alt="">
                                            <input type="file" id="up_img_WU_FILE_0" name="pic"/>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!--引入尾部-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
