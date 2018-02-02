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
            case "#owncenter":
                pathn = "/base/owncenter";
                break;
            case "#ownregist":
                pathn = "/base/ownregist";
                break;
            case "#ownkmjl":
                pathn = "/base/ownkmjl";
                break;
            case "#ownsqjl":
                pathn = "/base/ownsqjl";
                break;
            case "#ownfault":
                pathn = "/base/ownfault";
                break;
            case "#mngcenter":
                pathn = "/base/mngcenter";
                break;
            case "#mngregist":
                pathn = "/base/mngregist";
                break;
            case "#mngrequest":
                pathn = "/base/mngrequest";
                break;
            case "#mngnonregist":
                pathn = "/base/mngnonregist";
                break;
            case "#mngfault":
                pathn = "/base/mngfault";
                break;
            case "#mngcontrol":
                pathn = "/base/mngcontrol";
                break;
            case "#pptcheck":
                pathn = "/base/pptcheck";
                break;
            case "#ppthosmsg":
                pathn = "/base/ppthosmsg";
                break;
            case "#pptusermsg":
                pathn = "/base/pptusermsg";
                break;
            case "#pptfault":
                pathn = "/base/pptfault";
                break;
            case "#pptsystem":
                pathn = "/base/pptsystem";
                break;
            case "#personal_msg":
                pathn = "/base/personal_msg";
                break;
            default:
                pathn = "/base/personal_msg";
                break;
        }
        $("#content").load(pathn,function () {
            //加载相对应的内容
            pathbf = pathn;
            // if (flag[pathn] == null || flag[pathn] == false) {
            //     flag[pathn] = true;
                //owncenter
                if (pathn == "/base/owncenter") {
                    $.getScript("/js/page/owncenter.js");
                }
                //ownregist访客注册
                if (pathn == "/base/ownregist") {
                    $.getScript("/js/page/ownregist.js");
                }
                //ownkmjl
                if (pathn == "/base/ownkmjl") {
                    $.getScript("/js/page/ownkmjl.js");
                }
                //ownsqjl
                if (pathn == "/base/ownsqjl") {
                    $.getScript("/js/page/ownsqjl.js");
                }
                //ownfault
                if (pathn == "/base/ownfault") {
                    $.getScript("/js/page/ownfault.js");
                }
                //完善个人信息
                if (pathn == "/base/personal_msg") {
                    $.getScript("/js/page/personal_msg.js");
                }
            // }
        });
    }

    var sId = window.location.hash;
    loadInner(sId);

});