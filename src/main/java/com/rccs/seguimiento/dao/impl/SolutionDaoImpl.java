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

import com.rccs.seguimiento.dao.SolutionDao;
import com.rccs.seguimiento.model.Solution;

@Repository
public class SolutionDaoImpl extends JdbcDaoSupport implements SolutionDao{
	private static final Logger logger = LoggerFactory.getLogger(SolutionDaoImpl.class);
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public List<Solution> allSolution() {
		logger.info("Consulta todas las soluciones");
		String sql = "SELECT * FROM solution";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(Solution.class));
	}
	
}
