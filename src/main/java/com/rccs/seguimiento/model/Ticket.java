package com.rccs.seguimiento.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Ticket implements Serializable{
	private static final long serialVersionUID = 4687222276703745966L;
	
	private int tckId;
	private String tckCode;
	private String tckUrl;
	private int tckType;
	private int tckStatus;
	private int tckFlow;
	private BigDecimal tckStimated;
	private Timestamp tckDateIni;
	private Timestamp tckDateEnd;
	private Timestamp tckDateEndPlan;
	private int solId;

	public Ticket() {
	}

	public Ticket(int tckId, String tckCode, String tckUrl, int tckType, int tckStatus, int tckFlow,
			BigDecimal tckStimated, Timestamp tckDateIni, Timestamp tckDateEnd, Timestamp tckDateEndPlan, int solId) {
		this.tckId = tckId;
		this.tckCode = tckCode;
		this.tckUrl = tckUrl;
		this.tckType = tckType;
		this.tckStatus = tckStatus;
		this.tckFlow = tckFlow;
		this.tckStimated = tckStimated;
		this.tckDateIni = tckDateIni;
		this.tckDateEnd = tckDateEnd;
		this.tckDateEndPlan = tckDateEndPlan;
		this.solId = solId;
	}

	public int getTckId() {
		return tckId;
	}

	public void setTckId(int tckId) {
		this.tckId = tckId;
	}

	public String getTckCode() {
		return tckCode;
	}

	public void setTckCode(String tckCode) {
		this.tckCode = tckCode;
	}

	public String getTckUrl() {
		return tckUrl;
	}

	public void setTckUrl(String tckUrl) {
		this.tckUrl = tckUrl;
	}

	public int getTckType() {
		return tckType;
	}

	public void setTckType(int tckType) {
		this.tckType = tckType;
	}

	public int getTckStatus() {
		return tckStatus;
	}

	public void setTckStatus(int tckStatus) {
		this.tckStatus = tckStatus;
	}

	public int getTckFlow() {
		return tckFlow;
	}

	public void setTckFlow(int tckFlow) {
		this.tckFlow = tckFlow;
	}

	public BigDecimal getTckStimated() {
		return tckStimated;
	}

	public void setTckStimated(BigDecimal tckStimated) {
		this.tckStimated = tckStimated;
	}

	public Timestamp getTckDateIni() {
		return tckDateIni;
	}

	public void setTckDateIni(Timestamp tckDateIni) {
		this.tckDateIni = tckDateIni;
	}

	public Timestamp getTckDateEnd() {
		return tckDateEnd;
	}

	public void setTckDateEnd(Timestamp tckDateEnd) {
		this.tckDateEnd = tckDateEnd;
	}

	public Timestamp getTckDateEndPlan() {
		return tckDateEndPlan;
	}

	public void setTckDateEndPlan(Timestamp tckDateEndPlan) {
		this.tckDateEndPlan = tckDateEndPlan;
	}

	public int getSolId() {
		return solId;
	}

	public void setSolId(int solId) {
		this.solId = solId;
	}

	@Override
	public String toString() {
		return String.format("Ticket [tckId=%s, tckCode=%s, tckUrl=%s, tckType=%s, tckStatus=%s, tckFlow=%s"
				+ ", tckStimated=%s, tckDateIni=%s, tckDateEnd=%s, tckDateEndPlan=%s, solId=%s"
				, tckId, tckCode, tckUrl, tckType, tckStatus, tckFlow, tckStimated, tckDateIni
				, tckDateEnd, tckDateEndPlan, solId);
	}

}
