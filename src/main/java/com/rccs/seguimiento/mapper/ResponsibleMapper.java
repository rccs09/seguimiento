package com.rccs.seguimiento.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rccs.seguimiento.model.Responsible;

@Component
public class ResponsibleMapper implements RowMapper<Responsible>{
	@Override
	public Responsible mapRow(ResultSet row, int arg1) throws SQLException {
		Responsible r = new Responsible();
		r.setRpsId(row.getInt("rps_id"));
		r.setRpsName(row.getString("rps_name"));
		r.setRpsLastName(row.getString("rps_last_name"));
		r.setPrvId(row.getInt("prv_id"));
		return r;
	}

}
