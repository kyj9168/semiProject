package com.kh.semi.support.money.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.support.money.model.service.MoneySupService;
import com.kh.semi.support.money.model.vo.MoneySup;


/**
 * Servlet implementation class InsertRegularSupportServlet
 */
@WebServlet("/insertsup.re")
public class InsertRegularSupportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿 호출...");

		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int resultmoney = Integer.parseInt(request.getParameter("resultmoney"));

		MoneySup ms = new MoneySup();
		ms.setUserNo(userNo);
		ms.setSupPc(resultmoney);
		ms.setSupKind("정기");
		ms.setStatus("S");

		int result = new MoneySupService().insertMoneySupApp(ms);

		if(result > 0) {
			response.sendRedirect("views/member/6_support/success.jsp");
		}else {
			System.out.println("실패!");
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
