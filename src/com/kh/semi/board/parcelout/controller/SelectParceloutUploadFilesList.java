package com.kh.semi.board.parcelout.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.board.parcelout.model.service.UserBoardService;
import com.kh.semi.board.parcelout.model.vo.PageInfo;




@WebServlet("/selectOutList.tn")
public class SelectParceloutUploadFilesList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ajax = request.getParameter("ajax");


		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;


		currentPage = 1;


		if(request.getParameter("currentPage") != null) {

			currentPage = Integer.parseInt(request.getParameter("currentPage"));



		}


				limit = 5;


				int listCount = new UserBoardService().getListoutCount();




				maxPage = (int) ((double) listCount / limit + 0.8) ;


				startPage = ((int) ((double) currentPage / limit + 0.8) - 1) * 5 + 1;



				endPage = startPage + 5 -1 ;

				if(maxPage < endPage) {
					endPage = maxPage;
				}

				PageInfo pi = new PageInfo(currentPage, listCount , limit , maxPage, startPage, endPage);



				ArrayList list = new UserBoardService().selectRec10();



			ArrayList<HashMap<String,Object>> filelist = new UserBoardService().selectOutList(currentPage,limit);

			ArrayList<HashMap<String,Object>> filelist2 = new UserBoardService().selectOutList2(1,5);

			String page = "";
			String page2 = "";


			if(ajax == null) {
			if(filelist != null) {

				page = "views/member/3_parcelout/2_reviewParcelout/1_main.jsp";
				request.setAttribute("filelist", filelist);
				request.setAttribute("filelist2", filelist2);
				request.setAttribute("pi", pi);
				request.setAttribute("PagingSelect", 0);


			}
			request.getRequestDispatcher(page).forward(request, response);
			}else {
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				new Gson().toJson(filelist,response.getWriter());
			}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
