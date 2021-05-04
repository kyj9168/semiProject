package com.kh.semi.board.free.model.vo;

import java.sql.Date;

public class UserBoardAttachment {

	private int attachmentNo;
   private String fileKind;
   private String originNm;
   private String changeNm;
   private String filePath;
   private Date uploadDt;
   private int adBoardno;
   private int boardNo;
   private int entNo;
   private String fileLevel;

   public UserBoardAttachment() {}

   public UserBoardAttachment(int attachmentNo, String fileKind, String originNm, String changeNm, String filePath,
         Date uploadDt, int adBoardno, int boardNo, int entNo, String fileLevel) {
      super();
      this.attachmentNo = attachmentNo;
      this.fileKind = fileKind;
      this.originNm = originNm;
      this.changeNm = changeNm;
      this.filePath = filePath;
      this.uploadDt = uploadDt;
      this.adBoardno = adBoardno;
      this.boardNo = boardNo;
      this.entNo = entNo;
      this.fileLevel = fileLevel;
   }

   public int getAttachmentNo() {
      return attachmentNo;
   }

   public void setAttachmentNo(int attachmentNo) {
      this.attachmentNo = attachmentNo;
   }

   public String getFileKind() {
      return fileKind;
   }

   public void setFileKind(String fileKind) {
      this.fileKind = fileKind;
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

   public int getAdBoardno() {
      return adBoardno;
   }

   public void setAdBoardno(int adBoardno) {
      this.adBoardno = adBoardno;
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

   public String getFileLevel() {
      return fileLevel;
   }

   public void setFileLevel(String fileLevel) {
      this.fileLevel = fileLevel;
   }







}