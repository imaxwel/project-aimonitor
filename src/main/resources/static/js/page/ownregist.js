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


            //获取后台数据
            // $.ajax({
            //  url: url,
      //           type: 'post',
      //           dataType: 'json',
      //           success: function (json) {

      //           },
      //           error: function (json) {
      //               alert("Err");
      //           }
            // });
            $('.name').click(function(){
                $(this).next().toggle();
                $(this).next().children('button').click(function(){
                    var newname=$(this).prev().val();
                    $(this).parent().prev().text(newname);
                    $(this).parent().toggle();
                    // $.ajax({
                 //        type: "get",
                 //        url: "",//后台页面链接
                 //        async: true,
                 //        dataType: 'json',
                 //        data:{
                 //         newname:newname
                 //        },
                 //        success: function (data) {
                 //            console.log(data);
                 //        }
                 //    });
                });
            });
            $('.delete').click(function(){
                $(this).parents('.visitor').remove();
                var name=$(this).parents().find('.name').val();
                // $.ajax({
                //  type:'get',
                //  url:'',
                //  dataType:'json',
                //  data:{
                //      name:name
                //  },
                //  success:function(data){
                //      console.log(data);
                //  }
                // });
            });
            $('.edit_header button').click(function(){
                $('.tpl-content-wrapper').css('display','none');
                $('.tpl-login').css('display','inline-block');
            });
            $('.am-btn').click(function(){
                $('.tpl-content-wrapper').css('display','block');
                $('.tpl-login').css('display','none');
            });

    });
}())