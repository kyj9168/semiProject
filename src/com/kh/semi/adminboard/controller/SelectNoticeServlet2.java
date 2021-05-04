package com.kh.semi.adminboard.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.adminboard.model.service.AdminBoardService;
import com.kh.semi.adminboard.model.vo.AdminBoard;

/**
 * Servlet implementation class SelectNoticeServlet2
 */
@WebServlet("/selectNotice.no")
public class SelectNoticeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectNoticeServlet2() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		System.out.println(num);
		
		HashMap<String, Object> ab = new AdminBoardService().selectOne(num);
		
		System.out.println("ab : " + ab);
		
		String page = "";
		
		if(ab != null) {
			page = "views/member/1_introduce/2_notice/4_update.jsp";
			request.setAttribute("ab", ab);
		}else {
			/*page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 수정을 상세보기실패!");*/
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
