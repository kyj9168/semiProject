package com.kh.semi.sel.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.sel.model.service.SelSitService;

@WebServlet("/selectMonth.all")
public class SelectMonthSelSitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int month = Integer.parseInt(request.getParameter("month"));
		String day = request.getParameter("days");

		String result = 20190 + month + day;

		HashMap<String, Object> list = new SelSitService().selectAllSelDate(result);

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
