<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>login succ</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

	<style>
		table {
			width: 500px;
			border-collapse: collapse;
			border-top: 2px solid gray;
			border-bottom: 2px solid gray;
		}
		tbody input {
			width: 80px;
		}
	table td {
			text-align: center;
			padding: 3px 5px;
			border-top: 1px solid gray;
			border-bottom: 1px solid gray;
		}
		
	</style>
	
<script>
$(document).ready(function(){
	$('#fo').on('submit', function(event){
		if( $('#name').val() == '') {
			alert('이름을 입력해주세요');
			event.preventDefault();
			$('#name').focus();
			return false;
		} else if ( isNaN($('#point').val()) || $('#point').val() <= 0 ) {
			alert('point는 정수입니다.');
			event.preventDefault();
			$('#point').focus();
			return false;
		} 
		return true;
	});
	
	$('#deleteBtn').on('click', function(){
		if(confirm('탈퇴하시겠습니까?') == false) {
			event.preventDefault();
			return false;
		} else {
			location.href='/ServerProgram/delete.do?no='+${list.no}
		}
		return true;
	})
});


</script>	
	
	
</head>
<body>
	<h2>회원 관리 시스템</h2>
	<a href="/ServerProgram/logout.do">로그아웃</a>
	<hr>
	<form id="fo" method="post" action="/ServerProgram/">
		<table>
			<thead>
				<tr>
					<td>아이디</td>
					<td>이름</td>
					<td>등급</td>
					<td>포인트</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<input type="hidden" name="no" value="${list.no}">
					</td>
					<td>${list.id}</td>
					<td><input name="name" id="name" value="${list.name}"></td>
					<td>${list.grade}</td>
					<td><input name="point" id="point" value="${list.point}"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
						<input type="submit" value="수정하기">
						<input type="button" value="탈퇴하기" id="deleteBtn">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>