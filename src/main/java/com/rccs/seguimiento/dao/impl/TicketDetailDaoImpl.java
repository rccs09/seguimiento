package com.rccs.seguimiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.rccs.seguimiento.dao.TicketDetailDao;
import com.rccs.seguimiento.mapper.TicketDetailMapper;
import com.rccs.seguimiento.model.TicketDetail;

@Repository
public class TicketDetailDaoImpl extends JdbcDaoSupport implements TicketDetailDao{
	private static final Logger logger = LoggerFactory.getLogger(TicketDetailDaoImpl.class);
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	TicketDetailMapper ticketDetailMapper;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public List<TicketDetail> findByTicketId(int id) {
		logger.info("Consulta detalles del ticket : " + id);
		String sql = "SELECT * FROM ticket_detail WHERE tck_id = ?";
		
		List<TicketDetail> result = new ArrayList<>();
		Object[] param = new Object[1];
		param[0] = new Integer(1);
		
		result = getJdbcTemplate().query(sql, param, new BeanPropertyRowMapper<>(TicketDetail.class));
		return result;
	}
	
	@Override
	public List<TicketDetail> findByResposableId(int respId) {
		// TODO Auto-generated method stub
		return null;
	}

}
