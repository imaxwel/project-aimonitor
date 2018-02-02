(void function () {
    $(document).on('click', '#submit_btn', function () {
        var title = $("#user-name").val();
        var anonymous = $("input[type='checkbox']").is(':checked');
        var text = $("#user-intro").val();
        alert(anonymous);
        $.ajax({
            url: '',
            type: 'post',
            dataType: 'json',
            data: {
                title: title,
                anonymous: anonymous,
                text: text
            },
            success: function (data) {
                console.log(data);
                alert("提交成功！");
            },
            error: function (data) {
                alert("提交失败！");
            }
        });
    });
}())