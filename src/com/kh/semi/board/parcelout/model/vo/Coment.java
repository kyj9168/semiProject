package com.kh.semi.board.parcelout.model.vo;

public class Coment {

	private String coment;
	private int bNo;
	private int uNo;
	private int conNo;
	private String nickNm;

	public Coment() {}

	public Coment(String coment, int bNo, int uNo , int conNo ,String nickNm) {
		super();
		this.coment = coment;
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

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
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
