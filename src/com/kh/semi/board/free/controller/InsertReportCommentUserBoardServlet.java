package com.kh.semi.board.free.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.semi.board.free.model.service.UserBoardService;
import com.kh.semi.board.parcelout.model.vo.Report;


/**
 * Servlet implementation class InsertReportCommentUserBoardServlet
 */
@WebServlet("/InsertReportCom.ub")
public class InsertReportCommentUserBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReportCommentUserBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String reason = request.getParameter("reason");
		String commentNickNm = request.getParameter("commentNickNm") ;
		int commentNo = Integer.parseInt( request.getParameter("commentNo"));
		int loginUserNo = Integer.parseInt(request.getParameter("loginUserNo")) ;
		
		int userNo = new UserBoardService().getUserNo(commentNickNm);
		
		Report re = new Report();
		System.out.println(reason);
		System.out.println(commentNo);
		System.out.println(userNo);
		System.out.println(loginUserNo);
		re.setReason(reason);
		re.setBoardNo(commentNo);
		re.setReportin(userNo);
		re.setReportout(loginUserNo);

		int result = new UserBoardService().reportCon(re);


		String msg = "";
		String page = "views/member/5_freeBoard/1_freeBoard/7_reportComment.jsp";
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
