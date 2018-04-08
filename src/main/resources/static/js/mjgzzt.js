$(function () {
    var clients = [
        {
            '小区': '荣华小区',
            '设备ID': 'JOOKKMKDANSI522',
            '设备地址': '东大门',
            '设备工作情况': '正在运行',
            '设备已工作时间': '15:21:00',
            '当日开门次数': '26',
            '设备自检状态': '<span class="label label-sm label-success">健康</span>',
            '设备网络状态': '好'
        },
        {
            '小区': '荣华小区',
            '设备ID': 'JOOKKMKDANSI522',
            '设备地址': '东大门',
            '设备工作情况': '正在运行',
            '设备已工作时间': '15:21:00',
            '当日开门次数': '26',
            '设备自检状态': '<span class="label label-sm label-warning">待查</span>',
            '设备网络状态': '好'
        },
        {
            '小区': '荣华小区',
            '设备ID': 'JOOKKMKDANSI522',
            '设备地址': '东大门',
            '设备工作情况': '正在运行',
            '设备已工作时间': '15:21:00',
            '当日开门次数': '26',
            '设备自检状态': '<span class="label label-sm label-success">健康</span>',
            '设备网络状态': '好'
        },
        {
            '小区': '荣华小区',
            '设备ID': 'JOOKKMKDANSI522',
            '设备地址': '东大门',
            '设备工作情况': '正在运行',
            '设备已工作时间': '15:21:00',
            '当日开门次数': '26',
            '设备自检状态': '<span class="label label-sm label-success">健康</span>',
            '设备网络状态': '好'
        },
        {
            '小区': '荣华小区',
            '设备ID': 'JOOKKMKDANSI522',
            '设备地址': '东大门',
            '设备工作情况': '正在运行',
            '设备已工作时间': '15:21:00',
            '当日开门次数': '26',
            '设备自检状态': '<span class="label label-sm label-success">健康</span>',
            '设备网络状态': '好'
        },
        {
            '小区': '荣华小区',
            '设备ID': 'JOOKKMKDANSI522',
            '设备地址': '东大门',
            '设备工作情况': '正在运行',
            '设备已工作时间': '15:21:00',
            '当日开门次数': '26',
            '设备自检状态': '<span class="label label-sm label-success">健康</span>',
            '设备网络状态': '好'
        }
    ];

    var MyDateField = function (config) {
        jsGrid.Field.call(this, config);
    };

    MyDateField.prototype = new jsGrid.Field({
        sorter: function (date1, date2) {
            return new Date(date1) - new Date(date2);
        },

        itemTemplate: function (value) {
            return new Date(value).toDateString();
        },

        insertTemplate: function (value) {
            return this._insertPicker = $("<input>").datepicker({defaultDate: new Date()});
        },

        editTemplate: function (value) {
            return this._editPicker = $("<input>").datepicker().datepicker("setDate", new Date(value));
        },

        insertValue: function () {
            return this._insertPicker.datepicker("getDate").toISOString();
        },

        editValue: function () {
            return this._editPicker.datepicker("getDate").toISOString();
        }
    });

    jsGrid.fields.myDateField = MyDateField;

    $("#jsGrid").jsGrid({
        height: "100%",
        width: "100%",
        inserting: true,
        editing: true,
        sorting: true,
        paging: true,
        fields: [
            {name: "小区", type: "text", width: 50},
            {name: "设备ID", type: "text", width: 100},
            {name: "设备地址", type: "text", width: 100},
            {name: "设备工作情况", type: "text", width: 50},
            {name: "设备已工作时间", type: "text", width: 50},
            {name: "当日开门次数", type: "text", width: 50},
            {name: "设备自检状态", type: "text", width: 50},
            {name: "设备网络状态", type: "text", width: 50}
        ],
        data: clients
    });

});