package com.kh.semi.board.parcelout.model.vo;

public class Report {

	private String reason;
	private int boardNo;
	private int reportin;
	private int reportout;

	public Report() {}

	public Report(String reason, int boardNo, int reportin, int reportout) {
		super();
		this.reason = reason;
		this.boardNo = boardNo;
		this.reportin = reportin;
		this.reportout = reportout;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getReportin() {
		return reportin;
	}

	public void setReportin(int reportin) {
		this.reportin = reportin;
	}

	public int getReportout() {
		return reportout;
	}

	public void setReportout(int reportout) {
		this.reportout = reportout;
	}



}
