(void function () {
// mngcenter登录后从后台获取用户信息
    $.ajax({
        type: "get",
        url: "http://192.168.0.106:4001/owner/info",//后台页面链接
        cache: false,
        dataType: 'json',
        success: function (data) {
            console.log(data);
            // $(".username").text(data['username']);//用户名
            $("label").eq(1).text(data['residentNum']);//姓名
            // $("label").eq(3).text(data['idnumber']);//身份证
            $("label").eq(3).text(data['phone']);//手机
            $("label").eq(5).text(data['communityName']);//小区
        },
        error:function(data){
            $.MsgBox.Alert("Tips","加载个人信息失败！");
        }
    });
}())