<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/include-taglib.jspf"%>



<div class="header"> 
	<h1 class="page-header">
		 <small>논문</small>
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
				<input type="hidden" name="boardVO" value="${empty boardVO? 0:boardVO.boardNo }">
				
				<table class="table table-bordered">
					<colgroup>
						<col width="20%" />
						<col width="80%" />
					</colgroup>
					<%-- <tr>
						<th>*구분</th>
						<td>
						<select name="bid">
						<option value="bbs001" <c:if test="${bbsVO.bid eq 'bbs001'}">selected</c:if>>논문</option>
						<option value="bbs002" <c:if test="${bbsVO.bid eq 'bbs002'}">selected</c:if>>특허</option>
						<option value="bbs003" <c:if test="${bbsVO.bid eq 'bbs003'}">selected</c:if>>산출물</option>
						</select>
						<input type="hidden" name="구분" id="bid" title="구분" class="form-control" value="${bbsVO.bid }" required></td>
					</tr> --%>
					
					
					
					<tr>
						<th>*제목</th>
						<td><input type="text" name="title" id="title" title="제목" class="form-control" value="${board.title }"required></td>
					</tr>
					
					<tr>
						<th>*내용</th>
						<td ><textarea name="content" id="content" title="내용" class="form-control"  required>${board.content }</textarea></td>
					</tr>
					<tr>
						<th>표지 파일 </th>
						
						<td>※ 이미지 사이즈는 380pxx430px 사이즈 규격으로 올려 주십시오
						<input type="file" name="fFile" id="fFile" title="표지 파일" class="form-control"></td>
					</tr>
					
					<tr>
						<th>내용 파일 </th>
						<td><input type="file" name="cFile" id="cFile" title="내용 파일"  class="form-control"></td>
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

<script src="/ckeditor/ckeditor.js"></script>
<script>



$(function(){
	activeMenu('/admin/board/list');
	CKEDITOR.replace("content");
	

});

function goList() {
	var params = fnGetPrevParmas("");
	fnRedirect("./list");
}

function cancel(){
	var url = "${empty boardVO? 'list':boardVO.boardNo}";
	var params = fnGetPrevParmas("boardNo");
	fnRedirect(url+'?'+params);
}



function save(){

console.log($('#regForm').serialize());
//return;
	$('#content').val(CKEDITOR.instances.content.getData());
	
	var form = $('#regForm')[0];
	var formData = new FormData(form);
	
	var title = $('#title').val();
	var writer = $('#writer').val();
	var content = $('#content').val();
	
	

	if(title == ""){
		alert("제목을 입력해주세요.");
		return;
	}
	
	if(content == ""){
		alert("내용을 입력해주세요.");
		return;
	}

	
	$.ajax({
	    url : "/admin/board/save",
		type: 'POST',
		data: formData,
		enctype: 'multipart/form-data',
        processData: false,
        contentType: false,		
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
