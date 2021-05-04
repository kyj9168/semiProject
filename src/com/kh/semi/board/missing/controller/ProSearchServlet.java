package com.kh.semi.board.missing.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.missing.model.service.MissingService;
import com.kh.semi.board.missing.model.vo.MissingPageInfo;

/**
 * Servlet implementation class ProSearchServlet
 */
@WebServlet("/prosearch.bo")
public class ProSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String val= request.getParameter("searchVal");
		String cont=request.getParameter("search");
		System.out.println("서치바ㅏㅏㅏ"+val);
		System.out.println("내용쓰"+cont);
		
if(val.equals("전체")) {
		int currentPage;		//현재 페이지를 표시할 변수
		int limit;				//한 페이지에 보여질 게시물 수
		int maxPage;			//전체 페이지에서 가장 마지막 페이지
		int startPage;			//한 번에 표시될 페이징 버튼이 시작할 번호
		int endPage;			//한 번에 표시될 페이징 버튼이 끝나는 번호


		currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			System.out.println("들어오나 확인");
		}

		//한 페이지에 보여질 목록 갯수
		limit = 10;

		//전체 목록 갯수를 리턴받음
		int listCount = new MissingService().PgetListCount2(cont);

		System.out.println("listCount : " + listCount);

		//총 페이지 수 계산
		//예를 들면, 목록 수가 124개이면 페이지 수는 13페이지이다.
		maxPage = (int)((double)listCount / limit + 0.9);

		//현재 페이지에서 보여줄 시작 페이지 숫자
		//아래쪽에 페이지 수가 10개씩 보여지게 한다면
		//1, 11, 21, 31, ....

		startPage=(((int)((double)currentPage/limit+0.9))-1)*10+1;


		//목록 아래 쪽에 보여질 마지막 페이지 수
		endPage=startPage+10-1;
		if(maxPage<endPage) {

			endPage=maxPage;

		}

		MissingPageInfo pi= new MissingPageInfo(currentPage,listCount,limit,maxPage,startPage,endPage);

		ArrayList<HashMap<String, Object>> list= new MissingService().PselectList2(currentPage,limit,cont);

		String page = "";

		if(list != null) {
			page = "views/member/4_missing/2_protect/1_main.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		}

		request.getRequestDispatcher(page).forward(request, response);

}
if(val.equals("작성자")) {
	
	int currentPage;		//현재 페이지를 표시할 변수
	int limit;				//한 페이지에 보여질 게시물 수
	int maxPage;			//전체 페이지에서 가장 마지막 페이지
	int startPage;			//한 번에 표시될 페이징 버튼이 시작할 번호
	int endPage;			//한 번에 표시될 페이징 버튼이 끝나는 번호


	currentPage = 1;

	if(request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		System.out.println("들어오나 확인");
	}

	//한 페이지에 보여질 목록 갯수
	limit = 10;

	//전체 목록 갯수를 리턴받음
	int listCount = new MissingService().PgetListCount4(cont);

	System.out.println("listCount : " + listCount);

	//총 페이지 수 계산
	//예를 들면, 목록 수가 124개이면 페이지 수는 13페이지이다.
	maxPage = (int)((double)listCount / limit + 0.9);

	//현재 페이지에서 보여줄 시작 페이지 숫자
	//아래쪽에 페이지 수가 10개씩 보여지게 한다면
	//1, 11, 21, 31, ....

	startPage=(((int)((double)currentPage/limit+0.9))-1)*10+1;


	//목록 아래 쪽에 보여질 마지막 페이지 수
	endPage=startPage+10-1;
	if(maxPage<endPage) {

		endPage=maxPage;

	}

	MissingPageInfo pi= new MissingPageInfo(currentPage,listCount,limit,maxPage,startPage,endPage);

	ArrayList<HashMap<String, Object>> list= new MissingService().PselectList3(currentPage,limit,cont);

	String page = "";

	if(list != null) {
		page = "views/member/4_missing/2_protect/1_main.jsp";
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
	}

	request.getRequestDispatcher(page).forward(request, response);
	
}

if(val.equals("제목")) {
	int currentPage;		//현재 페이지를 표시할 변수
	int limit;				//한 페이지에 보여질 게시물 수
	int maxPage;			//전체 페이지에서 가장 마지막 페이지
	int startPage;			//한 번에 표시될 페이징 버튼이 시작할 번호
	int endPage;			//한 번에 표시될 페이징 버튼이 끝나는 번호


	currentPage = 1;

	if(request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		System.out.println("들어오나 확인");
	}

	//한 페이지에 보여질 목록 갯수
	limit = 10;

	//전체 목록 갯수를 리턴받음
	int listCount = new MissingService().PgetListCount5(cont);

	System.out.println("listCount : " + listCount);

	//총 페이지 수 계산
	//예를 들면, 목록 수가 124개이면 페이지 수는 13페이지이다.
	maxPage = (int)((double)listCount / limit + 0.9);

	//현재 페이지에서 보여줄 시작 페이지 숫자
	//아래쪽에 페이지 수가 10개씩 보여지게 한다면
	//1, 11, 21, 31, ....

	startPage=(((int)((double)currentPage/limit+0.9))-1)*10+1;


	//목록 아래 쪽에 보여질 마지막 페이지 수
	endPage=startPage+10-1;
	if(maxPage<endPage) {

		endPage=maxPage;

	}

	MissingPageInfo pi= new MissingPageInfo(currentPage,listCount,limit,maxPage,startPage,endPage);

	ArrayList<HashMap<String, Object>> list= new MissingService().PselectList4(currentPage,limit,cont);

	String page = "";

	if(list != null) {
		page = "views/member/4_missing/2_protect/1_main.jsp";
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
	}

	request.getRequestDispatcher(page).forward(request, response);	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}