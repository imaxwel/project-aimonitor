$.ajax({
    url: '/comm/getAll',
    type: 'get',
    dataType: 'json',
    success: function (data) {
        console.log(data);
        var objs=eval(data);
        var clients = new Array();
        for (var i = 0; i < objs.length; i++) {
            clients[i]={"Name" : objs[i].name};           
        }
                //将接收到的数据放入表格中
        $(function() {
            $("#jsGrid").jsGrid({
                height: "70%",
                width: "100%",
                filtering: true,
                editing: true,
                inserting: true,
                sorting: true,
                paging: true,
                autoload: true,
                pageSize: 15,
                pageButtonCount: 5,
                deleteConfirm: "Do you really want to delete the client?",
                data:clients,
                fields: [
                    { name: "Name", type: "text", width: 100 },
                    { type: "control" }
                ]
            });

        });

    },
    error: function (data) {
    }
});
        //insert
        $("input .jsgrid-insert-button").click(function(){
            var row1=$("jsgrid-cell input").eq(0).val();
            var row2=$("jsgrid-cell input").eq(1).val();
            var row3=$("jsgrid-cell input").eq(2).val();
            $.ajax({
                url: '',
                type: 'post',
                dataType: 'json',
                data:{
                    row1:row1,
                    row2:row2,
                    row3:row3
                },
                success: function (data) {
                    console.log(data);
                },
                error: function (data) {
                }
            });
        });
        //delete
        $("input .jsgrid-delete-button").click(function(){
            var row1=$(this).parent().parent().children("td").eq(0);
            var row2=$(this).parent().parent().children("td").eq(1);
            var row3=$(this).parent().parent().children("td").eq(2);
            $.ajax({
                url: '',
                type: 'post',
                dataType: 'json',
                data:{
                    row1:row1,
                    row2:row2,
                    row3:row3
                },
                success: function (data) {
                    console.log(data);
                },
                error: function (data) {
                }
            });
        });
        //edit
        $("input .jsgrid-update-button").click(function(){
            var row1=$(this).parent().parent().children("input").eq(0).val();
            var row2=$(this).parent().parent().children("input").eq(1).val();
            var row3=$(this).parent().parent().children("input").eq(2).val();
            $.ajax({
                url: '',
                type: 'post',
                dataType: 'json',
                data:{
                    row1:row1,
                    row2:row2,
                    row3:row3
                },
                success: function (data) {
                    console.log(data);
                },
                error: function (data) {
                }
            });
        });