package com.renshiproject.controller;

import com.renshiproject.Service.IAdminService;
import com.renshiproject.Service.IEmployeeService;
import com.renshiproject.Service.IManagerService;
import com.renshiproject.bean.administratorinfo;
import com.renshiproject.bean.manager_info;
import com.renshiproject.dataobject.AdministratorInfoDO;
import com.renshiproject.dataobject.EmployeeDO;
import com.renshiproject.dataobject.ManagerInfoDO;
import com.renshiproject.pojo.allEmployeeInfo;
import com.renshiproject.Service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
@SessionAttributes(value={"admin","employee","manager"},types = {AdministratorInfoDO.class,EmployeeDO.class,ManagerInfoDO.class})
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IManagerService managerService;

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/check.do")
    public ModelAndView loginCheck(@RequestParam("role")String role,
                                   @RequestParam("id")int id,
                                   @RequestParam("password")String password,
                                   Model model){

        ModelAndView mv = new ModelAndView();
        if(role.equals("管理员")){

            AdministratorInfoDO administratorInfoDO = new AdministratorInfoDO();
            administratorInfoDO.setId(id);
            administratorInfoDO.setPassword(password);
            administratorInfoDO = checkAdmin(administratorInfoDO);
            
            if(administratorInfoDO!=null){

                mv.addObject("administrator",administratorInfoDO);
                mv.setViewName("admin");

                model.addAttribute("admin",administratorInfoDO);
                return mv;
            }else{
                mv.setViewName("login");
                mv.addObject("errMsg","管理员账号密码输入错误");
                return mv;
            }
        }

        if(role.equals("员工")){
            EmployeeDO employeeDO = new EmployeeDO();
            employeeDO.setId(id);
            employeeDO.setPassword(password);
            employeeDO = employeeService.checkEmployee(employeeDO);
            if(employeeDO!=null){
                mv.addObject("employee",employeeDO);
                mv.setViewName("employee");
                model.addAttribute("employee",employeeDO);
                return mv;
            }else{
                mv.setViewName("login");
                mv.addObject("errMsg","账号密码输入错误");
                return mv;
            }
        }

        if(role.equals("经理")){
            ManagerInfoDO managerInfoDO = new ManagerInfoDO();
            managerInfoDO.setId(id);
            managerInfoDO.setPassword(password);
            managerInfoDO = managerService.checkManager(managerInfoDO);

            if(managerInfoDO!=null){
                mv.addObject("manager",managerInfoDO);
                mv.setViewName("manager");
                model.addAttribute("manager",managerInfoDO);
                return mv;
            }else{
                mv.setViewName("login");
                mv.addObject("errMsg","账号密码输入错误");
                return mv;
            }
        }

//        mv.setViewName("login");
       return mv;

    }

    private AdministratorInfoDO checkAdmin(AdministratorInfoDO administratorInfoDO){
        return adminService.chechAdmin(administratorInfoDO);
    }


    @Autowired
    private ILoginService loginService;
    @RequestMapping("/login.do")
    public String login(Model model,String id,String password,String role)
    {
        if(role.equals("admin"))
        {
            administratorinfo a=loginService.administratorinfoLogin(id,password);
            if(a!=null)
            {
                model.addAttribute("currentAdmin",a);
                return "admin/admin";
            }
        }
        if(role.equals("manager"))
        {
            manager_info m=loginService.manager_infoLogin(id,password);
            if(m!=null)
            {
                model.addAttribute("currentManager",m);
                return "manager/manager";
            }
        }
        if(role.equals("employee"))
        {
            allEmployeeInfo e=loginService.employeeLogin(id,password);
            if(e!=null)
            {
                model.addAttribute("currentEmployee",e);
                return "employee_homepage";
            }
        }
        return "";
    }



}
