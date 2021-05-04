package com.kh.semi.adminboard.model.vo;

import java.sql.Date;

public class AdminComment implements java.io.Serializable{


	private int bNo;
	private String bKind;
	private String bNm;
	private Date bDate;
	private String bCon;
	private int inqCon;
	private int recCon;
	private int sGrade;
	private int uNo;
	private String status;
	private int boardNo;
	private String missPlace;
	private Date missDt;
	private String missGender;
	private String missPhone;
	private String boardDiv;
	private int rewardPc;
	private String bUserNick;
private String cCon;
private int re;
private int cNo;




	public AdminComment() {}




	public AdminComment(int bNo, String bKind, String bNm, Date bDate, String bCon, int inqCon, int recCon, int sGrade,
			int uNo, String status, int boardNo, String missPlace, Date missDt, String missGender, String missPhone,
			String boardDiv, int rewardPc, String bUserNick,String cCon,int cNo,int re) {
		super();
		this.bNo = bNo;
		this.bKind = bKind;
		this.bNm = bNm;
		this.bDate = bDate;
		this.bCon = bCon;
		this.inqCon = inqCon;
		this.recCon = recCon;
		this.sGrade = sGrade;
		this.uNo = uNo;
		this.status = status;
		this.boardNo = boardNo;
		this.missPlace = missPlace;
		this.missDt = missDt;
		this.missGender = missGender;
		this.missPhone = missPhone;
		this.boardDiv = boardDiv;
		this.rewardPc = rewardPc;
		this.bUserNick = bUserNick;
		this.cCon=cCon;
		this.cNo=cNo;
		this.re=re;
		
	}




	public String getcCon() {
		return cCon;
	}




	public void setcCon(String cCon) {
		this.cCon = cCon;
	}




	public int getbNo() {
		return bNo;
	}




	public void setbNo(int bNo) {
		this.bNo = bNo;
	}




	public String getbKind() {
		return bKind;
	}




	public void setbKind(String bKind) {
		this.bKind = bKind;
	}




	public String getbNm() {
		return bNm;
	}




	public void setbNm(String bNm) {
		this.bNm = bNm;
	}




	public Date getbDate() {
		return bDate;
	}




	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}




	public String getbCon() {
		return bCon;
	}




	public void setbCon(String bCon) {
		this.bCon = bCon;
	}




	public int getInqCon() {
		return inqCon;
	}




	public void setInqCon(int inqCon) {
		this.inqCon = inqCon;
	}




	public int getRecCon() {
		return recCon;
	}




	public void setRecCon(int recCon) {
		this.recCon = recCon;
	}




	public int getsGrade() {
		return sGrade;
	}




	public void setsGrade(int sGrade) {
		this.sGrade = sGrade;
	}




	public int getuNo() {
		return uNo;
	}




	public void setuNo(int uNo) {
		this.uNo = uNo;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public int getBoardNo() {
		return boardNo;
	}




	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}




	public String getMissPlace() {
		return missPlace;
	}




	public void setMissPlace(String missPlace) {
		this.missPlace = missPlace;
	}




	public Date getMissDt() {
		return missDt;
	}




	public void setMissDt(Date missDt) {
		this.missDt = missDt;
	}




	public String getMissGender() {
		return missGender;
	}




	public void setMissGender(String missGender) {
		this.missGender = missGender;
	}




	public String getMissPhone() {
		return missPhone;
	}




	public void setMissPhone(String missPhone) {
		this.missPhone = missPhone;
	}




	public String getBoardDiv() {
		return boardDiv;
	}




	public void setBoardDiv(String boardDiv) {
		this.boardDiv = boardDiv;
	}




	public int getRewardPc() {
		return rewardPc;
	}




	public void setRewardPc(int rewardPc) {
		this.rewardPc = rewardPc;
	}




	public String getbUserNick() {
		return bUserNick;
	}




	public void setbUserNick(String bUserNick) {
		this.bUserNick = bUserNick;
	}




	public int getRe() {
	return re;
}




public void setRe(int re) {
	this.re = re;
}




	public int getcNo() {
	return cNo;
}




public void setcNo(int cNo) {
	this.cNo = cNo;
}



	@Override
	public String toString() {
		return "UserBoard [bNo=" + bNo + ", bKind=" + bKind + ", bNm=" + bNm + ", bDate=" + bDate + ", bCon=" + bCon
				+ ", inqCon=" + inqCon + ", recCon=" + recCon + ", sGrade=" + sGrade + ", uNo=" + uNo + ", status="
				+ status + ", boardNo=" + boardNo + ", missPlace=" + missPlace + ", missDt=" + missDt + ", missGender="
				+ missGender + ", missPhone=" + missPhone + ", boardDiv=" + boardDiv + ", rewardPc=" + rewardPc
				+ ", bUserNick=" + bUserNick + "]";
	}





}
