package com.kh.semi.adminboard.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.adminboard.model.service.AdminBoardService;
import com.kh.semi.adminboard.model.vo.AdminUserBoard;
import com.kh.semi.adminboard.model.vo.PageInfo;




@WebServlet("/boardList.ad")
public class AdminBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		int listCount = new AdminBoardService().getListCountad();


		//총 페이지 수 계산
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

		ArrayList<AdminUserBoard> list = new AdminBoardService().selectListad(currentPage, limit);
		ArrayList<Integer> recCount = new AdminBoardService().recCount(list);


		int currentPage2;
		int limit2;
		int maxPage2;
		int startPage2;
		int endPage2;


		currentPage2 = 1;

		if(request.getParameter("currentPage2") != null) {
			currentPage2 = Integer.parseInt(request.getParameter("currentPage"));
		}


		limit2= 10;

		int listCount2 = new AdminBoardService().getListCountad2();


		maxPage2 = (int)((double)listCount2/ limit2 + 0.9);

		startPage2 = (((int)((double) currentPage2 / limit2 + 0.9)) - 1) * 10 + 1;


		endPage2 = startPage2 + 10 - 1;

		if(maxPage2 < endPage2) {
			endPage2 = maxPage2;
		}

		PageInfo pi2 = new PageInfo(currentPage2, listCount2, limit2, maxPage2, startPage2, endPage2);

		ArrayList<AdminUserBoard> list2 = new AdminBoardService().selectListad2(currentPage2, limit2);
		ArrayList<Integer> report = new AdminBoardService().reportCount(list2);


		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("recCount", recCount);
		request.setAttribute("pi2", pi2);
		request.setAttribute("list2", list2);
		request.setAttribute("report", report);


		request.getRequestDispatcher("views/admin/1_admin/5_boardManagement.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
