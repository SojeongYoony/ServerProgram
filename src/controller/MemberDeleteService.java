package controller;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import service.MemberService;

public class MemberDeleteService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Optional<String> optNo = Optional.ofNullable(request.getParameter("no"));
		Long no = Long.parseLong(optNo.orElse("0"));
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.deleteMember(no);

		PrintWriter out = response.getWriter();
		
		if (result > 0) {
			out.println("<script>");
			out.println("location.href='/ServerProgram/deletePage.do';");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('삭제 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		return null;
	}

}
