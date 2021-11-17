package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class MemberListService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDAO dao = MemberDAO.getInstance();
		request.setAttribute("list", dao.selectAllMember());
		
		
		return new ModelAndView("views/list.jsp", false);
	}

}
