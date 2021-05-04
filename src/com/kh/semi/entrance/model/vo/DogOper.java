package com.kh.semi.entrance.model.vo;

public class DogOper {

	private String operCd;
	private int entNo;

	public DogOper() {}

	public DogOper(String operCd, int entNo) {
		super();
		this.operCd = operCd;
		this.entNo = entNo;
	}

	public String getOperCd() {
		return operCd;
	}

	public void setOperCd(String operCd) {
		this.operCd = operCd;
	}

	public int getEntNo() {
		return entNo;
	}

	public void setEntNo(int entNo) {
		this.entNo = entNo;
	}

	@Override
	public String toString() {
		return "DogOper [operCd=" + operCd + ", entNo=" + entNo + "]";
	}



}
