package com.kh.semi.support.money.controller;

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
import com.kh.semi.support.money.model.service.MoneySupService;

@WebServlet("/sendemail.sup")
public class SendEmailSupportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eamil = request.getParameter("eamil");
		int monSupNo = Integer.parseInt(request.getParameter("monSupNo"));

		int price = new MoneySupService().selectSupportPrice(monSupNo);

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
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("kyj9168@naver.com"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(eamil));
			//메일제목
			msg.setSubject("육인연 정기후원 결제 내역 메일입니다.");
			//메일내용
			message = "오늘 날짜로 육인연 정기후원으로 " + price +"원이 납부 되셨습니다. 항상 감사드립니다^^";
			msg.setText(message);
			//메일보내기
			Transport.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(message, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
