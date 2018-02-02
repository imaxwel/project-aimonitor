(void function () {
    $(document).on('click', '#camera', function () {
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
            // var imgData=canvas.toDataURL(“image/png”);
            // alert("imgData");
            $("#video").css("display", "inline-block");
            $("#capture").css("display", "inline-block");
            $("#imghead").css("display", "none");
            $("#capture").click(function () {
                $("#canvas").css("display", "inline-block");
            });
            //本地
            $("#previewImg").click(function () {
                $("#canvas").css("display", "none");
                $("#video").css("display", "none");
                $("#capture").css("display", "none");
                $("img").css("display", "inline-block");
            });
            $.ajax({
                type: "get",
                url: "/comm/getAll",
                dataType: "json",
                cache: false,
                success: function (data) {
                    var json = eval(data);
                    $.each(json, function (index, item) {
                        var housing = json[index].name;//??????获取所有小区数据
                        var cid = json[index].cid;
                        $("#select").append("<option value='" + cid + "'>" + housing + "</option>");
                    });
                }
            });
            $("#select").click(function () {
                var select = $('#select option:checked').text();
                $.ajax({
                    type: "get",
                    url: "",//??????????
                    dataType: "json",
                    cache: false,
                    data: {
                        select: select
                    },
                    success: function (data) {
                        var json = eval(data);
                        $.each(json, function (index, item) {
                            var building = json[index].building;//building list?????????
                            $("#building").append("<option value='" + index + "'>" + building + "</option>");
                        });
                    }
                });
            });

            $("#save").click(function () {
                // 将数据传到服务器
                var username = $("input").eq(0).val();
                var id = $('input').eq(1).val();
                var select = $('#select option:checked').text();
                var building = $('#building option:checked').text();
                var photo = new FormData($('.am-form')[0]);
                $.ajax({
                    type: "get",
                    url: "#",//后台页面
                    cache: false,
                    dataType: "json",
                    data: {
                        username: username,
                        id: id,
                        select: select,
                        building: building,
                        photo: photo
                    },
                    success: function (data) {
                        alert("保存成功!");
                    },
                    error: function () {
                        alert('保存失败！');
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

    });
}())