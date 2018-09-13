package com.pyh.controller;

import javax.servlet.http.HttpSession;

import com.pyh.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pyh.domain.User;
import com.pyh.service.HrmService;
import com.pyh.util.HrmConstants;

import java.util.List;

@Controller
public class UserController {
	
	/**
	 * 自动注入HrmService
	 * */
	@Autowired
	private HrmService hrmService;
	
	@RequestMapping("login")
	public ModelAndView login(@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,HttpSession session,ModelAndView modelAndView) {
		User user = hrmService.login(loginname, password);
		if(user!=null) {
			// 将用户保存到HttpSession当中
			session.setAttribute(HrmConstants.USER_SESSION, user);
			// 客户端跳转到main页面
			modelAndView.setViewName("redirect:/main");
		}else {
			// 设置登录失败提示信息
			modelAndView.addObject("message", "登录名或密码错误,请重新输入");
			// 服务器内部跳转到登录页面
			modelAndView.setViewName("forward:/loginForm");
		}
		return modelAndView;
	}

	@RequestMapping("user/selectUser")
	public String selectUser(Integer pageIndex, @ModelAttribute User user, Model model){
        PageModel pageModel = new PageModel();
        if(pageIndex !=null){
            pageModel.setPageIndex(pageIndex);
        }
        List<User> users = hrmService.findUser(user,pageModel);
        model.addAttribute("users",users);
        model.addAttribute("pageModel",pageModel);
		return "user/user";
	}
	
}
