package com.kh.semi.adminboard.model.vo;

import java.sql.Date;

public class AdminStatic implements java.io.Serializable{

	
	
	private String leave_cd;//탈퇴 코드
	private Date enroll_dt; //회원 가입일자
	private String can_cd; //후원끊는 코드
	private String dog_kind; //분양견 종류
	private int dog_age; //분양견 나이
	private String rt_cd; //회원가입 경로 코드	
	


	public AdminStatic() {}



	public AdminStatic(String leave_cd, Date enroll_dt, String can_cd, String dog_kind, int dog_age, String rt_cd) {
		super();
		this.leave_cd = leave_cd;
		this.enroll_dt = enroll_dt;
		this.can_cd = can_cd;
		this.dog_kind = dog_kind;
		this.dog_age = dog_age;
		this.rt_cd = rt_cd;
	}



	public String getLeave_cd() {
		return leave_cd;
	}



	public void setLeave_cd(String leave_cd) {
		this.leave_cd = leave_cd;
	}



	public Date getEnroll_dt() {
		return enroll_dt;
	}



	public void setEnroll_dt(Date enroll_dt) {
		this.enroll_dt = enroll_dt;
	}



	public String getCan_cd() {
		return can_cd;
	}



	public void setCan_cd(String can_cd) {
		this.can_cd = can_cd;
	}



	public String getDog_kind() {
		return dog_kind;
	}



	public void setDog_kind(String dog_kind) {
		this.dog_kind = dog_kind;
	}



	public int getDog_age() {
		return dog_age;
	}



	public void setDog_age(int dog_age) {
		this.dog_age = dog_age;
	}



	public String getRt_cd() {
		return rt_cd;
	}



	public void setRt_cd(String rt_cd) {
		this.rt_cd = rt_cd;
	}
	
	
	
	

}
