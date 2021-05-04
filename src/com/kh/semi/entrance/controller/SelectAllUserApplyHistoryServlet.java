package com.kh.semi.entrance.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.adminboard.model.vo.PageInfo;
import com.kh.semi.entrance.model.service.EntranceService;
import com.kh.semi.user.model.vo.User;

@WebServlet("/selectAllUser.app")
public class SelectAllUserApplyHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		int currentPage2;
		int limit2;
		int maxPage2;
		int startPage2;
		int endPage2;

		currentPage = 1;
		currentPage2 = 1;

		if(request.getParameter("currentPage") != null || request.getParameter("currentPage2") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			currentPage2 = Integer.parseInt(request.getParameter("currentPage2"));
		}

		limit = 5;
		limit2 = 5;

		int listCount = new EntranceService().getMyEntranceAllUserListCount();
		int listCount2 = new EntranceService().getMyParceloutAllUserListCount();

		//System.out.println("list Count : " + listCount);

		maxPage = (int)((double)listCount / limit + 0.8);
		maxPage2 = (int)((double)listCount2 / limit2 + 0.8);

		startPage = (((int)((double) currentPage / limit + 0.9)) - 1) * 10 + 1;
		startPage2 = (((int)((double) currentPage2 / limit2 + 0.9)) - 1) * 10 + 1;

		endPage = startPage + 10 - 1;
		endPage2 = startPage2 + 10 - 1;

		if(maxPage < endPage) {
			endPage = maxPage;
		}

		if(maxPage2 < endPage2) {
			endPage2 = maxPage2;
		}

		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		PageInfo pi2 = new PageInfo(currentPage2, listCount2, limit2, maxPage2, startPage2, endPage2);

		HashMap<String, Object> list = new EntranceService().selectAllUserApply(currentPage, currentPage2, limit, limit2);

		System.out.println("입소 : " + list.get("entranceList"));
		System.out.println("분양 : " + list.get("parceloutList"));

		if(list != null) {
			request.setAttribute("entranceList", list.get("entranceList"));
			request.setAttribute("parceloutList", list.get("parceloutList"));
			request.setAttribute("pi", pi);
			request.setAttribute("pi2", pi2);
		}else {
			System.out.println("오류났당");
		}

		request.getRequestDispatcher("views/admin/1_admin/2_applyManagement.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
