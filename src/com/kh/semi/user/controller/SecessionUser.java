package com.kh.semi.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.user.model.service.UserService;

/**
 * Servlet implementation class SecessionPwd
 */
@WebServlet("/secession.user")
public class SecessionUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecessionUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = request.getParameter("password");
		String userId = request.getParameter("userId");
		
		System.out.println("회원탈퇴시 입력한 비밀번호 : "+password);
		
		int result = new UserService().pwCheck(password,userId);
		
		String view = "/sixDestiny/views/member/7_member/3_mypage/2_secession.jsp";
		
		
		if(result>0) {
			
			response.sendRedirect(view);
			
		}
		else {
			request.setAttribute("msg","비밀번호가 다릅니다");
			request.getRequestDispatcher("views/member/7_member/3_mypage/10_secessionPwd.jsp").forward(request, response);
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
