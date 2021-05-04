package com.kh.semi.adminboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.adminboard.model.service.AdminBoardService;
import com.kh.semi.adminboard.model.vo.AdminBoard;
import com.kh.semi.adminboard.model.vo.NoticeAttachment;
import com.kh.semi.board.free.model.vo.UserBoard;
import com.kh.semi.board.free.model.vo.UserBoardAttachment;

@WebServlet("/selectOne.no")
public class SelectOneNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("현재 공지사항 번호 : " + num);
		
		
		HashMap<String, Object> hmap  = new AdminBoardService().selectOne(num);
		
		AdminBoard ab = (AdminBoard) hmap.get("board");
		ArrayList<NoticeAttachment> fileList = 
				(ArrayList<NoticeAttachment>) hmap.get("attachment");
		
		System.out.println("클릭한 게시글의 내용 : " + ab);
		System.out.println("클릭한 게시글의 사진 : " + fileList);
		String page = "";
		if(hmap != null) {
			request.setAttribute("ab", ab);
			request.setAttribute("fileList", fileList);
		
			page = "views/member/1_introduce/2_notice/3_read.jsp";
			request.setAttribute("ab", ab);
		}else {
			/*page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 상세 보기 실패!!");*/

		}

		request.getRequestDispatcher(page).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
