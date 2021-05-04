package com.kh.semi.adminboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.adminboard.model.service.AdminBoardService;
import com.kh.semi.adminboard.model.vo.AdminUserBoard;
import com.kh.semi.adminboard.model.vo.PageInfo;


@WebServlet("/AjaxBoard.ab")
public class SelectAjaxBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String data = request.getParameter("data");

			int currentPage;		//현재 페이지를 표시할 변수
			int limit;				//한 페이지에 보여질 게시물 수
			int maxPage;			//전체 페이지에서 가장 마지막 페이지
			int startPage;			//한 번에 표시될 페이징 버튼이 시작할 번호
			int endPage;			//한 번에 표시될 페이징 버튼이 끝나는 번호

			//게시판은 1페이지부터 시작함
			currentPage = 1;

			if(request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}

			//한 페이지에 보여질 목록 갯수

			limit = 10;

			//전체 목록 갯수를 리턴받음
			int listCount = 0;
			if(data != null) {
				if(data.equals("selectAll")) {

					listCount = new AdminBoardService().getListCountad();

				}else if(data.equals("selectfree")) {

					listCount = new AdminBoardService().getfreeCount();

				}else if(data.equals("selectparcelout")) {

					listCount = new AdminBoardService().getparceloutCount();

				}else if(data.equals("selectmissing")) {

					listCount = new AdminBoardService().getmssingCount();

				}else if(data.equals("selectmissing2")) {

					listCount = new AdminBoardService().getmssingCount2();

				}

			}

			System.out.println("listCount 게시판: " + listCount);

			//총 페이지 수 계산f
			//예를 들면, 목록 수가 124개이면 페이지 수는 13페이지이다.
			maxPage = (int)((double)listCount / limit + 0.9);

			//현재 페이지에서 보여줄 시작 페이지 숫자
			//아래쪽에 페이지 수가 10개씩 보여지게 한다면
			//1, 11, 21, 31, ....
			startPage = (((int)((double) currentPage / limit + 0.9)) - 1) * 10 + 1;

			//목록 아래 쪽에 보여질 마지막 페이지 수
			//10, 20, 30,...
			endPage = startPage + 10 - 1;

			if(maxPage < endPage) {
				endPage = maxPage;
			}

			PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

			HashMap<String,Object> hmap = new HashMap<String,Object>();

			ArrayList<AdminUserBoard> list = null;

			if(data.equals("selectAll")){

				list = new AdminBoardService().selectAll(currentPage , limit);

			}else if(data.equals("selectfree")) {

				list = new AdminBoardService().selectfree(currentPage , limit);

			}else if(data.equals("selectparcelout")) {

				list = new AdminBoardService().selectparcelout(currentPage,limit);

			}else if(data.equals("selectmissing")) {

				list = new AdminBoardService().selectmissing(currentPage,limit);

			}else if(data.equals("selectmissing2")) {

				list = new AdminBoardService().selectmissing2(currentPage, limit);
			}


			hmap.put("list", list);
			hmap.put("pi", pi);




			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(hmap,response.getWriter());




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
