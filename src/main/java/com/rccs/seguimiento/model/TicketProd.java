package com.rccs.seguimiento.model;

import java.io.Serializable;

public class TicketProd implements Serializable{
	private static final long serialVersionUID = 2472181424308909775L;
	
	private int tpdId;
	private String tpdCode;
	private String tpdUrl;
	private String tpdVersion;
	private int tpdStatus;
	private String tpdComment;
	private int dtkId;
	
	public TicketProd() {
	}

	public TicketProd(int tpdId, String tpdCode, String tpdUrl, String tpdVersion, int tpdStatus, String tpdComment,
			int dtkId) {
		this.tpdId = tpdId;
		this.tpdCode = tpdCode;
		this.tpdUrl = tpdUrl;
		this.tpdVersion = tpdVersion;
		this.tpdStatus = tpdStatus;
		this.tpdComment = tpdComment;
		this.dtkId = dtkId;
	}

	public int getTpdId() {
		return tpdId;
	}

	public void setTpdId(int tpdId) {
		this.tpdId = tpdId;
	}

	public String getTpdCode() {
		return tpdCode;
	}

	public void setTpdCode(String tpdCode) {
		this.tpdCode = tpdCode;
	}

	public String getTpdUrl() {
		return tpdUrl;
	}

	public void setTpdUrl(String tpdUrl) {
		this.tpdUrl = tpdUrl;
	}

	public String getTpdVersion() {
		return tpdVersion;
	}

	public void setTpdVersion(String tpdVersion) {
		this.tpdVersion = tpdVersion;
	}

	public int getTpdStatus() {
		return tpdStatus;
	}

	public void setTpdStatus(int tpdStatus) {
		this.tpdStatus = tpdStatus;
	}

	public String getTpdComment() {
		return tpdComment;
	}

	public void setTpdComment(String tpdComment) {
		this.tpdComment = tpdComment;
	}

	public int getDtkId() {
		return dtkId;
	}

	public void setDtkId(int dtkId) {
		this.dtkId = dtkId;
	}

	@Override
	public String toString() {
		return String.format("TicketProd [tpdId=%s, tpdCode=%s, tpdUrl=%s, tpdVersion=%s, tpdStatus=%s"
				+ ", tpdComment=%s, dtkId=%s", tpdId, tpdCode, tpdUrl, tpdVersion, tpdStatus, tpdComment, dtkId);
	}
	
}
