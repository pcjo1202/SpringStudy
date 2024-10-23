<%@page import="com.ssafy.model.dto.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	Dept dept = (Dept)request.getAttribute("dept");
%>
<body>
	<jsp:include page="/WEB-INF/views/common/menu.jsp"/>
	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">부서 조회</h2>

		</div>						
		<form method="post" action="<%=request.getContextPath() %>/dept/modify.do" class="row">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="deptno">부서번호</label></th>
						<td><input type="text" name="deptNo" id="deptno" 
									value="<%=dept.getDeptno() %>" 
									readonly="readonly"/></td>
					</tr>
					<tr>
						<th><label for="dname">부서이름</label></th>
						<td><input type="text" name="dname" id="dname" 
							value="<%=dept.getDname()%>"/></td>
					</tr>
					<tr>
						<th><label for="loc">지역</label></th>
						<td><input type="text" name="loc" id="loc" 
								value="<%=dept.getLoc() %>" /></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="submit" value="수정"/>
							<input type="submit" value="삭제" 
								formaction="<%=request.getContextPath()%>/dept/remove.do"/>
							<input type="reset" value="취소"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>





