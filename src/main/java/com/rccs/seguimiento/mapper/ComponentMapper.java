package com.rccs.seguimiento.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rccs.seguimiento.model.ComponentSol;

@Component
public class ComponentMapper  implements RowMapper<com.rccs.seguimiento.model.ComponentSol>{
	@Override
	public ComponentSol mapRow(ResultSet row, int arg1) throws SQLException {
		ComponentSol c = new ComponentSol();
		c.setCmpId(row.getInt("rps_id"));
		c.setCmpName(row.getString("rps_name"));
		c.setSolId(row.getInt("rps_id"));
		return c;
	}

}
