package com.kh.semi.support.money.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.support.money.model.service.MoneySupService;

@WebServlet("/insertmoney.mo")
public class InsertMoneySupportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int monSupNo = Integer.parseInt(request.getParameter("monSupNo"));

		System.out.println("악!" + monSupNo);

		int result = new MoneySupService().insertMoney(monSupNo);

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
