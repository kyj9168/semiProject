package com.kh.semi.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.user.model.service.UserService;
import com.kh.semi.user.model.vo.User;

/**
 * Servlet implementation class UserSecessionServlet
 */
@WebServlet("/usersec")
public class UserSecessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSecessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//로그인하고있는새끼
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		//탈퇴 사유를 값을받기
		String leaveRsCd = request.getParameter("leaveRsCd");
		String check = request.getParameter("check");

		User u = new User();
		u.setLeaveRsCd(leaveRsCd);
	

		int result = new UserService().secessionUser(leaveRsCd, loginUser.getUserNo());

		
		response.sendRedirect("/sixDestiny/logout");
		
		

			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
