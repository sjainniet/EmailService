package com.sidj.mail;

import org.springframework.stereotype.Component;

@Component
public class ResMail {
	
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ResMail [result=" + result + "]";
	}
	

}
