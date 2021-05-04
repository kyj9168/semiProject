package com.kh.semi.support.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/select.token")
public class SelectBootpayTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*curl -H "Content-Type: application/json" \
		-d '{"application_id": "[ REST용 Application ID ]", "private_key": "[ Project의 Private Key ( 보안 문제상 예제에 표기하지 않습니다. 부트페이 관리자에서 확인해주세요. ) ]"}' \
		-X POST https://api.bootpay.co.kr/request/token*/

		//response data를 담을 String 생성
		String inputLine = null;

		//요청할 쿼리스트링 담을 StringBuffer 생성
		StringBuffer outResult = new StringBuffer();

		//요청할 키값에 대응되는 value값 선언
		String application_id = "5d38293e02f57e00381e9c2e";
		String private_key = "nM+YsThKJu0Ca+6dbOAXiq6VhH/VHb0GduKLcwtP8rM=";

		//요청할 url과 연결할 Connection 생성
		try {

			URL url = new URL("https://api.bootpay.co.kr/request/token");
			System.out.println("url 생성 : " + url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			//conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);


			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			outResult.append("?application_id=" + application_id);
			outResult.append("&private_key=" + private_key);
			System.out.println("queryString 작성 : " + outResult);
			bw.write(outResult.	toString());
			bw.flush();

			String result = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while((inputLine = in.readLine()) != null) {
				result += inputLine;
			}

			System.out.println("토큰 출력값 : " + result);
		}catch (MalformedURLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (ProtocolException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
