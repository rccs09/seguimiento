package com.rccs.seguimiento.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rccs.seguimiento.model.Ticket;
import com.rccs.seguimiento.utils.Constants;

public class TicketDto implements Serializable{
	private static final long serialVersionUID = 3391633798486690829L;
	
	private Ticket ticket;
	private String tckTypeSt;
	private String tckStatusSt;
	private String tckFlowSt;
	private Date tckDateIniDt;
	private Date tckDateEndDt;
	private Date tckDateEndPlanDt;
	private String tckSolucion;
	
	public TicketDto() {
	}

	public TicketDto(Ticket ticket, String tckTypeSt, String tckStatusSt, String tckFlowSt, Date tckDateIniDt,
			Date tckDateEndDt, Date tckDateEndPlanDt, String tckSolucion) {
		this.ticket = ticket;
		this.tckTypeSt = tckTypeSt;
		this.tckStatusSt = tckStatusSt;
		this.tckFlowSt = tckFlowSt;
		this.tckDateIniDt = tckDateIniDt;
		this.tckDateEndDt = tckDateEndDt;
		this.tckDateEndPlanDt = tckDateEndPlanDt;
		this.tckSolucion = tckSolucion;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getTckTypeSt() {
		return tckTypeSt;
	}

	public void setTckTypeSt(String tckTypeSt) {
		this.tckTypeSt = tckTypeSt;
	}

	public String getTckStatusSt() {
		return tckStatusSt;
	}

	public void setTckStatusSt(String tckStatusSt) {
		this.tckStatusSt = tckStatusSt;
	}

	public String getTckFlowSt() {
		return tckFlowSt;
	}

	public void setTckFlowSt(String tckFlowSt) {
		this.tckFlowSt = tckFlowSt;
	}

	public Date getTckDateIniDt() {
		return tckDateIniDt;
	}

	public void setTckDateIniDt(Date tckDateIniDt) {
		this.tckDateIniDt = tckDateIniDt;
	}

	public Date getTckDateEndDt() {
		return tckDateEndDt;
	}

	public void setTckDateEndDt(Date tckDateEndDt) {
		this.tckDateEndDt = tckDateEndDt;
	}

	public Date getTckDateEndPlanDt() {
		return tckDateEndPlanDt;
	}

	public void setTckDateEndPlanDt(Date tckDateEndPlanDt) {
		this.tckDateEndPlanDt = tckDateEndPlanDt;
	}

	public String getTckSolucion() {
		return tckSolucion;
	}

	public void setTckSolucion(String tckSolucion) {
		this.tckSolucion = tckSolucion;
	}

	public static TicketDto entityToDto(Ticket entity) {
		TicketDto ticketDto = new TicketDto();
		ticketDto.setTicket(entity);
		ticketDto.setTckTypeSt(Constants.TCK_TYPE.get(entity.getTckType()));
		ticketDto.setTckStatusSt(Constants.TCK_STATUS.get(entity.getTckStatus()));
		ticketDto.setTckFlowSt(Constants.TCK_FLOW.get(entity.getTckFlow()));
		ticketDto.setTckDateIniDt(new Date(entity.getTckDateIni().getTime()));
		ticketDto.setTckDateEndDt(new Date(entity.getTckDateEnd().getTime()));
		ticketDto.setTckDateEndPlanDt(new Date(entity.getTckDateEndPlan().getTime()));
		return ticketDto;
	}
	
	public static List<TicketDto> listEntityToDto(List<Ticket> listEntity) {
		List<TicketDto> list = new ArrayList<TicketDto>();
		for (Ticket entity : listEntity) {
			list.add(entityToDto(entity));
		}
		return list;
	}
	
	@Override
	public String toString() {
		return String.format("TicketDto [ticket=%s, tckTypeSt=%s, tckStatusSt=%s, tckFlowSt=%s, tckSolucion=%s\""
				, ticket.toString(), tckTypeSt, tckStatusSt, tckFlowSt, tckSolucion);
	}

}
