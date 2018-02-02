(void function () {
    $(document).on('click', '#settime', function () {
        $("#fenge").toggle();
        $('#some_class_1').toggle().datetimepicker();
        $('#some_class_2').toggle().datetimepicker();
        var name = $("#user-name").val();
        var id = $("#user-id").val();
        var num = $("#user-num").val();
        var relation = $("select option:checked").text();
        //pictures

        var bgtime = $("#some_class_1").val();
        var endtime = $("#some_class_2").val();
        $.ajax({
            url: '',
            type: 'post',
            dataType: 'json',
            data: {
                name: name,
                id: id,
                num: num,
                relation: relation,

                bgtime: bgtime,
                endtime: endtime
            },
            success: function (data) {
                console.log(data);
                alert("注册成功！");
            },
            error: function (data) {
                alert("注册失败！");
            }
        });
    });
}())