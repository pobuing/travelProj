<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>购物车列表</title>


</head>
<body>
<!--引入头部-->
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="row" style="margin: 100px 200px;text-align: center">
        购物车内暂时没有商品，登录后将显示您之前加入的商品
    </div>
    <div class="row">

        <div style="margin:0 auto; margin-top:20px">
            <div style="font-weight: bold;font-size: 15px;margin-bottom: 10px">商品数量：3</div>
            <table class="table">
                <tbody>
                <tr bgcolor="#f5f5f5" class="table-bordered">
                    <th>图片</th>
                    <th>商品</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>小计</th>
                    <th>操作</th>
                </tr>
                <tr class="table-bordered">
                    <td width="180" width="40%">
                        <input type="hidden" name="id" value="22">
                        <img src="images/04-search_03.jpg" width="170" height="100">
                    </td>
                    <td width="30%">
                        <a target="_blank"> 【减100元 含除夕/春节出发】广州增城三英温泉度假酒店/自由行套票</a>
                    </td>
                    <td width="10%">
                        ￥159.00
                    </td>
                    <td width="14%">
                        ×2
                    </td>
                    <td width="15%">
                        <span class="subtotal">￥298.00</span>
                    </td>
                    <td>
                        <a href="javascript:;" class="delete">删除</a>
                    </td>
                </tr >
                <tr class="table-bordered">
                    <td width="180" width="40%">
                        <input type="hidden" name="id" value="22">
                        <img src="images/04-search_09.jpg" width="170" height="100">
                    </td>
                    <td width="30%">
                        <a target="_blank"> 全国-曼谷6-7天自由行 泰国出境旅游 特价往返机票自由行二次确认</a>
                    </td>
                    <td width="10%">
                        ￥298.00
                    </td>
                    <td width="14%">
                        ×1
                    </td>
                    <td width="15%">
                        <span class="subtotal">￥298.00</span>
                    </td>
                    <td>
                        <a href="javascript:;" class="delete">删除</a>
                    </td>
                </tr >
                </tbody>
            </table>
        </div>
    </div>

    <div>
        <div style="text-align:right;">
             商品金额: <strong style="color:#ff6600;">￥596.00元</strong>
        </div>
        <div style="text-align:right;margin-top:10px;margin-bottom:10px;">
                <a href="order_info.jsp">
					<input type="button" width="100" value="结算" name="submit" border="0" style="background-color: #ea4a36;
						height:45px;width:120px;color:white;font-size: 15px">
            </a>
        </div>
    </div>

</div>
<!--引入尾部-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
