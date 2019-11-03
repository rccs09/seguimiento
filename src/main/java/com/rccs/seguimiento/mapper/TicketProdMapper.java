package com.rccs.seguimiento.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rccs.seguimiento.model.TicketProd;

@Component
public class TicketProdMapper implements RowMapper<TicketProd>{
	@Override
	public TicketProd mapRow(ResultSet row, int arg1) throws SQLException {
		TicketProd t = new TicketProd();
		t.setTpdId(row.getInt("tck_id"));
		t.setTpdCode(row.getString("tck_code"));
		t.setTpdUrl(row.getString("tck_code"));
		t.setTpdVersion(row.getString("tck_code"));
		t.setTpdStatus(row.getInt("tck_type"));
		t.setTpdComment(row.getString("tck_code"));
		t.setDtkId(row.getInt("tck_id"));
		return t;
	}

}
