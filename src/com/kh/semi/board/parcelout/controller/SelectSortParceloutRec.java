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


@WebServlet("/SelectSort.re")
public class SelectSortParceloutRec extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String data = request.getParameter("data");

		System.out.println("에이작스 실행시 값 : " + data);

		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;


		currentPage = 1;


		if(request.getParameter("data") != null) {

			currentPage = Integer.parseInt(request.getParameter("data"));



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



				HashMap<String, Object> hmap = new HashMap<String, Object>();

				hmap.put("CurrentPage", pi.getCurrentPage());
				hmap.put("getListCount", pi.getListCount());
				hmap.put("limit", pi.getLimit());
				hmap.put("maxPage", pi.getMaxPage());
				hmap.put("startPage", pi.getStartPage());
				hmap.put("endPage", pi.getEndPage());

			ArrayList<HashMap<String,Object>> filelist = new UserBoardService().selectOutList3(currentPage,limit);

			//ArrayList<HashMap<String,Object>> filelist2 = new UserBoardService().selectOutList2(1,5);

			filelist.add(hmap);



				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				new Gson().toJson(filelist,response.getWriter());
			//	new Gson().toJson(pi, response.getWriter());


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
