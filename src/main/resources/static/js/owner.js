$(function(){
    $(".sidebar-nav").on("click", "li", function(){
        var sId = $(this).data("id");  //获取data-id的值
        window.location.hash = sId;  //设置锚点
        loadInner(sId);
    });
    function loadInner(sId){
        var sId = window.location.hash;
        var pathn, i;
        switch(sId){
            case "#owncenter": pathn = "owncenter.html"; i = 0; break;
　　　　　　case "#ownregist": pathn = "ownregist.html"; i = 1; break;
            case "#ownkmjl": pathn = "ownkmjl.html"; i = 2; break;
            case "#ownsqjl": pathn = "ownsqjl.html"; i = 3; break;
            case "#ownfault": pathn = "ownfault.html"; i = 4; break;
            case "#mngcenter": pathn = "mngcenter.html"; i = 5; break;
            case "#mngregist": pathn = "mngregist.html"; i = 6; break;
            case "#mngrequest": pathn = "mngrequest.html"; i = 7; break;
            case "#mngnonregist": pathn = "mngnonregist.html"; i = 8; break;
            case "#mngfault": pathn = "mngfault.html"; i = 9; break;
            case "#mngcontrol": pathn = "mngcontrol.html"; i = 10; break;
            case "#pptcheck": pathn = "pptcheck.html"; i = 11; break;
            case "#ppthosmsg": pathn = "ppthosmsg.html"; i = 12; break;
            case "#pptusermsg": pathn = "pptusermsg.html"; i = 13; break;
            case "#pptfault": pathn = "pptfault.html"; i = 14; break;
            case "#pptsystem": pathn = "pptsystem.html"; i = 15; break;
　　　　　　  default: pathn = "owncenter.html"; i = 0; break;
        }
        $("#content").load(pathn); //加载相对应的内容
        $(".sidebar-nav li").eq(i).addClass("current").siblings().removeClass("current"); //当前列表高亮
    }
    var sId = window.location.hash;
    loadInner(sId);
});