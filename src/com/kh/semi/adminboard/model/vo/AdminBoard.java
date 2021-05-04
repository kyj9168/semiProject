package com.kh.semi.adminboard.model.vo;

import java.sql.Date;

public class AdminBoard {

	private int adBoardNo;
	private String title;
	private String adBoardCon;
	private Date writeDt;
	private String boardDiv;
	private String supKind;
	private int adNo;
	private String status;
	private String nickNm;
	private int recCount;
	private int viewCount;
	private String sup_Mon;
	private String userNick;

	public AdminBoard() {}

	public AdminBoard(int adBoardNo, String title, String adBoardCon, Date writeDt, String boardDiv, String supKind,
			int adNo, String status, String nickNm, int recCount, int viewCount, String sup_Mon , String userNick) {
		super();
		this.adBoardNo = adBoardNo;
		this.title = title;
		this.adBoardCon = adBoardCon;
		this.writeDt = writeDt;
		this.boardDiv = boardDiv;
		this.supKind = supKind;
		this.adNo = adNo;
		this.status = status;
		this.nickNm = nickNm;
		this.recCount = recCount;
		this.viewCount = viewCount;
		this.sup_Mon = sup_Mon;
		this.userNick = userNick;
	}




	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {

		this.userNick = userNick;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getSup_Mon() {
		return sup_Mon;
	}



	public void setSup_Mon(String sup_Mon) {
		this.sup_Mon = sup_Mon;
	}



	public int getAdBoardNo() {
		return adBoardNo;
	}

	public void setAdBoardNo(int adBoardNo) {
		this.adBoardNo = adBoardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAdBoardCon() {
		return adBoardCon;
	}

	public void setAdBoardCon(String adBoardCon) {
		this.adBoardCon = adBoardCon;
	}

	public Date getWriteDt() {
		return writeDt;
	}

	public void setWriteDt(Date writeDt) {
		this.writeDt = writeDt;
	}

	public String getBoardDiv() {
		return boardDiv;
	}

	public void setBoardDiv(String boardDiv) {
		this.boardDiv = boardDiv;
	}

	public String getSupKind() {
		return supKind;
	}

	public void setSupKind(String supKind) {
		this.supKind = supKind;
	}

	public int getAdNo() {
		return adNo;
	}

	public void setAdNo(int adNo) {
		this.adNo = adNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getNickNm() {
		return nickNm;
	}



	public void setNickNm(String nickNm) {
		this.nickNm = nickNm;
	}




	public int getRecCount() {
		return recCount;
	}







	public void setRecCount(int recCount) {
		this.recCount = recCount;
	}

	@Override
	public String toString() {
		return "AdminBoard [adBoardNo=" + adBoardNo + ", title=" + title + ", adBoardCon=" + adBoardCon + ", writeDt="
				+ writeDt + ", boardDiv=" + boardDiv + ", supKind=" + supKind + ", adNo=" + adNo + ", status=" + status
				+ ", nickNm=" + nickNm + ", recCount=" + recCount + ", viewCount=" + viewCount + ", sup_Mon=" + sup_Mon
				+ ", userNick=" + userNick + "]";
	}











}
