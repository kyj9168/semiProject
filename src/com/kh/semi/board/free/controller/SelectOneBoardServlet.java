package com.kh.semi.board.free.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.semi.board.free.model.service.UserBoardService;
import com.kh.semi.board.free.model.vo.Recub;
import com.kh.semi.board.free.model.vo.UserBoard;
import com.kh.semi.board.free.model.vo.UserBoardAttachment;

/**
 * Servlet implementation class SelectOneNoticeServlet
 */
@WebServlet("/selectOne.bo")
public class SelectOneBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
	
		System.out.println("현재 글번호" + num);
		

		HashMap<String, Object> hmap = new UserBoardService().selectOne(num);
		
		
		UserBoard ub = (UserBoard) hmap.get("board");
		ArrayList<UserBoardAttachment> fileList = 
				(ArrayList<UserBoardAttachment>) hmap.get("attachment");
		
		String page = "";

		 int recCount = new UserBoardService().selectRecCount(num);
			
	
	
		if(hmap != null) {
			request.setAttribute("ub", ub);
			request.setAttribute("fileList", fileList);
			request.setAttribute("recCount", recCount);
	
			page = "views/member/5_freeBoard/1_freeBoard/3_read.jsp";
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "사진 게시판 상세보기 실패!");
		}
		
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












