package com.kh.semi.user.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.user.model.dao.UserDao;
import com.kh.semi.user.model.service.UserService;
import com.kh.semi.user.model.vo.User;

@WebServlet("/update.user")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("loginUser");

		request.setAttribute("user", user);

		request.getRequestDispatcher("views/member/7_member/3_mypage/3_modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();

		String userId = request.getParameter("userId");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");

		Date userHb =java.sql.Date.valueOf(year+"-"+month+"-"+day);

		User ur = userService.getUser(userId);
		ur.setNickNm(request.getParameter("nickNm"));
		ur.setEmail(request.getParameter("email"));
		ur.setAddress(request.getParameter("address"));
		ur.setDogYn(request.getParameter("dogYn"));
		ur.setUserHb(userHb);

		int result = new UserService().modifyUser(ur);

		String page="";

		if(result>0) {
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", ur);

			response.sendRedirect("views/member/7_member/3_mypage/1_main.jsp");
		}
		else {
			page="views/member/1_login/1_main.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
