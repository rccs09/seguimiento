package com.rccs.seguimiento.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rccs.seguimiento.model.TicketDetail;

@Component
public class TicketDetailMapper  implements RowMapper<TicketDetail>{
	@Override
	public TicketDetail mapRow(ResultSet row, int arg1) throws SQLException {
		TicketDetail t = new TicketDetail();
		t.setDtkId(row.getInt("dtk_id"));
		t.setDtkStatus(row.getInt("dtk_status"));
		t.setDtkStimated(row.getBigDecimal("dtk_estimated"));
		t.setDtkDateIni(row.getTimestamp("dtk_date_ini"));
		t.setDtkDateEnd(row.getTimestamp("dtk_date_end"));
		t.setDtkDateEndPlan(row.getTimestamp("dtk_date_end_plan"));
		t.setRpsId(row.getInt("rps_id"));
		t.setTckId(row.getInt("tck_id"));
		t.setCmpId(row.getInt("cmp_id"));
		return t;
	}

}
