package com.kh.semi.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.user.model.service.UserService;
import com.kh.semi.user.model.vo.User;


@WebServlet("/UpdateSign.user")
public class UpdateSign extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		User us = new User();

		us.setUserId(userId);
		us.setUserPwd(password);

		int result = new UserService().updatesign(us);

		String msg = "";
		String page = "index.jsp";
		if(result > 0) {
			msg = "성공적으로 변경 되었습니다. 다음부턴 잊어 버리지 마세요 ㅠㅠ";
			request.setAttribute("msg", msg);

		}else {
			msg = "변경이 실패 하셨습니다.. 다시 시도해주세요";
			request.setAttribute("msg", msg);
		}
		request.getRequestDispatcher(page).forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
