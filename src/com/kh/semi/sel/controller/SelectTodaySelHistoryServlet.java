package com.kh.semi.sel.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.sel.model.service.SelSitService;

@WebServlet("/selectDday.sel")
public class SelectTodaySelHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HashMap<String, Object> list = new SelSitService().selectTodaySelHistory();

		System.out.println("입소상담 : " + list.get("entrance"));
		System.out.println("분양상담 : " + list.get("parcelout"));

		if(list != null) {
			String page = "views/admin/1_admin/4_scheduleManagement.jsp";
			request.setAttribute("entrance", list.get("entrance"));
			request.setAttribute("parcelout", list.get("parcelout"));
			request.getRequestDispatcher(page).forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
