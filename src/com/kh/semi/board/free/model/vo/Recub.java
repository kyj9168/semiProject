package com.kh.semi.board.free.model.vo;

public class Recub {
	private int uNo;
	private int bNo;
	
	public Recub() {}

	public Recub(int uNo, int bNo) {
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

	@Override
	public String toString() {
		return "Recub [uNo=" + uNo + ", bNo=" + bNo + "]";
	}
	
	
}
