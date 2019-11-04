package com.rccs.seguimiento.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rccs.seguimiento.dto.TicketDetailDto;
import com.rccs.seguimiento.dto.TicketDto;
import com.rccs.seguimiento.model.Solution;
import com.rccs.seguimiento.model.Ticket;
import com.rccs.seguimiento.service.SolutionService;
import com.rccs.seguimiento.service.TicketDetailService;
import com.rccs.seguimiento.service.TicketService;

@Scope(value = "session")
@Component(value = "ticketController")
@ELBeanName(value = "ticketController")
@Join(path = "/page/admin/tickets/list", to = "/page/admin/tickets/list-form.jsf")
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@Autowired
	SolutionService solutionService;
	
	@Autowired
	TicketDetailService ticketDetailService;
	
	private TicketDto ticketFound;
	private List<TicketDto> listFndTicket;
	private TicketDto ticketEdit;
	private List<TicketDetailDto> listTicketDetail;
	private List<Solution> listSolution;
	private Integer tckFlagNew;
	
	
	public String findByCode(){
		listFndTicket = null;
		getListFndTicket();
		return null;
	}
	
	public String findReset(){
		listFndTicket = null;
		ticketFound = null;
		getListFndTicket();
		return null;
	}
	
	public String verDetalle(TicketDto tdto) {
		ticketEdit = tdto;
		getListTicketDetail();
		return "verDetalle";
	}
	
	public String returnList() {
		ticketEdit = null;
		getListFndTicket();
		return "returnList";
	}
	
	// Metodos para ticket
	public String irNuevoTicket() {
		tckFlagNew = 0;
		Ticket t = new Ticket();
//		t.setTckType(-1);
//		t.setTckStatus(-1);
//		t.setTckFlow(-1);
//		t.setSolId(-1);
		
		ticketEdit = new TicketDto();
		ticketEdit.setTicket(t);
		return "irNuevoTicket";
	}
	
	public String irEditarTicket(TicketDto tdto) {
		tckFlagNew = 1;
		ticketEdit = tdto;
		ticketEdit.setTckDateIniDt(new Date(tdto.getTicket().getTckDateIni().getTime()));
		ticketEdit.setTckDateEndDt(new Date(tdto.getTicket().getTckDateEnd().getTime()));
		ticketEdit.setTckDateEndPlanDt(new Date(tdto.getTicket().getTckDateEndPlan().getTime()));
		return "irNuevoTicket";
	}
	
	public String cancelEditTicket() {
		ticketEdit = null;
		getListFndTicket();
		return "cancelNuevoTicket";
	}
	
	public String saveTicket() {
		ticketEdit.getTicket().setTckDateEndPlan(new Timestamp(ticketEdit.getTckDateEndPlanDt().getTime()));
		ticketEdit.getTicket().setTckDateIni(new Timestamp(ticketEdit.getTckDateIniDt().getTime()));
		ticketEdit.getTicket().setTckDateEnd(new Timestamp(ticketEdit.getTckDateEndDt().getTime()));
		ticketService.save(ticketEdit.getTicket());
		
		ticketFound = null;
		listFndTicket = null;
		
		//aqui guadar ticket
		getListFndTicket();
		return "cancelNuevoTicket";
	}
	
	public String updateTicket() {
		ticketEdit.getTicket().setTckDateEndPlan(new Timestamp(ticketEdit.getTckDateEndPlanDt().getTime()));
		ticketEdit.getTicket().setTckDateIni(new Timestamp(ticketEdit.getTckDateIniDt().getTime()));
		ticketEdit.getTicket().setTckDateEnd(new Timestamp(ticketEdit.getTckDateEndDt().getTime()));
		ticketService.update(ticketEdit.getTicket());
		
		ticketFound = null;
		listFndTicket = null;
		getListFndTicket();
		return "cancelNuevoTicket";
	}
	
	// Metodos para detalles
	public String irNuevoDetalle() {
//		ticketEdit = null;
//		getListFndTicket();
		return "irNuevoDetalle";
	}
	
	
	
	
	//metodos accesores
	public List<Solution> getListSolution() {
		if(listSolution == null || listSolution.size()==0) {
			listSolution = solutionService.allSolution();
		}
		return listSolution;
	}

	public void setListSolution(List<Solution> listSolution) {
		this.listSolution = listSolution;
	}
	
	public TicketDto getTicketFound() {
		return ticketFound;
	}
	
	public void setTicketFound(TicketDto ticketFound) {
		this.ticketFound = ticketFound;
	}
	
	public List<TicketDto> getListFndTicket() {
		if(ticketFound == null){
			ticketFound = new TicketDto();
			ticketFound.setTicket(new Ticket());
			ticketFound.getTicket().setTckCode("");
		}else if (ticketFound.getTicket()==null) {
			ticketFound.setTicket(new Ticket());
			ticketFound.getTicket().setTckCode("");
		}
		if(listFndTicket == null){
			listFndTicket = ticketService.findByCode(ticketFound.getTicket().getTckCode());
		}
		return listFndTicket;
	}
	
	public void setListFndTicket(List<TicketDto> listFndTicket) {
		this.listFndTicket = listFndTicket;
	}
	
	public List<TicketDetailDto> getListTicketDetail() {
		listTicketDetail = ticketDetailService.findByTicketId((int)ticketEdit.getTicket().getTckId());
		return listTicketDetail;
	}

	public void setListTicketDetail(List<TicketDetailDto> listTicketDetail) {
		this.listTicketDetail = listTicketDetail;
	}

	public TicketDto getTicketEdit() {
		return ticketEdit;
	}
	
	public void setTicketEdit(TicketDto ticketEdit) {
		this.ticketEdit = ticketEdit;
	}

	public Integer getTckFlagNew() {
		return tckFlagNew;
	}

	public void setTckFlagNew(Integer tckFlagNew) {
		this.tckFlagNew = tckFlagNew;
	}
	
}
