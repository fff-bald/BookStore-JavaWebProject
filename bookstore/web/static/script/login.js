$(function () {
    //给各个输入框绑定失去焦点事件
    $("#username").blur(function () {
        // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
        //1 获取用户名输入框里的内容
        var usernameText = $("#username").val();
        //2 创建正则表达式对象
        var usernamePatt = /^\w{5,12}$/;
        //3 使用test方法验证
        if (!usernamePatt.test(usernameText)) {
            //4 提示用户结果
            $("span.errorMsg").text("用户名不合法！");
        } else
            // 去掉错误信息
            $("span.errorMsg").text("");
    });

    $("#password").blur(function () {
        // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
        //1 获取用户名输入框里的内容
        var passwordText = $("#password").val();
        //2 创建正则表达式对象
        var passwordPatt = /^\w{5,12}$/;
        //3 使用test方法验证
        if (!passwordPatt.test(passwordText)) {
            //4 提示用户结果
            $("span.errorMsg").text("密码不合法！");
        } else
            // 去掉错误信息
            $("span.errorMsg").text("");
    });

    // 给注册绑定单击事件
    $("#sub_btn").click(function () {
        // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
        //1 获取用户名输入框里的内容
        var usernameText = $("#username").val();
        //2 创建正则表达式对象
        var patt = /^\w{5,12}$/;
        //3 使用test方法验证
        if (!patt.test(usernameText)) {
            //4 提示用户结果
            $("span.errorMsg").text("用户名不合法！");

            return false;
        }

        // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
        //1 获取用户名输入框里的内容
        var passwordText = $("#password").val();
        //2 创建正则表达式对象
        var patt = /^\w{5,12}$/;
        //3 使用test方法验证
        if (!patt.test(passwordText)) {
            //4 提示用户结果
            $("span.errorMsg").text("密码不合法！");

            return false;
        }

        // 去掉错误信息
        $("span.errorMsg").text("");
    });
})