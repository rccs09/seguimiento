package com.rccs.seguimiento.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.rccs.seguimiento.dao.ResponsibleDao;
import com.rccs.seguimiento.model.Responsible;

@Repository
public class ResponsibleDaoImpl extends JdbcDaoSupport implements ResponsibleDao{
	private static final Logger logger = LoggerFactory.getLogger(ResponsibleDaoImpl.class);
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public List<Responsible> allResponsible(){
		logger.info("Consulta todas los responsables");
		String sql = "SELECT * FROM responsible order by rps_name";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(Responsible.class));
	}
	
}
