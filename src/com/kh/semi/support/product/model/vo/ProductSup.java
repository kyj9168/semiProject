package com.kh.semi.support.product.model.vo;

import java.sql.Date;

public class ProductSup {

	private int supPdNo;
	private String ctgCd;
	private String pdNm;
	private Date supDt;
	private int userNo;
	private String status;
	private String userNm;
	private String nickNm;

	public ProductSup() {}


	public ProductSup(int supPdNo, String ctgCd, String pdNm, Date supDt, int userNo, String status, String userNm,
			String nickNm) {
		super();
		this.supPdNo = supPdNo;
		this.ctgCd = ctgCd;
		this.pdNm = pdNm;
		this.supDt = supDt;
		this.userNo = userNo;
		this.status = status;
		this.userNm = userNm;
		this.nickNm = nickNm;
	}




	public String getUserNm() {
		return userNm;
	}


	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}


	public String getNickNm() {
		return nickNm;
	}


	public void setNickNm(String nickNm) {
		this.nickNm = nickNm;
	}


	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getSupPdNo() {
		return supPdNo;
	}

	public void setSupPdNo(int supPdNo) {
		this.supPdNo = supPdNo;
	}

	public String getCtgCd() {
		return ctgCd;
	}

	public void setCtgCd(String ctgCd) {
		this.ctgCd = ctgCd;
	}

	public String getPdNm() {
		return pdNm;
	}

	public void setPdNm(String pdNm) {
		this.pdNm = pdNm;
	}

	public Date getSupDt() {
		return supDt;
	}

	public void setSupDt(Date supDt) {
		this.supDt = supDt;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "ProductSup [supPdNo=" + supPdNo + ", ctgCd=" + ctgCd + ", pdNm=" + pdNm + ", supDt=" + supDt
				+ ", userNo=" + userNo + "]";
	}

}
