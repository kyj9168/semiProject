package com.kh.semi.entrance.model.vo;

public class DogIno {

	private String inoCd;
	private int entNo;

	public DogIno() {}

	public DogIno(String inoCd, int entNo) {
		super();
		this.inoCd = inoCd;
		this.entNo = entNo;
	}

	public String getInoCd() {
		return inoCd;
	}

	public void setInoCd(String inoCd) {
		this.inoCd = inoCd;
	}

	public int getEntNo() {
		return entNo;
	}

	public void setEntNo(int entNo) {
		this.entNo = entNo;
	}

	@Override
	public String toString() {
		return "DogIno [inoCd=" + inoCd + ", entNo=" + entNo + "]";
	}



}
