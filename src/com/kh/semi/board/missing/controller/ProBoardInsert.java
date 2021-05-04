package com.kh.semi.board.missing.controller;

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

import com.kh.semi.board.missing.model.service.MissingService;
import com.kh.semi.board.missing.model.vo.Missing;
import com.kh.semi.board.missing.model.vo.MissingAttachment;
import com.kh.semi.common.MyFileRenamePolicy;
import com.kh.semi.user.model.vo.User;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ProBoardInsert
 */
@WebServlet("/profile.bo")
public class ProBoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProBoardInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("들어왔니ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ");
		boolean a=ServletFileUpload.isMultipartContent(request);
		System.out.println(a);
			if(ServletFileUpload.isMultipartContent(request)) {
				//전송 파일 용량 제한 : 10Mbyte로 제한
				System.out.println("여긴들어왔니퓨ㅠㅠㅠㅠㅠ");
				int maxSize = 1024 * 1024 * 10;
				
				//웹서버 컨테이너 경로 추출
				String root = request.getSession().getServletContext().getRealPath("/");
				
				System.out.println(root);
				//파일 저장 경로(web/thumbnail_uploadFiles)
				String savePath = root + "thumbnail_uploadFiles/";
				
				//사용자가 올린 파일의 이름을 그대로 저장하지 않는 것이 일반적이다.
				//1. 같은 파일명이 있는 경우 이전 파일을 덮어쓸 수 있다.
				//2. 한글로된 파일명, 특수기호나 띄어쓰기 등은 서버에 따라 문제가 생길 수 도 있다.
				//DefaultFileRenamePolicy는 cos.jar안에 존재하는 클래스로
				//같은 파일명이 존재하는지를 검사하고, 있을 경우에 파일 뒤에 숫자를 붙인다.
				//ex : aaa.zip, aaa1.zip, aaa2.zip
				
				//DefaultFileRenamePolicy 사용
				/*MultipartRequest multiRequest = 
						new MultipartRequest(request, savePath, maxSize, 
											"UTF-8", new DefaultFileRenamePolicy());*/
				
				//FileRenamePolicy 상속 후 오버라이딩
				MultipartRequest multiRequest =
						new MultipartRequest(request, savePath, maxSize,
											"UTF-8", new MyFileRenamePolicy());
				
				//다중파일을 묶어서 업로드를 하기 위해 컬렉션 이용
				//저장한 파일(변경된 파일의) 이름을 저장할 ArrayList 객체 생성
				ArrayList<String> saveFiles = new ArrayList<String>();
				//원본 파일의 이름을 저장할 ArrayList 생성
				ArrayList<String> originFiles = new ArrayList<String>();
				
				//파일이 전송된 이름을 반환한다
				Enumeration<String> files = multiRequest.getFileNames();
				
				while(files.hasMoreElements()) {
					String name = files.nextElement();
					
					//System.out.println("name : " + name);
					
					saveFiles.add(multiRequest.getFilesystemName(name));
					originFiles.add(multiRequest.getOriginalFileName(name));
					
					
					System.out.println("fileSystem name : " + multiRequest.getFilesystemName(name));
					System.out.println("originFile name : " + multiRequest.getOriginalFileName(name));
				}
				//MultipartRequest 객체를 이용하여 파일 외의 값들도 꺼낼 수 있다.
				String title=multiRequest.getParameter("title");
				String content=multiRequest.getParameter("content");
				String bKind="실종";
				String mKind="보호";
				String place=multiRequest.getParameter("place");
				String placedetail=multiRequest.getParameter("placedetail");
				String date=multiRequest.getParameter("missdate");
				String[] missdate = date.split("-");
				String resultDate = "";
				System.out.println(missdate.length +"길이");
				for(int i = 0; i < missdate.length; i++) {
					resultDate += missdate[i];
					System.out.println(resultDate);
				}
				System.out.println("입력폼 : " + date);
				System.out.println("베열 : " + missdate[0]);
				//resultDate = 20190303
				//TO_DATE(resultDate, 'YYYYMMDD')
				String gender= multiRequest.getParameter("gender");
				
				String phone=multiRequest.getParameter("phone");
				
				System.out.println("Date:"+resultDate);
				
			int writer = ((User) request.getSession().getAttribute("loginUser")).getUserNo();
			
				/*System.out.println(multiTitle);
				System.out.println(multiContent);*/
				
				//Board객체 생성
			Missing b = new Missing();
			b.setuNo(writer);
			b.setbNm(title);
			b.setbKind(bKind);
			b.setbCon(content);
			b.setMissDt(resultDate);
			
			b.setMissPlace(place);
			b.setMissPlaceDetail(placedetail);
			b.setMissDt(resultDate);
			b.setMissGender(gender);
			b.setBoardDiv(mKind);
	

			b.setMissPhone(phone);//
				//b.setbWriter(String.valueOf(uno));
				
				//Attachment 객체 생성하여 ArrayList객체에 저장
				ArrayList<MissingAttachment> fileList = new ArrayList<MissingAttachment>();
				//전송순서 역순으로 저장되기 때문에 반복문을 역으로 돌려 list에 저장
				for(int i = originFiles.size() - 1; i >= 0; i--) {
					MissingAttachment at = new MissingAttachment();
					at.setFilePath(savePath);
					at.setOriginNm(originFiles.get(i));
					if(saveFiles.get(i) != null) {
			            at.setChangeNm(saveFiles.get(i));
			            }else {
			            at.setChangeNm("null.PNG");
			            }
					fileList.add(at);
				}
				
				System.out.println("controller board : " + b);
				System.out.println("controller attachment list : " + fileList);
				
				
				int result = new MissingService().ProInsert(b, fileList);
				
				if(result > 0) {
					response.sendRedirect(request.getContextPath() + "/proListo.bo");
				}else {
					//실패시 저장된 사진 삭제
					for(int i = 0; i < saveFiles.size(); i++) {
						File failedFile = new File(savePath + saveFiles.get(i));
						failedFile.delete();
					}
					
				
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
