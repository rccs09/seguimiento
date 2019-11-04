package com.rccs.seguimiento.dao;

import java.util.List;

import com.rccs.seguimiento.dto.TicketDetailDto;
import com.rccs.seguimiento.model.TicketDetail;

public interface TicketDetailDao {
	List<TicketDetail> findByTicketId(int id);
	List<TicketDetailDto> findDtoByTicketId(int id);
	List<TicketDetail> findByResposableId(int respId);
}
