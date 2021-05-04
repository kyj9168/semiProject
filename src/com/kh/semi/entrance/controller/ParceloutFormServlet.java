package com.kh.semi.entrance.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.parcelout.model.service.ParcelOutService;
import com.kh.semi.parcelout.model.vo.ParcelOut;
import com.kh.semi.parcelout.model.vo.ParcelOutQuestion;
import com.kh.semi.parcelout.model.vo.parceOutAnswer;

/**
 * Servlet implementation class ParceloutFormServlet
 */
@WebServlet("/parceloutform")
public class ParceloutFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParceloutFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pcoAppNo = Integer.parseInt(request.getParameter("pcoAppNo"));

		
		//PCO_APP
		ParcelOut pco = new ParcelOutService().parceloutInfo(pcoAppNo);
		//PCO_QU_ANS
		ArrayList<parceOutAnswer> poa = new ParcelOutService().parceloutqanda(pcoAppNo);
		//PCO_QU
		ArrayList<ParcelOutQuestion> poq = new ParcelOutService().parceloutquestion(pcoAppNo);
		
		request.setAttribute("pco",pco);
		request.setAttribute("poa", poa);
		request.setAttribute("poq", poq);
				
		request.getRequestDispatcher("views/member/3_parcelout/1_applyParcelout/3_parceloutInformation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
