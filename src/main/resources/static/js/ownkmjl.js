$(function () {
    $.ajax({
        url:'/record/permit/getOwner',
        type:'get',
        dataType:'json',
        success: function (data) {
            console.log(data);
            var objs=eval(data);
            var clients = new Array();
            for (var i = 0; i < objs.length; i++) {
                clients[i]={"ownName" : objs[i].ownName,"phone":objs[i].phone,"community":objs[i].community,
                "building":objs[i].building,"time":objs[i].time};           
            }
            $(function() {

                $("#jsGrid").jsGrid({
                    height: "50%",
                    width: "100%",
                    autoload: true,
                    confirmDeleting: false,
                    paging: true,
                    // controller: {
                    //     loadData: function() {
                    //         return db.clients;
                    //     }
                    // },
                    data:clients,
                    fields: [
                        {
                            headerTemplate: function() {
                                return $("<button>").attr("type", "button").text("Delete")
                                        .on("click", function () {
                                            deleteSelectedItems();
                                        });
                            },
                            itemTemplate: function(_, item) {
                                return $("<input>").attr("type", "checkbox")
                                        .prop("checked", $.inArray(item, selectedItems) > -1)
                                        .on("change", function () {
                                            $(this).is(":checked") ? selectItem(item) : unselectItem(item);
                                        });
                            },
                            align: "center",
                            width: 50
                        },
                        { name: "ownName", type: "text", width: 80 },
                        { name: "phone", type: "text", width:120 },
                        { name: "community", type: "text", width: 100 },
                        { name: "building", type: "text", width: 100 },
                        { name: "time", type: "text", width: 100 }
                    ]
                });


                var selectedItems = [];

                var selectItem = function(item) {
                    selectedItems.push(item);
                };

                var unselectItem = function(item) {
                    selectedItems = $.grep(selectedItems, function(i) {
                        return i !== item;
                    });
                };

                var deleteSelectedItems = function() {
                    if(!selectedItems.length || !confirm("Are you sure?"))
                        return;

                    deleteClientsFromDb(selectedItems);

                    var $grid = $("#jsGrid");
                    $grid.jsGrid("option", "pageIndex", 1);
                    $grid.jsGrid("loadData");

                    selectedItems = [];
                };

                var deleteClientsFromDb = function(deletingClients) {
                    db.clients = $.map(db.clients, function(client) {
                        return ($.inArray(client, deletingClients) > -1) ? null : client;
                    });
                };
            });
        },
        error:function(data){}
    });
});
 