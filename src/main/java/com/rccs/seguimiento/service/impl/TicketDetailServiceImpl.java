package com.rccs.seguimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rccs.seguimiento.dao.TicketDetailDao;
import com.rccs.seguimiento.dto.TicketDetailDto;
import com.rccs.seguimiento.model.TicketDetail;
import com.rccs.seguimiento.service.TicketDetailService;

@Service
public class TicketDetailServiceImpl implements TicketDetailService{
	@Autowired
	TicketDetailDao ticketDetailDao;
	
	@Override
	public List<TicketDetailDto> findByTicketId(int id) {
		System.out.println("111111111111111111111111111111111");
//		List<TicketDetail> listEntity = ticketDetailDao.findByTicketId(id);
//		return TicketDetailDto.listEntityToDto(listEntity);
		return ticketDetailDao.findDtoByTicketId(id);
	}
	
	@Override
	public List<TicketDetail> findByResposableId(int respId) {
		// TODO Auto-generated method stub
		return null;
	}

}
