package com.rccs.seguimiento.model;

import java.io.Serializable;

public class Client implements Serializable{
	private static final long serialVersionUID = 5937926602477048448L;
	
	private int cliId;
	private String cliName;

	public Client() {
	}

	public Client(int cliId, String cliName) {
		this.cliId = cliId;
		this.cliName = cliName;
	}

	public int getCliId() {
		return cliId;
	}

	public void setCliId(int cliId) {
		this.cliId = cliId;
	}

	public String getCliName() {
		return cliName;
	}

	public void setCliName(String cliName) {
		this.cliName = cliName;
	}

	@Override
	public String toString() {
		return String.format("Client [cliId=%s, cliName=%s", cliId, cliName);
	}
	

}
