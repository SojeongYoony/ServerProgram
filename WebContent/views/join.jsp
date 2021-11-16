<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join form</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<script>
$(document).ready(function(){
	$("#fo").on('submit', function(event){
		if($('#id').val() == '') {
			event.preventDefault();
			alert('ID 입력 필수');
			$('#id').focus();
			return false;
		}
		if($('#name').val() == '') {
			event.preventDefault();
			alert('name 입력 필수');
			$('#name').focus();
			return false;
		}
		return true;
	})
	
})

</script>

<style>
	span {
		display: inline-block;
		width: 100px;
	}
</style>

</head>
<body>

	<div id="wrap">
	<h2>회원 가입 폼</h2>
	<form id="fo" action="/ServerProgram/join.do" method="post">
		<div>
		<span>아이디</span><input type="text" name="id" id="id">
		</div>
		<div>
		<span>이름</span><input type="text" name="name" id="name">
		</div>
		<input type="hidden" name="grade" value="bronze">
		<input type="hidden" name="point" value="1000">

		
		
		<button>회원가입</button> <a href="/ServerProgram/loginPage.do">돌아가기</a>
	</form>
	</div>
	

</body>
</html>