package com.rccs.seguimiento.model;

import java.io.Serializable;

public class Responsible implements Serializable{
	private static final long serialVersionUID = -8868511057055464236L;
	
	private int rpsId;
	private String rpsName;
	private String rpsLastName;
	private int prvId;

	public Responsible() {
	}

	public Responsible(int rpsId, String rpsName, String rpsLastName, int prvId) {
		this.rpsId = rpsId;
		this.rpsName = rpsName;
		this.rpsLastName = rpsLastName;
		this.prvId = prvId;
	}

	public int getRpsId() {
		return rpsId;
	}

	public void setRpsId(int rpsId) {
		this.rpsId = rpsId;
	}

	public String getRpsName() {
		return rpsName;
	}

	public void setRpsName(String rpsName) {
		this.rpsName = rpsName;
	}

	public String getRpsLastName() {
		return rpsLastName;
	}

	public void setRpsLastName(String rpsLastName) {
		this.rpsLastName = rpsLastName;
	}

	public int getPrvId() {
		return prvId;
	}

	public void setPrvId(int prvId) {
		this.prvId = prvId;
	}
	
	@Override
	public String toString() {
		return String.format("Responsible [rpsId=%s, rpsName=%s, rpsLastName=%s, prvId=%s", rpsId, rpsName, rpsLastName, prvId);
	}
}
