<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="header"> 
	<h1 class="page-header">
		 <small>회원 관리</small>
	</h1>
</div>

<div id="page-inner"> 

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="card-title">
				<div class="title"></div>
			</div>
		</div>
		<div class="panel-body">
			<form id="regForm" class="form-horizontal" >
				<input type="hidden" name="managerNo" value="${empty managerVO? 0:managerVO.managerNo}">
			
				<table class="table table-bordered">
					<colgroup>
						<col width="20%" />
						<col width="80%" />
					</colgroup>

					
					<tr>
						<th>이름</th>
						<td><input type="text" name="managerName" id="managerName" title="이름" value="${managerVO.managerName }" ></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><input type="text" name="phone" id="phone" title="연락처" value="${managerVO.phone }" ></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="email" id="email" title="이메일" value="${managerVO.email }" ></td>
					</tr>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="memberId" id="memberId" title="아이디" value="${managerVO.managerId }" readonly></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password"  class="managerPassword" name="managerPassword" id="managerPassword" title="비밀번호" required>※비밀번호 미입력시 기존 비밀번호가 유지됩니다.</td>
					</tr>
				</table>
				
				
				<div class="form-group">
					<div class="col-sm-12 text-center">
						<button type="button" class="btn btn-default" onclick="cancel();">취소</button>
						<button type="button" class="btn btn-primary" onclick="save();">저장</button>
					</div>
				</div>
				
			</form>
		</div>
	</div>

</div>


<script>

$(function(){
	activeMenu('/admin/manager');
	
});

function goList() {
	var params = fnGetPrevParmas("");
	fnRedirect("./list");
}

function cancel(){
	var url = "${empty managerVO? 'list':managerVO.managerNo}";
	var params = fnGetPrevParmas("managerNo");
	fnRedirect(url+'?'+params);
}

$(function(){
	var managerNo= "${managerVO.managerNo}";
	if(managerNo== 0||managerNo== null){
	$('#memberId').attr('readonly',false);
	
	}
});

$(function(){
	var pwd = "${managerVO.managerPassword}";
	$('input').find("#managerPassword").prop("required", true);
});

function save(){
	
	
	var param = $('#regForm').serialize();
	var pwd = $('.managerPassword').val();
	var memberId =$('#memberId').val();

	
 
	$.ajax({
	    url : "/admin/manager/save",
		type: 'POST',
		data: param,
		dataType: 'json',
		success: function(response) {
			console.log(response);
			alert(response.msg);
			if(response.result){
				goList();
			}
		}
	});
	
}
</script>
