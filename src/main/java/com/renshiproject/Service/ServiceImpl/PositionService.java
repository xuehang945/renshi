package com.renshiproject.Service.ServiceImpl;

import com.renshiproject.Service.IPositionService;
import com.renshiproject.dao.PositionDOMapper;
import com.renshiproject.dataobject.PositionDO;
import org.springframework.stereotype.Service;

@Service
public class PositionService implements IPositionService {
    private PositionDOMapper positionDOMapper;
    @Override
    public int deleteByPrimaryKey(Integer positionId) {
        return positionDOMapper.deleteByPrimaryKey(positionId);
    }

    @Override
    public int insert(PositionDO record) {
        return positionDOMapper.insert(record);
    }

    @Override
    public int insertSelective(PositionDO record) {
        return positionDOMapper.insertSelective(record);
    }

    @Override
    public PositionDO selectByPrimaryKey(Integer positionId) {
        return positionDOMapper.selectByPrimaryKey(positionId);
    }

    @Override
    public int updateByPrimaryKeySelective(PositionDO record) {
        return positionDOMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PositionDO record) {
        return positionDOMapper.updateByPrimaryKeySelective(record);
    }
}
