package es.aarmenta.spring.framework.samples.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import es.aarmenta.spring.framework.samples.domain.User;

@Repository
public class UserDao implements IUserDao {

	// -------------------------------------------------------------- Properties

	private NamedParameterJdbcTemplate jdbcTemplate;

	// ---------------------------------------------------------- Public Methods

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<User> getUsers() {
		StringBuffer sql = new StringBuffer(
				"SELECT usr_username, usr_password, usr_email FROM t_user");

		List<User> users = this.jdbcTemplate.getJdbcOperations().query(
				sql.toString(), new UserRowMapper());

		return users;
	}

	public void addUser(User user) {

		StringBuffer sql = new StringBuffer(
				"INSERT INTO t_user (usr_username, usr_password, usr_email)"
						+ " VALUES (?,?,?)");

		Object[] parametros;
		parametros = new Object[] { user.getUsername(), user.getPassword(),
				user.getEmail() };

		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };

		this.jdbcTemplate.getJdbcOperations().update(sql.toString(),
				parametros, types);
	}

	public void deleteUser(User user) {

		String sql = "DELETE FROM t_user WHERE usr_username = :username";

		SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
		jdbcTemplate.update(sql, parameters);
	}

}
