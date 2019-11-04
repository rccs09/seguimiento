package com.rccs.seguimiento.dao.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.rccs.seguimiento.dao.TicketDetailDao;
import com.rccs.seguimiento.dto.TicketDetailDto;
import com.rccs.seguimiento.mapper.TicketDetailMapper;
import com.rccs.seguimiento.model.TicketDetail;
import com.rccs.seguimiento.utils.Constants;

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
	public List<TicketDetailDto> findDtoByTicketId(int id) {
		logger.info("Consulta detalles del ticket : " + id);
//		String sql = "SELECT * FROM ticket_detail WHERE tck_id = ?";
		System.out.println("222222222222222222222");
		
		StringBuilder sql = new StringBuilder();
		sql.append("select td.dtk_id,td.dtk_status,td.dtk_estimated,td.dtk_date_ini,td.dtk_date_end, ");
		sql.append("td.dtk_date_end_plan,td.rps_id, td.tck_id,td.cmp_id, c.cmp_name ,r.rps_name,r.rps_last_name ");
		sql.append("from ticket_detail td, responsible r, component c ");
		sql.append("where td.rps_id = r.rps_id ");
		sql.append("and td.cmp_id=c.cmp_id ");
		sql.append("and tck_id = ?");
		
//		List<TicketDetail> result = new ArrayList<>();
//		Object[] param = new Object[1];
//		param[0] = new Integer(1);
//		
//		result = getJdbcTemplate().query(sb.toString(), param, new BeanPropertyRowMapper<>(TicketDetail.class));
		System.out.println("33333: " + sql.toString());
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql.toString(), id);
		
		System.out.println("44444444444444444444444 ROWS: " + rows.size());
		List<TicketDetailDto> result = new ArrayList<>();
		for (Map<String, Object> row : rows) {
			TicketDetail t = new TicketDetail();
			t.setDtkId((Integer)row.get("dtk_id"));
			t.setDtkStatus((Integer)row.get("dtk_status"));
			t.setDtkStimated((BigDecimal)row.get("dtk_estimated"));
			t.setDtkDateIni(new Timestamp(((Date)row.get("dtk_date_ini")).getTime()));
			t.setDtkDateEnd(new Timestamp(((Date)row.get("dtk_date_end")).getTime()));
			t.setDtkDateEndPlan(new Timestamp(((Date)row.get("dtk_date_end_plan")).getTime()));
			t.setRpsId((Integer)row.get("rps_id"));
			t.setTckId((Integer)row.get("tck_id"));
			t.setCmpId((Integer)row.get("cmp_id"));
			System.out.println(t.toString());
			
			TicketDetailDto dto = new TicketDetailDto();
			dto.setTicketDetail(t);
			dto.setDtkCmpName((String)row.get("cmp_name"));
			dto.setDtkRpsLastName((String)row.get("rps_last_name"));
			dto.setDtkRpsName((String)row.get("rps_name"));
			dto.setDtkStatusSt(Constants.DTCK_STATUS.get(t.getDtkStatus()));

			System.out.println(dto.toString());
			result.add(dto);
		}
		
		return result;
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
