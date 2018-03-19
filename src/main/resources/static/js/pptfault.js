$(function() {
    var clients=[
        {'Name':'荣华小区','Tel':'1111111','matter':'摄像头可能需要更换','time':'2017/12/21 21:00'},
        {'Name':'荣华小区','Tel':'1111111','matter':'摄像头可能需要更换','time':'2017/12/21 21:00'}
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
                //将删除掉的信息返回给服务器
                var msg=$(this).parent().parent().parent();
                var name=$(msg).children("td").eq(1).val();
                var Idnumber=$(msg).children("td").eq(2).val();
                var tel=$(msg).children("td").eq(3).val();
                var relationship=$(msg).children("td").eq(4).val();
                var ValidityTime=$(msg).children("td").eq(5).val();
                var result=false;
                // $.ajax({
                //     url:'',
                //     dataType:'JSON',
                //     type:'get',
                //     data:{
                //         msg:msg,
                //         name:name,
                //         Idnumber:Idnumber,
                //         tel:tel,
                //         relationship:relationship,
                //         ValidityTime:ValidityTime,
                //         result:result
                //     },
                //     success:function(data){
                //         console.log(data);
                //     },
                //     error:function(data){

                //     }
                // });
            });
            //回复
            $(".answer").click(function(){
                var txt=  "请输入";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.input,{
                    onOk:function(v){
                        console.log(v);
                        $.MsgBox.Alert('Tips','回复成功！');

                        //把输入的内容上传服务器，发送给对应的用户；要将用户信息一起发送给服务器
                        // $.ajax({
                        //     url:'',
                        //     dataType:'json',
                        //     type:'get',
                        //     data:{
                        //         v:v
                        //     },
                        //     success:function(data){
                        //         console.log(data);
                        //         alert("发送成功！");
                        //     }
                        // });
                    }
                });
                $(this).parent().parent().parent().remove();
            });
        });