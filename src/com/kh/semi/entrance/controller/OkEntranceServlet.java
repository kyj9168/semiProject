package com.kh.semi.entrance.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.entrance.model.service.EntranceService;

/**
 * Servlet implementation class OkEntranceServlet
 */
@WebServlet("/okEntrance.ent")
public class OkEntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int entAppNo = Integer.parseInt(request.getParameter("entAppNo"));

		int result = new EntranceService().okEntrance(entAppNo);

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