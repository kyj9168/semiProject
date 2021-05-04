package com.kh.semi.board.missing.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.board.missing.model.service.MissingService;
import com.kh.semi.board.missing.model.vo.Comment;

/**
 * Servlet implementation class CommentChange2
 */
@WebServlet("/CommentChange2")
public class CommentChange2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentChange2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cNo = Integer.parseInt( request.getParameter("cNo"));
		  String con2=request.getParameter("comment");
			int bNo = Integer.parseInt( request.getParameter("bNo"));
		
		
			System.out.println("내용쓰"+con2);

			Comment cm = new Comment();
			cm.setConNo(cNo);
			cm.setComment(con2);
			ArrayList<Comment> list = new MissingService().changeCo(cNo,con2,bNo);
			System.out.println("호출한 리스트 : " + list);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(list, response.getWriter());




	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
