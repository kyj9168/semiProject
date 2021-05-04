package com.kh.semi.entrance.model.vo;

import java.sql.Date;

public class Entrance {

	private int entAppNo;
	private int userNo;
	private Date writeDt;
	private String selHopeDt;
	private String appSit;
	private String userNm;
	private String companionRs;

	public Entrance() {}

	public Entrance(int entAppNo, int userNo, Date writeDt, String selHopeDt, String appSit, String userNm,
			String companionRs) {
		super();
		this.entAppNo = entAppNo;
		this.userNo = userNo;
		this.writeDt = writeDt;
		this.selHopeDt = selHopeDt;
		this.appSit = appSit;
		this.userNm = userNm;
		this.companionRs = companionRs;
	}



	public String getCompanionRs() {
		return companionRs;
	}

	public void setCompanionRs(String companionRs) {
		this.companionRs = companionRs;
	}

	public String getUserNm() {
		return userNm;
	}



	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}



	public String getAppSit() {
		return appSit;
	}



	public void setAppSit(String appSit) {
		this.appSit = appSit;
	}



	public int getEntAppNo() {
		return entAppNo;
	}

	public void setEntAppNo(int entAppNo) {
		this.entAppNo = entAppNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public Date getWriteDt() {
		return writeDt;
	}

	public void setWriteDt(Date writeDt) {
		this.writeDt = writeDt;
	}

	public String getSelHopeDt() {
		return selHopeDt;
	}

	public void setSelHopeDt(String selHopeDt) {
		this.selHopeDt = selHopeDt;
	}

	@Override
	public String toString() {
		return "Entrance [entAppNo=" + entAppNo + ", userNo=" + userNo + ", writeDt=" + writeDt + ", selHopeDt="
				+ selHopeDt + "]";
	}



}
