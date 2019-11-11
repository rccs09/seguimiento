package com.rccs.seguimiento.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.rccs.seguimiento.dao.ComponentDao;
import com.rccs.seguimiento.model.ComponentSol;

@Repository
public class ComponentDaoImpl extends JdbcDaoSupport implements ComponentDao{
	private static final Logger logger = LoggerFactory.getLogger(ComponentDaoImpl.class);
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public List<ComponentSol> componetBySolution(int solId){
		logger.info("Consulta los componentes por solucion: " + solId);
		String sql = "SELECT * FROM component where sol_id = ?";
		logger.info("ppppppppppp");
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql.toString(), solId);
		logger.info("qqqqqqqqqqqqqqqq");
		List<ComponentSol> list = new ArrayList<ComponentSol>();
		logger.info("rrrrrrrrrrrrr");
		for (Map<String, Object> row : rows) {
			logger.info("sssssssssss");
			ComponentSol c = new ComponentSol();
			c.setCmpId((Integer)row.get("cmp_id"));
			c.setCmpName((String)row.get("cmp_name"));
			c.setSolId((Integer)row.get("sol_id"));
			list.add(c);
		}
		
		return list;
	}
	
}
