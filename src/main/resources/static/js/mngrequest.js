$(function() {
    var clients=[
        {'Name':'小王','Enter Time':'2018/02/10 7:00','Leaving Time':'2018/02/10 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小张','Enter Time':'2018/02/09 18:00','Leaving Time':'2018/02/10 8:00','Host':'lulu','Building':'05','Entrance':'389'},
    ];
            $("#jsGrid").jsGrid({
                height: "70%",
                width: "100%",
                sorting: true,
                paging: true,
                fields: [
                    // { name: "Avator", type: "text", width: 150 },
                    { name: "Name", type: "text", width: 50 },
                    { name: "Enter Time", type: "text", width: 100 },
                    { name: "Leaving Time", type: "text", width:100 },
                    { name: "Host", type: "text",width:100 },
                    { name: "Building", type: "text",width:50 },
                    { name: "Entrance",type: "text",width:100}
                ],
                data: clients
            });
            $("#sort").click(function() {
                var field = $("#sortingField").val();
                $("#jsGrid").jsGrid("sort", field);
            });
        });