package com.kh.semi.board.free.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.board.free.model.service.UserBoardService;

/**
 * Servlet implementation class UpdateCommentUserBoardServlet
 */
@WebServlet("/updateCom.ub")
public class UpdateCommentUserBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommentUserBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int thisCommentNo = Integer.parseInt(request.getParameter("thisCommentNo"));
		int thisBoardNo = Integer.parseInt(request.getParameter("thisBoardNo"));
		String comcon = request.getParameter("comcon");
		System.out.println(thisCommentNo);
		System.out.println(comcon);
		
		int result =  new UserBoardService().updateCommentub(thisCommentNo, comcon);
	
		
		if(result > 0) {
			request.getRequestDispatcher("<%=request.getContextPath()%>/selectOne.bo?num=" + thisBoardNo).forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
