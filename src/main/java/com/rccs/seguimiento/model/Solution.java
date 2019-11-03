package com.rccs.seguimiento.model;

import java.io.Serializable;

public class Solution implements Serializable{
	private static final long serialVersionUID = 195164455230418250L;
	
	private int solId;
	private String solName;
	private int cliId;
	
	public Solution() {
	}

	public Solution(int solId, String solName, int cliId) {
		this.solId = solId;
		this.solName = solName;
		this.cliId = cliId;
	}

	public int getSolId() {
		return solId;
	}

	public void setSolId(int solId) {
		this.solId = solId;
	}

	public String getSolName() {
		return solName;
	}

	public void setSolName(String solName) {
		this.solName = solName;
	}

	public int getCliId() {
		return cliId;
	}

	public void setCliId(int cliId) {
		this.cliId = cliId;
	}
	
	@Override
	public String toString() {
		return String.format("Solution [solId=%s, solName=%s, cliId=%s", solId, solName, cliId);
	}

}
