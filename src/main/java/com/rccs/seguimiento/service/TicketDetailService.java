package com.rccs.seguimiento.service;

import java.util.List;

import com.rccs.seguimiento.dto.TicketDetailDto;
import com.rccs.seguimiento.model.TicketDetail;

public interface TicketDetailService {
	List<TicketDetailDto> findByTicketId(int id);
	List<TicketDetail> findByResposableId(int respId);
}
