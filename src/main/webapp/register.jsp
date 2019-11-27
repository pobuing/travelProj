<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <link rel="stylesheet" href="css/register.css">
</head>
<body>
<!--引入头部-->
<jsp:include page="header.jsp"></jsp:include>
<script>
    $(function () {
        //名字已经验证
        let isnameChecked = false;
        //手机号已经验证
        let isPhoneChecked = false;
        //验证码验证
        let isSmsCodeChecked = false;
        //验证用户名是否已经存在
        $("#username").blur(function () {
            let url = "${pageContext.request.contextPath}/user";
            let params = {
                "action": "isExistByUsername",
                "username": $("#username").val()
            };
            let usernameVal = $("#username").val();
            if (usernameVal.length < 6) {
                $("#userInfo").html("<font color='red'>用户名必须大于6位</font>");

            } else {
                //请求后台验证
                $.post(url, params, function (data) {
                    console.log("data=" + data);
                    console.log("data.code=" + data.code);
                    if (data.code === 1) {
                        $("#userInfo").html("<font color='red'>用户名已经存在</font>");
                    } else {
                        $("#userInfo").html("<font color='green'>用户名可用</font>");
                        isnameChecked = true;
                    }
                }, "json");
            }

        });
        //验证手机号是否已经存在
        $("#telephone").blur(function () {
            //获取输入的手机号
            var telphone = $("#telephone").val();
            let url = "${pageContext.request.contextPath}/user"
            let param = {
                "action": "isExistByTelephone",
                "telephone": telphone
            };
            //验证
            let phone = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
            if (phone.test(telphone)) {
                console.log("手机号格式正确");
                $.post(url, param, function (data) {
                    if (data.code == 1) {
                        $("#phoneInfo").html("<font color='red'>手机号不可用</font>");
                    } else {
                        $("#phoneInfo").html("<font color='green'>手机号可用</font>");
                        isPhoneChecked = true;
                    }
                }, "json");
            } else {
                $("#phoneInfo").html("<font color='red'>手机号格式错误</font>");
            }

        });

        //点击发送验证码
        $("#sendSmsCode").click(function () {
            var url = "${pageContext.request.contextPath}/user";
            var param = {"action": "sendSmsCode", "telephone": $("#telephone").val()}
            $.post(url, param, function (data) {
                alert(data.message);
            }, "json");
        });


        $("#submit").submit(function () {
            console
        });

    });
</script>
<!-- 头部 end -->
<div class="rg_layout">
    <div class="rg_form clearfix">
        <%--左侧--%>
        <div class="rg_form_left">
            <p>新用户注册</p>
            <p>USER REGISTER</p>
        </div>
        <div class="rg_form_center">
            <!--注册表单-->
            <form id="registerForm" action="${pageContext.request.contextPath}/user" method="post">
                <!--提交处理请求的标识符-->
                <input type="hidden" name="action" value="register">
                <table style="margin-top: 25px;width: 558px">
                    <tr>
                        <td class="td_left">
                            <label for="username">用户名</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="username" name="username" placeholder="请输入账号">
                            <span id="userInfo" style="font-size:10px"></span>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="telephone">手机号</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="telephone" name="telephone" placeholder="请输入您的手机号">
                            <span id="phoneInfo" style="font-size:10px"></span>

                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="password">密码</label>
                        </td>
                        <td class="td_right">
                            <input type="password" id="password" name="password" placeholder="请输入密码">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="smsCode">验证码</label>
                        </td>
                        <td class="td_right check">
                            <input type="text" id="smsCode" name="smsCode" class="check" placeholder="请输入验证码">
                            <a href="javaScript:void(0)" id="sendSmsCode">发送手机验证码</a>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                        </td>
                        <td class="td_right check">
                            <input type="submit" class="submit" value="注册" id="submit">
                            <span id="msg" style="color: red;">${resultInfo.message}</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <%--右侧--%>
        <div class="rg_form_right">
            <p>
                已有账号？
                <a href="javascript:$('#loginBtn').click()">立即登录</a>
            </p>
        </div>
    </div>
</div>
<!--引入尾部-->
<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>
