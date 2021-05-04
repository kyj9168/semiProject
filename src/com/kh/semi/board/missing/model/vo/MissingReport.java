package com.kh.semi.board.missing.model.vo;

import java.sql.Date;

public class MissingReport {

	private String reason;
	private int bNo;
	private int uNo2;
	private Date reDate;
	private int uNo;
	public MissingReport() {}
	public MissingReport(String reason, int bNo, int uNo2, Date reDate, int uNo) {
		super();
		this.reason = reason;
		this.bNo = bNo;
		this.uNo2 = uNo2;
		this.reDate = reDate;
		this.uNo = uNo;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public int getuNo2() {
		return uNo2;
	}
	public void setuNo2(int uNo2) {
		this.uNo2 = uNo2;
	}
	public Date getReDate() {
		return reDate;
	}
	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}
	public int getuNo() {
		return uNo;
	}
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}





}
