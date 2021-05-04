package com.kh.semi.board.parcelout.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.board.parcelout.model.service.UserBoardService;
import com.kh.semi.board.parcelout.model.vo.Coment;


@WebServlet("/UpdateComment.uc")
public class UpdateComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cNo = Integer.parseInt(request.getParameter("cNo"));
		String comment = request.getParameter("comment");

		Coment cm = new Coment();

		cm.setConNo(cNo);
		cm.setComent(comment);

		int result = new UserBoardService().updateComment(cm);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(comment , response.getWriter());





	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
