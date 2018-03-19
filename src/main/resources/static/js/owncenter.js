(void function () {
// owncenter登录后从后台获取用户信息
    $.ajax({
        type: "get",
        url: "http://192.168.0.106:4001/owner/info",//后台页面链接
        cache: false,
        dataType: 'json',
        success: function (data) {
            console.log(data);
            // $(".username").text(data['username']);//用户名
            $("label").eq(1).text(data['name']);//姓名
            $("label").eq(3).text(data['idnumber']);//身份证
            $("label").eq(5).text(data['phone']);//手机
            $("label").eq(7).text(data['communityName']);//小区
            $("label").eq(9).text(data['buildingName']);//楼栋
            $("label").eq(11).text(data['num']);//number
        },
        error:function(data){
            $.MsgBox.Alert("Tips","加载个人信息失败！");
        }
    });
}())