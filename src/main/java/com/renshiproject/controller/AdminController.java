package com.renshiproject.controller;

import com.mysql.jdbc.StringUtils;
import com.renshiproject.Service.IAdminService;
import com.renshiproject.Service.IDepartmentService;
import com.renshiproject.Service.IEmployeeService;
import com.renshiproject.Service.IWageService;
import com.renshiproject.dataobject.DepartmentDO;
import com.renshiproject.dataobject.EmployeeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private IWageService wageService;

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

        return  toManageEmployee();
    }

    //跳转到编辑员工信息页面
    @RequestMapping("/manageEmployee/toUpdateEmployee")
    public ModelAndView toEditEmployee(int id){
        EmployeeDO employeeDO = employeeService.selectById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("employeeInfo",employeeDO);
        mv.setViewName("adminEditEmployee");

        return mv;
    }

    //更新员工信息控制
    @RequestMapping("/manageEmployee/updateEmployee.do")
    public ModelAndView editEmployee(EmployeeDO employeeDO){
        employeeService.updateEmployee(employeeDO);

        ModelAndView mv = new ModelAndView();
        mv.addObject("Mgs","修改成功");            //还未做错误处理

        return  toManageEmployee();
    }

    //删除员工控制
    @RequestMapping("/manageEmployee/deleteEmployee.do")
    public ModelAndView deleteEmployee(@RequestParam("id")int id){
        employeeService.deleteEmployee(id);

        return toManageEmployee();
    }



    //查询员工信息，对应搜索
    @RequestMapping("/manageEmployee/search.do")
    public ModelAndView queryEmployee(String username){
        ModelAndView mv = new ModelAndView();

        List<EmployeeDO> employeeDOS = employeeService.searchEmployee(username);

        if(!StringUtils.isNullOrEmpty(username)){
            mv.setViewName("adminManageEmployee");
            mv.addObject("employeeInfos",employeeDOS);
            return mv;
        }else{
            mv.setViewName("adminManageEmployee");
            mv.addObject("employeeInfos",employeeDOS);
            return mv;
        }
    }




    @RequestMapping("/manageDepartment.do")
    public ModelAndView toManageDepartment(){
        List<DepartmentDO> departmentDOS = departmentService.allDepartment();

        ModelAndView mv =new ModelAndView();
        mv.addObject("departmentInfos",departmentDOS);
        mv.setViewName("adminManageDepartment");
        return mv;
    }

    @RequestMapping("/manageDepartment/toAddDept.do")
    public ModelAndView toAddDept(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminAddDepartment");
        return mv;
    }

    //添加员工
    @RequestMapping("/manageDepartment/addDept")
    public ModelAndView addDept(DepartmentDO departmentDO){
        departmentService.addDept(departmentDO);

        return  toManageDepartment();
    }

    @RequestMapping("/manageDepartment/deleteDept.do")
    public ModelAndView deleteDept(int id){
        departmentService.deleteByPrimaryKey(id);

        return toManageDepartment();
    }


    @RequestMapping("/manageDepartment/search.do")
    public ModelAndView searchDept(String deptName){
        ModelAndView mv = new ModelAndView();

        List<DepartmentDO> departmentInfos = null;

        if(!StringUtils.isNullOrEmpty(deptName)){
            departmentInfos = departmentService.searchDept(deptName);
        }
        mv.setViewName("adminManageDepartment");
        mv.addObject("departmentInfos",departmentInfos);
        return mv;
    }

    //跳转到编辑部门信息页面
    @RequestMapping("/manageDepartment/toUpdateDept.do")
    public ModelAndView toUpdateDept(int id){
        DepartmentDO departmentDO = departmentService.selectByPrimaryKey(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("departmentInfo",departmentDO);
        mv.setViewName("adminUpdateDepartment");

        return mv;
    }

    //更新部门信息控制
    @RequestMapping("/manageDepartment/updateDept.do")
    public ModelAndView updateDept(DepartmentDO departmentDO){
        departmentService.updateDept(departmentDO);

        ModelAndView mv = new ModelAndView();
        mv.addObject("Mgs","修改成功");            //还未做错误处理

        return  toManageDepartment();
    }

    @RequestMapping("")

}
