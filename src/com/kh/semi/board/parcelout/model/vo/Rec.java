package com.kh.semi.board.parcelout.model.vo;

public class Rec {

	private int uNo;
	private int bNo;

	public Rec() {}

	public Rec(int uNo, int bNo) {
		super();
		this.uNo = uNo;
		this.bNo = bNo;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}



}
