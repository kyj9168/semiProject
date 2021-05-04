package com.kh.semi.chatiing.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/storage")
public class StorageChatSend extends Chattstorage{

	private static Map<String, Session> admin = Collections.synchronizedMap(new HashMap<String, Session>());

	@OnOpen
	public void onOpen(Session session) {
		String chatroom = session.getQueryString();
		String[] roomArr = chatroom.split(":");

		String roomkey = roomArr[1];

		admin.put(roomkey, session);
		System.out.println("storage 웹소켓 : " + admin);

		Iterator<String> keySetChatIterator = chat.keySet().iterator();
		if(keySetChatIterator.hasNext()) {
			while(keySetChatIterator.hasNext()) {
				String key2 = keySetChatIterator.next();
				if(key2.equals(roomkey)) {
					synchronized(admin) {
						for(int i = 0; i < chat.get(roomkey).size(); i ++) {
							String message = chat.get(roomkey).get(i);
							try {
								admin.get(roomkey).getBasicRemote().sendText(message);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}else {

				}
			}
		}




	}

	@OnMessage
	public void onMessage(String msg, Session session) throws IOException {
		//서버로부터 데이터를 전송받을 경우 동작할 메소드
		System.out.println("storage 웹소켓 : " + msg);

		//하나의 일 처리를 수행하는동안 사용자의 변경이 일어나면 안된다.
		//즉 NullPointer를 방지하기 위해 동기화 처리를 해준다.
		/*synchronized(admin) {
			for(Session client : admin) {
				client.getBasicRemote().sendText(msg);

			}
		}*/
	}

	@OnError
	public void onError(Throwable e) {
		//데이터를 전달하는 과정에서 에러가 발생할 경우 동작하는 메소드
		e.printStackTrace();
	}

	@OnClose
	public void onClose(Session session) {
		//지워주지 않으면 Set에 이미 나간 사용자가 남아있기 때문에 메세지 전송시 에러 난다.
		//clients.remove(session);
	}


}
