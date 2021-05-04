package com.kh.semi.board.missing.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.board.missing.model.service.MissingService;

/**
 * Servlet implementation class MissingRecServlet
 */
@WebServlet("/missingrec.bo")
public class MissingRecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MissingRecServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int test = Integer.parseInt(request.getParameter("test"));
		int test2 = Integer.parseInt(request.getParameter("test2"));
		int result = Integer.parseInt(request.getParameter("result"));
		System.out.println("보트넘버"+test);
		System.out.println("resu;t넘버"+result);
		
		int num = 0;
		
		if(result==0) {
			int re =  new MissingService().re2(test, test2);
			num = 1;
		}else {
			
			int re=  new MissingService().re3(test, test2);
			num = 0;
		}
		
	
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(num, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
