package com.rccs.seguimiento.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rccs.seguimiento.model.Solution;

@Component
public class SolutionMapper  implements RowMapper<Solution>{
	@Override
	public Solution mapRow(ResultSet row, int arg1) throws SQLException {
		Solution s = new Solution();
		s.setSolId(row.getInt("sol_id"));
		s.setSolName(row.getString("sol_name"));
		s.setCliId(row.getInt("cli_id"));
		return s;
	}

}
