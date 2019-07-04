package com.renshiproject.controller;


import com.renshiproject.Service.IManagerService;
import com.renshiproject.bean.attendance;
import com.renshiproject.bean.employee;
import com.renshiproject.bean.manager_info;
import com.renshiproject.pojo.allEmployeeInfo;
import com.renshiproject.Service.IManagerService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;



public class managerController {
    @Autowired
    IManagerService managerService;

    @RequestMapping("/addAttendance.do")
    public String addAttendance(int employee_id,String employee_name, String dept_name, String position, int absence, int late, String date)
    {
        employee e=new employee();
        e.setId(employee_id);
        e.setName(employee_name);
        int re=managerService.addAttendance(e,dept_name,position,absence,late,date);
        return "/manager/addAttendance";
    }

    @RequestMapping("/searchAllEmployeeInfo")
    public String searchAllEmployeeInfo(Model model, HttpSession session, Integer dept_id)
    {
        manager_info m= (manager_info) session.getAttribute("currentManager");
        List<allEmployeeInfo> all=managerService.searchAllEmployeeInfo(m.getDept_id());
        model.addAttribute("allEmployeeInfo",all);
        return "manager/searchAllEmployeeInfo";
    }

    @RequestMapping("/exportUserInfo")
    public void exportAttendance(HttpServletResponse response, HttpSession session)
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
            cell.setCellValue("员工id");
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue("员工姓名");
            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue("身份证");
            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue("手机号");
            HSSFCell cell4=row.createCell(4);
            cell4.setCellValue("性别");
            HSSFCell cell5=row.createCell(5);
            cell5.setCellValue("部门");
            HSSFCell cell6=row.createCell(6);
            cell6.setCellValue("职位");

            manager_info m= (manager_info) session.getAttribute("currentManager");
            List<allEmployeeInfo> list=managerService.searchAllEmployeeInfo(m.getDept_id());


            for (int i = 0; i < list.size(); i++) {
                allEmployeeInfo us = list.get(i);
                //创建表头
                HSSFRow lrow = sheet.createRow(i + 1);
                //创建单元格
                HSSFCell lcell = lrow.createCell(0);
                lcell.setCellValue(us.getId());
                HSSFCell lcell1 = lrow.createCell(1);
                lcell1.setCellValue(us.getName());
                HSSFCell lcell2 = lrow.createCell(2);
                lcell2.setCellValue(us.getId_number());
                HSSFCell lcell3 = lrow.createCell(3);
                lcell3.setCellValue(us.getPhone_number());
                HSSFCell lcell4 = lrow.createCell(4);
                lcell4.setCellValue(us.getGender());
                HSSFCell lcell5 = lrow.createCell(5);
                lcell5.setCellValue(us.getDept_name());
                HSSFCell lcell6 = lrow.createCell(6);
                lcell6.setCellValue(us.getPosition_name());
            }
            //根据response获取输出流
            response.setContentType("application/force-download"); // 设置下载类型
            response.setHeader("Content-Disposition", "attachment;filename=userInfo.xls"); // 设置文件的名称
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

    @RequestMapping("/exportAttendance")
    public void exportUserInfo(HttpServletResponse response)
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
            cell.setCellValue("员工id");
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue("员工姓名");
            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue("部门");
            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue("职位");
            HSSFCell cell4=row.createCell(4);
            cell4.setCellValue("缺席");
            HSSFCell cell5=row.createCell(5);
            cell5.setCellValue("迟到");
            HSSFCell cell6=row.createCell(6);
            cell6.setCellValue("时间");

            List<attendance> list=managerService.findAllAttendance();


            for (int i = 0; i < list.size(); i++) {
                attendance us = list.get(i);
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
                lcell4.setCellValue(us.getAbsence());
                HSSFCell lcell5 = lrow.createCell(5);
                lcell5.setCellValue(us.getLate());
                HSSFCell lcell6 = lrow.createCell(6);
                lcell6.setCellValue(us.getTime());
            }
            //根据response获取输出流
            response.setContentType("application/force-download"); // 设置下载类型
            response.setHeader("Content-Disposition", "attachment;filename=attendance.xls"); // 设置文件的名称
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