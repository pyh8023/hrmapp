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
		// 调用业务逻辑组件判断用户是否可以登录
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
		/** 查询用户信息     */
        List<User> users = hrmService.findUser(user,pageModel);
        model.addAttribute("users",users);
        model.addAttribute("pageModel",pageModel);
        model.addAttribute("selectUser",user);
		return "user/user";
	}

	@RequestMapping("user/removeUser")
	public ModelAndView deleteUser(String ids , ModelAndView modelAndView){
		String[] idArray = ids.split(",");
		for (String id : idArray){
			hrmService.removeUserById(Integer.parseInt(id));
		}
		User user = (User) modelAndView.getModel().get("selectUser");
		// 设置客户端跳转到查询请求
		modelAndView.setViewName("redirect:/user/selectUser");
		return modelAndView;
	}

	/**
	 *  处理添加请求
	 * @param flag 1表示跳转到添加页面，2表示执行添加操作
	 * @param user 要添加用户的对象
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/user/addUser")
	public ModelAndView addUser(String flag, @ModelAttribute User user, ModelAndView mv){
		if("1".equals(flag)){
			// 设置跳转到添加页面
			mv.setViewName("user/showAddUser");
		}else{
			// 执行添加操作
			hrmService.addUser(user);
			// 设置客户端跳转到查询请求
			mv.setViewName("user/showAddUser");
			mv.getModel().put("msg","添加成功");
		}
		// 返回
		return mv;
	}

    /**
     *  处理修改用户请求
     * @param flag 1表示跳转到修改页面，2表示执行修改操作
     * @param user 要修改用户的对象
     * @param mv
     * @return
     */
	@RequestMapping(value = "/user/updateUser")
	public ModelAndView updateUser(String flag,@ModelAttribute User user,ModelAndView mv){
	    if ("1".equals(flag)){
            // 根据id查询用户
	        User tagert = hrmService.findUserById(user.getId());
	        mv.addObject("user",tagert);
            // 设置跳转到添加页面
            mv.setViewName("user/showUpdateUser");
        }else{
            hrmService.updateUser(user);
            mv.setViewName("redirect:/user/selectUser");
        }
	    return mv;
    }
}
