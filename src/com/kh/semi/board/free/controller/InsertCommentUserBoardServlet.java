package com.kh.semi.board.free.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.board.free.model.service.UserBoardService;
import com.kh.semi.board.free.model.vo.Commentub;
import com.kh.semi.board.free.model.vo.UserBoard;

/**
 * Servlet implementation class CommentUserBoardServlet
 */
@WebServlet("/insertComment.ub")
public class InsertCommentUserBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCommentUserBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int thisBoardNo = Integer.parseInt(request.getParameter("thisBoardNo"));
		int nowLoginUser = Integer.parseInt(request.getParameter("nowLoginUser"));
		String comcon = request.getParameter("comcon");

		System.out.println("댓글쓸 게시판 넘버 : " + thisBoardNo);
		System.out.println("현재 로그인 유저번호 : " + nowLoginUser);
		System.out.println("댓글 내용 : " + comcon);
		
		Commentub comment = new Commentub();
		comment.setBoardNo(thisBoardNo);
		comment.setCommentCon(comcon);
		comment.setUserNo(nowLoginUser);

		int result = new UserBoardService().insertComment(comment);
		
	
		ArrayList<Commentub> commentList = new UserBoardService().selectListComment(thisBoardNo);
		System.out.println(commentList);
		HashMap<String,Object> hmap = new HashMap<String,Object>();
		
		hmap.put("result", result);
		hmap.put("commentList", commentList);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(hmap, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
