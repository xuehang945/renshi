package com.renshiproject.controller;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.StringUtils;
import com.renshiproject.Service.*;
import com.renshiproject.bean.*;
import com.renshiproject.dataobject.AnnouncementDO;
import com.renshiproject.dataobject.DepartmentDO;
import com.renshiproject.dataobject.EmployeeDO;
import com.renshiproject.pojo.allAward_punishInfo;
import com.renshiproject.pojo.allEmployeeInfo;
import com.renshiproject.viewObject.EmployeeVO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Autowired
    private IAnnouncementService announcementService;

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
    @Transactional
    @RequestMapping("/manageEmployee/addEmployee")
    public ModelAndView addEmployee(EmployeeDO employeeDO){
        employeeService.addEmployee(employeeDO);

        EmployeeVO employeeVO = employeeService.getEmployeeInfoById(employeeDO.getId());

        AnnouncementDO announcementDO = new AnnouncementDO();
        announcementDO.setContent("部门："+employeeVO.getDepartment()+"迎来新员工:"
                +employeeVO.getPosition()+" "+employeeVO.getName()+"   欢迎加入大家庭");

        //获得当前时间并转换成字符串
        SimpleDateFormat dateFormat = new SimpleDateFormat(" yyyy-MM-dd ");
        String currentDate =   dateFormat.format( new Date() );

        //添加公告
        announcementDO.setTime(currentDate);
        announcementService.addAnnouncement(announcementDO);

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
    @Transactional
    @RequestMapping("/manageEmployee/deleteEmployee.do")
    public ModelAndView deleteEmployee(@RequestParam("id")int id){
        EmployeeVO employeeVO = employeeService.getEmployeeInfoById(id);
        employeeService.deleteEmployee(id);

        AnnouncementDO announcementDO = new AnnouncementDO();
        announcementDO.setContent(employeeVO.getDepartment()+"的"+employeeVO.getPosition()
        +" "+employeeVO.getName()+" 办理了离职手续，祝他一路顺风");

        //获得当前时间并转换成字符串
        SimpleDateFormat dateFormat = new SimpleDateFormat(" yyyy-MM-dd ");
        String currentDate =   dateFormat.format( new Date() );

        //添加公告
        announcementDO.setTime(currentDate);
        announcementService.addAnnouncement(announcementDO);

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

    //添加部门
    @RequestMapping("/manageDepartment/addDept")
    public ModelAndView addDept(DepartmentDO departmentDO){
        departmentService.addDept(departmentDO);

        return  toManageDepartment();
    }

    @RequestMapping("/manageDepartment/deleteDept.do")
    public ModelAndView deleteDept(int id){
        //先删除部门中的员工
        employeeService.deleteFromDept(id);
        departmentService.deleteByPrimaryKey(id);

        AnnouncementDO announcementDO = new AnnouncementDO();
        announcementDO.setContent("ID为 "+id+"的部门与今日解散，祝愿所有员工前程似锦！");

        //获得当前时间并转换成字符串
        SimpleDateFormat dateFormat = new SimpleDateFormat(" yyyy-MM-dd ");
        String currentDate =   dateFormat.format( new Date() );

        //添加公告
        announcementDO.setTime(currentDate);
        announcementService.addAnnouncement(announcementDO);

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
        mv.addObject("msg","修改成功");            //还未做错误处理


        return  toManageDepartment();
    }





    @RequestMapping("/addPosition")
    public String addPosition(String addPositionName)
    {
        int i=adminService.addPosition(addPositionName);
        if(i>0)
        {
            return "/admin/addPosition";
        }
        else
        {
            return "/admin/admin";
        }
    }
    @RequestMapping("/findAllPosition.do")
    public String findAllPosition(Model model)
    {
        List<position> all=adminService.findAllPosition();
        model.addAttribute("positionInfos",all);
        return "/admin/renameOrDeletePosition";
    }
    @RequestMapping("/renamePosition")
    public String toRenamePosition(Model model,int position_id,String position_name)
    {
        try {
            position_name=new String(position_name.getBytes("ISO-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        model.addAttribute("position_id",position_id);
        model.addAttribute("renamePosition_name",position_name);
        return "admin/renamePosition";
    }
    @RequestMapping("/renamePosition.do")
    public String renamePosition(int position_id,String renamePosition_name)
    {
        int i=adminService.renamePosition(position_id,renamePosition_name);
        return "redirect:/admin/findAllPosition";
    }
    @RequestMapping("/searchPosition")
    public String searchPosition(Model model,Integer employee_id)
    {
        List<allEmployeeInfo> all=adminService.searchPosition(employee_id);
        model.addAttribute("searchPositionInfos",all);
        return "/admin/searchPosition";
    }
    @RequestMapping("/deletePosition")
    public String deletePosition(Integer position_id)
    {
        int i=adminService.deletePosition(position_id);
        return "redirect:/admin/findAllPosition";
    }



    @RequestMapping("/toAddAward_punish")
    public String toAddAward_punish(Model model)
    {
        List<position> allPosition=adminService.findAllPosition();
        List<department> allDept=adminService.findAllDepartment();
        model.addAttribute("allPosition",allPosition);
        model.addAttribute("allDept",allDept);
        return "/admin/addAward_punish";
    }
    @RequestMapping(value="/addAward_punish")
    public String addAward_punish(Integer employee_id,String employee_name,Integer dept_id,Integer position_id,String award_reason,Integer award_money,String punish_reason,Integer punish_money,String date)
    {
        award_punish ap=new award_punish();
        ap.setEmployee_id(employee_id);
        ap.setEmployee_name(employee_name);
        ap.setDept_id(dept_id);
        ap.setPosition_id(position_id);
        ap.setAward_reason(award_reason);
        ap.setAward_money(award_money);
        ap.setPunish_reason(punish_reason);
        ap.setPunish_money(punish_money);
        ap.setTime(date);
        int i=adminService.addAward_punish(ap);
        if(i>0)
            return "admin/addAward_punish";
        else
            return "";
    }
    @RequestMapping("/toAllAward_punish")
    public String toAllAward_punish(Model model)
    {
        List<allAward_punishInfo> all=adminService.searchAllAward_punish();
        model.addAttribute("allAward_punish",all);
        return "admin/allAward_punish";
    }
    @RequestMapping("/toUpdateAward_punish")
    public String toUpdateAward_punish(Model model,Integer employee_id,String date)
    {
        List<allAward_punishInfo> all=adminService.searchAward_punish(employee_id,date);
        if(all.isEmpty())
        {
            return "";
        }
        else
        {
            List<position> allPosition=adminService.findAllPosition();
            List<department> allDept=adminService.findAllDepartment();
            model.addAttribute("allPosition",allPosition);
            model.addAttribute("allDept",allDept);
            model.addAttribute("updateAward_punish",all.get(0));
            return "admin/updateAward_punish";
        }
    }
    @RequestMapping("/updateAward_punish")
    public String updateAward_punish(Integer id,Integer employee_id,String employee_name,Integer dept_id,Integer position_id,String award_reason,Integer award_money,String punish_reason,Integer punish_money,String date)
    {
        award_punish ap=new award_punish();
        ap.setId(id);
        ap.setEmployee_id(employee_id);
        ap.setEmployee_name(employee_name);
        ap.setDept_id(dept_id);
        ap.setPosition_id(position_id);
        ap.setAward_reason(award_reason);
        ap.setAward_money(award_money);
        ap.setPunish_reason(punish_reason);
        ap.setPunish_money(punish_money);
        ap.setTime(date);
        int i=adminService.updateAward_punish(ap);
        if(i>0)
            return "redirect:/admin/toAllAward_punish";
        else
            return "";
    }
    @RequestMapping("/deleteAward_punish")
    public String deleteAward_punish(Integer employee_id,String date)
    {
        int i=adminService.deleteAward_punish(employee_id,date);
        if(i>0)
            return "redirect:/admin/toAllAward_punish";
        else
            return "";
    }

    @RequestMapping(value = "/searchAward_punish",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String  searchAward_punish(Model model,Integer employee_id,String date)
    {
        List<allAward_punishInfo> all=adminService.searchAward_punish(employee_id,date);

        attendance attendance=adminService.searchLateAndAbsence(employee_id,date);
        if(all.isEmpty())
        {
            allAward_punishInfo allAward_punishInfo=new allAward_punishInfo();
            allEmployeeInfo allEmployeeInfo= adminService.searchPosition(employee_id).get(0);
            if(null==allEmployeeInfo)
            {
                return null;
            }
            if(null==attendance)
            {
                allAward_punishInfo.setLate(attendance.getLate());
                allAward_punishInfo.setAbsence(attendance.getAbsence());
            }
            allAward_punishInfo.setLate(attendance.getLate());
            allAward_punishInfo.setAbsence(attendance.getAbsence());
            allAward_punishInfo.setAward_money(0);
            allAward_punishInfo.setAward_reason("none");
            allAward_punishInfo.setPunish_money(0);
            allAward_punishInfo.setPunish_reason("none");
            allAward_punishInfo.setDept_name(allEmployeeInfo.getDept_name());
            allAward_punishInfo.setPosition_name(allEmployeeInfo.getPosition_name());
            allAward_punishInfo.setTime(date);
            allAward_punishInfo.setId(0);
            allAward_punishInfo.setEmployee_id(allEmployeeInfo.getId());
            allAward_punishInfo.setEmployee_name(allEmployeeInfo.getName());
            return JSON.toJSONString(allAward_punishInfo);
        }
        else
        {
            all.get(0).setLate(attendance.getLate());
            all.get(0).setAbsence(attendance.getAbsence());
            return JSON.toJSONString(all.get(0));
        }
    }


    @RequestMapping("/findAllWage")
    public String findAllWage(Model model)
    {
        List<wage> all= adminService.findAllWage();
        model.addAttribute("allWages",all);
        return "admin/allWage";
    }

    @RequestMapping("/toAddWage")
    public String toAddWage()
    {
        return "admin/addWage";
    }

    @RequestMapping("/addWage")
    public String addWage(wage wage)
    {
        int i=adminService.addWage(wage);
        return "redirect:/admin/findAllWage";
    }
    @RequestMapping("/deleteWage")
    public String deleteWage(int employee_id,String date)
    {
        int i=adminService.deleteWage(employee_id,date);
        if(i>0)
        {
            return "redirect:/admin/findAllWage";
        }
        else
        {
            return "";
        }
    }
    @RequestMapping("exportexcel")
    public void exportexcel(HttpServletResponse response) {
        OutputStream oStream = null;

        try {
//			创建工作簿
            HSSFWorkbook wb = new HSSFWorkbook();
//			创建sheet
            HSSFSheet sheet = wb.createSheet("列表");
//			创建表头
            HSSFRow row = sheet.createRow(0);
            //创建单元格
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("员工id");
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue("员工姓名");
            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue("部门");
            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue("职位");
            HSSFCell cell4=row.createCell(4);
            cell4.setCellValue("基础工资");
            HSSFCell cell5=row.createCell(5);
            cell5.setCellValue("奖励");
            HSSFCell cell6=row.createCell(6);
            cell6.setCellValue("惩罚");
            HSSFCell cell7=row.createCell(7);
            cell7.setCellValue("实际工资");
            HSSFCell cell8=row.createCell(8);
            cell8.setCellValue("迟到");
            HSSFCell cell9=row.createCell(9);
            cell9.setCellValue("缺席");
            HSSFCell cell10=row.createCell(10);
            cell10.setCellValue("时间");

            List<wage> list=adminService.findAllWage();


            for (int i = 0; i < list.size(); i++) {
                wage us = list.get(i);
                attendance attendance=adminService.searchLateAndAbsence(us.getEmployee_id(),us.getTime());
                int late=0;
                int absence=0;
                if(null!=attendance)
                {
                    late=attendance.getLate();
                    absence=attendance.getAbsence();
                }

                //创建表头
                HSSFRow lrow = sheet.createRow(i + 1);
                //创建单元格
                HSSFCell lcell = lrow.createCell(0);
                lcell.setCellValue(us.getEmployee_id());
                HSSFCell lcell1 = lrow.createCell(1);
                lcell1.setCellValue(us.getEmployee_name());
                HSSFCell lcell2 = lrow.createCell(2);
                lcell2.setCellValue(us.getDept_name());
                HSSFCell lcell3 = lrow.createCell(3);
                lcell3.setCellValue(us.getPosition());
                HSSFCell lcell4 = lrow.createCell(4);
                lcell4.setCellValue(us.getBasic_wage());
                HSSFCell lcell5 = lrow.createCell(5);
                lcell5.setCellValue(us.getAward());
                HSSFCell lcell6 = lrow.createCell(6);
                lcell6.setCellValue(us.getPunish_money());
                HSSFCell lcell7 = lrow.createCell(7);
                lcell7.setCellValue(us.getSalary());
                HSSFCell lcell8 = lrow.createCell(8);
                lcell8.setCellValue(late);
                HSSFCell lcell9 = lrow.createCell(9);
                lcell9.setCellValue(absence);
                HSSFCell lcell10 = lrow.createCell(10);
                lcell10.setCellValue(us.getTime());
            }
            //根据response获取输出流
            response.setContentType("application/force-download"); // 设置下载类型
            response.setHeader("Content-Disposition", "attachment;filename=salarys.xls"); // 设置文件的名称
            oStream = response.getOutputStream(); // 输出流
            //把工作薄写入到输出流
            wb.write(oStream);

        } catch (Exception e) {
            // TODO: handle exception
            try {
                oStream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @RequestMapping("/exportAward_punish")
    public void exportAward_punish(HttpServletResponse response)
    {
        OutputStream oStream = null;

        try {
//			创建工作簿
            HSSFWorkbook wb = new HSSFWorkbook();
//			创建sheet
            HSSFSheet sheet = wb.createSheet("列表");
//			创建表头
            HSSFRow row = sheet.createRow(0);
            //创建单元格
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("id");
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue("员工id");
            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue("员工姓名");
            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue("部门");
            HSSFCell cell4=row.createCell(4);
            cell4.setCellValue("职位");
            HSSFCell cell5=row.createCell(5);
            cell5.setCellValue("奖励原因");
            HSSFCell cell6=row.createCell(6);
            cell6.setCellValue("奖励金额");
            HSSFCell cell7=row.createCell(7);
            cell7.setCellValue("惩罚原因");
            HSSFCell cell8=row.createCell(8);
            cell8.setCellValue("惩罚金额");
            HSSFCell cell9=row.createCell(9);
            cell9.setCellValue("时间");

            List<allAward_punishInfo> list=adminService.searchAllAward_punish();


            for (int i = 0; i < list.size(); i++) {
                allAward_punishInfo us = list.get(i);
                attendance attendance=adminService.searchLateAndAbsence(us.getEmployee_id(),us.getTime());
                int late=0;
                int absence=0;
                if(null!=attendance)
                {
                    late=attendance.getLate();
                    absence=attendance.getAbsence();
                }

                //创建表头
                HSSFRow lrow = sheet.createRow(i + 1);
                //创建单元格
                HSSFCell lcell = lrow.createCell(0);
                lcell.setCellValue(us.getId());
                HSSFCell lcell1 = lrow.createCell(1);
                lcell1.setCellValue(us.getEmployee_id());
                HSSFCell lcell2 = lrow.createCell(2);
                lcell2.setCellValue(us.getEmployee_name());
                HSSFCell lcell3 = lrow.createCell(3);
                lcell3.setCellValue(us.getDept_name());
                HSSFCell lcell4 = lrow.createCell(4);
                lcell4.setCellValue(us.getPosition_name());
                HSSFCell lcell5 = lrow.createCell(5);
                lcell5.setCellValue(us.getAward_reason());
                HSSFCell lcell6 = lrow.createCell(6);
                lcell6.setCellValue(us.getAward_money());
                HSSFCell lcell7 = lrow.createCell(7);
                lcell7.setCellValue(us.getPunish_reason());
                HSSFCell lcell8 = lrow.createCell(8);
                lcell8.setCellValue(us.getPunish_money());
                HSSFCell lcell9 = lrow.createCell(9);
                lcell9.setCellValue(us.getTime());
            }
            //根据response获取输出流
            response.setContentType("application/force-download"); // 设置下载类型
            response.setHeader("Content-Disposition", "attachment;filename=award_punish.xls"); // 设置文件的名称
            oStream = response.getOutputStream(); // 输出流
            //把工作薄写入到输出流
            wb.write(oStream);

        } catch (Exception e) {
            // TODO: handle exception
            try {
                oStream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }


}
