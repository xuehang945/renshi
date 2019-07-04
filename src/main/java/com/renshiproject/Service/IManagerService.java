package com.renshiproject.Service;

import com.renshiproject.bean.attendance;
import com.renshiproject.bean.employee;
import com.renshiproject.dataobject.ManagerInfoDO;
import com.renshiproject.pojo.allEmployeeInfo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IManagerService {
    public ManagerInfoDO checkManager(ManagerInfoDO managerInfoDO);


    public int addAttendance(employee e, String dept_name, String position, int absence, int late, String date);
    public List<allEmployeeInfo> searchAllEmployeeInfo(int dept_id);
    public List<attendance> findAllAttendance();
}
