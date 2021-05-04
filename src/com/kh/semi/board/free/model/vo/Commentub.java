package com.kh.semi.board.free.model.vo;

import java.sql.Date;

public class Commentub {

	private String commentCon;
	private int boardNo;
	private int userNo;
	private int commentNo;
	private String nickNm;
	private Date writeDay;
	private String boardNm;
	private String boardKind;
	
	public Commentub() {}

	public Commentub(String commentCon, int boardNo, int userNo, int commentNo, String nickNm, Date writeDay,
			String boardNm, String boardKind) {
		super();
		this.commentCon = commentCon;
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.commentNo = commentNo;
		this.nickNm = nickNm;
		this.writeDay = writeDay;
		this.boardNm = boardNm;
		this.boardKind = boardKind;
	}

	public String getCommentCon() {
		return commentCon;
	}

	public void setCommentCon(String commentCon) {
		this.commentCon = commentCon;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getNickNm() {
		return nickNm;
	}

	public void setNickNm(String nickNm) {
		this.nickNm = nickNm;
	}

	public Date getWriteDay() {
		return writeDay;
	}

	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}

	public String getBoardNm() {
		return boardNm;
	}

	public void setBoardNm(String boardNm) {
		this.boardNm = boardNm;
	}

	public String getBoardKind() {
		return boardKind;
	}

	public void setBoardKind(String boardKind) {
		this.boardKind = boardKind;
	}

	@Override
	public String toString() {
		return "Commentub [commentCon=" + commentCon + ", boardNo=" + boardNo + ", userNo=" + userNo + ", commentNo="
				+ commentNo + ", nickNm=" + nickNm + ", writeDay=" + writeDay + ", boardNm=" + boardNm + ", boardKind="
				+ boardKind + "]";
	}
	
	
	


	

	


}
