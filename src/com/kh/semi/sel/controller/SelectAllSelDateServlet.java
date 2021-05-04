package com.kh.semi.sel.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.sel.model.service.SelSitService;

@WebServlet("/selectSel.all")
public class SelectAllSelDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String day = request.getParameter("day");
		String month = request.getParameter("month");

		String day1 = null;

			if(day.length() == 43) {
				day1 = day.substring(23, 25);

			}else {
				String day2 = day.substring(23, 24);
				day1 = 0 + day2;
			}



		System.out.println("day"+day1);
		System.out.println("month : " + month);

		String result = 20190 + month + day1;

		System.out.println("결과" + result);

		HashMap<String, Object> list = new SelSitService().selectAllSelDate(result);

		String result2 = "entrance";

		result2 += list.get("entrance").toString();
		result2 += "/parcelout";
		result2 += list.get("parcelout").toString();

		System.out.println("캬캬컄 : " + result2);



		if(list != null) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(list, response.getWriter());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
