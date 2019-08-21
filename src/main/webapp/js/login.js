function userLogin(){
	var name=$('#userName').val().trim();
	var password=$('#userPwd').val().trim();
	//账号密码非空判断
	if(name==""){
		$(this).text('账号不能为空');
	}else if(password==""){
		$(this).text('密码不能为空');
	}else{
		//ajax发送登陆请求
		$.ajax({
			url:path+'/login.do',
			type:"post",
			data:{"name":name,"password":password},
			dataType:"json",
			success:function(){
				alert("登陆成功");
			},
			error:function(){
				alert("登录失败");
			}
		})
	}
}