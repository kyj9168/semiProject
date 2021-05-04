package com.kh.semi.chatiing.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/confirm")
public class ConfirmChatting {

	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen
	public void onOpen(Session session) {
		
		clients.add(session);
		System.out.println("confirm 웹소켓 : " + clients);
	}

	@OnMessage
	public void onMessage(String msg, Session session) throws IOException {
		//서버로부터 데이터를 전송받을 경우 동작할 메소드
		System.out.println("confirm 웹소켓 : " + msg);

		//하나의 일 처리를 수행하는동안 사용자의 변경이 일어나면 안된다.
		//즉 NullPointer를 방지하기 위해 동기화 처리를 해준다.
		synchronized(clients) {
			for(Session client : clients) {
				client.getBasicRemote().sendText(msg);

			}
		}
	}

	@OnError
	public void onError(Throwable e) {
		//데이터를 전달하는 과정에서 에러가 발생할 경우 동작하는 메소드
		e.printStackTrace();
	}

	@OnClose
	public void onClose(Session session) {
		//지워주지 않으면 Set에 이미 나간 사용자가 남아있기 때문에 메세지 전송시 에러 난다.
		clients.remove(session);
	}


}
