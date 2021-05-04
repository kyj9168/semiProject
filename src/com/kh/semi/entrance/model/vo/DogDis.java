package com.kh.semi.entrance.model.vo;

public class DogDis {

	private String disCd;
	private int entNo;

	public DogDis() {}

	public DogDis(String disCd, int entNo) {
		super();
		this.disCd = disCd;
		this.entNo = entNo;
	}

	public String getDisCd() {
		return disCd;
	}

	public void setDisCd(String disCd) {
		this.disCd = disCd;
	}

	public int getEntNo() {
		return entNo;
	}

	public void setEntNo(int entNo) {
		this.entNo = entNo;
	}

	@Override
	public String toString() {
		return "DogDis [disCd=" + disCd + ", entNo=" + entNo + "]";
	}



}
