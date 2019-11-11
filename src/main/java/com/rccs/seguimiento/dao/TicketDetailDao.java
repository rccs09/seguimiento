package com.rccs.seguimiento.dao;

import java.util.List;

import com.rccs.seguimiento.dto.TicketDetailDto;
import com.rccs.seguimiento.dto.TicketDto;
import com.rccs.seguimiento.model.TicketDetail;

public interface TicketDetailDao {
	List<TicketDetailDto> findByDetDtoTicket(TicketDto t);
	List<TicketDetail> findByTicketId(int id);
	List<TicketDetail> findByResposableId(int respId);
	long save(TicketDetailDto t);
	long update(TicketDetailDto t);
	long delete(TicketDetailDto t);
	
}
