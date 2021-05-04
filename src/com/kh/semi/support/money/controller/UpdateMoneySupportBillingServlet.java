package com.kh.semi.support.money.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.support.money.model.service.MoneySupService;

@WebServlet("/updateBill.mon")
public class UpdateMoneySupportBillingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String billing = request.getParameter("billing");
		int monSupNo = Integer.parseInt(request.getParameter("monSupNo"));
		String order_id = request.getParameter("order_id");

		int result = new MoneySupService().updateBillingkey(monSupNo, billing, order_id);

		if(result > 0) {
			System.out.println("서블릿 성공!");
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
