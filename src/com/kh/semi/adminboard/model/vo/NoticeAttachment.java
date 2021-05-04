package com.kh.semi.adminboard.model.vo;

import java.sql.Date;

public class NoticeAttachment {
	private int attachmentNo;
	private String originNm;
	private String changeNm;
	private String filePath;
	private Date uploadDt;
	private int adBoardNo;
	private int boardNo;
	private int entNo;
	private String fileKind;
	private String fileLevel;
	
	public NoticeAttachment() {}
	
	

	public NoticeAttachment(int attachmentNo, String originNm, String changeNm, String filePath, Date uploadDt,
			int adBoardNo, int boardNo, int entNo, String fileKind, String fileLevel) {
		super();
		this.attachmentNo = attachmentNo;
		this.originNm = originNm;
		this.changeNm = changeNm;
		this.filePath = filePath;
		this.uploadDt = uploadDt;
		this.adBoardNo = adBoardNo;
		this.boardNo = boardNo;
		this.entNo = entNo;
		this.fileKind = fileKind;
		this.fileLevel = fileLevel;
	}



	public int getAttachmentNo() {
		return attachmentNo;
	}

	public void setAttachmentNo(int attachmentNo) {
		this.attachmentNo = attachmentNo;
	}

	public String getOriginNm() {
		return originNm;
	}

	public void setOriginNm(String originNm) {
		this.originNm = originNm;
	}

	public String getChangeNm() {
		return changeNm;
	}

	public void setChangeNm(String changeNm) {
		this.changeNm = changeNm;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDt() {
		return uploadDt;
	}

	public void setUploadDt(Date uploadDt) {
		this.uploadDt = uploadDt;
	}

	public int getAdBoardNo() {
		return adBoardNo;
	}

	public void setAdBoardNo(int adBoardNo) {
		this.adBoardNo = adBoardNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getEntNo() {
		return entNo;
	}

	public void setEntNo(int entNo) {
		this.entNo = entNo;
	}

	public String getFileKind() {
		return fileKind;
	}

	public void setFileKind(String fileKind) {
		this.fileKind = fileKind;
	}

	public String getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(String fileLevel) {
		this.fileLevel = fileLevel;
	}



	@Override
	public String toString() {
		return "NoticeAttachment [attachmentNo=" + attachmentNo + ", originNm=" + originNm + ", changeNm=" + changeNm
				+ ", filePath=" + filePath + ", uploadDt=" + uploadDt + ", adBoardNo=" + adBoardNo + ", boardNo="
				+ boardNo + ", entNo=" + entNo + ", fileKind=" + fileKind + ", fileLevel=" + fileLevel + "]";
	}
	
	
	
	
}
