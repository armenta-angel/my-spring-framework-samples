package es.aarmenta.spring.framework.samples.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.aarmenta.spring.framework.samples.rest.model.User;

@Controller
@RequestMapping(value = "/user")
public class UserRestController {

	@RequestMapping(value = "/getUser/", method = RequestMethod.GET)
    @ResponseBody
	public User getUser() {
		return new User("aarmenta", "1234");
	}
}
