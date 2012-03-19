package es.aarmenta.spring.framework.samples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.aarmenta.spring.framework.samples.domain.User;
import es.aarmenta.spring.framework.samples.service.UserService;

@ContextConfiguration("/META-INF/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringJdbcTest {

	@Autowired
	UserService userService;

	@Test
	public void testUserService() throws Exception {
		User user1 = new User();
		user1.setUsername("aarmenta");
		user1.setPassword("password");
		user1.setEmail("aarmenta@domain1.com");

		userService.createNewUser(user1);
		userService.findAllUsers();
		userService.killUser(user1);
	}
}
