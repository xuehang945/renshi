package com.renshiproject.Service.ServiceImpl;

import com.renshiproject.bean.attendance;
import com.renshiproject.bean.employee;
import com.renshiproject.dao.IManagerDao;
import com.renshiproject.dao.ManagerInfoDOMapper;
import com.renshiproject.dataobject.ManagerInfoDO;
import com.renshiproject.pojo.allEmployeeInfo;
import com.renshiproject.Service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService implements IManagerService {
    @Autowired
    IManagerDao managerDao;
    @Override
    public int addAttendance(employee e, String dept_name, String position, int absence, int late, String date) {
        int re=managerDao.addAttendance(e,dept_name,position,absence,late,date);
        return  re;
    }

    @Override
    public List<allEmployeeInfo> searchAllEmployeeInfo(int dept_id) {
        return managerDao.searchAllEmployeeInfo(dept_id);
    }

    @Override
    public List<attendance> findAllAttendance() {
        return managerDao.findAllAttendance();
    }

    @Autowired
    private ManagerInfoDOMapper managerInfoDOMapper;

    @Override
    public ManagerInfoDO checkManager(ManagerInfoDO managerInfoDO) {
        return managerInfoDOMapper.selectByIdAndPwd(managerInfoDO);
    }
}
