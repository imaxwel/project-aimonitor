(void function(){
    //从后台获取表格数据显示
    function GetMultiLineSelectTable(tableId, selectIds) {
        var table = $(tableId);
        var url = table.data('url');//后台对应的页面！！！！！！！！！！
        //获取数据项名称
        var fileds = new Array();//table表头放在fileds数组中
        table.children('thead').children('tr').children('th').each(function (index, el) {
            var type = 'Content';
            if ($(this).data('type')) type = $(this).data('type');
            if (type == 'Content') {
                var field = $(this).data('field');
                fileds[index] = field;
            }
        });
        $.ajax({
            url: url,
            type: 'post',
            dataType: 'json',
            success: function (json) {
                var tbody = '';
                $.each(json, function (index, el) {
                    var tr = "<tr class='even gradeC'>";

                    $.each(fileds, function (i, el) {//生成内容
                        if (fileds[i]) {
                            tr += '<td>' + formatJsonData(json[index][fileds[i]]) + '</td>';
                        }
                    });
                    tr += " <td><div class='tpl-table-black-operation'><a class='tpl-table-black-operation-del'><i class='am-icon-trash'></i> 删除</a></div></td></tr>";
                    tbody += tr;
                });
                table.children('tbody').empty();
                table.children('tbody').append(tbody);//显示数据
            },
            error: function (json) {
                alert("Err");
            }
        });
        selectIds.click(function () {
            var select = [];
            select.push({
                "访客姓名": select.children().eq(0),
                "授权时间": select.children().eq(1),
                "有效期": select.children().eq(2),
            });
            $.ajax({
                url: url,//!!!!!!!!!!!!!!!!!!!!
                type: 'post',
                dataType: 'json',
                data: {
                    select: JSON.stringify(select)
                },
                success: function (json) {
                    alert("删除成功");
                    select.remove();
                },
                error: function (json) {
                    alert("删除失败");
                }
            });
        });

    }

    //格式化JSON数据，比如日期
    function formatJsonData(jsondata) {
        if (jsondata == null) {
            return '';
        }
        else if (/\/Date\(\d+\)/.exec(jsondata)) {
            var date = new Date(parseInt(jsondata.replace("/Date(", "").replace(")/", ""), 10));
            return date.toLocaleString();
        }
        return jsondata;
    }

    //     $(document).on('click','.tpl-table-black-operation-del',function(){
    //         // $(this).parents("tr").remove();
    //         GetMultiLineSelectTable("#example-r",$(this).parents("tr"));
    //     });
}())