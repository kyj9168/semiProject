package com.kh.semi.user.controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.user.model.service.UserService;
import com.kh.semi.user.model.vo.User;

@WebServlet("/sign.user")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			String userNm = request.getParameter("userName");
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			String NickNm = request.getParameter("userNickName");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			String address2 = request.getParameter("address2");
			String dogYn = request.getParameter("dogYn");
			String userHb = request.getParameter("birthday");
			String rtcd = request.getParameter("rtcd");

			String addresslist = address + " " + address2;

			System.out.println(addresslist);
			System.out.println(dogYn);



			//SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");


			UserService us = new UserService();


			java.sql.Date day = null;

			if(!userHb.equals("")) {

				day =java.sql.Date.valueOf(userHb);

			}else {
				day = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
			}
			
			User ur = new User();

			ur.setAddress(addresslist);
			ur.setUserNm(userNm);
			ur.setUserId(userId);
			ur.setUserPwd(password);
			ur.setNickNm(NickNm);
			ur.setEmail(email);
			ur.setGender(gender);
			ur.setDogYn(dogYn);
			ur.setUserHb(day);
			ur.setRtCd(rtcd);


			int result = us.signupUser(ur);

			String msg = "";
			String page = "/sixDestiny/views/member/7_member/2_signup/3_signupHomepage.jsp";

			if(result > 0) {
				msg = "회원가입에 성공하셨습니다 !";

				response.sendRedirect("/sixDestiny/index.jsp");
			}else {
				msg = "회원가입에 실패 하셨습니다..";
				request.setAttribute("msg", msg);

				request.getRequestDispatcher(page).forward(request, response);
			}








	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
