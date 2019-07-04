package com.renshiproject.Service.ServiceImpl;

import com.renshiproject.bean.*;
import com.renshiproject.dao.AdministratorInfoDOMapper;
import com.renshiproject.dao.IAdminDao;
import com.renshiproject.dataobject.AdministratorInfoDO;
import com.renshiproject.pojo.allAward_punishInfo;
import com.renshiproject.pojo.allEmployeeInfo;
import com.renshiproject.Service.IAdminService;
import com.renshiproject.bean.*;
import com.renshiproject.dao.IAdminDao;
import com.renshiproject.pojo.allAward_punishInfo;
import com.renshiproject.pojo.allEmployeeInfo;
import com.renshiproject.Service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminService implements IAdminService {
    @Autowired
    IAdminDao adminDao;
    @Override
    public int addPosition(String addPositionName) {
        return adminDao.addPosition(addPositionName);
    }

    @Override
    public List<position> findAllPosition() {
        return adminDao.findAllPosition();
    }

    @Override
    public List<department> findAllDepartment() {
        return adminDao.findAllDepartment();
    }

    @Override
    public int renamePosition(int position_id, String renamePositionName) {
        return adminDao.renamePosition(position_id,renamePositionName);
    }

    @Override
    public List<allEmployeeInfo> searchPosition(int id) {
        return adminDao.searchPosition(id);
    }

    @Override
    public List<allAward_punishInfo> searchAllAward_punish() {
        return adminDao.searchAllAward_punish();
    }

    @Override
    public List<allAward_punishInfo> searchAward_punish(int employee_id,String date) {
        return adminDao.searchAward_punish(employee_id,date);
    }

    @Override
    public int deletePosition(int position_id) {
        return adminDao.deletePosition(position_id);
    }

    @Override
    public int addAward_punish(award_punish ap) {
        return adminDao.addAward_punish(ap);
    }

    @Override
    public int updateAward_punish(award_punish ap) {
        return adminDao.updateAward_punish(ap);
    }
    public int deleteAward_punish(int employee_id,String date)
    {
        return adminDao.deleteAward_punish(employee_id,date);
    }

    @Override
    public List<wage> findAllWage() {
        return adminDao.findAllWage();
    }

    @Override
    public int addWage(wage wage) {
        return adminDao.addWage(wage);
    }

    @Override
    public attendance searchLateAndAbsence(int employee_id, String date) {
        return adminDao.searchLateAndAbsence(employee_id,date);
    }

    @Override
    public int deleteWage(int employee_id, String date) {
        return adminDao.deleteWage(employee_id,date);
    }


    @Autowired
    private AdministratorInfoDOMapper administratorInfoDOMapper;

    @Override
    public AdministratorInfoDO chechAdmin(AdministratorInfoDO administratorInfoDO) {
        return administratorInfoDOMapper.selectByIdAndPwd(administratorInfoDO);
    }
}
