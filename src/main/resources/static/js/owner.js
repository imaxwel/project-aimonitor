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
            case"#mngownmsg":
                pathn = "/base/mngownmsg";
                break;
            default:
                pathn = pathbf;
                break;
            //加载相对应的内容
            pathbf = pathn;
        }
        $("#content").load(pathn,function () {
            // if (flag[pathn] == null || flag[pathn] == false) {
            //     flag[pathn] = true;
                //owncenter
                if (pathn == "/base/owncenter") {
                    $.getScript("/js/owncenter.js");
                    $.getScript("/js/msg_out.js");
                }
                //ownregist访客注册
                if (pathn == "/base/ownregist") {
                    $.getScript("/js/page.js");
                    $.getScript("/js/ownregist.js");
                    $.getScript("/js/msg_out.js");
                }
                //ownkmjl
                if (pathn == "/base/ownkmjl") {
                    $.getScript("/js/ownkmjl.js");
                    $.getScript("/js/msg_out.js");
                }
                //ownsqjl
                // if (pathn == "ownsqjl.html") {
                //     $.getScript("../static/js/ownsqjl.js");
                //     $.getScript("../static/js/msg_out.js");
                // }
                //ownfault
                if (pathn == "/base/ownfault") {
                    $.getScript("/js/ownfault.js");
                    $.getScript("/js/msg_out.js");
                }
                //mngcenter.html
                if (pathn=="/base/mngcenter") {
                    $.getScript("/js/mngcenter.js");
                    $.getScript("/js/msg_out.js");
                }
                //mngregist.html
                if (pathn=="/base/mngregist") {
                    $.getScript("/js/mngregist.js");
                    $.getScript("/js/msg_out.js");
                }
                //mngrequest.html
                if (pathn=="/base/mngrequest") {
                    $.getScript("/js/mngrequest.js");
                    $.getScript("/js/msg_out.js");
                }
                //mngnonregist.html
                if (pathn=="/base/mngnonregist") {
                    $.getScript("/js/mngnonregist.js");
                    $.getScript("/js/msg_out.js");
                }
                //mngfault.html
                if (pathn=="/base/mngfault") {
                    $.getScript("/js/mngfault.js");
                    $.getScript("/js/msg_out.js");
                }
                //mngcontrol.html
                if (pathn=="/base/mngcontrol") {
                    $.getScript("/js/bootstrap-treeview.js");
                    $.getScript("/js/mngcontrol.js");
                    $.getScript("/js/msg_out.js");
                }
                //pptcheck.html
                if (pathn=="/base/pptcheck") {
                    $.getScript("/js/pptcheck.js");
                    $.getScript("/js/msg_out.js");
                }
                //ppthosmsg.html
                if (pathn=="/base/ppthosmsg") {
                    $.getScript("/js/ppthosmsg.js");
                    $.getScript("/js/msg_out.js");
                }
                //pptusermsg.html
                if (pathn=="/base/pptusermsg") {
                    $.getScript("/js/pptusermsg.js");
                    $.getScript("/js/msg_out.js");
                }
                //pptfault.html
                if (pathn=="/base/pptfault") {
                    $.getScript("/js/pptfault.js");
                    $.getScript("/js/xcConfirm.js");
                    $.getScript("/js/msg_out.js");
                }
                //pptsystem.html
                if (pathn=="/base/pptsystem") {
                    $.getScript("/js/pptsystem.js");
                    $.getScript("/js/msg_out.js");
                }
                //完善个人信息
                if (pathn == "/base/personal_msg") {
                    $.getScript("/js/personal_msg.js");
                    $.getScript("/js/msg_out.js");
                }
                //业主信息
                if (pathn == "/base/mngownmsg") {
                    $.getScript("/js/mngownmsg.js");
                    $.getScript("/js/msg_out.js");
                }
            // }
        });
    }

    var sId = window.location.hash;
    loadInner(sId);

});