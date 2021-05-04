package com.kh.semi.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.user.model.service.UserService;
import com.kh.semi.user.model.vo.User;

/**
 * Servlet implementation class KakaoLoginServelt
 */
@WebServlet("/kakaosignup")
public class KakaoSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakaoSignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//필수정보입력
		String userNm = request.getParameter("userName");	//카카오정보
		String userId = request.getParameter("userId");		//카카오정보
		String NickNm = request.getParameter("userNickName");
		String email = request.getParameter("email");		//카카오정보
		
		//추가정보입력
		String userHb = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String dogYn = request.getParameter("dogYn");
		String rtcd = request.getParameter("rtcd");

		String addresslist = address + " " + address2;

		java.sql.Date day = null;

		if(!userHb.equals("")) {

			day =java.sql.Date.valueOf(userHb);

		}else {
			day = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
		}
		
		User ur = new User();
		
		ur.setUserNm(userNm);
		ur.setUserId(userId);
		ur.setNickNm(NickNm);
		ur.setEmail(email);
		ur.setUserHb(day);
		ur.setGender(gender);
		ur.setAddress(addresslist);
		ur.setDogYn(dogYn);
		ur.setRtCd(rtcd);
		
		int result = new UserService().kakaoSignup(ur);
		
		if(result > 0) {

			response.sendRedirect("/sixDestiny/");
		}else {

			request.getRequestDispatcher("/sixDestiny/").forward(request, response);
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
