package com.rccs.seguimiento.model;

import java.io.Serializable;

public class TicketQa implements Serializable{
	private static final long serialVersionUID = 3620685959752156835L;
	
	private int tqaId;
	private String tqaCode;
	private String tqaUrl;
	private int tqaCycle;
	private String tqaVersion;
	private int tqaStatus;
	private String tqaComment;
	private int dtkId;
	
	public TicketQa() {
	}

	public TicketQa(int tqaId, String tqaCode, String tqaUrl, int tqaCycle, String tqaVersion, int tqaStatus,
			String tqaComment, int dtkId) {
		this.tqaId = tqaId;
		this.tqaCode = tqaCode;
		this.tqaUrl = tqaUrl;
		this.tqaCycle = tqaCycle;
		this.tqaVersion = tqaVersion;
		this.tqaStatus = tqaStatus;
		this.tqaComment = tqaComment;
		this.dtkId = dtkId;
	}

	public int getTqaId() {
		return tqaId;
	}

	public void setTqaId(int tqaId) {
		this.tqaId = tqaId;
	}

	public String getTqaCode() {
		return tqaCode;
	}

	public void setTqaCode(String tqaCode) {
		this.tqaCode = tqaCode;
	}

	public String getTqaUrl() {
		return tqaUrl;
	}

	public void setTqaUrl(String tqaUrl) {
		this.tqaUrl = tqaUrl;
	}

	public int getTqaCycle() {
		return tqaCycle;
	}

	public void setTqaCycle(int tqaCycle) {
		this.tqaCycle = tqaCycle;
	}

	public String getTqaVersion() {
		return tqaVersion;
	}

	public void setTqaVersion(String tqaVersion) {
		this.tqaVersion = tqaVersion;
	}

	public int getTqaStatus() {
		return tqaStatus;
	}

	public void setTqaStatus(int tqaStatus) {
		this.tqaStatus = tqaStatus;
	}

	public String getTqaComment() {
		return tqaComment;
	}

	public void setTqaComment(String tqaComment) {
		this.tqaComment = tqaComment;
	}

	public int getDtkId() {
		return dtkId;
	}

	public void setDtkId(int dtkId) {
		this.dtkId = dtkId;
	}

	@Override
	public String toString() {
		return String.format("TicketQa [tqaId=%s, tqaCode=%s, tqaUrl=%s, tqaCycle=%s, tqaVersion=%s, tqaStatus=%s"
				+ ", tqaComment=%s, dtkId=%s", tqaId, tqaCode, tqaUrl, tqaCycle, tqaVersion, tqaStatus, tqaComment
				, dtkId);
	}
	
}
