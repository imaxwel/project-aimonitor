$(function(){
	$(".confirmbtn").click(function(){
		$(".item").remove();
		var text=$("textarea").val();
		$("#home .admin-content-comment").append($(".itemlast").clone());
		$.MsgBox.Alert("Tips","回复成功！");
		$(".feedback p").html(text);
	});
});