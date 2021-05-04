package com.kh.semi.adminboard.controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Synthesizer;

import com.kh.semi.adminboard.model.service.AdminBoardService;
import com.kh.semi.adminboard.model.vo.AdminBoard;
import com.kh.semi.board.parcelout.model.vo.Attachment;

@WebServlet("/selectSup.his")
public class SelectSupportBoardMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GregorianCalendar today = new GregorianCalendar ( );
		int month = today.get ( today.MONTH ) + 1;

		int currentPage;		//현재 페이지를 표시할 변수
		int limit;				//한 페이지에 보여질 게시물 수
		int maxPage;			//전체 페이지에서 가장 마지막 페이지
		int startPage;			//한 번에 표시될 페이징 버튼이 시작할 번호
		int endPage;			//한 번에 표시될 페이징 버튼이 끝나는 번호

		currentPage = month;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		AdminBoard ab = new AdminBoardService().selectSupportList(currentPage);
		Attachment ac = new AdminBoardService().selectSupportAttachment(currentPage);

		String page = "";
		if(ab != null) {
			page = "views/member/6_support/4_history/1_main.jsp";
			request.setAttribute("ab", ab);
			request.setAttribute("ac", ac);
			request.setAttribute("currentPage", currentPage);
			System.out.println("보더  : " + ab);
			System.out.println("파일 : " + ac);
			System.out.println("월 : " + currentPage);
		}else {
			System.out.println("aaaaaa");
		}

		request.getRequestDispatcher(page).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
