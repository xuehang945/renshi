package com.renshiproject.controller;


import com.renshiproject.Service.IEmployeeService;
import com.renshiproject.dataobject.EmployeeDO;
import com.renshiproject.viewObject.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/getInfo.do")
    public ModelAndView getInfo(HttpSession session){
        EmployeeDO employeeDO = (EmployeeDO)session.getAttribute("employee");
        EmployeeVO employeeVO  = employeeService.getEmployeeInfoById(employeeDO.getId());

        ModelAndView mv = new ModelAndView();
        mv.addObject("employeeVO",employeeVO);
        mv.setViewName("employeeInfo");
        return mv;
    }

}
