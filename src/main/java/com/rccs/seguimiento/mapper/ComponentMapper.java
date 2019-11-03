package com.rccs.seguimiento.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class ComponentMapper  implements RowMapper<com.rccs.seguimiento.model.Component>{
	@Override
	public com.rccs.seguimiento.model.Component mapRow(ResultSet row, int arg1) throws SQLException {
		com.rccs.seguimiento.model.Component c = new com.rccs.seguimiento.model.Component();
		c.setCmpId(row.getInt("rps_id"));
		c.setCmpName(row.getString("rps_name"));
		c.setSolId(row.getInt("rps_id"));
		return c;
	}

}
