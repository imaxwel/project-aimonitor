(void function () {
    $(document).on('click', '#edit', function () {
        $("#changepwd").toggle();
    });
    $(document).on('click', '#changepwd button', function () {
        $("#changepwd").css("display", "none");
        var newpwd = $("#changepwd input").val();
        alert("111");
        $("#newpwd").text(newpwd);
    });
// owncenter登录后从后台获取用户信息
    $.ajax({
        type: "get",
        url: "",//后台页面链接
        async: true,
        dataType: 'json',
        success: function (data) {
            console.log(data);
            $(".username").text(data['']);//用户名
            $("label").eq(1).text(data['']);//姓名
            $("label").eq(3).text(data['']);//身份证
            $("label").eq(5).text(data['']);//手机
            $("#newpwd").text(data['']);//密码
            $("label").eq(9).text(data['']);//小区
        }
    });
    $(document).on('click', '.am-btn', function () {    //保存
        var message = $("#user-intro").val();
        var newpwd1 = $("#changepwd input").val();
        // alert(newpwd1);
        $.ajax({
            type: "get",
            url: "",
            async: true,
            dataType: "json",
            data: {
                message: message
            },
            success: function (data) {
                alert("保存成功！");
            }
        });

    });
}())