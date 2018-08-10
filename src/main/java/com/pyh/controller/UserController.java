package com.pyh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pyh.service.HrmService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private HrmService hrmService;
	
}
