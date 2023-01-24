package com.example.iSpanHotel.model;

import java.util.Objects;

public class EmailDetails {
	private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
    
	public EmailDetails(String recipient, String msgBody, String subject, String attachment) {
		super();
		this.recipient = recipient;
		this.msgBody = msgBody;
		this.subject = subject;
		this.attachment = attachment;
	}

	public EmailDetails() {
		
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "EmailDetails [recipient=" + recipient + ", msgBody=" + msgBody + ", subject=" + subject
				+ ", attachment=" + attachment + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(attachment, msgBody, recipient, subject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailDetails other = (EmailDetails) obj;
		return Objects.equals(attachment, other.attachment) && Objects.equals(msgBody, other.msgBody)
				&& Objects.equals(recipient, other.recipient) && Objects.equals(subject, other.subject);
	}
    
    
}
