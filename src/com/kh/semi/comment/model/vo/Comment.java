package com.kh.semi.comment.model.vo;

import java.sql.Date;

public class Comment {

	private int comNo;
	private String comCon;
	private Date writeDt;
	private int userNo;
	private int boardNo;

	public Comment() {}

	public Comment(int comNo, String comCon, Date writeDt, int userNo, int boardNo) {
		super();
		this.comNo = comNo;
		this.comCon = comCon;
		this.writeDt = writeDt;
		this.userNo = userNo;
		this.boardNo = boardNo;
	}

	public int getComNo() {
		return comNo;
	}

	public void setComNo(int comNo) {
		this.comNo = comNo;
	}

	public String getComCon() {
		return comCon;
	}

	public void setComCon(String comCon) {
		this.comCon = comCon;
	}

	public Date getWriteDt() {
		return writeDt;
	}

	public void setWriteDt(Date writeDt) {
		this.writeDt = writeDt;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "Comment [comNo=" + comNo + ", comCon=" + comCon + ", writeDt=" + writeDt + ", userNo=" + userNo
				+ ", boardNo=" + boardNo + "]";
	}



}
