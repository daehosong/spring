<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>상품 검색 결과</h3>
		<!-- 테이블 형태로 검색 결과 출력 : 학번, 성명, 학년  -->
		<!-- JSTL / EL  -->
		<table border="1">
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>제조회사</th>
			</tr>
			<c:forEach var="prd" items="${prdList }">
				<tr>
					<td>${prd.prdNo }</td>
					<td>${prd.prdName }</td>
					<td>${prd.prdCompany}</td>
				</tr>
			</c:forEach>
		</table>
		
</body>
</html>