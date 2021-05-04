package com.kh.semi.board.parcelout.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.board.parcelout.model.service.UserBoardService;
import com.kh.semi.board.parcelout.model.vo.Rec;


@WebServlet("/DeleteRec.dr")
public class DeleteParceloutRec extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int uNo = Integer.parseInt(request.getParameter("uNo"));
		int bNo = Integer.parseInt(request.getParameter("bNo"));

		Rec re = new Rec();

		re.setbNo(bNo);
		re.setuNo(uNo);

		int[] result = new int[2];

		result[0] = new UserBoardService().deleteRec(re);
		result[1] = new UserBoardService().selectRecajax(re);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(result, response.getWriter());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
