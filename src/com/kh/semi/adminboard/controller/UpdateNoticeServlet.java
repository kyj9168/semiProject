package com.kh.semi.adminboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.adminboard.model.service.AdminBoardService;
import com.kh.semi.adminboard.model.vo.AdminBoard;

/**
 * Servlet implementation class UpdateNoticeServlet
 */
@WebServlet("/update.no")
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		/*private String title;
		private String adBoardCon;*/
		String title = request.getParameter("title");
		String adBoardCon = request.getParameter("adBoardCon");
		System.out.println("title : " + title);
		System.out.println("adBoardCon : " + adBoardCon);
		int adBoardNo = Integer.parseInt(request.getParameter("adBoardNo"));
		
		
		AdminBoard ab = new AdminBoard();
		ab.setTitle(title);
		ab.setAdBoardCon(adBoardCon);
		ab.setAdBoardNo(adBoardNo);
		
		int result = new AdminBoardService().updateNotice(ab);
		
		String page = "";
	
		
		if(result>0) {
			/*response.sendRedirect("selectOne.no?num" + adBoardNo);*/
			/*request.getRequestDispatcher("selectOne.no?num=" + adBoardNo).forward(request, response);*/
			response.sendRedirect("/sixDestiny/select.no");
			/*request.getRequestDispatcher("views/member/1_introduce/2_notice/1_main.jsp").forward(request, response);*/
			
		}else {
			//request.getRequestDispatcher("views/member/1_introduce/2_notice/1_main.jsp").forward(request, response);;
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