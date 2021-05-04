package com.kh.semi.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.user.model.service.UserService;
import com.kh.semi.user.model.vo.User;


@WebServlet("/SelectFindld.sf")
public class SelectFindld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String email = request.getParameter("email");

		System.out.println("userId = " + userId);
		System.out.println("email = " + email);

		User us = new UserService().selectfind(userId,email);
		System.out.println(us.getUserId());
		System.out.println(us.getUserNm());

		String page = "";


		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(us,response.getWriter());




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
