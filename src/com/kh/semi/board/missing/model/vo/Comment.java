package com.kh.semi.board.missing.model.vo;

public class Comment {

	private String comment;
	private int bNo;
	private int uNo;
	private int conNo;
	private String nickNm;

	public Comment() {}

	public Comment(String comment, int bNo, int uNo , int conNo ,String nickNm) {
		super();
		this.comment = comment;
		this.bNo = bNo;
		this.uNo = uNo;
		this.conNo = conNo;
		this.nickNm = nickNm;
	}

	public String getNickNm() {
		return nickNm;
	}
	public void setNickNm(String nickNm) {
		this.nickNm = nickNm;
	}

	public int getConNo() {
		return conNo;
	}
	public void setConNo(int conNo) {
		this.conNo = conNo;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}



}
