package com.kh.semi.board.missing.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.missing.model.service.MissingService;
import com.kh.semi.board.missing.model.vo.Missing;
import com.kh.semi.board.missing.model.vo.MissingAttachment;
import com.kh.semi.board.missing.model.vo.Comment;


/**
 * Servlet implementation class ProSelectOneServlet
 */
@WebServlet("/proSelectOne.bo")
public class ProSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int num = Integer.parseInt(request.getParameter("num"));
		int uu=0;
		System.out.println("모야모야"+num);
		

if(request.getParameter("uu")!= null) {
	uu= Integer.parseInt(request.getParameter("uu"));
	System.out.println(uu+"uuuuuuuuuuuu");
}
	
			
			HashMap<String, Object> hmap = new MissingService().missingselectThumbnailMap2(num);
			ArrayList<Comment> list = (ArrayList<Comment>) hmap.get("comment");
			Missing b = (Missing) hmap.get("board");
			System.out.println("보드?????????/"+b);
			ArrayList<MissingAttachment> fileList = 
					(ArrayList<MissingAttachment>) hmap.get("attachment");
			
			String page = "";
			
			if(hmap != null&& uu==0||uu==1) {
				page = "views/member/4_missing/2_protect/3_read.jsp";
				request.setAttribute("b", b);
				request.setAttribute("fileList", fileList);
				System.out.println("파일리스트"+fileList.get(0));
				System.out.println("보드"+b);
				
				if(list != null) {

					if(list.size() > 0) {

						request.setAttribute("comment", list);
						System.out.println("코멘트"+list);
					}

				}
			}else {
			
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
