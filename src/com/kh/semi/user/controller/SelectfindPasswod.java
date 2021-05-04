package com.kh.semi.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.user.model.service.UserService;
import com.kh.semi.user.model.vo.User;


@WebServlet("/SelectfindPasswod.sp")
public class SelectfindPasswod extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					String userNm = request.getParameter("userNm");
					String userId = request.getParameter("userId");
					String email = request.getParameter("email");

					User us = new User();

					us.setUserNm(userNm);
					us.setUserId(userId);
					us.setEmail(email);

					int result = new UserService().selectfindpwd(us);

					String page = "";


					if(result > 0) {
						page = "views/member/7_member/1_login/6_findpwd_1.jsp";
						request.setAttribute("us", us);

					}else {
						page = "views/member/7_member/1_login/6_findpwd_1.jsp";
						request.setAttribute("msg", "정보가 없습니다 확인후 다시 입력해주세요 .");

					}
					request.getRequestDispatcher(page).forward(request, response);


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
