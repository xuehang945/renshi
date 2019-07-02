package com.renshiproject.Service.ServiceImpl;

import com.renshiproject.Service.IAttendanceService;
import com.renshiproject.dao.AttendanceDOMapper;
import com.renshiproject.dataobject.AttendanceDO;
import com.renshiproject.dataobject.AttendanceDOKey;
import org.springframework.stereotype.Service;


@Service
public class AttendanceService implements IAttendanceService {
    private AttendanceDOMapper attendanceDOMapper;

    @Override
    public int deleteByPrimaryKey(AttendanceDOKey key) {
        return attendanceDOMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(AttendanceDO record) {
        return attendanceDOMapper.insert(record);
    }

    @Override
    public int insertSelective(AttendanceDO record) {
        return attendanceDOMapper.insertSelective(record);
    }

    @Override
    public AttendanceDO selectByPrimaryKey(AttendanceDOKey key) {
        return attendanceDOMapper.selectByPrimaryKey(key);
    }

    @Override
    public int updateByPrimaryKeySelective(AttendanceDO record) {
        return attendanceDOMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AttendanceDO record) {
        return attendanceDOMapper.updateByPrimaryKey(record);
    }
}
