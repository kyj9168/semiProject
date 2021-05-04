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
 * Servlet implementation class ProReportServlet
 */
@WebServlet("/proreport.bo")
public class ProReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reason = request.getParameter("reason");
		String test = request.getParameter("test"); //보드넘버


		System.out.println("reason 의 값 : " + reason);
		System.out.println("test 의 값 : " + test);

		String[] str = test.split(",");

		int bNo = Integer.parseInt(str[0]);
		int uNo = Integer.parseInt(str[1]);
		int uNo2 = Integer.parseInt(str[2]);

		//System.out.println(boardNo);
	//	System.out.println(reportin);
		//System.out.println(reportout);

		MissingReport re = new MissingReport();
		re.setbNo(bNo);
		re.setReason(reason);
		re.setuNo(uNo); //신고한사람
		re.setuNo2(uNo2); //신고받은사람
		
		


		MissingService ub = new MissingService();

		int result = ub.report(re);

		String msg = "";
		String page = "views/member/4_missing/2_protect/5_report.jsp";
		if(result > 0) {
			msg = "신고 가 완료 되었습니다";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(page).forward(request, response);

		}else {
			msg = "다시 신고 해주세요";
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
