package com.renshiproject.Service;

import com.renshiproject.dataobject.PositionDO;

public interface IPositionService {
    int deleteByPrimaryKey(Integer positionId);

    int insert(PositionDO record);

    int insertSelective(PositionDO record);


    PositionDO selectByPrimaryKey(Integer positionId);


    int updateByPrimaryKeySelective(PositionDO record);


    int updateByPrimaryKey(PositionDO record);
}
