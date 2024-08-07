<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>


<!-- Bootstrap core CSS -->
<link href="/assets/admin/css/bootstrap.css" rel="stylesheet">
<script src="/assets/common/js/jquery-1.10.2.js"></script>
<script src="/assets/common/js/common.js"></script>

<style>
body{background: #EDEDED;}
</style>
</head>
<body>
	
	<div class="container">
		<div class="row"><div class="col-sm-12" style="text-align: center;"><img src="/assets/admin/img/logimg.png" style="margin: 5px auto 5px auto;"></div></div>
		<div class="row" style="border-radius: 10px;">
			<div class="col-sm-3" style="text-align: center;"></div>
			<div class="col-sm-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="card-title">
							<div class="title text-center">관리자 로그인</div>
						</div>
					</div>
					<div class="panel-body">
						<form name="loginForm" id="loginForm" class="form-horizontal" >
							
							<div class="form-group">
								<label class="col-sm-3 control-label">아이디</label>
								<div class="col-sm-9">
									<input type="text" name="managerId" id="managerId" class="form-control" value="tester" placeholder="id" autofocus required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">비밀번호</label>
								<div class="col-sm-9">
									<input type="password" name="managerPassword" id="managerPassword" class="form-control" value="1234" placeholder="Password" required>
								</div>
							</div>
								<div class="form-group">

							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<button type="button" class="btn btn-lg btn-primary btn-block" onclick="login()">로그인</button>
								</div>
							</div>
							
							
						</form>
					
					</div>
				</div>
			
			</div>
			<div class="col-sm-3"></div>
		</div>

	</div>
	
	
		<script type="text/javascript">
		
		
		$(function(){
			$("#loginForm").find("input").keyup(function(k){
				if(k.keyCode==13){
					login();
				}
			});
		});
		
		function login(){
			var frm=document.loginForm;
			
			if(!frm.managerId.value){
				alert("아이디를 입력해주세요");
				frm.memberId.focus();
				return;
			}else if(!frm.managerPassword.value){
				alert("비밀번호를 입력해주세요");
				frm.pwd.focus();
				return;
			}
		

			var params = $("#loginForm").serialize();
			
			$.ajax({
				url : "/admin/login",
				type: 'post',
				data: params,
				dataType: 'json',
				success: function(response) {
					if(response.result) fnRedirect(response.redirectUrl);
					else alert(response.msg);
				}
			});
			
		}
	
	</script>
	
</body>
</html>