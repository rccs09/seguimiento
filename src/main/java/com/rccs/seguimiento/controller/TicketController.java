package com.rccs.seguimiento.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rccs.seguimiento.model.Ticket;
import com.rccs.seguimiento.model.TicketDetail;
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
	TicketDetailService ticketDetailService;
	
	private Ticket ticketFound;
	private List<Ticket> listFndTicket;
	private Ticket ticketEdit;
	private List<TicketDetail> listTicketDetail;
	
	
	public String findByCode(){
		listFndTicket = null;
		getListFndTicket();
		return null;
	}
	
	//metodos accesores
	public Ticket getTicketFound() {
		return ticketFound;
	}
	
	public void setTicketFound(Ticket ticketFound) {
		this.ticketFound = ticketFound;
	}
	
	public List<Ticket> getListFndTicket() {
		if(ticketFound == null){
			ticketFound = new Ticket();
			ticketFound.setTckCode("");
		}
		if(listFndTicket == null){
			listFndTicket = ticketService.findByCode(ticketFound.getTckCode());
		}
		return listFndTicket;
	}
	
	public List<TicketDetail> getListTicketDetail() {
		if(listTicketDetail == null){
			listTicketDetail = ticketDetailService.findByTicketId((int)ticketEdit.getTckId());
		}
		return listTicketDetail;
	}

	public void setListTicketDetail(List<TicketDetail> listTicketDetail) {
		this.listTicketDetail = listTicketDetail;
	}

	public void setListFndTicket(List<Ticket> listFndTicket) {
		this.listFndTicket = listFndTicket;
	}
	
	public Ticket getTicketEdit() {
		return ticketEdit;
	}
	
	public void setTicketEdit(Ticket ticketEdit) {
		this.ticketEdit = ticketEdit;
	}

}
