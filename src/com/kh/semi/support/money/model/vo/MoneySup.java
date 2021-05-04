package com.kh.semi.support.money.model.vo;

import java.sql.Date;

public class MoneySup {

	private int supAppNo;
	private int userNo;
	private int supPc;
	private Date supDt;
	private String supKind;
	private String regSupDate;
	private String billKey;
	private int approvalNo;
	private String status;
	private String userNm;
	private String NickNm;

	public MoneySup() {}



	public MoneySup(int supAppNo, int userNo, int supPc, Date supDt, String supKind, String regSupDate, String billKey,
			int approvalNo, String status, String userNm, String nickNm) {
		super();
		this.supAppNo = supAppNo;
		this.userNo = userNo;
		this.supPc = supPc;
		this.supDt = supDt;
		this.supKind = supKind;
		this.regSupDate = regSupDate;
		this.billKey = billKey;
		this.approvalNo = approvalNo;
		this.status = status;
		this.userNm = userNm;
		NickNm = nickNm;
	}



	public int getSupAppNo() {
		return supAppNo;
	}

	public void setSupAppNo(int supAppNo) {
		this.supAppNo = supAppNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getSupPc() {
		return supPc;
	}

	public void setSupPc(int supPc) {
		this.supPc = supPc;
	}

	public Date getSupDt() {
		return supDt;
	}

	public void setSupDt(Date supDt) {
		this.supDt = supDt;
	}

	public String getSupKind() {
		return supKind;
	}

	public void setSupKind(String supKind) {
		this.supKind = supKind;
	}

	public String getRegSupDate() {
		return regSupDate;
	}

	public void setRegSupDate(String regSupDate) {
		this.regSupDate = regSupDate;
	}

	public String getBillKey() {
		return billKey;
	}

	public void setBillKey(String billKey) {
		this.billKey = billKey;
	}

	public int getApprovalNo() {
		return approvalNo;
	}

	public void setApprovalNo(int approvalNo) {
		this.approvalNo = approvalNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getUserNm() {
		return userNm;
	}



	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}



	public String getNickNm() {
		return NickNm;
	}



	public void setNickNm(String nickNm) {
		NickNm = nickNm;
	}



	@Override
	public String toString() {
		return "MoneySup [supAppNo=" + supAppNo + ", userNo=" + userNo + ", supPc=" + supPc + ", supDt=" + supDt
				+ ", supKind=" + supKind + ", regSupDate=" + regSupDate + ", billKey=" + billKey + ", approvalNo="
				+ approvalNo + ", status=" + status + "]";
	}


}
