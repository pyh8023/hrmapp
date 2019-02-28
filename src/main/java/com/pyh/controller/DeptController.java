package com.pyh.controller;

import com.pyh.domain.Dept;
import com.pyh.service.HrmService;
import com.pyh.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author panyh
 * @Date 2018/10/10
 **/
@Controller
public class DeptController {

    /**
     * 自动注入HrmService
     * */
    @Autowired
    private HrmService hrmService;

    @RequestMapping(value = "dept/selectDept")
    public String selectDept(Model model, Integer pageIndex, @ModelAttribute Dept dept){
        PageModel pageModel = new PageModel();
        if (pageIndex!=null){
            pageModel.setPageIndex(pageIndex);
        }
        List<Dept> depts = hrmService.findDept(dept,pageModel);
        model.addAttribute("depts",depts);
        model.addAttribute("pageModel",pageModel);
        System.out.println(pageModel.getRecordCount());
        return "dept/dept";
    }
}
