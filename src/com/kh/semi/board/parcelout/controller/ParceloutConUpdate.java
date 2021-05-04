package com.kh.semi.board.parcelout.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.parcelout.model.service.UserBoardService;
import com.kh.semi.board.parcelout.model.vo.UserBoard;




@WebServlet("/ParceloutConUpdate.po")
public class ParceloutConUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));
		String imgname = request.getParameter("imgname");


		UserBoard ub = new UserBoardService().selectmodified(num);


		String page = "";
		if(ub != null) {
			page = "views/member/3_parcelout/2_reviewParcelout/4_modified.jsp?imgname=" + imgname;
			request.setAttribute("ub", ub);
		}
		request.getRequestDispatcher(page).forward(request, response);




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
