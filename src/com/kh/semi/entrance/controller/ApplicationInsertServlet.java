package com.kh.semi.entrance.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.semi.board.parcelout.model.vo.Attachment;
import com.kh.semi.entrance.model.service.EntranceService;
import com.kh.semi.entrance.model.vo.Entrance;
import com.kh.semi.entrance.model.vo.EntranceDogInfo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/ApplicationInsert")
public class ApplicationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일전송
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10; //10MB

			String root = request.getSession().getServletContext().getRealPath("/");

			String savePath = root + "entrance_uploadFiles/";

			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());

			ArrayList<String> saveFiles = new ArrayList<String>();
			ArrayList<String> originFiles = new ArrayList<String>();

			Enumeration<String> files = multiRequest.getFileNames();

			while(files.hasMoreElements()) {
				String name = files.nextElement();

				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));

				System.out.println("fileSystem name : " + multiRequest.getFilesystemName(name));
				System.out.println("originFile name : " + multiRequest.getOriginalFileName(name));

			}

			ArrayList<Attachment> fileList = new ArrayList<Attachment>();

			for(int i = originFiles.size() - 1; i >= 0; i--) {
				Attachment at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginNm(originFiles.get(i));
				at.setChangeNm(saveFiles.get(i));

				fileList.add(at);
			}

		//Entrance.java insert
		int userNo = Integer.parseInt(multiRequest.getParameter("userNo"));
		String selHope1 = multiRequest.getParameter("test");
		String selHope2 = multiRequest.getParameter("test2");
		String[] date = selHope1.split("/");
		String day = date[2] + date[0] + date[1];
		String selHopeDt = day + selHope2;

		Entrance et = new Entrance();
		et.setUserNo(userNo);
		et.setSelHopeDt(selHopeDt);

		System.out.println(selHope1);
		System.out.println(selHope2);


		//EntranceDogInfo.java insert
		String dogNm = multiRequest.getParameter("dogNm");
		String dogAge = multiRequest.getParameter("dogAge");
		String dogGender = multiRequest.getParameter("dogGender");
		String dogKind = multiRequest.getParameter("dogKind");
		int dogWeight = Integer.parseInt(multiRequest.getParameter("dogWeight"));
		int dogHeight = Integer.parseInt(multiRequest.getParameter("dogHeight"));
		String inoYn = multiRequest.getParameter("inoYn");
		String disYn = multiRequest.getParameter("disYn");
		String operYn = multiRequest.getParameter("operYn");
		String allegy = multiRequest.getParameter("allegy");
		String dogHobby = multiRequest.getParameter("dogHobby");
		String dogBark = multiRequest.getParameter("dogBark");
		String dogBowel = multiRequest.getParameter("dogBowel");
		String dogAct = multiRequest.getParameter("dogAct");
		String seperate = multiRequest.getParameter("seperate");
		String furColor = multiRequest.getParameter("furColor");
		String obYn = multiRequest.getParameter("obYn");
		String regYn = multiRequest.getParameter("regYn");
		String dogChar = multiRequest.getParameter("dogChar");

		String[] t1 = multiRequest.getParameterValues("t1");
		String[] tt1 = multiRequest.getParameterValues("tt1");
		String[] ttt1 = multiRequest.getParameterValues("ttt1");

		EntranceDogInfo dogInfo = new EntranceDogInfo();
		dogInfo.setDogNm(dogNm);
		dogInfo.setDogAge(dogAge);
		dogInfo.setDogGender(dogGender);
		dogInfo.setDogKind(dogKind);
		dogInfo.setDogWeight(dogWeight);
		dogInfo.setDogHeight(dogHeight);
		dogInfo.setInoYn(inoYn);
		dogInfo.setDisYn(disYn);
		dogInfo.setOperYn(operYn);
		dogInfo.setAllegy(allegy);
		dogInfo.setDogHobby(dogHobby);
		dogInfo.setDogBark(dogBark);
		dogInfo.setDogBowel(dogBowel);
		dogInfo.setDogAct(dogAct);
		dogInfo.setSeperate(seperate);
		dogInfo.setFurColor(furColor);
		dogInfo.setObYn(obYn);
		dogInfo.setRegYn(regYn);
		dogInfo.setDogChar(dogChar);
		dogInfo.setT1(t1);
		dogInfo.setTt1(tt1);
		dogInfo.setTtt1(ttt1);

		System.out.println("입소 파일 : " + fileList);
		System.out.println("입소 내역 : " + et);
		System.out.println("입소견 : " + dogInfo);

		int result = new EntranceService().insertEntrance(fileList, et, dogInfo);

		if(result > 0) {
			System.out.println("서블릿까지 성공했다!!");
			response.sendRedirect("index.jsp");
		}


		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
