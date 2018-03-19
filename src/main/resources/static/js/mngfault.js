$(function() {
    var clients=[
        {'Name':'小王','Tel':'11111111111','matter':'摄像头识别效率太低，希望有所改进','time':'2017/12/21 21:00'},
        {'Name':'小李','Tel':'11111111111','matter':'很方便','time':'2017/12/12 21:00'},
        {'Name':'小钱','Tel':'11111111111','matter':'还是很不错的','time':'2016/12/21 21:00'}
    ];
            $("#jsGrid").jsGrid({
                height: "70%",
                width: "100%",
                sorting: true,
                paging: true,
                fields: [
                    // { name: "Avator", type: "text", width: 150 },
                    { name: "Name", type: "text", width: 50 },
                    // { name: "ID number", type: "text", width: 200 },
                    { name: "Tel", type: "text", width:100 },
                    { name: "matter", type: "text",width:100 },
                    { name: "time", type: "text",width:50 }
                ],
                data: clients
            });


            $(".jsgrid-grid-header .jsgrid-table .jsgrid-header-row").append("<th style='width:100px;'>answer</th>");
            $(".jsgrid-grid-body tr").each(function(){
                $(this).append("<td style='width:100px;'><label><button style='margin-left:15px;width:59px;' class='answer'>answer</button><button style='margin-left:15px;background-color:red;width:59px;height:26px;' class='delete'>delete</button></label></td>");
            });
            //删除
            $(".delete").click(function(){
                $(this).parent().parent().parent().remove();
            });
            //回复
            $(".answer").click(function(){
                var txt=  "请输入";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.input,{
                    onOk:function(v){
                        console.log(v);
                        $.MsgBox.Alert('Tips','回复成功！');
                    }
                });
                $(this).parent().parent().parent().remove();
            });
        });