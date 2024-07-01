<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/include-taglib.jspf"%>



<div class="header"> 
	<h1 class="page-header">
		<small>Board</small>
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
<%-- 				<tr>
					<th>구분</th>
					<td>${bbsVO.bid }</td>
				</tr> --%>
				<tr>
				<!-- ck에디터 들어와야함  -->
				</tr>
				
				<tr>
					<th>논문명</th>
					<td>${board.title }</td>
				</tr>
				
				<tr>
					<th>주저자</th>
					<td>${board.writer }</td>
				</tr>
				
				
				<tr>
					<th>요약내용(초록)</th>
					<td style=" line-height: 1.5em">${board.content }</td>
				</tr>
				 <tr>
					<th>표지 파일</th>
					<td>
						<ul class="list-unstyled">
							<c:forEach var="item" items="${board.fFileList }">
								<li class="mb-5">
									<a class="bold" onclick="fnFileDown('${item.fileNoAES}')">${item.fileName }</a> &nbsp; 
									[${item.fileSizeMB } M]
								</li>
	                    	</c:forEach>
						</ul>
					</td>
				</tr> 
				
			</table>
			
			<div class="form-group">
				<div class="col-sm-12 text-center">
                       <input type="button" class="btn btn-success" value="수정" onclick="goForm(${board.boardNo})"> 
                       <input type="button" class="btn btn-danger" value="삭제" onclick="del(${board.boardNo})"> 
                       <input type="button" class="btn btn-default" value="목록으로" onclick="goList();"> 
				</div>
			</div>
				
		</div>
	</div>
</div>


<script>
$(function(){
	activeMenu('/admin/board/list');
});

function goList() {
	var params = fnGetPrevParmas("");
	fnRedirect("./list");
}


function goForm(boardNo){
	location.href='./form?boardNo='+boardNo+'&'+window.location.search.substring(1);
}

function del(boardNo) {
	
	if(!confirm("삭제하시겠습니까?")) return;
	
	var params = {
		"boardNo": boardNo
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


