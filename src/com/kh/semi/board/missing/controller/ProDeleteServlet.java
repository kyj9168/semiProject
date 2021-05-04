package com.kh.semi.board.missing.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.missing.model.service.MissingService;


/**
 * Servlet implementation class ProDeleteServlet
 */
@WebServlet("/proDelete.bo")
public class ProDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("왜안들어와씨발!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("넘ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ"+num);

		int result = new MissingService().deletemissing(num);

		if(result > 0) {
			response.sendRedirect("/sixDestiny/proListo.bo");
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
