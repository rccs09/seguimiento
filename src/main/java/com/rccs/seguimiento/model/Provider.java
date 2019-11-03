package com.rccs.seguimiento.model;

import java.io.Serializable;

public class Provider implements Serializable {
	private static final long serialVersionUID = 6111729106333144058L;
	
	private int prvId;
	private String prvName;
	
	public Provider() {	}

	public Provider(int prvId, String prvName) {
		this.prvId = prvId;
		this.prvName = prvName;
	}

	public int getPrvId() {
		return prvId;
	}

	public void setPrvId(int prvId) {
		this.prvId = prvId;
	}

	public String getPrvName() {
		return prvName;
	}

	public void setPrvName(String prvName) {
		this.prvName = prvName;
	}
	
	@Override
	public String toString() {
		return String.format("Provider [prvId=%s, prvName=%s", prvId, prvName);
	}
	
}
