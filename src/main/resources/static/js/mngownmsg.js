$(function () {
$.ajax({
    url: '/owner/permit/getOwnInfo',
    type: 'get',
    dataType: 'json',
    success: function (data) {
        console.log(data);
        var objs=eval(data);
        var clients = new Array();
        for (var i = 0; i < objs.length; i++) {
            //要改！！！
            clients[i]={"UserName" : objs[i].username,"Name":objs[i].name,"Phone":objs[i].phone,
                "IdNumber":objs[i].idnumber,"Community":objs[i].communityName,
                "Building":objs[i].buildingName,"Num":objs[i].num};           
        }
                //将接收到的数据放入表格中
        var numbers = [
            { Name: "" ,Id: 0},
            { Name: "1802",Id:'1802' },
            { Name: "15",Id:15 }
        ];
        var buildings=[
            {Name:"",Id:''},
            {Name:"1栋",Id:'1栋'},
            {Name:"15栋",Id:'15栋'}
        ];
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
                pageSize: 11,
                pageButtonCount: 5,
                deleteConfirm: "Do you really want to delete the client?",
                data:clients,
                fields: [
                    { name: "UserName", type: "text", width: 100 },
                    { name: "Name", type: "text", width: 100 },
                    { name: "Phone", type: "text", width: 100 },
                    { name: "IdNumber", type: "text",width: 250 },
                    { name: "Community", type: "text", width: 100 },
                    { name: "Building", type: "text", width: 100},
                    { name: "Num", type: "text", width: 100},
                    { type: "control" }
                ]
            });

        });

    },
    error: function (data) {
        console.log(data);
    }
});
});