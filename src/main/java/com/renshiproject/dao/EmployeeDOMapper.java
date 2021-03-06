package com.renshiproject.dao;

import com.renshiproject.dataobject.EmployeeDO;
import com.renshiproject.viewObject.EmployeeVO;

import java.util.List;

public interface EmployeeDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    int insert(EmployeeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    int addEmployee(EmployeeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    EmployeeDO selectById(Integer id);

    EmployeeDO selectByIdAndPwd(EmployeeDO employeeDO);

    EmployeeVO selectById2VO(int id);

    List<EmployeeDO> allEmployee();

    void updateEmployee(EmployeeDO employeeDO);

    List<EmployeeDO> searchEmployee(String username);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    int updateByPrimaryKeySelective(EmployeeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    int updateByPrimaryKey(EmployeeDO record);

    int deleteFromDept(int id);
}