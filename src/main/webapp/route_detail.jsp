<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>路线详情</title>
    <link rel="stylesheet" type="text/css" href="css/route-detail.css">
</head>

<body>
<!--引入头部-->
<jsp:include page="header.jsp"></jsp:include>
<!-- 详情 start -->
<div class="wrap">
    <div class="bread_box">
        <a href="index.jsp">首页</a>
        <span> &gt;</span>
        <a href="#">国内游</a><span> &gt;</span>
        <a href="#">全国-曼谷6-7天自由行 泰国出境旅游 特价往返机票自由行二次确认</a>
    </div>
    <div class="prosum_box">
        <dl class="prosum_left">
            <dt>
                <img alt="" class="big_img" src="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size4/201703/m49788843d72171643297ccc033d9288ee.jpg">
            </dt>
            <dd>
                <a class="up_img up_img_disable"></a>
                <a title="" class="little_img" data-bigpic="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size4/201703/m40920d0669855e745d97f9ad1df966ebb.jpg">
                    <img src="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size2/201703/m20920d0669855e745d97f9ad1df966ebb.jpg">
                </a>
                <a title="" class="little_img cur_img" data-bigpic="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size4/201703/m49788843d72171643297ccc033d9288ee.jpg">
                    <img src="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size2/201703/m29788843d72171643297ccc033d9288ee.jpg">
                </a>
                <a title="" class="little_img" data-bigpic="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size4/201703/m4531a8dbceefa2c44e6d0e35627cd2689.jpg">
                    <img src="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size2/201703/m2531a8dbceefa2c44e6d0e35627cd2689.jpg">
                </a>
                <a title="" class="little_img" data-bigpic="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size4/201703/m46d8cb900e9f6c0a762aca19eae40c00c.jpg">
                    <img src="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size2/201703/m26d8cb900e9f6c0a762aca19eae40c00c.jpg">
                </a>
                <a title="" class="little_img" data-bigpic="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size4/201703/m45ea00f6eba562a767b5095bbf8cffe07.jpg" style="display:none;">
                    <img src="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size2/201703/m25ea00f6eba562a767b5095bbf8cffe07.jpg">
                </a>
                <a title="" class="little_img" data-bigpic="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size4/201703/m4265ec488cd1bc7ce749bc8c9b34b87bc.jpg" style="display:none;">
                    <img src="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size2/201703/m2265ec488cd1bc7ce749bc8c9b34b87bc.jpg">
                </a>
                <a title="" class="little_img" data-bigpic="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size4/201703/m4e7e964909d7dd1a9f6e5494d4dc0c847.jpg" style="display:none;">
                    <img src="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size2/201703/m2e7e964909d7dd1a9f6e5494d4dc0c847.jpg">
                </a>
                <a title="" class="little_img" data-bigpic="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size4/201703/m467db00e1b76718fab0fe8b96e10f4d35.jpg" style="display:none;">
                    <img src="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size2/201703/m267db00e1b76718fab0fe8b96e10f4d35.jpg">
                </a>
                <a title="" class="little_img" data-bigpic="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size4/201703/m487bbbc6e43eba6aa6a36cc1a182f7a20.jpg" style="display:none;">
                    <img src="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size2/201703/m287bbbc6e43eba6aa6a36cc1a182f7a20.jpg">
                </a>
                <a class="down_img down_img_disable" style="margin-bottom: 0;"></a>
            </dd>
        </dl>
        <div class="prosum_right">
            <p class="pros_title">【尾单特卖】全国-曼谷6-7天自由行 泰国出境旅游 特价往返机票自由行二次确认</p>
            <p class="hot">1-2月出发，网付立享￥1099/2人起！爆款位置有限，抢完即止！</p>
            <div class="pros_other">
                <p>经营商家  ：黑马国旅</p>
                <p>咨询电话 : 400-618-9090</p>
                <p>地址 ： 传智播客黑马程序员</p>
            </div>
            <div class="pros_price">
                <p class="price">
                    <strong>￥2699.00</strong>
                </p>
                <div class="p_number">
                    <div class="f_l add_chose">
                        <a class="reduce" onClick="setAmount.reduce('#qty_item_1')" href="javascript:void(0)">-</a>
                        <input type="text" name="qty_item_1" value="1" id="qty_item_1" onKeyUp="setAmount.modify('#qty_item_1')" class="text" />
                        <a class="add" onClick="setAmount.add('#qty_item_1')" href="javascript:void(0)">+</a>
                    </div>
                    <span class="collect">
                         <a class="btn" href="cart_success.jsp" id="addCart"><i class="glyphicon glyphicon-heart-empty"></i>加入购物车</a>
                    </span>
                </div>

            </div>
        </div>
    </div>
    <div class="you_need_konw">
        <span>旅游须知</span>
        <div class="notice">
            <p>1、旅行社已投保旅行社责任险。建议游客购买旅游意外保险 <br>

            <p>2、旅游者参加打猎、潜水、海边游泳、漂流、滑水、滑雪、滑草、蹦极、跳伞、滑翔、乘热气球、骑马、赛车、攀岩、水疗、水上飞机等属于高风险性游乐项目的，敬请旅游者务必在参加前充分了解项目的安全须知并确保身体状况能适应此类活动；如旅游者不具备较好的身体条件及技能，可能会造成身体伤害。</p>

            <p>3、参加出海活动时，请务必穿着救生设备。参加水上活动应注意自己的身体状况，有心脏病、冠心病、高血压、感冒、发烧和饮酒及餐后不可以参加水上活动及潜水。在海里活动时，严禁触摸海洋中各种鱼类，水母，海胆，珊瑚等海洋生物，避免被其蛰伤。老人和小孩必须有成年人陪同才能参加合适的水上活动。在海边游玩时，注意保管好随身携带的贵重物品。</p>

            <p>4、根据中国海关总署的规定，旅客在境外购买的物品，在进入中国海关时可能需要征收关税。详细内容见《中华人民共和国海关总署公告2010年第54号文件》。</p>

            <p>5、建议出发时行李托运，贵重物品、常用物品、常用药品、御寒衣物等请随身携带，尽量不要托运。行李延误属于不可抗力因素，我司将全力协助客人跟进后续工作，但我司对此不承担任何责任。</p>
            <p>1、旅行社已投保旅行社责任险。建议游客购买旅游意外保险 <br>

            <p>2、旅游者参加打猎、潜水、海边游泳、漂流、滑水、滑雪、滑草、蹦极、跳伞、滑翔、乘热气球、骑马、赛车、攀岩、水疗、水上飞机等属于高风险性游乐项目的，敬请旅游者务必在参加前充分了解项目的安全须知并确保身体状况能适应此类活动；如旅游者不具备较好的身体条件及技能，可能会造成身体伤害。</p>

            <p>3、参加出海活动时，请务必穿着救生设备。参加水上活动应注意自己的身体状况，有心脏病、冠心病、高血压、感冒、发烧和饮酒及餐后不可以参加水上活动及潜水。在海里活动时，严禁触摸海洋中各种鱼类，水母，海胆，珊瑚等海洋生物，避免被其蛰伤。老人和小孩必须有成年人陪同才能参加合适的水上活动。在海边游玩时，注意保管好随身携带的贵重物品。</p>

            <p>4、根据中国海关总署的规定，旅客在境外购买的物品，在进入中国海关时可能需要征收关税。详细内容见《中华人民共和国海关总署公告2010年第54号文件》。</p>

            <p>5、建议出发时行李托运，贵重物品、常用物品、常用药品、御寒衣物等请随身携带，尽量不要托运。行李延误属于不可抗力因素，我司将全力协助客人跟进后续工作，但我司对此不承担任何责任。</p>
        </div>
    </div>
</div>
<!-- 详情 end -->

<!--引入头部-->
<jsp:include page="footer.jsp"></jsp:include>
<script>
    $(document).ready(function() {
        //焦点图效果
        //点击图片切换图片
        $('.little_img').on('mousemove', function() {
            $('.little_img').removeClass('cur_img');
            var big_pic = $(this).data('bigpic');
            $('.big_img').attr('src', big_pic);
            $(this).addClass('cur_img');
        });
        //上下切换
        var picindex = 0;
        var nextindex = 4;
        $('.down_img').on('click',function(){
            var num = $('.little_img').length;
            if((nextindex + 1) <= num){
                $('.little_img:eq('+picindex+')').hide();
                $('.little_img:eq('+nextindex+')').show();
                picindex = picindex + 1;
                nextindex = nextindex + 1;
            }
        });
        $('.up_img').on('click',function(){
            var num = $('.little_img').length;
            if(picindex > 0){
                $('.little_img:eq('+(nextindex-1)+')').hide();
                $('.little_img:eq('+(picindex-1)+')').show();
                picindex = picindex - 1;
                nextindex = nextindex - 1;
            }
        });
        //自动播放
        // var timer = setInterval("auto_play()", 5000);
    });

    //自动轮播方法
    function auto_play() {
        var cur_index = $('.prosum_left dd').find('a.cur_img').index();
        cur_index = cur_index - 1;
        var num = $('.little_img').length;
        var max_index = 3;
        if ((num - 1) < 3) {
            max_index = num - 1;
        }
        if (cur_index < max_index) {
            var next_index = cur_index + 1;
            var big_pic = $('.little_img:eq(' + next_index + ')').data('bigpic');
            $('.little_img').removeClass('cur_img');
            $('.little_img:eq(' + next_index + ')').addClass('cur_img');
            $('.big_img').attr('src', big_pic);
        } else {
            var big_pic = $('.little_img:eq(0)').data('bigpic');
            $('.little_img').removeClass('cur_img');
            $('.little_img:eq(0)').addClass('cur_img');
            $('.big_img').attr('src', big_pic);
        }
    }
</script>
<!--演示内容开始-->
<script type="text/javascript" src="js/payfor.js"></script>
<style type="text/css">
    *{margin:0;padding:0;}
    a,img{border:0;text-decoration:none;}
    body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}
    /* p_number */
    .p_number{border:solid 1px #ddd;padding:10px 0 0 10px;width:480px;height:80px;margin:30px auto;}
    .p_number .f_l{float:left;}
    .p_number .add_chose{width:105px;}
    .p_number .add_chose a{float:left;margin:5px 0 0 0;display:block;width:15px;height:15px;line-height:99em;overflow:hidden;background:url(images/reduce-add.gif) no-repeat;}
    .p_number .add_chose a.reduce{background-position:0 0;}
    .p_number .add_chose a.reduce:hover{background-position:0 -16px;}
    .p_number .add_chose a.add{background-position:-16px 0;}
    .p_number .add_chose a.add:hover{background-position: -16px;}
    .p_number .add_chose .text{float:left;margin:0 5px;display:inline;border:solid 1px #ccc;padding:4px 3px 4px 8px;width:40px;line-height:18px;font-size:14px;color:#990000;font-weight:800;}
    .p_number .buy{line-height:2em;}
    .p_number .buy .total-font{font-family:Arial;font-size:26px;}
    .p_number .buy .jifen{margin-left:20px;color:#ACACAC;}
    .p_number .buy .jifen b{margin:0 3px;}
</style>
</body>
</html>
