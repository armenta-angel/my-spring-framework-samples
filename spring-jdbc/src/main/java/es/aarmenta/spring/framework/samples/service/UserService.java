package es.aarmenta.spring.framework.samples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.aarmenta.spring.framework.samples.dao.IUserDao;
import es.aarmenta.spring.framework.samples.domain.User;

@Service
public class UserService {

	// -------------------------------------------------------------- Properties

	@Autowired
	private IUserDao userDao;

	public List<User> findAllUsers() {
		return this.userDao.getUsers();
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void createNewUser(User user) {
		this.userDao.addUser(user);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void killUser(User user) {
		this.userDao.deleteUser(user);
	}

}
