package es.aarmenta.spring.framework.samples.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.aarmenta.spring.framework.samples.domain.User;

public class UserRowMapper implements RowMapper<User>{

	// ---------------------------------------------------------- Public Methods

	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();

		user.setUsername(rs.getString("usr_username"));
		user.setPassword(rs.getString("usr_password"));
		user.setEmail(rs.getString("usr_email"));

		return user;
	}
}
