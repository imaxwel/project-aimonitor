(void function () {
 // 获取后台数据,每页显示8位访客信息
    $.ajax({
      url: '',
      type: 'post',
      dataType: 'json',
      success: function (json) {
        var objs=eval(json);
        // 分页
        $('.pageTest').page({
          leng: objs.length,//分页总数
          activeClass: 'activP' , //active 类样式定义
          clickBack:function(page){
            console.log(page)
          }
        })
        var currentPage=$('.activP').text();
        for (var i = currentPage*8-8; i <= currentPage*8-1; i++) {
          var img=objs[i].img;
          var name=objs[i].name;
          var begin_time=objs[i].begin_time;
          var end_time=objs[i].end_time;
          var regist_time=objs[i].regist_time;
          var last_time=objs[i].last_time;
          $(".visitor").append('<div class="visitor_msg"><div class="avator">'+img
            +'</div><div class="message"><hr style="height:1px;border:none;border-top:1px solid #ccc;width: 40%;margin: auto;" /><p class="name">'+
            name+'</p><label class="newname"><input type="" name=""><button>确定</button></label><p class="begin_time"><span>'+
            begin_time+'</span><span></span></p><p class="end_time"><span>'+
            end_time+'</span><span></span></p><p><span>'+
            regist_time+'</span><span></span></p><p><span>'+
            last_time+'</span><span></span></p></div>');
        }
        
      },
      error: function (json) {
        // $.MsgBox.Alert("Tips","获取访客信息失败！");
      }
    }); 
//add new visitor
  $('.edit_header button').click(function(){
    $('.tpl-content-wrapper').css('display','none');
    $('.tpl-login').css('display','inline-block'); 
    $('#preview').children().remove();
    $('input').val('');
    $("#fenge").css('display','none');
    $('#some_class_1').css('display','none');
    $('#some_class_2').css('display','none');
  });
  //timepicker
  $('#settime').click(function () {
    $("#fenge").toggle();
    $('.some_class').toggle();
  });
  $('.some_class').datetimepicker();
  //submit
  $('.tpl-login-btn').click(function(){
      var name = $("#user-name").val();
      var id = $("#user-id").val();
      var num = $("#user-num").val();
      var relation = $("select option:checked").text();
      //pictures  上传图片转换成base64值！！！！！！！！！！
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
              // image_base64:image_base64,
              bgtime: bgtime,
              endtime: endtime
          },
          success: function (data) {
              console.log(data);
              $.MsgBox.Alert("Tips","注册已提交！正在审核...");
              $.MsgBox.Alert("Tips",data);
              $('.tpl-content-wrapper').css('display','block');
              $('.tpl-login').css('display','none');
          },
          error: function (data) {
              $.MsgBox.Alert("注册提交失败！");
              $('.tpl-content-wrapper').css('display','block');
              $('.tpl-login').css('display','none');
          }
      });
  });
  $('#preview button').click(function(){
    $(this).parent().remove();
    alert("a");
  });
//edit current visitor
  $('.name').click(function(){
    $(this).next().toggle();
    $(this).next().children('button').click(function(){
      var newname=$(this).prev().val();
      $(this).parent().prev().text(newname);
      $(this).parent().toggle();
      $.ajax({
        type: "get",
        url: "",//后台页面链接
        async: true,
        dataType: 'json',
        data:{
          newname:newname
        },
        success: function (data) {
          console.log(data);
          $.MsgBox.Alert("Tips","data");
        },
        error:function(data){
          $.MsgBox.Alert("Tips","data");
        }
      });
    });
  });
  $('.delete').click(function(){
      $(this).parent().parent().remove();
      $.MsgBox.Alert("Tips","success");
      var name=$(this).parents().find('.name').val();
        // $.ajax({
        //   type:'get',
        //   url:'',
        //   dataType:'json',
        //   data:{
        //     name:name
        //   },
        //   success:function(data){
        //     console.log(data);
        //     $.MsgBox.Alert("Tips","data");
        //   },
        //   error:function(data){
        //     $.MsgBox.Alert("Tips","data");
        //   }
        // });
    });
}())