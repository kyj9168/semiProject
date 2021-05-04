package com.kh.semi.parcelout.model.vo;

public class ParcelOutQuestion {
	
	private String quCd; 
	private String quCon; 
	private String quKind; 
	
	public ParcelOutQuestion() {}
	
	public ParcelOutQuestion(String quCd,String quCon,String quKind) {
		
		super();
		this.quCd=quCd;
		this.quCon=quCon;
		this.quKind=quKind;
	}

	public String getQuCd() {
		return quCd;
	}

	public void setQuCd(String quCd) {
		this.quCd = quCd;
	}

	public String getQuCon() {
		return quCon;
	}

	public void setQuCon(String quCon) {
		this.quCon = quCon;
	}

	public String getQuKind() {
		return quKind;
	}

	public void setQuKind(String quKind) {
		this.quKind = quKind;
	}

	@Override
	public String toString() {
		return "ParcelOutQuestion [quCd=" + quCd + ", quCon=" + quCon + ", quKind=" + quKind + "]";
	}
	
	

}
