$(function(){
    $('.confirm').click(function(){
        $.MsgBox.Alert("Tips","操作成功！");
        // $(this).removeClass('am-text-warning');
        // $(this).addClass('am-text-success');
        $(this).parent().html('<button class="am-btn am-btn-default am-btn-xs am-text-success"><span class="am-icon-pencil-square-o"></span> 已确认</button>');
    });
    $(".server_time").datetimepicker();  
    $(".select li").click(function(){
    	var content=$(this).text();
    	$(this).parent().prev().html(content);
    });
    $(".confirmbtn").click(function(){
    	var type_content=$(".type_content").html();
    	var name_content=$(".name_content").html();
    	var server_time=$(".server_time").val();
    	var other_msg=$(".other_msg").val();
    	// alert(type_content);
    	
    	$("tbody").prepend('<tr><td><input type="checkbox"></td><td><a href="#">'+type_content
    		+'</a></td><td>'+name_content+'</td><td class="am-hide-sm-only">'+server_time+
    		'</td><td class="am-hide-sm-only">'+other_msg+
    		'</td><td><div class="am-btn-toolbar"><div class="am-btn-group am-btn-group-xs"><button class="am-btn am-btn-default am-btn-xs am-text-warning confirm"><span class="am-icon-pencil-square-o"></span> 待确认</button></div></div></td></tr>');
    	$("tr").eq(12).remove();
    });
    $(".deletebtn").click(function(){
    	$("tbody tr").eq(0).remove();
    	$.MsgBox.Alert("Tips","操作成功！");
        $("tbody").append('<tr><td><input type="checkbox"></td><td><a href="#">送水服务</a></td><td>小王</td><td class="am-hide-sm-only">2018/01/27 17:00</td><td class="am-hide-sm-only"></td><td><div class="am-btn-toolbar"><div class="am-btn-group am-btn-group-xs"><button class="am-btn am-btn-default am-btn-xs am-text-success"><span class="am-icon-pencil-square-o"></span> 已确认</button></div></div></td></tr>');
        
    });
});