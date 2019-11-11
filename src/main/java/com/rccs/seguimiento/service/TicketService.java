package com.rccs.seguimiento.service;

import java.util.List;

import com.rccs.seguimiento.dto.TicketDto;
import com.rccs.seguimiento.model.Ticket;

public interface TicketService {
	List<TicketDto> findByCode(String code);
	
	long save(Ticket t);
	
	long update(Ticket t);
	
	long delete(Ticket t);
}
