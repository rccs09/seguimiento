package com.rccs.seguimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rccs.seguimiento.dao.TicketDetailDao;
import com.rccs.seguimiento.model.TicketDetail;
import com.rccs.seguimiento.service.TicketDetailService;

@Service
public class TicketDetailServiceImpl implements TicketDetailService{
	@Autowired
	TicketDetailDao ticketDetailDao;
	
	@Override
	public List<TicketDetail> findByTicketId(int id) {
		return ticketDetailDao.findByTicketId(id);
	}
	
	@Override
	public List<TicketDetail> findByResposableId(int respId) {
		// TODO Auto-generated method stub
		return null;
	}

}
