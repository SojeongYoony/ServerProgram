package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public interface MemberService {
// 6번
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
