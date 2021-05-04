package com.kh.semi.entrance.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.entrance.model.service.EntranceService;
import com.kh.semi.entrance.model.vo.Entrance;
import com.kh.semi.entrance.model.vo.EntranceDogInfo;
import com.kh.semi.user.model.service.UserService;
import com.kh.semi.user.model.vo.User;

/**
 * Servlet implementation class ApplicationForm
 */
@WebServlet("/applicationform")
public class ApplicationFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int entAppNo = Integer.parseInt(request.getParameter("entAppNo"));
		
		//ENT_APP
		Entrance et = new EntranceService().entranceInfo(entAppNo);
		//ENT_DOG_INF
		EntranceDogInfo dogInfo =  new EntranceService().dogInfo(entAppNo);
		//USERES
		User user = new UserService().entUser(et);
		//DOG_DIS_HS
		//DOG_INO_HS
		//DOG_OPER_HS
		
		request.setAttribute("et", et);
		request.setAttribute("dogInfo", dogInfo);
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("views/member/2_entrance/1_applyEntrance/3_entranceInformation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
