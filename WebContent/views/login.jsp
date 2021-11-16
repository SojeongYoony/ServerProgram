<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>



</head>
<body>
	
	<h3>회원 관리 프로그램</h3>
	
	<form id="fo" action="/ServerProgram/login.do" method="post">
	<div>
		<input type="text" name="id" id="id" placeholder="아이디">
	</div>
	<div>
		<input type="text" name="name" id="name" placeholder="이름">
	</div>
	<span>
		<button>로그인</button> 
	</span>
	<span>
		<a href="/ServerProgram/joinPage.do">회원가입</a>
	</span>
	</form>
	
<%--
<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String name = request.getParameter("name");
	
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setId(id);
	memberDTO.setName(name);
	
	MemberDTO loginUser = null;
	if(memberDTO.getId().equals(id)) {
		if(memberDTO.getName().equals(name)) {
			loginUser = new MemberDTO();
			loginUser.setId(id);
			loginUser.setName(name);
		}
	}
	
	if (loginUser != null) {
		session.setAttribute("loginUser", loginUser);
	}
	
	response.sendRedirect("/ServerProgram/loginPage.do");

%>
 --%>








</body>
</html>