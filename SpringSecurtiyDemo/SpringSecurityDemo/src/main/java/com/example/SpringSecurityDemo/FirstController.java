package com.example.SpringSecurityDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

@RequestMapping("/getMyPage")	
	public String getFirstPage(String name) {
		return "myPage";
	}
	
@RequestMapping("/getAdminPage")	
public String getAdminPage(String name) {
	return "admin";
}

@RequestMapping("/getNormalUserPage")	
public String getNormalUserPage(String name) {
	return "normalPage";
}


@RequestMapping("/loginFailed")	
public String loginFailed(String name) {
	return "loginFailedPage";
}

}
