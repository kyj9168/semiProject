package com.kh.semi.board.free.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.board.free.model.service.UserBoardService;
import com.kh.semi.board.free.model.vo.Recub;

/**
 * Servlet implementation class CheckHeartServlet
 */
@WebServlet("/checkHeart.ub")
public class CheckHeartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckHeartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("thisBoardNo"));
		int logUno = Integer.parseInt(request.getParameter("nowLoginUser"));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		if(logUno > 0) {
			Recub rec = new UserBoardService().selectRec(num,logUno);
			int heart = 0;
			if(rec==null) {
				heart = 1;
			}else {
				heart = 0;
			}
			map.put("heart", heart);
	
		}
		
		
		 int recCount = new UserBoardService().selectRecCount(num);
			
			
			
			request.setAttribute("recCount", recCount);

			
			
			
			map.put("recCount", recCount);

			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(map, response.getWriter());
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
