package com.ibcs.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMAIL_INFORMATION")
public class EmailInfo {

	@Id
	@Column(name = "emailNo")
	private int emailNo;
	public int getEmailNo() {
		return emailNo;
	}

	public void setEmailNo(int emailNo) {
		this.emailNo = emailNo;
	}

	@Column(name = "recipient")
	private String recipient;
	@Column(name = "subject")
	private String subject;
	@Column(name = "body_of_email")
	private String writtenInformation;

	public EmailInfo() {
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWrittenInformation() {
		return writtenInformation;
	}

	public void setWrittenInformation(String writtenInformation) {
		this.writtenInformation = writtenInformation;
	}

	@Override
	public String toString() {
		return "Email [emailNo=" + emailNo + ", recipint=" + recipient + ", subject=" + subject + ", writtenInformation="
				+ writtenInformation + "]";
	}


}
