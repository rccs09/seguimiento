package com.rccs.seguimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rccs.seguimiento.dao.TicketDetailDao;
import com.rccs.seguimiento.dto.TicketDetailDto;
import com.rccs.seguimiento.dto.TicketDto;
import com.rccs.seguimiento.model.TicketDetail;
import com.rccs.seguimiento.service.TicketDetailService;

@Service
public class TicketDetailServiceImpl implements TicketDetailService{
	@Autowired
	TicketDetailDao ticketDetailDao;
	
	@Override
	public List<TicketDetailDto> findByDetDtoTicket(TicketDto tdto) {
		return ticketDetailDao.findByDetDtoTicket(tdto);
	}
	
	@Override
	public List<TicketDetail> findByResposableId(int respId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long save(TicketDetailDto t) {
		ticketDetailDao.save(t);
		return 0;
	}

	@Override
	public long update(TicketDetailDto t) {
		ticketDetailDao.update(t);
		return 0;
	}

	@Override
	public long delete(TicketDetailDto t) {
		ticketDetailDao.delete(t);
		return 0;
	}

}
