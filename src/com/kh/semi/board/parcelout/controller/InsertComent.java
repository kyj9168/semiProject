package com.kh.semi.board.parcelout.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.board.parcelout.model.service.UserBoardService;
import com.kh.semi.board.parcelout.model.vo.Coment;

@WebServlet("/Insert.coment")
public class InsertComent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String coment = request.getParameter("coment");
			int bNo = Integer.parseInt(request.getParameter("bNo"));
			int uNo = Integer.parseInt(request.getParameter("uNo"));

			Coment cm = new Coment();

			cm.setbNo(bNo);
			cm.setComent(coment);
			cm.setuNo(uNo);

			ArrayList<Coment> list = new UserBoardService().coment(cm);

			System.out.println("list 값 : " + list);


			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(list, response.getWriter());


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
