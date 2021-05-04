package com.kh.semi.adminboard.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.semi.adminboard.model.service.AdminBoardService;
import com.kh.semi.adminboard.model.vo.AdminBoard;
import com.kh.semi.board.parcelout.model.vo.Attachment;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/insertSup.mon")
public class InsertSupportBoardMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {

			int maxSize = 1024 * 1024 * 10; //10MB


			String root = request.getSession().getServletContext().getRealPath("/");
			System.out.println("root : " + root);

			String savePath = root + "support_uploadFiles/";

			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());

			ArrayList<String> saveFiles = new ArrayList<String>();

			ArrayList<String> originFiles = new ArrayList<String>();

			Enumeration<String> files = multiRequest.getFileNames();
			System.out.println("files : " + files);

			while(files.hasMoreElements()) {
				String name = files.nextElement();

				System.out.println("name : " + name);
				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));

				System.out.println("fileSystem name : " + multiRequest.getFilesystemName(name));
				System.out.println("originFile name : " + multiRequest.getOriginalFileName(name));

			}


			String multiTitle = multiRequest.getParameter("title");
			String multiContent = multiRequest.getParameter("content");
			String month = multiTitle.substring(0, 1);
			int userNo = Integer.parseInt(multiRequest.getParameter("userNo"));


			System.out.println("제목 : " + multiTitle);
			System.out.println("내용 : " + multiContent);
			System.out.println("번호 : " + userNo);
			System.out.println("달 : " + month);

			AdminBoard ab = new AdminBoard();
			ab.setTitle(multiTitle);
			ab.setAdBoardCon(multiContent);
			ab.setAdNo(userNo);
			ab.setSup_Mon(month);

			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			//전송순서 역순으로 저장되기 때문에 반복문을 역으로 돌려서 list에 저장
			for(int i = originFiles.size() - 1; i >= 0; i--) {
				Attachment at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginNm(originFiles.get(i));
				at.setChangeNm(saveFiles.get(i));

				fileList.add(at);
			}

			int result = new AdminBoardService().insertSupportMoneyBoard(ab, fileList);


			if(result > 0) {
				response.sendRedirect(request.getContextPath()+"/selectSup.his");
				System.out.println("성공스!!!!");
			}else {
				//실패시 저장된 사진 삭제
				for(int i = 0; i < saveFiles.size(); i++) {
					File failedFile = new File(savePath + saveFiles.get(i));
					failedFile.delete();
				}

				request.setAttribute("msg", "사진게시판 등록 실패!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
