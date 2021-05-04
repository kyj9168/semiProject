package com.kh.semi.user.model.vo;

import java.sql.Date;

public class User {

	private int userNo;
	private String userId;
	private String userNm;
	private String nickNm;
	private String email;
	private String phone;
	private Date userHb;
	private String gender;
	private String address;
	private String dogYn;
	private Date enrollDt;
	private Date leaveDt;
	private String userSit;
	private String userKind;
	private String userPwd;
	private String rtCd;
	private String leaveRsCd;
	private int statusNum;
	private String pwdHis;

	public User() {}



	public User(int userNo, String userId, String userNm, String nickNm, String email, String phone, Date userHb,
			String gender, String address, String dogYn, Date enrollDt, Date leaveDt, String userSit, String userKind,
			String userPwd, String rtCd, String leaveRsCd, int statusNum, String pwdHis) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userNm = userNm;
		this.nickNm = nickNm;
		this.email = email;
		this.phone = phone;
		this.userHb = userHb;
		this.gender = gender;
		this.address = address;
		this.dogYn = dogYn;
		this.enrollDt = enrollDt;
		this.leaveDt = leaveDt;
		this.userSit = userSit;
		this.userKind = userKind;
		this.userPwd = userPwd;
		this.rtCd = rtCd;
		this.leaveRsCd = leaveRsCd;
		this.statusNum = statusNum;
		this.pwdHis = pwdHis;
	}





	public String getPwdHis() {
		return pwdHis;
	}



	public void setPwdHis(String pwdHis) {
		this.pwdHis = pwdHis;
	}



	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getUserHb() {
		return userHb;
	}

	public void setUserHb(Date userHb) {
		this.userHb = userHb;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDogYn() {
		return dogYn;
	}

	public void setDogYn(String dogYn) {
		this.dogYn = dogYn;
	}

	public Date getEnrollDt() {
		return enrollDt;
	}

	public void setEnrollDt(Date enrollDt) {
		this.enrollDt = enrollDt;
	}

	public Date getLeaveDt() {
		return leaveDt;
	}

	public void setLeaveDt(Date leaveDt) {
		this.leaveDt = leaveDt;
	}

	public String getUserSit() {
		return userSit;
	}

	public void setUserSit(String userSit) {
		this.userSit = userSit;
	}

	public String getUserKind() {
		return userKind;
	}

	public void setUserKind(String userKind) {
		this.userKind = userKind;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getRtCd() {
		return rtCd;
	}

	public void setRtCd(String rtCd) {
		this.rtCd = rtCd;
	}

	public String getLeaveRsCd() {
		return leaveRsCd;
	}

	public void setLeaveRsCd(String leaveRsCd) {
		this.leaveRsCd = leaveRsCd;
	}

	public int getStatusNum() {
		return statusNum;
	}

	public void setStatusNum(int statusNum) {
		this.statusNum = statusNum;
	}

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", userId=" + userId + ", userNm=" + userNm + ", nickNm=" + nickNm
				+ ", email=" + email + ", phone=" + phone + ", userHb=" + userHb + ", gender=" + gender + ", address="
				+ address + ", dogYn=" + dogYn + ", enrollDt=" + enrollDt + ", leaveDt=" + leaveDt + ", userSit="
				+ userSit + ", userKind=" + userKind + ", userPwd=" + userPwd + ", rtCd=" + rtCd + ", leaveRsCd="
				+ leaveRsCd + ", statusNum=" + statusNum + "]";
	}



}
