package com.renshiproject.Service.ServiceImpl;

import com.renshiproject.Service.IEmployeeService;
import com.renshiproject.dao.EmployeeDOMapper;
import com.renshiproject.dataobject.EmployeeDO;
import com.renshiproject.viewObject.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Override
    public List<EmployeeDO> searchEmployee(String username) {
        return employeeDOMapper.searchEmployee(username);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeDOMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateEmployee(EmployeeDO employeeDO) {
        employeeDOMapper.updateEmployee(employeeDO);
    }

    @Override
    public List<EmployeeDO> allEmployee() {
        return employeeDOMapper.allEmployee();
    }

    @Autowired
    private EmployeeDOMapper employeeDOMapper;

    @Override
    public void addEmployee(EmployeeDO employeeDO) {
        employeeDOMapper.addEmployee(employeeDO);
    }

    @Override
    public EmployeeDO checkEmployee(EmployeeDO employeeDO) {

        return employeeDOMapper.selectByIdAndPwd(employeeDO);
    }

    @Override
    public EmployeeDO selectById(int id) {
        return employeeDOMapper.selectById(id);
    }

    @Override
    public EmployeeVO getEmployeeInfoById(int id) {
        return employeeDOMapper.selectById2VO(id);
    }
}
