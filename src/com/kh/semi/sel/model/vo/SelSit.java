package com.kh.semi.sel.model.vo;

import java.sql.Date;

public class SelSit {

	private String selNo;
	private String selSit;
	private String appDiv;
	private int entAppNo;
	private int pcoAppNo;
	private Date selDt;
	private String day;
	private int userNo;
	private String userNm;
	private String NickNm;

	public SelSit() {}



	public SelSit(String selNo, String selSit, String appDiv, int entAppNo, int pcoAppNo, Date selDt, String day,
			int userNo, String userNm, String nickNm) {
		super();
		this.selNo = selNo;
		this.selSit = selSit;
		this.appDiv = appDiv;
		this.entAppNo = entAppNo;
		this.pcoAppNo = pcoAppNo;
		this.selDt = selDt;
		this.day = day;
		this.userNo = userNo;
		this.userNm = userNm;
		NickNm = nickNm;
	}



	public int getUserNo() {
		return userNo;
	}



	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}



	public String getUserNm() {
		return userNm;
	}



	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}



	public String getNickNm() {
		return NickNm;
	}



	public void setNickNm(String nickNm) {
		NickNm = nickNm;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}



	public String getSelNo() {
		return selNo;
	}

	public void setSelNo(String selNo) {
		this.selNo = selNo;
	}

	public String getSelSit() {
		return selSit;
	}

	public void setSelSit(String selSit) {
		this.selSit = selSit;
	}

	public String getAppDiv() {
		return appDiv;
	}

	public void setAppDiv(String appDiv) {
		this.appDiv = appDiv;
	}

	public int getEntAppNo() {
		return entAppNo;
	}

	public void setEntAppNo(int entAppNo) {
		this.entAppNo = entAppNo;
	}

	public int getPcoAppNo() {
		return pcoAppNo;
	}

	public void setPcoAppNo(int pcoAppNo) {
		this.pcoAppNo = pcoAppNo;
	}

	public Date getSelDt() {
		return selDt;
	}

	public void setSelDt(Date selDt) {
		this.selDt = selDt;
	}



	@Override
	public String toString() {
		return "SelSit [selNo=" + selNo + ", selSit=" + selSit + ", appDiv=" + appDiv + ", entAppNo=" + entAppNo
				+ ", pcoAppNo=" + pcoAppNo + ", selDt=" + selDt + ", day=" + day + ", userNo=" + userNo + ", userNm="
				+ userNm + ", NickNm=" + NickNm + "]";
	}



}
