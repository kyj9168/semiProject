package com.kh.semi.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LoginWrapper extends HttpServletRequestWrapper{

	public LoginWrapper(HttpServletRequest request) {
		super(request);

	}

	@Override
	public String getParameter(String key) {
		String value = "";

		if(key != null && key.equals("password")) {
			value = getSha512(super.getParameter("password"));
		}else {
			value = super.getParameter(key);
		}

		return value;
	}

	private static String getSha512(String pwd) {
		String  encPwd ="";

		try {
			//평문화된 문자를 암호화 시킨 문자 = Digest
			//SHA-512 : 단방향 + 해쉬 암호화 기능
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
			//암호화된 digest생성
			md.update(bytes);
			//암호화된 digest를 인코딩처리하여 문자열로 리턴
			encPwd = Base64.getEncoder().encodeToString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return encPwd;
	}

}
