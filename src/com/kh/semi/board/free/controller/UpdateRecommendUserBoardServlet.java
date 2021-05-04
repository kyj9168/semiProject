package com.kh.semi.board.free.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.board.free.model.service.UserBoardService;
import com.kh.semi.board.missing.model.service.MissingService;


/**
 * Servlet implementation class UpdateRecommendUserBoard
 */
@WebServlet("/updateRec.ub")
public class UpdateRecommendUserBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRecommendUserBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int thisBoardNo = Integer.parseInt(request.getParameter("thisBoardNo"));
		int nowLoginUser = Integer.parseInt(request.getParameter("nowLoginUser"));

		System.out.println("추천할 게시물 번호"+thisBoardNo);
		System.out.println("현재 로그인유저"+nowLoginUser);
		
			int result =  new UserBoardService().uprecommendUserBoard(thisBoardNo, nowLoginUser);
		
			System.out.println("insert 추천 결과: "  + result);
			
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(result, response.getWriter());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
