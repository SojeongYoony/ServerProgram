<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Member List</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	
	<div>
		<a href="/ServerProgram/loginPage.do">로그인하러 가기</a>
	</div>
	<hr>
	<h1>회원 목록</h1>
	<table border="1">
		<thead>
			<tr>
				<td>회원번호</td>				
				<td>아이디</td>				
				<td>이름</td>				
				<td>등급</td>				
				<td>포인트</td>				
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="5">게시물이 없습니다</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="members" items="${list}">
					<tr>
						<td>${members.no}</td>
						<td>${members.id}</td>
						<td>${members.name}</td>
						<td>${members.grade}</td>
						<td>${members.point}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>