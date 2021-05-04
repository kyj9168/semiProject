package com.kh.semi.dog.model.vo;

public class Dog {

	private int entNo;
	private String dogNm;
	private int dogAge;
	private String dogGender;
	private String dogKind;
	private int dogWeight;
	private int dogHeight;
	private String inoYn;
	private String disYn;
	private String operYn;
	private String allegy;
	private String dogHobby;
	private String dogBark;
	private String dogBowel;
	private String dogAct;
	private String seperate;
	private String furColor;
	private String obYn;
	private String regYn;
	private String dogChar;
	private int entAppNo;
	private String dogSit;

	public Dog() {}

	public Dog(int entNo, String dogNm, int dogAge, String dogGender, String dogKind, int dogWeight, int dogHeight,
			String inoYn, String disYn, String operYn, String allegy, String dogHobby, String dogBark, String dogBowel,
			String dogAct, String seperate, String furColor, String obYn, String regYn, String dogChar, int entAppNo,
			String dogSit) {
		super();
		this.entNo = entNo;
		this.dogNm = dogNm;
		this.dogAge = dogAge;
		this.dogGender = dogGender;
		this.dogKind = dogKind;
		this.dogWeight = dogWeight;
		this.dogHeight = dogHeight;
		this.inoYn = inoYn;
		this.disYn = disYn;
		this.operYn = operYn;
		this.allegy = allegy;
		this.dogHobby = dogHobby;
		this.dogBark = dogBark;
		this.dogBowel = dogBowel;
		this.dogAct = dogAct;
		this.seperate = seperate;
		this.furColor = furColor;
		this.obYn = obYn;
		this.regYn = regYn;
		this.dogChar = dogChar;
		this.entAppNo = entAppNo;
		this.dogSit = dogSit;
	}

	public int getEntNo() {
		return entNo;
	}

	public void setEntNo(int entNo) {
		this.entNo = entNo;
	}

	public String getDogNm() {
		return dogNm;
	}

	public void setDogNm(String dogNm) {
		this.dogNm = dogNm;
	}

	public int getDogAge() {
		return dogAge;
	}

	public void setDogAge(int dogAge) {
		this.dogAge = dogAge;
	}

	public String getDogGender() {
		return dogGender;
	}

	public void setDogGender(String dogGender) {
		this.dogGender = dogGender;
	}

	public String getDogKind() {
		return dogKind;
	}

	public void setDogKind(String dogKind) {
		this.dogKind = dogKind;
	}

	public int getDogWeight() {
		return dogWeight;
	}

	public void setDogWeight(int dogWeight) {
		this.dogWeight = dogWeight;
	}

	public int getDogHeight() {
		return dogHeight;
	}

	public void setDogHeight(int dogHeight) {
		this.dogHeight = dogHeight;
	}

	public String getInoYn() {
		return inoYn;
	}

	public void setInoYn(String inoYn) {
		this.inoYn = inoYn;
	}

	public String getDisYn() {
		return disYn;
	}

	public void setDisYn(String disYn) {
		this.disYn = disYn;
	}

	public String getOperYn() {
		return operYn;
	}

	public void setOperYn(String operYn) {
		this.operYn = operYn;
	}

	public String getAllegy() {
		return allegy;
	}

	public void setAllegy(String allegy) {
		this.allegy = allegy;
	}

	public String getDogHobby() {
		return dogHobby;
	}

	public void setDogHobby(String dogHobby) {
		this.dogHobby = dogHobby;
	}

	public String getDogBark() {
		return dogBark;
	}

	public void setDogBark(String dogBark) {
		this.dogBark = dogBark;
	}

	public String getDogBowel() {
		return dogBowel;
	}

	public void setDogBowel(String dogBowel) {
		this.dogBowel = dogBowel;
	}

	public String getDogAct() {
		return dogAct;
	}

	public void setDogAct(String dogAct) {
		this.dogAct = dogAct;
	}

	public String getSeperate() {
		return seperate;
	}

	public void setSeperate(String seperate) {
		this.seperate = seperate;
	}

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	public String getObYn() {
		return obYn;
	}

	public void setObYn(String obYn) {
		this.obYn = obYn;
	}

	public String getRegYn() {
		return regYn;
	}

	public void setRegYn(String regYn) {
		this.regYn = regYn;
	}

	public String getDogChar() {
		return dogChar;
	}

	public void setDogChar(String dogChar) {
		this.dogChar = dogChar;
	}

	public int getEntAppNo() {
		return entAppNo;
	}

	public void setEntAppNo(int entAppNo) {
		this.entAppNo = entAppNo;
	}

	public String getDogSit() {
		return dogSit;
	}

	public void setDogSit(String dogSit) {
		this.dogSit = dogSit;
	}

	@Override
	public String toString() {
		return "Dog [entNo=" + entNo + ", dogNm=" + dogNm + ", dogAge=" + dogAge + ", dogGender=" + dogGender
				+ ", dogKind=" + dogKind + ", dogWeight=" + dogWeight + ", dogHeight=" + dogHeight + ", inoYn=" + inoYn
				+ ", disYn=" + disYn + ", operYn=" + operYn + ", allegy=" + allegy + ", dogHobby=" + dogHobby
				+ ", dogBark=" + dogBark + ", dogBowel=" + dogBowel + ", dogAct=" + dogAct + ", seperate=" + seperate
				+ ", furColor=" + furColor + ", obYn=" + obYn + ", regYn=" + regYn + ", dogChar=" + dogChar
				+ ", entAppNo=" + entAppNo + ", dogSit=" + dogSit + "]";
	}



}
