package com.kh.semi.board.missing.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.missing.model.service.MissingService;
import com.kh.semi.board.missing.model.vo.MissingReport;

/**
 * Servlet implementation class ProCommentReport
 */
@WebServlet("/ProCommentReport")
public class ProCommentReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProCommentReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reason = request.getParameter("reason");
		int uNo = Integer.parseInt(request.getParameter("uNo")) ;
		int cNo = Integer.parseInt( request.getParameter("cNo"));
		int u2No = Integer.parseInt(request.getParameter("u2No")) ;

		MissingReport re = new MissingReport();

		re.setReason(reason);
		re.setbNo(cNo);
		re.setuNo(uNo);
		re.setuNo2(u2No);
		int result = new MissingService().reportCon(re);


		String msg = "";
		String page = "views/member/4_missing/2_protect/6_report_comment.jsp";
		if(result > 0) {
			msg = "신고 가 완료 되었습니다";
			request.setAttribute("msg", msg);

		}else {
			msg = "이미 신고 하셨습니다 ^^ 감사합니다.";
			request.setAttribute("msg", msg);
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
