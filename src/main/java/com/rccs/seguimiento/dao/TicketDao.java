package com.rccs.seguimiento.dao;

import java.util.List;

import com.rccs.seguimiento.dto.TicketDto;
import com.rccs.seguimiento.model.Ticket;

public interface TicketDao {
	List<Ticket> findByCode(String code);
	
	List<TicketDto> findDtoByCode(String code);
	
	long save(Ticket t);
	
	long update(Ticket t);
	
}
