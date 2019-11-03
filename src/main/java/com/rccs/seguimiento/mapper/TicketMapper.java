package com.rccs.seguimiento.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rccs.seguimiento.model.Ticket;

@Component
public class TicketMapper implements RowMapper<Ticket>{
	@Override
	public Ticket mapRow(ResultSet row, int arg1) throws SQLException {
		Ticket t = new Ticket();
		t.setTckId(row.getInt("tck_id"));
		t.setTckCode(row.getString("tck_code"));
		t.setTckUrl(row.getString("tck_url"));
		t.setTckType(row.getInt("tck_type"));
		t.setTckStatus(row.getInt("tck_status"));
		t.setTckFlow(row.getInt("tck_flow"));
		t.setTckStimated(row.getBigDecimal("tck_estimated"));
		t.setTckDateIni(row.getTimestamp("tck_date_ini"));
		t.setTckDateEnd(row.getTimestamp("tck_date_end"));
		t.setTckDateEndPlan(row.getTimestamp("tck_date_end_plan"));
		t.setSolId(row.getInt("sol_id"));
		return t;
	}

}
