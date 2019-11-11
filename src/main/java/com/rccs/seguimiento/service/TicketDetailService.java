package com.rccs.seguimiento.service;

import java.util.List;

import com.rccs.seguimiento.dto.TicketDetailDto;
import com.rccs.seguimiento.dto.TicketDto;
import com.rccs.seguimiento.model.TicketDetail;

public interface TicketDetailService {
	List<TicketDetailDto> findByDetDtoTicket(TicketDto tdto);
	List<TicketDetail> findByResposableId(int respId);
	long save(TicketDetailDto t);
	long update(TicketDetailDto t);
	long delete(TicketDetailDto t);
	
	
}
