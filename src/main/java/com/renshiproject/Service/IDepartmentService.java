package com.renshiproject.Service;

import com.renshiproject.dataobject.DepartmentDO;

import java.util.List;

//部门管理Service


public interface IDepartmentService {
    public int deleteByPrimaryKey(Integer deptId);


    public void addDept(DepartmentDO record);

    public int insertSelective(DepartmentDO record);

    public DepartmentDO selectByPrimaryKey(Integer deptId);

    public int updateDept(DepartmentDO record);

    public int updateByPrimaryKey(DepartmentDO record);

    public List<DepartmentDO> allDepartment();

    public List<DepartmentDO> searchDept(String deptName);


}
