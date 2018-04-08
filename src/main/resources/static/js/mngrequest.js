$(function() {
    var clients=[
        {'Name':'小王','Enter Time':'2018/02/10 7:00','Leaving Time':'2018/02/10 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小李','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小张','Enter Time':'2018/02/09 18:00','Leaving Time':'2018/02/10 8:00','Host':'lulu','Building':'05','Entrance':'389'},
        {'Name':'小明','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小徐','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小赵','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小苏','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小吴','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'},
        {'Name':'小王','Enter Time':'2018/02/10 6:00','Leaving Time':'2018/02/11 8:00','Host':'DONGDONG','Building':'15','Entrance':'302'}

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