package com.rccs.seguimiento.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rccs.seguimiento.model.Client;

@Component
public class ClientMapper  implements RowMapper<Client>{
	@Override
	public Client mapRow(ResultSet row, int arg1) throws SQLException {
		Client c = new Client();
		c.setCliId(row.getInt("cli_id"));
		c.setCliName(row.getString("cli_name"));
		return c;
	}
}
