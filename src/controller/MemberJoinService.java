package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;
import service.MemberService;

public class MemberJoinService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String grade = request.getParameter("grade");
		Long point = Long.parseLong(request.getParameter("point"));
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setName(name);
		memberDTO.setGrade(grade);
		memberDTO.setPoint(point);
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		int result = memberDAO.insertMember(memberDTO);
		
		PrintWriter out = null;
			out = response.getWriter();
			if(result > 0) {
				out.println("<script>");
				out.println("location.href='/ServerProgram/joinSuccPage.do';");
				out.println("</script>");
				out.close();	
			} else {
				out.println("<script>");
				out.println("alert('가입실패')");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
		return null;
	}

}
