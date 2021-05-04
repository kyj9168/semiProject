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
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet("/CommentDeleteServlet")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cNo = Integer.parseInt( request.getParameter("cNo"));
		int bNo = Integer.parseInt( request.getParameter("bNo"));

		  /*
			int uu2 = Integer.parseInt( request.getParameter("uu"));
			
			String num= request.getParameter("num");
			String uu= request.getParameter("uu");
			*/
			String num= request.getParameter("num");
			String comment= request.getParameter("num");
/*			String page = "/mSelectOne.bo?num="+cNo;*/

			Comment cm = new Comment();
			cm.setConNo(cNo);
			cm.setbNo(bNo);
			ArrayList<Comment> list = new MissingService().commentdelete(cm);

		/*	int result = new MissingService().deletemissing(cNo);*/

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
