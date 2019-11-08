package com.rccs.seguimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rccs.seguimiento.dao.TicketDao;
import com.rccs.seguimiento.dto.TicketDto;
import com.rccs.seguimiento.model.Ticket;
import com.rccs.seguimiento.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{
	@Autowired
	TicketDao ticketDao;
	
	@Override
	public List<TicketDto> findByCode(String code) {
		return ticketDao.findDtoByCode(code);
	}
	
	@Override
	public long save(Ticket t) {
		return ticketDao.save(t);
	}
	
	@Override
	public long update(Ticket t) {
		return ticketDao.update(t);
	}
}
