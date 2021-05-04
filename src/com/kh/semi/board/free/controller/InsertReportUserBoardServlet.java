package com.kh.semi.board.free.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.parcelout.model.service.UserBoardService;
import com.kh.semi.board.parcelout.model.vo.Report;

/**
 * Servlet implementation class InsertReportUserBoardServlet
 */
@WebServlet("/insertReport.ub")
public class InsertReportUserBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReportUserBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String reason = request.getParameter("reason");
		String test = request.getParameter("test");


		System.out.println("reason 의 값 : " + reason);
		System.out.println("test 의 값 : " + test);

		String[] str = test.split(",");

		int boardNo = Integer.parseInt(str[0]);
		int reportin = Integer.parseInt(str[1]);
		int reportout = Integer.parseInt(str[2]);

		System.out.println(boardNo);
		System.out.println(reportin);
		System.out.println(reportout);

		Report re = new Report();

		re.setBoardNo(boardNo);
		re.setReason(reason);
		re.setReportin(reportin);
		re.setReportout(reportout);

		UserBoardService ub = new UserBoardService();

		int result = ub.report(re);

		String msg = "";
		String page = "views/member/5_freeBoard/1_freeBoard/5_report.jsp";
		if(result > 0) {
			msg = "신고가 완료 되었습니다";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(page).forward(request, response);

		}else {
			msg = "이미 신고 하셨습니다 ^^ 감사합니다.";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(page).forward(request, response);
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
