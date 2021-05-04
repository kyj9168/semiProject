package com.kh.semi.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.semi.user.model.service.UserService;
import com.kh.semi.user.model.vo.User;

/**
 * Servlet implementation class KakaoLoginServlet
 */
@WebServlet("/kakaologin")
public class KakaoLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public KakaoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		
		// 유저 정보 조회
		User loginUser = new UserService().getUser(userId);

		// 유저정보 있음 -> 메인페이지
		// 닉네임 
		if(loginUser != null && loginUser.getNickNm() != null && loginUser.getDogYn() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);

			Map<String, String> result = new HashMap<>();
			result.put("returnUrl", "/sixDestiny");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			new Gson().toJson(result, response.getWriter());
		}
		// 유저정보 없음 -> 추가정보 입력 페이지
		else {
			
			Map<String, String> result = new HashMap<>();
			result.put("userId", userId);		//userId
			result.put("email", email);			//email
			result.put("userName", userName);	//userName
			result.put("returnUrl", "/sixDestiny/views/member/7_member/2_signup/4_signupKakao.jsp");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			new Gson().toJson(result, response.getWriter());
		}
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
