package es.aarmenta.spring.framework.samples.dao;

import java.util.List;

import es.aarmenta.spring.framework.samples.domain.User;

public interface IUserDao {

	// ---------------------------------------------------------- Public Methods

	public List<User> getUsers();
	public void addUser(User user);
	public void deleteUser(User user);
}
