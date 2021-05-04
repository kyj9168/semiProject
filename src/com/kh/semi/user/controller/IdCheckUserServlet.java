package com.kh.semi.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.user.model.service.UserService;


@WebServlet("/idCheck.user")
public class IdCheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");

		System.out.println("입력받은 아이디 : " + userId);

		int result = new UserService().idCheck(userId);

		String msg = "";
		if(result > 0) {
			msg = "해당 아이디가 존재합니다!";
		}else {
			msg = "사용 가능 한 아이디 입니다!";
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(msg, response.getWriter());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
