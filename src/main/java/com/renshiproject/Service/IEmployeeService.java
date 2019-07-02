package com.renshiproject.Service;

import com.renshiproject.dataobject.EmployeeDO;
import com.renshiproject.viewObject.EmployeeVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IEmployeeService {
    public EmployeeDO checkEmployee(EmployeeDO employeeDO);
    public EmployeeVO getEmployeeInfoById(int id);
    public void addEmployee(EmployeeDO employeeDO);
    public List<EmployeeDO> allEmployee();
    public void updateEmployee(EmployeeDO employeeDO);
    public void deleteEmployee(Integer id);
    public List<EmployeeDO> searchEmployee(String username);
    public EmployeeDO selectById(int id);
}
