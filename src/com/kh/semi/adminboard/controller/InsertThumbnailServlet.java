package com.kh.semi.adminboard.controller;

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
import com.kh.semi.adminboard.model.vo.NoticeAttachment;
import com.kh.semi.common.MyFileRenamePolicy;
import com.kh.semi.user.model.vo.User;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertThumbnailServlet
 */
@WebServlet("/insert.bo")
public class InsertThumbnailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertThumbnailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10;
			
			String root = request.getSession().getServletContext().getRealPath("/");
			
			System.out.println(root);
			
			String savePath = root + "Notice_uploadFiles/";
			
			MultipartRequest multiRequest = 
					new MultipartRequest(request, savePath, maxSize,
										"UTF-8", new MyFileRenamePolicy());
			
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
			
			String multiTitle = multiRequest.getParameter("title");
			String multiContent = multiRequest.getParameter("content");
			int userNo = ((User)(request.getSession().getAttribute(""))).getUserNo();
			
			AdminBoard ab = new AdminBoard();
			ab.setTitle(multiTitle);
			ab.setAdBoardCon(multiContent);
			ab.setNickNm(String.valueOf(userNo));
			
			ArrayList<NoticeAttachment> fileList = new ArrayList<NoticeAttachment>();
			
			for(int i =originFiles.size() -1; i>=0; i--) {
				NoticeAttachment nat = new NoticeAttachment();
				nat.setFilePath(savePath);
				nat.setOriginNm(originFiles.get(i));
				nat.setChangeNm(saveFiles.get(i));
				

				fileList.add(nat);
			}
			
			System.out.println("controller board : " + ab);
			System.out.println("controller attachment list : " + fileList);
			
			int result = new AdminBoardService().insertThumnail(ab, fileList);
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/selectList.tn");
			}
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











