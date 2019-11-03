package com.rccs.seguimiento.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.rccs.seguimiento.dao.TicketDao;
import com.rccs.seguimiento.mapper.TicketMapper;
import com.rccs.seguimiento.model.Ticket;

@Repository
public class TicketDaoImpl extends JdbcDaoSupport implements TicketDao{
	private static final Logger logger = LoggerFactory.getLogger(TicketDaoImpl.class);
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	TicketMapper ticketMapper;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public List<Ticket> findByCode(String code) {
		logger.info("Consulta de ticket por codigo: " + code);
		String sql = "SELECT * FROM TICKET WHERE tck_code like ?";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, "%"+code+"%");
		List<Ticket> result = new ArrayList<>();
		logger.info("Numero de registros: " + rows.size());
		for (Map<String, Object> row : rows) {
			Ticket t = new Ticket();
			t.setTckId((Integer)row.get("tck_id"));
			t.setTckCode((String)row.get("tck_code"));
			t.setTckUrl((String)row.get("tck_url"));
			t.setTckType((Integer)row.get("tck_type"));
			t.setTckStatus((Integer)row.get("tck_status"));
			t.setTckFlow((Integer)row.get("tck_flow"));
			t.setTckStimated((BigDecimal)row.get("tck_estimated"));
			t.setTckDateIni( new Timestamp(((Date)row.get("tck_date_ini")).getTime()));
			t.setTckDateEnd( new Timestamp(((Date)row.get("tck_date_end")).getTime()));
			t.setTckDateEndPlan( new Timestamp(((Date)row.get("tck_date_end_plan")).getTime()));
			t.setSolId((Integer)row.get("sol_id"));
			result.add(t);
		}
		return result;
	}
	
	@Override
	public long save(Ticket t) {
		final String sql = "INSERT INTO TICKET (tck_code, tck_url, tck_type, tck_status, tck_flow, tck_estimated, tck_date_ini, tck_date_end, tck_date_end_plan, sol_id) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				 final PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				        ps.setString(1, t.getTckCode());
				        ps.setString(2, t.getTckUrl());
				        ps.setInt(3, t.getTckType());
				        ps.setInt(4, t.getTckStatus());
				        ps.setInt(5, t.getTckFlow());
				        ps.setBigDecimal(6, t.getTckStimated());
				        ps.setTimestamp(7, t.getTckDateIni());
				        ps.setTimestamp(8, t.getTckDateEnd());
				        ps.setTimestamp(9, t.getTckDateEndPlan());
				        ps.setLong(10, t.getSolId());
				 return ps;
			}
		};
		
		final KeyHolder holder = new GeneratedKeyHolder();
		return getJdbcTemplate().update(psc, holder);
//		int newId = 0;
//		List<Map<String, Object>> lista = holder.getKeyList();
//		for (Map<String, Object> map : lista) {
//			newId = ((Integer)map.get("dmrs_id")).intValue();
//			break;
//		}
//		String code = Constants.SUFIX_CODE.concat(Utilities.stringCompleteLeft(newId+"", Constants.NUM_DIG_CODE, Constants.WILDCARD_CODE));
//		dummy.setDmrsCode(code);
//		dummy.setDmrsId(newId);
//		update(dummy);
//		return code;
	}
	
	@Override
	public long update(Ticket t) {
		String sql = "UPDATE TICKET SET tck_code=?, tck_url=?, tck_type=?, tck_status=?, tck_flow=?, tck_estimated=?, tck_date_ini=?, tck_date_end=?, tck_date_end_plan=?, sol_id=? WHERE tck_id =? ";
		
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				 final PreparedStatement ps = conn.prepareStatement(sql);
					 	ps.setString(1, t.getTckCode());
				        ps.setString(2, t.getTckUrl());
				        ps.setInt(3, t.getTckType());
				        ps.setInt(4, t.getTckStatus());
				        ps.setInt(5, t.getTckFlow());
				        ps.setBigDecimal(6, t.getTckStimated());
				        ps.setTimestamp(7, t.getTckDateIni());
				        ps.setTimestamp(8, t.getTckDateEnd());
				        ps.setTimestamp(9, t.getTckDateEndPlan());
				        ps.setLong(10, t.getSolId());
				        ps.setLong(11, t.getTckId());
				 return ps;
			}
		};
		
		return getJdbcTemplate().update(psc);
	}
}
