package com.kh.semi.board.missing.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.board.missing.model.service.MissingService;
import com.kh.semi.board.missing.model.vo.MissingPageInfo;

/**
 * Servlet implementation class ProOrderListServlet
 */
@WebServlet("/proorder.bo")
public class ProOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProOrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String val= request.getParameter("li");
		
	System.out.println("바바바바바바밥바바"+val);
	if(val.equals("서울시")||val.equals("인천시")||val.equals("대전시")||val.equals("울산시")||val.equals("부산시")||val.equals("경기도")||val.equals("강원도")||
			val.equals("경상북도")||val.equals("경상남도")||val.equals("전라북도")||val.equals("전라남도")||val.equals("충정북도")||val.equals("충정남도")||val.equals("세종시")||val.equals("제주도")) {
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
	int listCount = new MissingService().MissinggetListCount9(val);

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

	ArrayList<HashMap<String, Object>> list= new MissingService().MissngselectList9(currentPage,limit,val);

	String page = "";

	if(list != null) {
		System.out.println("들어오알ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ");
		page = "views/member/4_missing/2_protect/1_main.jsp";
		//request.setAttribute("list", list);
		//request.setAttribute("pi", pi);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(list, response.getWriter());
	}

	}
	
	
	
	
	if(val.equals("수컷")||val.equals("암컷")) {
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
	int listCount = new MissingService().MissinggetListCount11(val);

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

	ArrayList<HashMap<String, Object>> list= new MissingService().MissngselectList11(currentPage,limit,val);

	String page = "";

	if(list != null) {
		System.out.println("들어오알ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ");
		page = "views/member/4_missing/2_protect/1_main.jsp";
		//request.setAttribute("list", list);
		//request.setAttribute("pi", pi);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(list, response.getWriter());
	}

	}
	
	
	
	if(val.equals("최신순")||val.equals("오래된순")) {
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
	int listCount = new MissingService().MissinggetListCount();

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
	if(val.equals("최신순")) {
	ArrayList<HashMap<String, Object>> list= new MissingService().ProselectList(currentPage,limit);
	
	String page = "";

	if(list != null) {
		System.out.println("최신최신ㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ");
		System.out.println("들어오알ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ");
		page = "views/member/4_missing/1_fine/1_main.jsp";
		//request.setAttribute("list", list);
		//request.setAttribute("pi", pi);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(list, response.getWriter());
	
	}}else {
		ArrayList<HashMap<String, Object>> list= new MissingService().MissngselectList17(currentPage,limit);
		
		String page = "";


		if(list != null) {
			System.out.println("오래오래ㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐ");
			System.out.println("들어오알ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ");
			page = "views/member/4_missing/2_protect/1_main.jsp";
			//request.setAttribute("list", list);
			//request.setAttribute("pi", pi);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(list, response.getWriter());
			
		
		
	}}
	
	
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
