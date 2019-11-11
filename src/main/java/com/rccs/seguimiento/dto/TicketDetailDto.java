package com.rccs.seguimiento.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rccs.seguimiento.model.TicketDetail;
import com.rccs.seguimiento.utils.Constants;

public class TicketDetailDto implements Serializable{
	private static final long serialVersionUID = -5992524161119689182L;
	
	private TicketDetail ticketDetail;
	private TicketDto ticketDto;
	private String dtkStatusSt;
	private String dtkRpsName;
	private String dtkRpsLastName;
	private String dtkCmpName;
	
	private Date dtkDateIniDt;
	private Date dtkDateEndDt;
	private Date dtkDateEndPlanDt;
	
	public TicketDetailDto() {
	}

	public TicketDetailDto(TicketDetail ticketDetail, TicketDto ticketDto, String dtkStatusSt, String dtkRpsName,
			String dtkRpsLastName, String dtkCmpName, Date dtkDateIniDt, Date dtkDateEndDt, Date dtkDateEndPlanDt) {
		this.ticketDetail = ticketDetail;
		this.ticketDto = ticketDto;
		this.dtkStatusSt = dtkStatusSt;
		this.dtkRpsName = dtkRpsName;
		this.dtkRpsLastName = dtkRpsLastName;
		this.dtkCmpName = dtkCmpName;
		this.dtkDateIniDt = dtkDateIniDt;
		this.dtkDateEndDt = dtkDateEndDt;
		this.dtkDateEndPlanDt = dtkDateEndPlanDt;
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

	public TicketDto getTicketDto() {
		return ticketDto;
	}

	public void setTicketDto(TicketDto ticketDto) {
		this.ticketDto = ticketDto;
	}

	public Date getDtkDateIniDt() {
		return dtkDateIniDt;
	}

	public void setDtkDateIniDt(Date dtkDateIniDt) {
		this.dtkDateIniDt = dtkDateIniDt;
	}

	public Date getDtkDateEndDt() {
		return dtkDateEndDt;
	}

	public void setDtkDateEndDt(Date dtkDateEndDt) {
		this.dtkDateEndDt = dtkDateEndDt;
	}

	public Date getDtkDateEndPlanDt() {
		return dtkDateEndPlanDt;
	}

	public void setDtkDateEndPlanDt(Date dtkDateEndPlanDt) {
		this.dtkDateEndPlanDt = dtkDateEndPlanDt;
	}

	public static TicketDetailDto entityToDto(TicketDetail entity) {
		TicketDetailDto ticketDto = new TicketDetailDto();
		ticketDto.setTicketDetail(entity);
		ticketDto.setDtkStatusSt(Constants.DTCK_STATUS.get(entity.getDtkStatus()));
		ticketDto.setDtkDateIniDt(new Date(entity.getDtkDateIni().getTime()));
		ticketDto.setDtkDateEndDt(new Date(entity.getDtkDateEnd().getTime()));
		ticketDto.setDtkDateEndPlanDt(new Date(entity.getDtkDateEndPlan().getTime()));
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
