package com.rccs.seguimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rccs.seguimiento.dao.TicketDao;
import com.rccs.seguimiento.model.Ticket;
import com.rccs.seguimiento.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{
	@Autowired
	TicketDao ticketDao;
	
	@Override
	public List<Ticket> findByCode(String code) {
		return ticketDao.findByCode(code);
	}
	
	@Override
	public long save(Ticket t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public long update(Ticket t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
