package com.kh.semi.chatiing.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Chattstorage {

	public static HashMap<String, ArrayList<String>> chat = new HashMap<String, ArrayList<String>>();

	public Chattstorage() {}

	public void intoChattstorage(String key) {
		ArrayList<String> comment = new ArrayList<String>();
		chat.put(key, comment);
	}

	public void intoChattstorage(String key, String message) {
		chat.get(key).add(message);
	}

	public HashMap<String, ArrayList<String>> getChat() {
		return chat;
	}

	public void setChat(HashMap<String, ArrayList<String>> chat) {
		this.chat = chat;
	}




}
