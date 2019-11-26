<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/webbase.css">
    <link rel="stylesheet" href="css/pages-seckillOrder.css">
    <title>我的订单</title>

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
                        <div class="person-photo"><img src="img/_/photo.png" alt=""></div>
                        <div class="person-account">
                            <span class="name">itcast</span>
                            <span class="safe"><a href="#">退出登录 </a></span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="list-items">
                        <dl>
                            <dt><i>·</i> 设置</dt>
                            <dd><a href="home_index.jsp" >个人信息</a></dd>
                            <dd><a href="home_address.jsp">地址管理</a></dd>
                        </dl>
                        <dl>
                            <dt><i>·</i> 订单中心</dt>
                            <dd><a href="home_orderlist.jsp" class="list-active">我的订单</a></dd>
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
                    <div class="body">
                        <div class="table-title">
                            <table class="sui-table  order-table">
                                <tr>
                                    <thead>
                                    <th width="18%">图片</th>
                                    <th width="15%">商品</th>
                                    <th width="15%">单价</th>
                                    <th width="10%">数量</th>
                                    <th width="8%">商品操作</th>
                                    <th width="10%">实付款</th>
                                    </thead>
                                </tr>
                            </table>
                        </div>
                        <div class="order-detail">
                            <div class="orders">
                                <!--order1-->
                                <div class="choose-title">
                                    <label>
                                        <span>2017-02-11 11:59　订单编号：7867473872181848  店铺：哇哈哈 <a>和我联系</a></span>
                                    </label>
                                    <a class="sui-btn btn-info share-btn">分享</a>
                                </div>
                                <table class="sui-table table-bordered order-datatable">
                                    <tbody>
                                    <tr>
                                        <td width="15%">
                                            <div class="typographic">
                                                <img src="images/04-search_03.jpg" width="150" height="80">

                                            </div>
                                        </td>
                                        <td width="35%">
                                            <div>
                                                <a href="#" class="block-text">【减100元 含除夕/春节出发】广州增城三英温泉度假酒店/自由行套票</a>
                                            </div>
                                        </td>
                                        <td width="5%" class="center">
                                            <ul class="unstyled">
                                                <li>¥299.00</li>
                                            </ul>
                                        </td>
                                        <td width="5%" class="center">1</td>
                                        <td width="8%" class="center">
                                            售后服务
                                        </td>
                                        <td width="10%" class="center" >
                                            <ul class="unstyled">
                                                <li>¥299.00</li>
                                            </ul>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="15%">
                                            <div class="typographic">
                                                <img src="images/04-search_03.jpg" width="150" height="80">

                                            </div>
                                        </td>
                                        <td width="35%">
                                            <div>
                                                <a href="#" class="block-text">【减100元 含除夕/春节出发】广州增城三英温泉度假酒店/自由行套票</a>
                                            </div>
                                        </td>
                                        <td width="5%" class="center">
                                            <ul class="unstyled">
                                                <li>¥299.00</li>
                                            </ul>
                                        </td>
                                        <td width="5%" class="center">1</td>
                                        <td width="8%" class="center">
                                            售后服务
                                        </td>
                                        <td width="10%" class="center" >
                                            <ul class="unstyled">
                                                <li>¥299.00</li>
                                            </ul>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="clearfix"></div>
                        </div>

                        <div style="margin-top: 50px">
                            <div class="page_num_inf">
                                <i></i> 共
                                <span>12</span>页<span>132</span>条
                            </div>
                            <div class="pageNum">
                                <ul>
                                    <li><a href="">首页</a></li>
                                    <li class="threeword"><a href="#">上一页</a></li>
                                    <li class="curPage"><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li><a href="#">6</a></li>
                                    <li><a href="#">7</a></li>
                                    <li><a href="#">8</a></li>
                                    <li><a href="#">9</a></li>
                                    <li><a href="#">10</a></li>
                                    <li class="threeword"><a href="javascript:;">下一页</a></li>
                                    <li class="threeword"><a href="javascript:;">末页</a></li>
                                </ul>
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
