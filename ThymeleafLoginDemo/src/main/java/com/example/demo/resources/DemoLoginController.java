package com.example.demo.resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.LoginFrom;

@Controller
public class DemoLoginController {

	@GetMapping("/login")
	public String getLoginFrom() {
		return "Login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute(name = "loginForm") LoginFrom loginFrom, Model model) {

		String uname = loginFrom.getUsername();
		String pwd = loginFrom.getPassword();
		System.out.println(uname + " -- " + pwd);

		if ("admin".equals(uname) && "admin".equals(pwd)) {
			return "Home";
		} else {
			model.addAttribute("invalidCredentials",true);
			return "Login";
		}
	}
}
