$(function() {
    var clients=[
        {'Name':'荣华小区','number':'111','Tel':'1111111'},
        {'Name':'水岸御景小区','number':'123','Tel':'1111111'}
    ];
            $("#jsGrid").jsGrid({
                height: "70%",
                width: "100%",
                sorting: true,
                paging: true,
                fields: [
                    // { name: "Avator", type: "text", width: 150 },
                    { name: "Name", type: "text", width: 50 },
                    { name: "number", type: "text", width: 200 },
                    { name: "Tel", type: "text", width:100 }
                ],
                data: clients
            });


            $(".jsgrid-grid-header .jsgrid-table .jsgrid-header-row").append("<th style='width:100px;'>answer</th>");
            $(".jsgrid-grid-body tr").each(function(){
                $(this).append("<td style='width:100px;'><label><button style='margin-left:15px;width:59px;' class='answer'>同意</button><button style='margin-left:15px;background-color:red;width:59px;height:26px;' class='delete'>拒绝</button></label></td>");
            });
            //拒绝
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
            //同意
            $(".answer").click(function(){
                $(this).parent().parent().parent().remove();
                //将删除掉的信息返回给服务器
                var msg=$(this).parent().parent().parent();
                var name=$(msg).children("td").eq(1).val();
                var Idnumber=$(msg).children("td").eq(2).val();
                var tel=$(msg).children("td").eq(3).val();
                var relationship=$(msg).children("td").eq(4).val();
                var ValidityTime=$(msg).children("td").eq(5).val();
                var result=true;
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
                //         ValidityTime:ValidityTime
                //         result:result
                //     },
                //     success:function(data){
                //         console.log(data);
                //     },
                //     error:function(data){

                //     }
                // });
            });
            //pass
            $("#pass").click(function(){
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
                //         ValidityTime:ValidityTime
                //         result:result
                //     },
                //     success:function(data){
                //         console.log(data);
                //     },
                //     error:function(data){

                //     }
                // });
            });
             //fail
            $("#fail").click(function(){
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
                //         ValidityTime:ValidityTime
                //         result:result
                //     },
                //     success:function(data){
                //         console.log(data);
                //     },
                //     error:function(data){

                //     }
                // });
            });
        });