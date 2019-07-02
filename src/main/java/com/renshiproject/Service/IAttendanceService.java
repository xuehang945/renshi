package com.renshiproject.Service;

import com.renshiproject.dataobject.AttendanceDO;
import com.renshiproject.dataobject.AttendanceDOKey;


public interface IAttendanceService {

    int deleteByPrimaryKey(AttendanceDOKey key);

    int insert(AttendanceDO record);


    int insertSelective(AttendanceDO record);


    AttendanceDO selectByPrimaryKey(AttendanceDOKey key);


    int updateByPrimaryKeySelective(AttendanceDO record);


    int updateByPrimaryKey(AttendanceDO record);
}
