package com.kh.semi.entrance.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.entrance.model.service.EntranceService;

@WebServlet("/noEntrance.ent")
public class NoEntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int entAppNo = Integer.parseInt(request.getParameter("entAppNo"));
		String reason = request.getParameter("result");

		int result = new EntranceService().noEntrance(entAppNo, reason);

		if(result > 0) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(result, response.getWriter());
		}else {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
