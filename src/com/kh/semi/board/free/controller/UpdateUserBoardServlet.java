package com.kh.semi.board.free.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.semi.board.free.model.service.UserBoardService;
import com.kh.semi.board.free.model.vo.UserBoard;
import com.kh.semi.board.free.model.vo.UserBoardAttachment;
import com.kh.semi.common.MyFileRenamePolicy;
import com.kh.semi.user.model.vo.User;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UpdateUserBoardServlet
 */
@WebServlet("/update.ub")
public class UpdateUserBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bNm = request.getParameter("bNm");
		String bKind = request.getParameter("bKind");
		String bCon = request.getParameter("bCon");
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		System.out.println(bNm);
		System.out.println(bKind);
		System.out.println(bCon);
		System.out.println(bNo);
		UserBoard ub = new UserBoard();
		ub.setbNm(bNm);
		ub.setbCon(bCon);
		ub.setbKind(bKind);
		
		int result = new UserBoardService().updateUserBoard(ub, bNo);
		
		String page = "";
		
		if(result > 0) {
			response.sendRedirect("/sixDestiny/selectOne.bo?num=" + bNo);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 수정 실패!!");
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
