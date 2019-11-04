package com.rccs.seguimiento.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rccs.seguimiento.dto.TicketDetailDto;
import com.rccs.seguimiento.dto.TicketDto;
import com.rccs.seguimiento.model.Ticket;
import com.rccs.seguimiento.model.TicketDetail;
import com.rccs.seguimiento.service.TicketDetailService;
import com.rccs.seguimiento.service.TicketService;

@Scope(value = "session")
@Component(value = "ticketDetalleController")
@ELBeanName(value = "ticketDetalleController")
@Join(path = "/detalle", to = "/detalles-form.jsf")
public class TicketDetalleController {
	@Autowired
	TicketDetailService ticketDetailService;
	
	private TicketDetailDto dticketEdit;
	private List<TicketDetailDto> listTicketDetail;
	
	
	public String findByCode(){
//		listFndTicket = null;
//		getListFndTicket();
		return null;
	}
	
	public String verDetalle(TicketDto tdto) {
		System.out.println("ENRAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//		ticketEdit = tdto;
		getListTicketDetail();
		return "verDetalle";
	}
	
	
	
	//metodos accesores
	public List<TicketDetailDto> getListTicketDetail() {
//		listTicketDetail = ticketDetailService.findByTicketId((int)ticketEdit.getTicket().getTckId());
		return listTicketDetail;
	}

	public void setListTicketDetail(List<TicketDetailDto> listTicketDetail) {
		this.listTicketDetail = listTicketDetail;
	}

	public TicketDetailService getTicketDetailService() {
		return ticketDetailService;
	}

	public void setTicketDetailService(TicketDetailService ticketDetailService) {
		this.ticketDetailService = ticketDetailService;
	}


}
