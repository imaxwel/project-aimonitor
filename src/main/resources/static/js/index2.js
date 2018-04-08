// var flag = {}
$(function () {
    $("a").click(function () {
        var sId = $(this).parent().data("id");  //获取data-id的值
        if(sId){
            window.location.hash = sId;  //设置锚点
            loadInner(sId);
        }
    });

    function loadInner(sId) {
        var sId = window.location.hash;
        var pathn, pathbf;
        switch (sId) {
            case "#zhxxgl":
                pathn = "/base/zhxxgl";
                break;
            case "#yjcl":
                pathn = "/base/yjcl";
                break;
            case "#yzswtz":
                pathn = "/base/yzswtz";
                break;
            case "#lssq":
                pathn = "/base/lssq";
                break;
            case "#dbsw":
                pathn = "/base/dbsw";
                break;
            case "#mjkgkz":
                pathn = "/base/mjkgkz";
                break;
            case "#wyryxx":
                pathn = "/base/wyryxx";
                break;
            case "#wykqjl":
                pathn = "/base/wykqjl";
                break;
            case "#wysqjl":
                pathn = "/base/wysqjl";
                break;
            case "#jcjl":
                pathn = "/base/jcjl";
                break;
            case "#gzryjl":
                pathn = "/base/gzryjl";
                break;
            case "#fksqjl":
                pathn = "/base/fksqjl";
                break;
            case "#fkjl":
                pathn = "/base/fkjl";
                break;
            case "#bjjl":
                pathn = "/base/bjjl";
                break;
            case "#lstxsq":
                pathn = "/base/lstxsq";
                break;
            case "#mjkgkz":
                pathn = "/base/mjkgkz";
                break;
            case "#aqjbsz":
                pathn = "/base/aqjbsz";
                break;
            case "#sssbxj":
                pathn = "/base/sssbxj";
                break;
            case "#mjxxgl":
                pathn = "/base/mjxxgl";
                break;
            case "#wykqjl":
                pathn = "/base/wykqjl";
                break;
            case "#wyryxx":
                pathn = "/base/wyryxx";
                break;
            case "#jzfw":
                pathn = "/base/jzfw";
                break;
            case "#yzkdgl":
                pathn = "/base/yzkdgl";
                break;
            case "#mngownmsg":
                pathn = "/base/mngownmsg";
                break;
            case "#yzsjgl":
                pathn = "/base/yzsjgl";
                break;
            case "#yzqrgl":
                pathn = "/base/yzqrgl";
                break;
            case "#yzrzls":
                pathn = "/base/yzrzls";
                break;
            case "#yzqcgl":
                pathn = "/base/yzqcgl";
                break;
            case "#mjgzzt":
                pathn = "/base/mjgzzt";
                break;
            case "#zzqk":
                pathn = "/base/zzqk";
                break;
            case "#jcqk":
                pathn = "/base/jcqk";
                break;
            case "#gzrygl" :
                pathn = "/base/gzrygl";
                break;
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
                pathn = pathbf;
                break;
                //加载相对应的内容
                pathbf = pathn;
        }
        $("#content").load(pathn,function () {
            // if (flag[pathn] == null || flag[pathn] == false) {
            //     flag[pathn] = true;
            //owncenter
            if(pathn == "/base/zhxxgl"){
                $.getScript("/js/zhxxgl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/yjcl"){
                $.getScript("/js/yjcl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/lssq"){
                $.getScript("/js/lssq.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/yzswtz"){
                $.getScript("/js/yzswtz.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/dbsw"){
                $.getScript("/js/dbsw.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/wykqjl"){
                $.getScript("/js/wykqjl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/wyryxx"){
                $.getScript("/js/wyryxx.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/mjkgkz"){
                $.getScript("/js/bootstrap-treeview.js")
                $.getScript("/js/mjkgkz.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/bjjl"){
                $.getScript("/js/bjjl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/fkjl"){
                $.getScript("/js/fkjl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/fksqjl"){
                $.getScript("/js/fksqjl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/gzryjl"){
                $.getScript("/js/gzryjl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/jcjl"){
                $.getScript("/js/jcjl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/wysqjl"){
                $.getScript("/js/wysqjl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/lstxsq"){
                $.getScript("/js/lstxsq.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/mjkgkz"){
                // $.getScript("/js/bootstrap-treeview.js")
                $.getScript("/js/mjkgkz.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/aqjbsz"){
                $.getScript("/js/aqjbsz.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/sssbxj"){
                $.getScript("/js/sssbxj.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/mjxxgl"){
                $.getScript("/js/mjxxgl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/wykqjl"){
                $.getScript("/js/wykqjl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/wyryxx"){
                $.getScript("/js/wyryxx.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/jzfw"){
                $.getScript("/js/jzfw.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/yzkdgl"){
                $.getScript("/js/yzkdgl.js");
                $.getScript("/js/msg_out.js");
            }
            //业主信息
            if (pathn == "/base/mngownmsg") {
                $.getScript("/js/mngownmsg.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/yzsjgl"){
                $.getScript("/js/yzsjgl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/yzqrgl"){
                $.getScript("/js/yzqrgl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/yzrzls"){
                $.getScript("/js/yzrzls.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/yzqcgl"){
                $.getScript("/js/yzqcgl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/gzrygl"){
                $.getScript("/js/gzrygl.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/mjgzzt"){
                $.getScript("/js/mjgzzt.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/zzqk"){
                $.getScript("/js/zzqk.js");
                $.getScript("/js/msg_out.js");
            }
            if(pathn == "/base/jcqk"){
                $.getScript("/js/jcqk.js");
                $.getScript("/js/msg_out.js");
            }
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
            //ownfault
            if (pathn == "/base/ownfault") {
                $.getScript("/js/ownfault.js");
                $.getScript("/js/msg_out.js");
            }
            //mngcenter
            if (pathn == "/base/mngcenter") {
                $.getScript("/js/mngcenter.js");
                $.getScript("/js/msg_out.js");
            }
            //mngregist
            if (pathn == "/base/mngregist") {
                $.getScript("/js/mngregist.js");
                $.getScript("/js/msg_out.js");
            }
            //mngrequest
            if (pathn == "/base/mngrequest") {
                $.getScript("/js/mngrequest.js");
                $.getScript("/js/msg_out.js");
            }
            //mngnonregist
            if (pathn == "/base/mngnonregist") {
                $.getScript("/js/mngnonregist.js");
                $.getScript("/js/msg_out.js");
            }
            //mngcontrol
            if (pathn == "/base/mngcontrol") {
                $.getScript("/js/bootstrap-treeview.js");
                $.getScript("/js/mngcontrol.js");
                $.getScript("/js/msg_out.js");
            }
            //pptcheck
            if (pathn=="/base/pptcheck") {
                $.getScript("/js/pptcheck.js");
                $.getScript("/js/msg_out.js");
            }
            //ppthosmsg
            if (pathn=="/base/ppthosmsg") {
                $.getScript("/js/ppthosmsg.js");
                $.getScript("/js/msg_out.js");
            }
            //pptusermsg
            if (pathn=="/base/pptusermsg") {
                $.getScript("/js/pptusermsg.js");
                $.getScript("/js/msg_out.js");
            }
            //pptfault
            if (pathn=="/base/pptfault") {
                $.getScript("/js/pptfault.js");
                $.getScript("/js/xcConfirm.js");
                $.getScript("/js/msg_out.js");
            }
            //pptsystem
            if (pathn=="/base/pptsystem") {
                $.getScript("/js/pptsystem.js");
                $.getScript("/js/msg_out.js");
            }
            //完善个人信息
            if (pathn == "/base/personal_msg") {
                $.getScript("/js/personal_msg.js");
                $.getScript("/js/msg_out.js");
            }

            // }
        });
    }

    window.location.hash = "#mjgzzt";
    var sId = window.location.hash;
    loadInner(sId);

});