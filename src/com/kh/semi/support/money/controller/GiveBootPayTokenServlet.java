//package com.kh.semi.support.money.controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class GiveBootPayTokenServlet
// */
//@WebServlet("/billing")
//public class GiveBootPayTokenServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//		BootpayApi api = new BootpayApi(
//		        "[ REST용 Application ID ]",
//		        "[ Project의 Private Key ( 보안 문제상 예제에 표기하지 않습니다. 부트페이 관리자에서 확인해주세요. ) ]"
//		);
//		api.getAccessToken();
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
