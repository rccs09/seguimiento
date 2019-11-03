package com.rccs.seguimiento.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class TicketDetail implements Serializable{
	private static final long serialVersionUID = -5992524161119689182L;
	
	private int dtkId;
	private int dtkStatus;
	private BigDecimal dtkStimated;
	private Timestamp dtkDateIni;
	private Timestamp dtkDateEnd;
	private Timestamp dtkDateEndPlan;
	private int rpsId;
	private int tckId;
	private int cmpId;
	
	public TicketDetail() {
	}

	public TicketDetail(int dtkId, int dtkStatus, BigDecimal dtkStimated, Timestamp dtkDateIni, Timestamp dtkDateEnd,
			Timestamp dtkDateEndPlan, int rpsId, int tckId, int cmpId) {
		this.dtkId = dtkId;
		this.dtkStatus = dtkStatus;
		this.dtkStimated = dtkStimated;
		this.dtkDateIni = dtkDateIni;
		this.dtkDateEnd = dtkDateEnd;
		this.dtkDateEndPlan = dtkDateEndPlan;
		this.rpsId = rpsId;
		this.tckId = tckId;
		this.cmpId = cmpId;
	}

	public int getDtkId() {
		return dtkId;
	}

	public void setDtkId(int dtkId) {
		this.dtkId = dtkId;
	}

	public int getDtkStatus() {
		return dtkStatus;
	}

	public void setDtkStatus(int dtkStatus) {
		this.dtkStatus = dtkStatus;
	}

	public BigDecimal getDtkStimated() {
		return dtkStimated;
	}

	public void setDtkStimated(BigDecimal dtkStimated) {
		this.dtkStimated = dtkStimated;
	}

	public Timestamp getDtkDateIni() {
		return dtkDateIni;
	}

	public void setDtkDateIni(Timestamp dtkDateIni) {
		this.dtkDateIni = dtkDateIni;
	}

	public Timestamp getDtkDateEnd() {
		return dtkDateEnd;
	}

	public void setDtkDateEnd(Timestamp dtkDateEnd) {
		this.dtkDateEnd = dtkDateEnd;
	}

	public Timestamp getDtkDateEndPlan() {
		return dtkDateEndPlan;
	}

	public void setDtkDateEndPlan(Timestamp dtkDateEndPlan) {
		this.dtkDateEndPlan = dtkDateEndPlan;
	}

	public int getRpsId() {
		return rpsId;
	}

	public void setRpsId(int rpsId) {
		this.rpsId = rpsId;
	}

	public int getTckId() {
		return tckId;
	}

	public void setTckId(int tckId) {
		this.tckId = tckId;
	}

	public int getCmpId() {
		return cmpId;
	}

	public void setCmpId(int cmpId) {
		this.cmpId = cmpId;
	}
	
	@Override
	public String toString() {
		return String.format("TicketDetail [dtkId=%s, dtkStatus=%s, dtkStimated=%s, dtkDateIni=%s, dtkDateEnd=%s"
				+ ", dtkDateEndPlan=%s, rpsId=%s, tckId=%s, cmpId=%s",
				dtkId, dtkStatus, dtkStimated, dtkDateIni, dtkDateEnd, dtkDateEndPlan, rpsId, tckId, cmpId);
	}


}
