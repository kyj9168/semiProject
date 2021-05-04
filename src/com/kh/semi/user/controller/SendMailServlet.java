package com.kh.semi.user.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/sendMail")
public class SendMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputEmail = request.getParameter("inputEmail");
		System.out.println("받은 이메일 : " + inputEmail);

		String host = "smtp.naver.com";
		String user = "kyj9168";
		String password = "rlawns1158*";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smpt.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", host);

		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			String un = user;
			String pw = password;
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(un, pw);
			}
		});
		session.setDebug(true);

		String message = null;
		int random = 0;
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("kyj9168@naver.com"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(inputEmail));
			//메일제목
			msg.setSubject("육인연 회원가입 인증번호 안내");
			//메일내용
			random = (int)(Math.random()*99999)+10000;
			message = "육인연 회원가입 인증번호 : " + random + " 입니다.\n"
					+ "인증번호 입력칸에 올바르게 입력하여 주세요." ;
			msg.setText(message);
			//메일보내기
			Transport.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(random, response.getWriter());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
