package com.renshiproject.controller;

import com.renshiproject.Service.IAdminService;
import com.renshiproject.Service.IEmployeeService;
import com.renshiproject.dataobject.DepartmentDO;
import com.renshiproject.dataobject.EmployeeDO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/manageEmployee.do")
    public ModelAndView toManageEmployee(){
        List<EmployeeDO> employeeDOs = employeeService.allEmployee();

        ModelAndView mv =new ModelAndView();
        mv.addObject("employeeInfos",employeeDOs);
        mv.setViewName("adminManageEmployee");
        return mv;
    }
    //跳转到添加员工页面
    @RequestMapping("/manageEmployee/toAddEmployee.do")
    public ModelAndView toAddEmployee(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminAddEmployee");
        return mv;
    }

    //添加员工
    @RequestMapping("/manageEmployee/addEmployee")
    public ModelAndView addEmployee(EmployeeDO employeeDO){
        employeeService.addEmployee(employeeDO);

        ModelAndView mv = new ModelAndView();
        mv.addObject("Mgs","添加成功");            //还未做错误处理
        mv.setViewName("adminManageEmployee");
        return  mv;
    }

    //跳转到编辑员工信息页面
    @RequestMapping("/manageEmployee/toUpdateEmployee")
    public ModelAndView toEditEmployee(int id){
        EmployeeDO employeeDO = employeeService.selectById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminEditEmployee");

        return mv;
    }

    //编辑员工信息控制
    @RequestMapping("/manageEmployee/updateEmployee")
    public ModelAndView editEmployee(EmployeeDO employeeDO){
        employeeService.updateEmployee(employeeDO);

        ModelAndView mv = new ModelAndView();
        mv.addObject("Mgs","修改成功");            //还未做错误处理
        mv.setViewName("admin");
        return  mv;
    }

    //删除员工控制
    @RequestMapping("/manageEmployee/deleteEmployee.do")
    public ModelAndView deleteEmployee(@RequestParam("id")int id){
        employeeService.deleteEmployee(id);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminManageEmployee");
        return mv;
    }




    //查询员工信息，对应搜索
    @RequestMapping("/adminQueryEmployee.do")
    public ModelAndView queryEmployee(EmployeeDO employeeDO){
        ModelAndView mv = new ModelAndView();

        if(employeeDO==null){
            mv.setViewName("adminQueryEmployee");
            mv.addObject("adminQueryEmployeeResult",null);
            return mv;
        }else{
            employeeService.queryEmployee(employeeDO);
            mv.addObject(("adminQueryEmployeeResult"));
            return mv;
        }
    }




//    @RequestMapping("/manageDepartment/addDepartment.do")
//    public ModelAndView addDepartment(DepartmentDO departmentDO){
//        ModelAndView
//    }


}
