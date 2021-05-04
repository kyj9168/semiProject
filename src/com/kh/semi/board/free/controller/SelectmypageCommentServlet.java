package com.kh.semi.board.free.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.board.free.model.service.UserBoardService;
import com.kh.semi.board.free.model.vo.Commentub;
import com.kh.semi.board.free.model.vo.PageInfoFreeBoard;
import com.kh.semi.board.free.model.vo.UserBoard;
import com.kh.semi.user.model.vo.User;

/**
 * Servlet implementation class SelectmypageCommentServlet
 */
@WebServlet("/mypageCom.bo")
public class SelectmypageCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectmypageCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
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
				int listCount = new UserBoardService().getmyComListCount(loginUser.getUserNo());
				
				System.out.println("listCount : " + listCount);
				
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
				
				ArrayList<Commentub> list = new UserBoardService().myComselectList(currentPage, limit, loginUser.getUserNo());
				
				request.setAttribute("pi", pi);
				request.setAttribute("list", list);
				
				
				request.getRequestDispatcher("views/member/7_member/3_mypage/9_commentHistory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
