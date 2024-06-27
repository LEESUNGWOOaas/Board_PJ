<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<div class="header"> 
	<h1 class="page-header">
		 <small>관리자 관리</small>
	</h1>
</div>

<div id="page-inner"> 

	<div class="row mb-10 ">
		<div class="col-sm-12 text-right">

			 <a href="/admin/manager/form" class="btn btn-sm btn-primary">등록</a><br/>
		</div>
	</div>
	
	<div class="panel panel-default">
		
		<div class="panel-body">
			
			<form id="searchForm" action="list">
			<div class="row mb-10 ">
				<div class="col-sm-6 pt-10">
					전체 <span class="text-red" style="color:red">2</span>건
				</div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3">
					<div class="input-group">
						<div class="input-group-addon">
							<select name="searchType">						
								<option value="mamagerName">이름</option>						
							</select>
						</div>
						<span class="input-group-btn">
							<button type="submit" class="btn btn-primary">검색
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>
						</span>
					</div>
				
				</div>
			</div>
			</form>

			<div class="row">
				<div class="col-sm-12">

					<div class="table-responsive">
						<table class="table table-bordered table-hover text-center">
							<thead>
								<tr>
									<th width="10">번호</th>
									<th width="50">아이디</th>
									<th width="50">이름</th>
									<th width="100">생성일자</th>
									<th width="5">관리 </th>
								</tr>
							</thead>
							<tbody>
							<c:set var="rownum" value="${pageVO.rownum }"/>
								<c:forEach var="item" items="${managerList}">
								<tr>
									<td>${rownum}</td>
									<td>${item.managerId }</td>
									<td>${item.managerName }</td>
									<td><fmt:formatDate value="${item.insertDate }" pattern="yyyy-MM-dd"/></td>
									<td><input type="button" class="btn btn-xs btn-danger" value="삭제"
											onclick="del('${item.managerNo}')"></td></td>
								</tr>
								<c:set var="rownum" value="${rownum-1 }"/>
								</c:forEach>
							</tbody>
						</table>
					</div>
					
					
				</div>
			</div>
			
       
		</div>
	</div>
</div>

