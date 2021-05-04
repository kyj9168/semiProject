package com.kh.semi.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.kh.semi.user.model.service.UserService;
import com.kh.semi.user.model.vo.PageInfo;
import com.kh.semi.user.model.vo.User;

/**
 * Servlet implementation class UserManageServlet
 */
@WebServlet("/userManage")
public class UserManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
	int listCount = new UserService().getListCount();
	
	System.out.println("listCount : " + listCount);
	
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
	
	ArrayList<User> list = new UserService().selectList(currentPage, limit);
	
	//신고받은 횟수
	ArrayList<Integer> reportC = new UserService().reportCount(list);
	
	
	
	String page = "";

	if(list!=null) {
		page = "views/admin/1_admin/1_userManagement.jsp";
		request.setAttribute("list", list);
	}else {
		page="views/common/bottom_Include.jsp";
		request.setAttribute("msg", "실패");
	}
	request.setAttribute("pi", pi);
	request.setAttribute("list", list);
	request.setAttribute("reportC", reportC);

	request.getRequestDispatcher(page).forward(request, response);
	
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
