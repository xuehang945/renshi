package com.renshiproject.dao;

import com.renshiproject.dataobject.AdministratorInfoDO;

public interface AdministratorInfoDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administratorinfo
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administratorinfo
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    int insert(AdministratorInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administratorinfo
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    int insertSelective(AdministratorInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administratorinfo
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    AdministratorInfoDO selectByPrimaryKey(Integer id);

    AdministratorInfoDO selectByIdAndPwd(AdministratorInfoDO administratorInfoDO);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administratorinfo
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    int updateByPrimaryKeySelective(AdministratorInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administratorinfo
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    int updateByPrimaryKey(AdministratorInfoDO record);
}