package com.YE.rest.practice.practice.HW;

public class HWBean  {
	private String message;
	

	@Override
	public String toString() {
		return "HWBean [message=" + message + "]";
	}

	public HWBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
