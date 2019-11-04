package com.rccs.seguimiento.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.rccs.seguimiento.model.TicketDetail;
import com.rccs.seguimiento.utils.Constants;

public class TicketDetailDto implements Serializable{
	private static final long serialVersionUID = -5992524161119689182L;
	
	private TicketDetail ticketDetail;
	private String dtkStatusSt;
	private String dtkRpsName;
	private String dtkRpsLastName;
	private String dtkCmpName;
	
	public TicketDetailDto() {
	}

	public TicketDetailDto(TicketDetail ticketDetail, String dtkStatusSt, String dtkRpsName, String dtkRpsLastName,
			String dtkCmpName) {
		this.ticketDetail = ticketDetail;
		this.dtkStatusSt = dtkStatusSt;
		this.dtkRpsName = dtkRpsName;
		this.dtkRpsLastName = dtkRpsLastName;
		this.dtkCmpName = dtkCmpName;
	}


	public TicketDetail getTicketDetail() {
		return ticketDetail;
	}

	public void setTicketDetail(TicketDetail ticketDetail) {
		this.ticketDetail = ticketDetail;
	}

	public String getDtkStatusSt() {
		return dtkStatusSt;
	}

	public void setDtkStatusSt(String dtkStatusSt) {
		this.dtkStatusSt = dtkStatusSt;
	}
	
	public String getDtkRpsName() {
		return dtkRpsName;
	}

	public void setDtkRpsName(String dtkRpsName) {
		this.dtkRpsName = dtkRpsName;
	}

	public String getDtkRpsLastName() {
		return dtkRpsLastName;
	}

	public void setDtkRpsLastName(String dtkRpsLastName) {
		this.dtkRpsLastName = dtkRpsLastName;
	}

	public String getDtkCmpName() {
		return dtkCmpName;
	}

	public void setDtkCmpName(String dtkCmpName) {
		this.dtkCmpName = dtkCmpName;
	}

	public static TicketDetailDto entityToDto(TicketDetail entity) {
		TicketDetailDto ticketDto = new TicketDetailDto();
		ticketDto.setTicketDetail(entity);
		ticketDto.setDtkStatusSt(Constants.DTCK_STATUS.get(entity.getDtkStatus()));
		return ticketDto;
	}
	
	public static List<TicketDetailDto> listEntityToDto(List<TicketDetail> listEntity) {
		List<TicketDetailDto> list = new ArrayList<TicketDetailDto>();
		for (TicketDetail entity : listEntity) {
			list.add(entityToDto(entity));
		}
		return list;
	}

	@Override
	public String toString() {
		return String.format("TicketDetailDto [ticketDetail=%s, dtkStatusSt=%s", ticketDetail.toString(), dtkStatusSt);
	}
}
