package com.rccs.seguimiento.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rccs.seguimiento.model.TicketQa;

@Component
public class TicketQaMapper implements RowMapper<TicketQa>{
	@Override
	public TicketQa mapRow(ResultSet row, int arg1) throws SQLException {
		TicketQa t = new TicketQa();
		t.setTqaId(row.getInt("tck_id"));
		t.setTqaCode(row.getString("tck_code"));
		t.setTqaUrl(row.getString("tck_code"));
		t.setTqaCycle(row.getInt("tck_type"));
		t.setTqaVersion(row.getString("tck_code"));
		t.setTqaStatus(row.getInt("tck_type"));
		t.setTqaComment(row.getString("tck_code"));
		t.setDtkId(row.getInt("tck_id"));
		return t;
	}

}
