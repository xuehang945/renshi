package com.renshiproject.Service;

import com.renshiproject.bean.*;
import com.renshiproject.dataobject.AdministratorInfoDO;
import com.renshiproject.pojo.allAward_punishInfo;
import com.renshiproject.pojo.allEmployeeInfo;

import java.util.List;

public interface IAdminService {
    public AdministratorInfoDO chechAdmin(AdministratorInfoDO administratorInfoDO);


    public int addPosition(String addPositionName);
    public List<position> findAllPosition();
    public List<department> findAllDepartment();
    public int renamePosition(int position_id, String renamePositionName);
    public List<allEmployeeInfo> searchPosition(int id);
    public List<allAward_punishInfo> searchAllAward_punish();
    public List<allAward_punishInfo> searchAward_punish(int employee_id, String date);
    public int deletePosition(int position_id);

    public int addAward_punish(award_punish ap);
    public int updateAward_punish(award_punish ap);
    public int deleteAward_punish(int employee_id, String date);


    public List<wage> findAllWage();
    public int addWage(wage wage);
    public attendance searchLateAndAbsence(int employee_id, String date);
    public int deleteWage(int employee_id, String date);
}
