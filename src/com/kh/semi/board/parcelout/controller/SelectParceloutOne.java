package com.kh.semi.board.parcelout.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.parcelout.model.service.UserBoardService;
import com.kh.semi.board.parcelout.model.vo.Attachment;
import com.kh.semi.board.parcelout.model.vo.Coment;
import com.kh.semi.board.parcelout.model.vo.Rec;
import com.kh.semi.board.parcelout.model.vo.UserBoard;
import com.kh.semi.user.model.vo.User;


@WebServlet("/selectParceloutOne.tn")
public class SelectParceloutOne extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));

		int uNo = 0;



			if(!request.getParameter("uNo").equals("")) {

				uNo = Integer.parseInt(request.getParameter("uNo"));

			}





			HashMap<String,Object> hmap = new UserBoardService().selectParceloutOne(num,uNo);

			UserBoard ub = (UserBoard) hmap.get("ParceloutBoard");



			ArrayList<Attachment> filelist = (ArrayList<Attachment>) hmap.get("attachment");


			ArrayList<Coment> list = (ArrayList<Coment>) hmap.get("coment");

			ArrayList<Integer> list2 = (ArrayList<Integer>) hmap.get("Rec");

			ArrayList<Integer> list3 = (ArrayList<Integer>) hmap.get("selectRec");






			User us = (User) hmap.get("User");



			String page = "";

			if(hmap != null) {
				page = "views/member/3_parcelout/2_reviewParcelout/3_read.jsp";
				request.setAttribute("ParceloutBoard", ub);
				request.setAttribute("filelist", filelist);
				request.setAttribute("User", us);
				request.setAttribute("list3", list3);

				if(list2 != null) {

				request.setAttribute("list2", list2);

				}

				if(list != null) {

					if(list.size() > 0) {

						request.setAttribute("coment", list);

					}

				}

			}


			request.getRequestDispatcher(page).forward(request, response);





	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
