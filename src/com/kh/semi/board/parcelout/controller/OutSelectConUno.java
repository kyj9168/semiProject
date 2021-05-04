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
import com.kh.semi.board.parcelout.model.vo.PageInfo;

@WebServlet("/outSelect.po")
public class OutSelectConUno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int number = 1;

		String outselect = request.getParameter("outselect");
		String selectinput = null;

		selectinput = request.getParameter("selectinput");

		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;

		String currentPage1 = null;
		String[] currentPage2 = null;
		int currentPage3 = 0;
		String currentPage4 = null;
		int listCount = 0;

	if(request.getParameter("currentPage1") == null) {
		if (outselect.equals("NICK_NM")) {
			number = 2;
		} else {
			number = 1;
		}
	}

		currentPage3 = 1;
		if (request.getParameter("currentPage1") != null) {

			currentPage1 = request.getParameter("currentPage1");
			currentPage2 = currentPage1.split(",");

			currentPage3 = Integer.parseInt(currentPage2[0]);
			currentPage4 = currentPage2[1];
			selectinput = currentPage2[2];

			System.out.println("currentPage4 : " + currentPage4);

			if (!currentPage4.equals("NICK_NM")) {
				number = 1;
				listCount = new UserBoardService().getListoutCount3(selectinput);


			} else {
				number = 2;
				listCount = new UserBoardService().getListoutCount2(selectinput);
			}
			if (currentPage4.equals("NICK_NM")) {
				listCount = new UserBoardService().getListoutCount2(selectinput);
				number = 2;
			} else {
				number = 1;
				listCount = new UserBoardService().getListoutCount3(selectinput);
			}

		}

		currentPage = 1;

		if (request.getParameter("currentPage") != null) {

			currentPage = Integer.parseInt(request.getParameter("currentPage"));

		}

		limit = 5;



		if(outselect != null) {

			if(outselect.equals("NICK_NM")) {

				listCount = new UserBoardService().getListoutCount2(selectinput);

			}else {
				listCount = new UserBoardService().getListoutCount3(selectinput);
			}
		}



		maxPage = (int) ((double) listCount / limit + 0.8);

		startPage = ((int) ((double) currentPage / limit + 0.8) - 1) * 5 + 1;

		endPage = startPage + 5 - 1;

		if (maxPage < endPage) {
			endPage = maxPage;
		}

		PageInfo pi = null;
		if (request.getParameter("currentPage1") != null) {

			pi = new PageInfo(currentPage3, listCount, limit, maxPage, startPage, endPage);

		} else {

			pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

		}

		ArrayList<HashMap<String, Object>> filelist = new UserBoardService().outselectConUno(outselect, selectinput,
				currentPage4, currentPage3, limit);

		ArrayList<HashMap<String, Object>> filelist2 = new UserBoardService().selectOutList2(1, 5);

		String page = "";
		if (filelist != null) {
			page = "views/member/3_parcelout/2_reviewParcelout/1_main.jsp";
			request.setAttribute("filelist", filelist);
			request.setAttribute("filelist2", filelist2);
			request.setAttribute("pi", pi);
			request.setAttribute("PagingSelect", number);
			request.setAttribute("selectinput", selectinput);

		}
		request.getRequestDispatcher(page).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
