package com.kh.semi.parcelout.model.vo;

import java.sql.Date;

public class ParcelOutResult {
	private int pcoAppNo;
	private Date pcoDt;
	private int entNo;
	private String userNm;
	private String dogNm;

	public ParcelOutResult() {}

	public ParcelOutResult(int pcoAppNo, Date pcoDt, int entNo, String userNm, String dogNm) {
		super();
		this.pcoAppNo = pcoAppNo;
		this.pcoDt = pcoDt;
		this.entNo = entNo;
		this.userNm = userNm;
		this.dogNm = dogNm;
	}



	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getDogNm() {
		return dogNm;
	}

	public void setDogNm(String dogNm) {
		this.dogNm = dogNm;
	}

	public int getPcoAppNo() {
		return pcoAppNo;
	}

	public void setPcoAppNo(int pcoAppNo) {
		this.pcoAppNo = pcoAppNo;
	}

	public Date getPcoDt() {
		return pcoDt;
	}

	public void setPcoDt(Date pcoDt) {
		this.pcoDt = pcoDt;
	}

	public int getEntNo() {
		return entNo;
	}

	public void setEntNo(int entNo) {
		this.entNo = entNo;
	}

	@Override
	public String toString() {
		return "ParcelOutResult [pcoAppNo=" + pcoAppNo + ", pcoDt=" + pcoDt + ", entNo=" + entNo + "]";
	}


}
