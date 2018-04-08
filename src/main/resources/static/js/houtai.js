// var flag = {}
$(function () {
    $("a").click(function () {
        var sId = $(this).parent().data("id");  //获取data-id的值
        window.location.hash = sId;  //设置锚点
        loadInner(sId);
    });

    function loadInner(sId) {
        var sId = window.location.hash;
        var pathn, pathbf;
        switch (sId) {
            case "#xqxxgl":
                pathn = "/base/xqxxgl";
                break;
            case "#wyglysh":
                pathn = "/base/wyglysh";
                break;
            case "#htdagl":
                pathn = "/base/htdagl";
                break;
            case "#wdzl":
                pathn = "/base/wdzl";
                break;
            default:
                pathn = pathbf;
                break;
            //加载相对应的内容
            pathbf = pathn;
        }
        $("#content").load(pathn,function () {
                //小区信息管理
                if (pathn == "/base/xqxxgl") {
                    $.getScript("/js/xqxxgl.js");
                    $.getScript("/js/msg_out.js");
                }
                //物业管理员审核
                if (pathn == "/base/wyglysh") {
                    $.getScript("/js/wyglysh.js");
                    $.getScript("/js/msg_out.js");
                }
                //合同档案管理
                if (pathn == "/base/htdagl") {
                    $.getScript("/js/htdagl.js");
                    $.getScript("/js/msg_out.js");
                }
                //文档资料
                if (pathn == "/base/wdzl") {
                    $.getScript("/js/wdzl.js");
                    $.getScript("/js/msg_out.js");
                }
            // }
        });
    }

    window.location.hash = "#xqxxgl";
    var sId = window.location.hash;
    loadInner(sId);

});