<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">부서 목록</h2>
		</div>
		<div class="row mt-3">
			
				<form action="${root}/dept/search.do" method="post">
					<input type="text" name="dname" placeholder="부서명입력" value="${param.dname}"/> 
					<input type="submit" value="검색"/> 
				</form>
			
		</div>		
		<div class="row">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>부서번호</th>
						<th>부서이름</th>
					</tr>			
				</thead>
				<tbody>
	<c:choose>
		<c:when test="${not empty requestScope.depts}">
			<!-- 부서 있을때 -->
			<c:forEach var="dept" items="${depts}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${pageScope.dept.deptno }</td>
					<td><a href="${root}/dept/detail.do?deptNo=${dept.deptno}">${dept.dname }</a></td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<!-- 부서 없을때 -->
			<tr><td colspan="3">등록된 부서가 없습니다.</td></tr>		
		</c:otherwise>
	</c:choose>		
		</tbody>
	</table>
	</div>
	</div>
</body>
</html>












