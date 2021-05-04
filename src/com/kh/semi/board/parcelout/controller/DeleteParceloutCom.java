package com.kh.semi.board.parcelout.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.parcelout.model.service.UserBoardService;
import com.kh.semi.board.parcelout.model.vo.Coment;


@WebServlet("/DeletePa.cm")
public class DeleteParceloutCom extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		int uNo = Integer.parseInt(request.getParameter("uNo"));



		Coment cm = new Coment();

		cm.setConNo(cNo);


		int result = new UserBoardService().deletcom(cm);

		String page = "";
		if(result > 0) {
			page = "selectParceloutOne.tn?num=" + bNo + "&uNo=" + uNo;
		}
		request.getRequestDispatcher(page).forward(request, response);





	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
