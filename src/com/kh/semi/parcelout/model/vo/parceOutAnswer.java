package com.kh.semi.parcelout.model.vo;

import java.sql.Date;

public class parceOutAnswer {
	
	private int pcoAppNo;
	private int pcoQuNo;
	private Date ansDt;
	private String ansKind;
	private String ansCon;
	private String ansRs;
	private String quCd;
	private int opNo;
	
	public parceOutAnswer() {}
	
	public parceOutAnswer(int pcoAppNo,int pcoQuNo,Date ansDt,String ansKind,String ansCon,String ansRs,String quCd,int opNo ) {
		
		super();
		this.pcoAppNo=pcoAppNo;
		this.pcoQuNo=pcoQuNo;
		this.ansDt=ansDt;
		this.ansKind=ansKind;
		this.ansCon=ansCon;
		this.ansRs=ansRs;
		this.quCd=quCd;
		this.opNo=opNo;
	}

	public int getPcoAppNo() {
		return pcoAppNo;
	}

	public void setPcoAppNo(int pcoAppNo) {
		this.pcoAppNo = pcoAppNo;
	}

	public int getPcoQuNo() {
		return pcoQuNo;
	}

	public void setPcoQuNo(int pcoQuNo) {
		this.pcoQuNo = pcoQuNo;
	}

	public Date getAnsDt() {
		return ansDt;
	}

	public void setAnsDt(Date ansDt) {
		this.ansDt = ansDt;
	}

	public String getAnsKind() {
		return ansKind;
	}

	public void setAnsKind(String ansKind) {
		this.ansKind = ansKind;
	}

	public String getAnsCon() {
		return ansCon;
	}

	public void setAnsCon(String ansCon) {
		this.ansCon = ansCon;
	}

	public String getAnsRs() {
		return ansRs;
	}

	public void setAnsRs(String ansRs) {
		this.ansRs = ansRs;
	}

	public String getQuCd() {
		return quCd;
	}

	public void setQuCd(String quCd) {
		this.quCd = quCd;
	}

	public int getOpNo() {
		return opNo;
	}

	public void setOpNo(int opNo) {
		this.opNo = opNo;
	}

	@Override
	public String toString() {
		return "parceOutAnswer [pcoAppNo=" + pcoAppNo + ", pcoQuNo=" + pcoQuNo + ", ansDt=" + ansDt + ", ansKind="
				+ ansKind + ", ansCon=" + ansCon + ", ansRs=" + ansRs + ", quCd=" + quCd + ", opNo=" + opNo + "]";
	}
	
	

}
