package com.kh.semi.parcelout.model.vo;

public class Application {

	private String application;
	private String day;


	public Application() {}

	public Application(String application ,String day) {
		super();
		this.application = application;
		this.day = day;
	}
	public String getday() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}



}
