(void function () {

        $('#camera').click(function () {
            $("#content img").css("display", "none");
            //调用摄像头进行拍照
            var capture = document.getElementById("capture");
            var video = document.getElementById("video");
            var canvas = document.getElementById("canvas");
            var context = canvas.getContext("2d");
            navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia || navigator.msGetUserMedia;
            window.URL = window.URL || window.webkitURL;
            navigator.getUserMedia({video: true}, onSuccess, onError); //调用摄像头捕捉视频信息
            capture.onclick = function (e) {
                e.preventDefault();
                canvas.width = video.videoWidth * 0.5;
                canvas.height = video.videoHeight * 0.5;
                // $("img").width = video.videoWidth;
                // $("img").height = video.videoHeight;
                context.drawImage(video, 0, 0, video.videoWidth * 0.5, video.videoHeight * 0.5);
                // var imgData=canvas.toDataURL("mimeType,qualityArgument");
                // alert("imgData");

                canvas.toBlob(function(blob){
                    //ajax upload
                    // var xhr=new XMLHttpRequest();
                    // xhr.open("POST","http://192.168.0.118:4001/eng/checkFeature",true);
                    // xhr.send(blob);
                    var formdata=new FormData();
                    formdata.append("image",blob,"image.png");
                    // $.post("http://192.168.0.118:4001/eng/checkFeature",formdataC,function (data) {  
                    //     console.log(data);  
                    // });
                    $.ajax({  
                          url: 'http://192.168.0.106:4001/eng/checkFeature' ,  
                          type: 'POST',  
                          data: formdata,  
                          async: false,  
                          cache: false,  
                          contentType: false,  
                          processData: false,  
                          success: function (returndata) {  
                            console.log(returndata);
                            if (!returndata['flag']) {
                                $.MsgBox.Alert("Tips","照片无效，请重新拍摄！");
                            }else{
                                $.MsgBox.Alert("Tips","照片有效！");
                            }
                          },  
                          error: function (returndata) {  
                            
                          }  
                     });
                });
            }
            function onSuccess(stream) {
                video.src = window.URL.createObjectURL(stream);
               
                // alert (video.src);
            }
            function onError() {
                mystatus.innerHTML = "获取视频出错"
            }
            $("#video").css("display", "inline-block");
            $("#capture").css("display", "inline-block");
            $("#imghead").css("display", "none");
            $("#capture").click(function () {
                $("#canvas").css("display", "inline-block");
            });
        });

        //本地
        $("#previewImg").click(function () {
            $("#canvas").css("display", "none");
            $("#video").css("display", "none");
            $("#capture").css("display", "none");
            $("img").css("display", "inline-block");
        });
        //动态检测上传的图片是否合格
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
                            // alert($(this).prev().attr('id'));
                            $(this).parent().remove();
                        });
                    }else{
                        $.MsgBox.Alert("Tips","照片有效！");
                    }
                  },  
                  error: function (returndata) {  
                    
                  }  
             });
         }
        //get all communities
        $.ajax({
            type: "get",
            url: "http://192.168.0.106:4001/comm/getAll",
            dataType: "json",
            success: function (data) {
                var json = eval(data);
                $.each(json, function (index, item) {
                    var housing = json[index].name;//??????获取所有小区数据
                    var cid = json[index].cid;
                    $("#select").append("<option value='" + cid + "'>" + housing + "</option>");
                    $("#select").trigger("change");//手动触发一次change事件
                });
            }
        });
        //get buildings
        $("#select").change(function () {
            var select = $('#select').val();
            $.ajax({
                type: "get",
                url: "http://192.168.0.106:4001/buil/getByCid",//??????????
                dataType: "json",
                cache: false,
                data: {
                    cid: select
                },
                success: function (data) {
                    var json = eval(data);
                    var options = "";
                    $.each(json, function (index, item) {
                        var building = json[index].location;//building list?????????
                        var bid = json[index].bid;
                        options+=("<option value='" + bid + "'>" + building + "</option>");
                    });
                    $("#building").html(options);
                }
            });
        });

        $("#save").click(function () {
            // 将数据传到服务器
            var name = $("input").eq(1).val();
            var idnumber = $('input').eq(2).val();
            var phone = $('input').eq(3).val();
            var cid = $('#select').val();
            var bid = $('#building').val();
            var num = $('input').eq(4).val();
            $.ajax({
                type: "post",
                url: "http://192.168.0.106:4001/owner/regist",//后台页面
                cache: false,
                dataType: "json",
                data: {
                    name: name,
                    idnumber: idnumber,
                    phone: phone,
                    cid: cid,
                    bid: bid,
                    num: num
                },
                success: function (data) {
                    $.MsgBox.Alert("Tips","保存成功！");
                    // alert("保存成功!");
                },
                error: function () {
                    $.MsgBox.Alert("Tips","保存失败！");
                    // alert('保存失败！');
                }
            });
        });
    }
    ()
)