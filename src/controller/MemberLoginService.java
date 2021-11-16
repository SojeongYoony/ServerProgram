package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import service.MemberService;

public class MemberLoginService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.getParameter("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		return null;
	}

}
