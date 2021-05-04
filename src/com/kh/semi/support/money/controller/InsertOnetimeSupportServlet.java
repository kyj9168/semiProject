package com.kh.semi.support.money.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.support.money.model.service.MoneySupService;
import com.kh.semi.support.money.model.vo.MoneySup;


@WebServlet("/insertsup.one")
public class InsertOnetimeSupportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int money = Integer.parseInt(request.getParameter("money"));

		MoneySup ms = new MoneySup();
		ms.setUserNo(userNo);
		ms.setSupPc(money);
		ms.setSupKind("일회성");
		ms.setStatus("S");

		int result = new MoneySupService().insertMoneySupApp(ms);

		if(result > 0) {
			response.sendRedirect("views/member/6_support/success.jsp");
		}else {
			System.out.println("실패!");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
