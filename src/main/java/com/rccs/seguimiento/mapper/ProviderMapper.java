package com.rccs.seguimiento.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rccs.seguimiento.model.Provider;

@Component
public class ProviderMapper  implements RowMapper<Provider>{
	@Override
	public Provider mapRow(ResultSet row, int arg1) throws SQLException {
		Provider p = new Provider();
		p.setPrvId(row.getInt("prv_id"));
		p.setPrvName(row.getString("prv_name"));
		
		return p;
	}
}
