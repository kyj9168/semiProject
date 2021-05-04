package com.kh.semi.support.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.support.product.model.service.ProductSupService;
import com.kh.semi.support.product.model.vo.ProductSup;

@WebServlet("/insertsup.on")
public class InsertProductSupportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String product = request.getParameter("product");
		String detailPro = request.getParameter("detailPro");

		ProductSup ps = new ProductSup();
		ps.setCtgCd(product);
		ps.setPdNm(detailPro);
		ps.setUserNo(userNo);

		int result = new ProductSupService().insertMoneySupApp(ps);

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
