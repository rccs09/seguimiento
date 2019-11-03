package com.rccs.seguimiento.model;

import java.io.Serializable;

public class Component implements Serializable{
	private static final long serialVersionUID = -2547494848500089788L;
	
	private int cmpId;
	private String cmpName;
	private int solId;

	public Component() {
	}

	public Component(int cmpId, String cmpName, int solId) {
		this.cmpId = cmpId;
		this.cmpName = cmpName;
		this.solId = solId;
	}

	public int getCmpId() {
		return cmpId;
	}

	public void setCmpId(int cmpId) {
		this.cmpId = cmpId;
	}

	public String getCmpName() {
		return cmpName;
	}

	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	public int getSolId() {
		return solId;
	}

	public void setSolId(int solId) {
		this.solId = solId;
	}

	@Override
	public String toString() {
		return String.format("Component [cmpId=%s, cmpName=%s, solId=%s", cmpId, cmpName, solId);
	}

}
