package com.kh.semi.adminboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.adminboard.model.service.AdminBoardService;
import com.kh.semi.adminboard.model.vo.AdminBoard;
import com.kh.semi.adminboard.model.vo.PageInfo;

@WebServlet("/select.no")
public class SelectNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징처리 후
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
		int listCount = new AdminBoardService().getListCount();

		System.out.println("list Count : " + listCount);

		//총 페이지 수 계산
		//예를 들면, 목록수가 124개면 페이지수는 13페이지이다.
		maxPage = (int)((double)listCount / limit + 0.9);

		//현재 페이지에서 보여줄 시작 페이지 숫자
		//아래쪽에 페이지 수가 10개씩 보여지게 한다면
		//1, 11, 21, 31, .....
		startPage = (((int)((double) currentPage / limit + 0.9)) - 1) * 10 + 1;

		//목록 아래 쪽에 보여질 마지막 페이지 수
		endPage = startPage + 10 - 1;

		if(maxPage < endPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

		ArrayList<AdminBoard> list = new AdminBoardService().selectList(currentPage, limit);

		String page = "";

		System.out.println("공지객체  : " + list);

		if(list != null) {
			page = "views/member/1_introduce/2_notice/1_main.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		}else {
			/*page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 조회 실패!");*/
		}

		request.getRequestDispatcher(page).forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
