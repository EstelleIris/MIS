<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!--为了确保适当的绘制和触屏缩放，需要在 <head> 之中添加 viewport 元数据标签。-->
    <title>用户登录</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.5.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <script language="JavaScript" type="text/javascript">
        function Login() {
            var no = document.getElementById("no");
            var password = document.getElementById("password");
            if (no.value == "" || no.value == "职工号/学号") {
                alert("职工号/学号不能为空！");
                return false;
            } else if (password.value == "" || password.value == "密码") {
                alert("密码不能为空！");
                return false;
            }
        }
    </script>
</head>
<body>
<div class="login">
    <header class="login-header">
        <img src="images/logo.png" alt="logo">
        <h1>浙江工业大学 成绩管理系统</h1>
    </header>
    <section class="login-content">
        <h2>用户登录</h2>
        <div>
            <form action="loginServlet" method="post" onSubmit="return Login()">
                <div class="form-group">
                    <label><h5>用户类型：</h5></label>
                    <input type="radio" name="type" value="教师" checked="checked">教师
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="type" value="学生">学生
                </div>
                <div class="form-group">
                    <label class="sr-only">用户名</label>
                    <input type="text" class="form-control" id="no" name="no" placeholder="职工号/学号">
                </div>
                <div class="form-group">
                    <label class="sr-only">密码</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="密码">
                </div>
                <div class="form-group">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="记住账号">记住账号
                        </label>
                        <label class="hint">${loginMessage}</label>
                    </div>
                </div>
                <div class="form-group">
                    <input class="btn btn-default btn-login" type="submit" value="登 录">
                </div>
                <div class="form-group">
                    <label>没有账号?</label>
                    <a href="register.jsp"><label>立即注册</label></a>
                    <a href="" class="forget"><label>忘记密码</label></a>
                </div>
            </form>
        </div>
    </section>
</div>
</body>
</html>