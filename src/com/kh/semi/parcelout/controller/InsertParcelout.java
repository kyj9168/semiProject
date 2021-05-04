package com.kh.semi.parcelout.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.parcelout.model.service.ParcelOutService;
import com.kh.semi.parcelout.model.vo.Application;
import com.kh.semi.user.model.vo.User;


@WebServlet("/Insert.po")
public class InsertParcelout extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String applic1 = request.getParameter("applic1");
			String applic2 = request.getParameter("applic2");
			String applic3 = request.getParameter("applic3");
			String applic4 = request.getParameter("applic4");
			String applic5 = request.getParameter("applic5");
			String applic6 = request.getParameter("applic6");
			String applic7 = request.getParameter("applic7");
			String applic8 = request.getParameter("applic8");
			String applic9 = request.getParameter("applic9");
			String applic10 = request.getParameter("applic10");
			String applic11 = request.getParameter("applic11");
			String applic12 = request.getParameter("applic12");
			String applic13 = request.getParameter("applic13");
			String applic14 = request.getParameter("applic14");
			String applic15 = request.getParameter("applic15");
			String applic16 = request.getParameter("applic16");
			String applic17 = request.getParameter("applic17");
			String applic18 = request.getParameter("applic18");
			String applic19 = request.getParameter("applic19");
			String applic20 = request.getParameter("applic20");
			String applic21 = request.getParameter("applic21");
			String applic22 = request.getParameter("applic22");

			String applic66 = applic5 + "," + applic6;

			String[] str = applic21.split("/");
			String[] str2 = applic22.split("~");
			String[] str3 = str2[0].split(":");



			String str1 = str[2] + str[0] + str[1] + str3[0] ;


			System.out.println(str1);

			int userNo = Integer.parseInt(request.getParameter("userNo"));

			User us = new User();
			Application ap = null;

			us.setUserNo(userNo);
			System.out.println(str1);
			String[] applic = new String[19] ;
			applic[0] = applic1;
			applic[1] = applic2;
			applic[2] = applic3;
			applic[3] = applic4;
			applic[4] = applic66;
			applic[5] = applic7;
			applic[6] = applic8;
			applic[7] = applic9;
			applic[8] = applic10;
			applic[9] = applic11;
			applic[10] = applic12;
			applic[11] = applic13;
			applic[12] = applic14;
			applic[13] = applic15;
			applic[14] = applic16;
			applic[15] = applic17;
			applic[16] = applic18;
			applic[17] = applic19;
			applic[18] = applic20;


			ArrayList<Application> list = new ArrayList<Application>();



			for(int i = 0 ; i <= 18; i++) {
				ap = new Application();

				ap.setApplication(applic[i]);

				list.add(ap);

			}
			ap = new Application();
			ap.setDay(str1);

			System.out.println(list.size());


			int result = new ParcelOutService().insertApplication(list,us,ap);

			String page = "";
			String msg = "";
			if(result > 0) {
				msg = "신청이 완료 되었습니다. 검토후 연락 드리겠습니다 ^^";
				page = "index.jsp";
				request.setAttribute("msg", msg);
			}else {
				msg = "신청 중 오류가 발생했습니다. 다시 신청해주시기 바랍니다 .";
				page = "index.jsp";
				request.setAttribute("msg", msg);
			}

			request.getRequestDispatcher(page).forward(request, response);






	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
