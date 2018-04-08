$(function() {
    var clients=[
        {'Name':'小王','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小李','ID number':'222222222222222222','Tel':'33333333333','Relationship':'亲戚','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小张','ID number':'333333333333333333','Tel':'44444444444','Relationship':'同学','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小钱','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小青','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小明','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小汪','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小王','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小苏','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小赵','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小旭','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小超','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小钱','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小钱','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小钱','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小钱','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小钱','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小钱','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小钱','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小钱','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小钱','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小钱','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小钱','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'},
        {'Name':'小钱','ID number':'111111111111111111','Tel':'22222222222','Relationship':'朋友','Validity Time':'2017/01/12 19:00--2018/01/12 19:00'}
    ];

            $("#jsGrid").jsGrid({
                height: "70%",
                width: "100%",
                sorting: true,
                paging: true,
                fields: [
                    { name: "Name", type: "text", width: 50 },
                    { name: "ID number", type: "text", width: 200 },
                    { name: "Tel", type: "text", width:100 },
                    { name: "Relationship", type: "text",width:100 },
                    { name: "Validity Time", type: "text",width:200 }
                ],
                data: clients
            });


            $(".jsgrid-grid-header .jsgrid-table .jsgrid-header-row").append("<th style='width:100px;'>option</th>");
            $(".jsgrid-grid-body tr").each(function(){
                $(this).append("<td style='width:100px;'><label><button style='margin-left:50px;width:59px;' class='answer'>删除</button></label></td>");
            });
            //同意
            $(".answer").click(function(){
                $(this).parent().parent().parent().remove();
                $.MsgBox.Alert("Tips","操作成功,已删除");
                
            });
            //pass
    $("tr").attr({"data-toggle":"modal","data-target":"#myModal"});
    $(".confirmbtn").click(function(){
        $.MsgBox.Alert("Tips","已同意该申请");
    });
});