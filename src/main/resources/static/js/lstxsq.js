(void function () {
 // 获取后台数据,每页显示8位访客信息
    // $.ajax({
    //   url: '',
    //   type: 'post',
    //   dataType: 'json',
    //   success: function (json) {
    //     var objs=eval(json);
    //     // 分页
    //     $('.pageTest').page({
    //       leng: objs.length,//分页总数
    //       activeClass: 'activP' , //active 类样式定义
    //       clickBack:function(page){
    //         console.log(page)
    //       }
    //     })
    //     var currentPage=$('.activP').text();
    //     for (var i = currentPage*8-8; i <= currentPage*8-1; i++) {
    //       var img=objs[i].img;
    //       var name=objs[i].name;
    //       var begin_time=objs[i].begin_time;
    //       var end_time=objs[i].end_time;
    //       var regist_time=objs[i].regist_time;
    //       var last_time=objs[i].last_time;
    //       //has changed!
    //       $(".visitor").append('<div class="visitor_msg"><div class="avator">'+img
    //         +'</div><div class="message"><hr style="height:1px;border:none;border-top:1px solid #ccc;width: 40%;margin: auto;" /><p class="name">'+
    //         name+'</p><p class="begin_time"><span>开始时间:</span><span>'+
    //         begin_time+'</span></p><label class="NewBeginTime"><input type="text" class="new_begin_time" value="" /><button>确定</button></label><p class="end_time"><span>结束时间:</span><span>'+
    //         end_time+'</span></p><label class="NewEndTime"><input type="text" class="new_end_time" value="" /><button>确定</button></label> <p class="regist_time"><span>注册时间:</span><span>'+
    //         regist_time+'</span></p><p class="last_time"><span>上次来访:</span><span>'+
    //         last_time+'</span></p></div><div class="foot"><button class="delete">delete</button></div></div></div>'
    //       );
    //     }
        
    //   },
    //   error: function (json) {
    //     // $.MsgBox.Alert("Tips","获取访客信息失败！");
    //   }
    // }); 
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
  //check photo
  $('input[type="file"]').on('change',doUpload);
  function doUpload() { 
    var formData = new FormData($( "#uploadForm" )[0]);
    $.ajax({  
      url: 'http://192.168.0.106:4001/eng/checkFeature' ,  
      type: 'POST',  
      data: formData,  
      async: false,  
      cache: false,  
      contentType: false,  
      processData: false,  
      success: function (returndata) {  
        console.log(returndata);
        if (!returndata['flag']) {
          $.MsgBox.Alert("Tips","照片无效，请重新上传照片！");
          $('.delete_photo').click(function(){
            $(this).parent().remove();
          });
        }else{
          $.MsgBox.Alert("Tips","照片有效！");
        }
      },  
      error: function (returndata) { 
        console.log(returndata); 
      }  
    });
  }
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
      var bgtime = $("#some_class_1").val();
      var endtime = $("#some_class_2").val();
      var id = $("#user-count").val();
// alert(name+bgtime+endtime);
      $.MsgBox.Alert("Tips","注册已提交！");
      $('.visitor').prepend('<div class="visitor_msg"><div class="avator"><img src="/images/user10.jpg"></div><div class="message"><hr style="height:1px;border:none;border-top:1px solid #ccc;width: 40%;margin: auto;" /><p class="name" id="name">'+
        name+'</p><p class="begin_time"><span>开始时间:</span><span>'+bgtime+'</span></p><label class="NewBeginTime"><input type="text" class="new_begin_time" value="" /><button>确定</button></label><p class="end_time"><span>结束时间:</span><span>'+
        endtime+'</span></p><label class="NewEndTime"><input type="text" class="new_end_time" value="" /><button>确定</button></label> <p class="regist_time"><span>注册时间:</span><span>2017/08/21 9:00</span></p><p class="last_time"><span>工作编号:</span><span>'+
        id+'</span></p></div><div class="foot"> <button class="delete">delete</button></div></div>');
      $('.tpl-content-wrapper').css('display','block');
      $('.tpl-login').css('display','none');
      $('#visitor_msg').css('display','block');
      // $.ajax({
      //     url: 'http://192.168.0.106:4001/visitor/regist',
      //     type: 'post',
      //     dataType: 'json',
      //     data: {
      //         name: name,
      //         idnumber: id,
      //         phone: num,
      //         relationType: relation,
      //         allowBegin: bgtime,
      //         allowEnd: endtime
      //     },
      //     success: function (data) {
      //         console.log(data);
      //         $.MsgBox.Alert("Tips","注册已提交！正在审核...");
      //         $.MsgBox.Alert("Tips",data);
      //         $('.tpl-content-wrapper').css('display','block');
      //         $('.tpl-login').css('display','none');
      //     },
      //     error: function (data) {
      //         $.MsgBox.Alert("Tips","注册提交失败！");
      //         $('.tpl-content-wrapper').css('display','block');
      //         $('.tpl-login').css('display','none');
      //     }
      // });
  });
  $('#preview button').click(function(){
    $(this).parent().remove();
    alert("a");
  });
//edit current visitor
  $('.begin_time').click(function(){
    $(this).next().toggle();
    $(this).next().children('button').click(function(){
      var newbegintime=$(this).prev().val();
      $(this).parent().prev().children('span:last').text(newbegintime);
      $(this).parent().toggle();      
      $.ajax({
              type: "get",
              url: "nnn",//后台页面链接
              async: true,
              dataType: 'json',
              data:{
                newbegintime:newbegintime
              },
              success: function (data) {
                console.log(data);
              },
              error:function(data){
              }
      });
      $.MsgBox.Alert('Tips','修改成功！');
    });
  });
  $('.end_time').click(function(){
    $(this).next().toggle();
    $(this).next().children('button').click(function(){
      var newendtime=$(this).prev().val();
      $(this).parent().prev().children('span:last').text(newendtime);
      $(this).parent().toggle();      
      $.ajax({
              type: "get",
              url: "nnn",//后台页面链接
              async: true,
              dataType: 'json',
              data:{
                newendtime:newendtime
              },
              success: function (data) {
                console.log(data);
              },
              error:function(data){
              }
      });
      $.MsgBox.Alert('Tips','修改成功！');
    });
  });
  $('.new_begin_time').datetimepicker();
  $('.new_end_time').datetimepicker();
  $('.delete').click(function(){
      $(this).parent().parent().remove();
      $.MsgBox.Alert("Tips","success");
      var name=$(this).parent().prev().children('.name').val();
        $.ajax({
          type:'get',
          url:'',
          dataType:'json',
          data:{
            name:name
          },
          success:function(data){
            console.log(data);
            $.MsgBox.Alert("Tips","data");
          },
          error:function(data){
            $.MsgBox.Alert("Tips","data");
          }
        });
    });
}())