package it.objectmethod.WorldCountry.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@PostMapping("/login")
	public String login(@RequestParam(name = "loginName", required = true) String userName, ModelMap map,
			HttpServletResponse response) {
		if (userName.trim().isEmpty()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		return userName;
	}
}
