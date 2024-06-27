<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<div class="header"> 
	<h1 class="page-header">
		<small>������ ����</small>
	</h1>
</div>

<div id="page-inner"> 

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="card-title">
				<div class="title"><!-- form --></div>
			</div>
		</div>
		<div class="panel-body">
				
			<table class="table table-bordered">
				<colgroup>
					<col width="20%" />
					<col width="80%" />
				</colgroup>

				<tr>
					<th>�̸�</th>
					<td>${managerVO.managerName}</td>
				</tr>
				<tr>
					<th>����ó</th>
					<td>${managerVO.phone}</td>
				</tr>
				<tr>
					<th>�̸���</th>
					<td>${managerVO.email}</td>
				</tr>
				<tr>
					<th>���̵�</th>
					<td>${managerVO.memberId}</td>
				</tr>
			</table>
			
			<div class="form-group">
				<div class="col-sm-12 text-center">
                       <input type="button" class="btn btn-success" value="����" onclick="goForm(${managerVO.managerNo})"> 
                       <input type="button" class="btn btn-danger" value="����" onclick="del(${managerVO.managerNo})"> 
                       <input type="button" class="btn btn-default" value="�������" onclick="goList();"> 
				</div>
			</div>
				
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

function goForm(managerNo) {
	location.href='./form?managerNo='+memberNo+'&'+window.location.search.substring(1);
}


function del(managerNo) {
	if(!confirm("�����Ͻðڽ��ϱ�?")) return;
	
	var params = {
		"managerNo": managerNo
	}

	$.ajax({
		url : "./delete",
		type: 'post',
		data: params,
		dataType: 'json',
		success: function(response) {
			alert(response.msg);
			if(response.result){
				goList();
			}
		}
	}); 	
	
}
</script>