package com.pyh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pyh.domain.User;
import com.pyh.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getuser")
	public String getUser(@RequestParam("id") int id,Model model) {
		User user = userService.findUserById(id);
		model.addAttribute("user",user);
		return "user";
	}
}
