$(function(){
	var stuList = getStuList();//设置传送信息：学生的集合
	//input各种判断
//	手机号
	$('input').eq(0).blur(function(){
		var num=$(this).val();
		if($(this).val().length==0){
			$(this).parent().next("div").text("");
			$(this).parent().next("div").css("color",'#ccc');
		}else if(!isPhoneNo(num)){
			$(this).parent().next("div").text("手机号格式不正确");
			$(this).parent().next("div").css("color",'red');
		}else{
			$(this).parent().next("div").text("");
		}		
	});
	function isPhoneNo(phone) {   
		var pattern = /^1[34578]\d{9}$/;   
		return pattern.test(phone);  
	}

//密码
	$('input').eq(1).blur(function(){
		if($(this).val().length==0){
			$(this).parent().next("div").text("");
			$(this).parent().next("div").css("color",'#ccc');
		}else if($(this).val().length>0 && $(this).val().length<6){
			$(this).parent().next("div").text("长度只能在6-20个字符之间");
			$(this).parent().next("div").css("color",'red');
		}else{
			$(this).parent().next("div").text("");
		}		
	});
//	确认密码
	$('input').eq(2).blur(function(){
		if($(this).val().length==0){
			$(this).parent().next("div").text("");
			$(this).parent().next("div").css("color",'#ccc');
		}else if($(this).val()!=$('input').eq(2).val()){
			$(this).parent().next("div").text("两次密码不匹配");
			$(this).parent().next("div").css("color",'red');
		}else{
			$(this).parent().next("div").text("");
		}		
	});
//	提交按钮
	$("#submit_btn").click(function(e){		
		for(var j=0 ;j<5;j++){
			if($('input').eq(j).val().length==0){				
				$('input').eq(j).focus();				
				if(j==4){
					$('input').eq(j).parent().next().next("div").text("此处不能为空");
					$('input').eq(j).parent().next().next("div").css("color",'red');
					e.preventDefault();
					return;
				}
				$('input').eq(j).parent().next(".tips").text("此处不能为空");
				$('input').eq(j).parent().next(".tips").css("color",'red');	
				e.preventDefault();
				return;
			}			
		}
	});	
//  建立构造函数，构造学生信息模板
	function Student(name,password,tel,id){
         this.name = name;
         this.password = password;
         this.tel = tel;
         this.id = id;
     }
//	获取之前所有已经注册的用户集合
	function getStuList(){
	    var list = localStorage.getItem('stuList');
	    if(list != null){
	        return JSON.parse(list);
	    }else{
	        return new Array();
	    }
	}
});
