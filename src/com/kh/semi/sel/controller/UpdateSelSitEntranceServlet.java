package com.kh.semi.sel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.sel.model.service.SelSitService;

@WebServlet("/updatesit.selent")
public class UpdateSelSitEntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int selNo = Integer.parseInt(request.getParameter("selNo"));
		String result = request.getParameter("result");

		System.out.println("상담내역변경 내용  : " + result);

		int num = new SelSitService().updateSelsitEntrance(selNo, result);

		if(num > 0) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(num, response.getWriter());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
