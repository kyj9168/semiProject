package com.kh.semi.board.free.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.semi.board.free.model.service.UserBoardService;

import com.kh.semi.board.free.model.vo.PageInfoFreeBoard;
import com.kh.semi.board.free.model.vo.UserBoard;

/**
 * Servlet implementation class SelectBoardListServlet
 */
@WebServlet("/selectList.bo")
public class SelectBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징처리 전
		//ArrayList<UserBoard> list = new UserBoardService().selectList();
		ArrayList<UserBoard> best = new UserBoardService().selectListBest();
		//페이징처리 후
		int currentPage;		//현재 페이지를 표시할 변수
		int limit;				//한 페이지에 보여질 게시물 수
		int maxPage;			//전체 페이지에서 가장 마지막 페이지
		int startPage;			//한 번에 표시될 페이징 버튼이 시작할 번호
		int endPage;			//한 번에 표시될 페이징 버튼이 끝나는 번호
		
		//게시판은 1페이지부터 시작함
		currentPage = 1;
		String category = request.getParameter("category");
		String what = request.getParameter("what");
		String search = request.getParameter("search");
		String alignment = request.getParameter("alignment");
		System.out.println(category);
		System.out.println(search);
		System.out.println(what);
		System.out.println(alignment);
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//한 페이지에 보여질 목록 갯수
		
		limit = 10;
		
		//전체 목록 갯수를 리턴받음
		int listCount = new UserBoardService().getListCount(category, what, search, alignment);
		
	
		
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
		
		PageInfoFreeBoard pi = new PageInfoFreeBoard(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<UserBoard> list = new UserBoardService().selectList(currentPage, limit, category, what, search, alignment);
		 
		
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("best", best);
		request.setAttribute("category", category);
		request.setAttribute("search", search);
		request.setAttribute("what", what);
		request.setAttribute("alignment", alignment);
		
		request.getRequestDispatcher("views/member/5_freeBoard/1_freeBoard/1_main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}





















