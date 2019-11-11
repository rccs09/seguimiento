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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.rccs.seguimiento.dao.TicketDetailDao;
import com.rccs.seguimiento.dto.TicketDetailDto;
import com.rccs.seguimiento.dto.TicketDto;
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
	public List<TicketDetailDto> findByDetDtoTicket(TicketDto tdto) {
		logger.info("Consulta detalles DTO del ticket : " + tdto.getTicket().getTckId());

		StringBuilder sql = new StringBuilder();
		sql.append("select td.dtk_id,td.dtk_status,td.dtk_estimated,td.dtk_date_ini,td.dtk_date_end, ");
		sql.append("td.dtk_date_end_plan,td.rps_id, td.tck_id,td.cmp_id, c.cmp_name ,r.rps_name,r.rps_last_name ");
		sql.append("from ticket_detail td, responsible r, component c ");
		sql.append("where td.rps_id = r.rps_id ");
		sql.append("and td.cmp_id=c.cmp_id ");
		sql.append("and tck_id = ?");
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql.toString(), tdto.getTicket().getTckId());
		
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
			
			TicketDetailDto dto = TicketDetailDto.entityToDto(t);
			dto.setDtkCmpName((String)row.get("cmp_name"));
			dto.setDtkRpsLastName((String)row.get("rps_last_name"));
			dto.setDtkRpsName((String)row.get("rps_name"));
			dto.setTicketDto(tdto);

			result.add(dto);
		}
		
		return result;
	}
	
	@Override
	public List<TicketDetail> findByTicketId(int id) {
		logger.info("Consulta detalles del ticket por ID : " + id);
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

	@Override
	public long save(TicketDetailDto t) {
		final String sql = "INSERT INTO ticket_detail (dtk_status,dtk_estimated,dtk_date_ini,dtk_date_end,dtk_date_end_plan,rps_id,tck_id,cmp_id) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		System.out.println(t.getTicketDetail().getDtkStatus());
		System.out.println(t.getTicketDetail().getDtkStimated());
		System.out.println(t.getTicketDetail().getDtkDateIni());
		System.out.println("RESPOM: " +t.getTicketDetail().getRpsId());
		System.out.println("TICKET: " +t.getTicketDetail().getTckId());
		System.out.println("COMPON: " + t.getTicketDetail().getCmpId());
		
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				 final PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				 		ps.setInt(1, t.getTicketDetail().getDtkStatus());
				 		ps.setBigDecimal(2, t.getTicketDetail().getDtkStimated());
				 		ps.setTimestamp(3, t.getTicketDetail().getDtkDateIni());
				        ps.setTimestamp(4, t.getTicketDetail().getDtkDateEnd());
				        ps.setTimestamp(5, t.getTicketDetail().getDtkDateEndPlan());
				        ps.setLong(6, t.getTicketDetail().getRpsId());
				        ps.setLong(7, t.getTicketDto().getTicket().getTckId());
				        ps.setLong(8, t.getTicketDetail().getCmpId());
				 return ps;
			}
		};
		
		final KeyHolder holder = new GeneratedKeyHolder();
		return getJdbcTemplate().update(psc, holder);
	}

	@Override
	public long update(TicketDetailDto t) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ticket_detail SET dtk_status=?, dtk_estimated=?, dtk_date_ini=?, dtk_date_end=?, dtk_date_end_plan=?, ");
		sql.append("rps_id=?, tck_id=?, cmp_id=? WHERE dtk_id=? ");
		
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				 final PreparedStatement ps = conn.prepareStatement(sql.toString());
				 	ps.setInt(1, t.getTicketDetail().getDtkStatus());
			 		ps.setBigDecimal(2, t.getTicketDetail().getDtkStimated());
			 		ps.setTimestamp(3, t.getTicketDetail().getDtkDateIni());
			        ps.setTimestamp(4, t.getTicketDetail().getDtkDateEnd());
			        ps.setTimestamp(5, t.getTicketDetail().getDtkDateEndPlan());
			        ps.setLong(6, t.getTicketDetail().getRpsId());
			        ps.setLong(7, t.getTicketDto().getTicket().getTckId());
			        ps.setLong(8, t.getTicketDetail().getCmpId());
			        ps.setLong(9, t.getTicketDetail().getDtkId());
				 return ps;
			}
		};
		
		return getJdbcTemplate().update(psc);
	}

	@Override
	public long delete(TicketDetailDto t) {
		String sql = "DELETE FROM ticket_detail WHERE dtk_id=? ";
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				 final PreparedStatement ps = conn.prepareStatement(sql);
				        ps.setLong(1, t.getTicketDetail().getDtkId());
				 return ps;
			}
		};
		return getJdbcTemplate().update(psc);
	}

}
