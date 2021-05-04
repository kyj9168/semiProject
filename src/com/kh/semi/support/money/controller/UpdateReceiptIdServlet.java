package com.kh.semi.support.money.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.support.model.service.SupportService;

@WebServlet("/updateReceipt.id")
public class UpdateReceiptIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String receipt_id = request.getParameter("receipt_id");
		int monSupNo = Integer.parseInt(request.getParameter("monSupNo"));

		String eamil = new SupportService().updateRegualSupport(receipt_id, monSupNo);

		if(eamil != null) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(eamil, response.getWriter());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
