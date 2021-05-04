package com.kh.semi.support.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.support.model.service.SupportService;

/**
 * Servlet implementation class SelectUserBillingKeyServlet
 */
@WebServlet("/select.bill")
public class SelectUserBillingKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int monSupNo = Integer.parseInt(request.getParameter("monSupNo"));

		HashMap<String, String> result = new SupportService().selectUserBillingKey(monSupNo);

		System.out.println("회원 빌링키 : " + result);

		if(result != null) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(result, response.getWriter());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
