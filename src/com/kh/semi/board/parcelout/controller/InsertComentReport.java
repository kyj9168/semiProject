package com.kh.semi.board.parcelout.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.parcelout.model.service.UserBoardService;
import com.kh.semi.board.parcelout.model.vo.Report;


@WebServlet("/comentReport.cp")
public class InsertComentReport extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String reason = request.getParameter("reason");
		int uNo = Integer.parseInt(request.getParameter("uNo")) ;
		int cNo = Integer.parseInt( request.getParameter("cNo"));
		int u2No = Integer.parseInt(request.getParameter("u2No")) ;

		Report re = new Report();

		re.setReason(reason);
		re.setBoardNo(cNo);
		re.setReportin(uNo);
		re.setReportout(u2No);

		int result = new UserBoardService().reportCon(re);


		String msg = "";
		String page = "views/member/3_parcelout/2_reviewParcelout/7_report_coment.jsp";
		if(result > 0) {
			msg = "신고 가 완료 되었습니다";
			request.setAttribute("msg", msg);

		}else {
			msg = "이미 신고 하셨습니다 ^^ 감사합니다.";
			request.setAttribute("msg", msg);
		}
		request.getRequestDispatcher(page).forward(request, response);






	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
