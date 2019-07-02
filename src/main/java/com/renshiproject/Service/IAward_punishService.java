package com.renshiproject.Service;

import com.renshiproject.dataobject.Award_punishDO;


public interface IAward_punishService {

    public int deleteByPrimaryKey(Integer id);

    public int insert(Award_punishDO record);

    public int insertSelective(Award_punishDO record);

    public Award_punishDO selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(Award_punishDO record);

    public int updateByPrimaryKey(Award_punishDO record);
}
