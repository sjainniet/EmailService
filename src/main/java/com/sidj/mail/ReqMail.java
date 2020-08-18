package com.sidj.mail;

import org.springframework.stereotype.Component;

@Component
public class ReqMail {
	
	private String mailTo;
	private String mailType;
	private String mailData;
	private int mailFile;
	private String filePath;
	
	
	public int getMailFile() {
		return mailFile;
	}
	public void setMailFile(int mailFile) {
		this.mailFile = mailFile;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getMailfile() {
		return mailFile;
	}
	public void setMailfile(int mailfile) {
		this.mailFile = mailfile;
	}
	public String getMailData() {
		return mailData;
	}
	public void setMailData(String mailData) {
		this.mailData = mailData;
	}
	public String getMailTo() {
		return mailTo;
	}
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	public String getMailType() {
		return mailType;
	}
	public void setMailType(String mailType) {
		this.mailType = mailType;
	}
	
	@Override
	public String toString() {
		return "ReqMail [mailTo=" + mailTo + ", mailType=" + mailType + ", mailData=" + mailData + ", mailFile="
				+ mailFile + ", filePath=" + filePath + "]";
	}
	
	

}
