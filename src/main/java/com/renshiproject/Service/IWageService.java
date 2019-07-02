package com.renshiproject.Service;

import com.renshiproject.dataobject.WageDO;
import com.renshiproject.dataobject.WageDOKey;

public interface IWageService {

    public int deleteByPrimaryKey(WageDOKey key);

    public int insert(WageDO record);

    public int insertSelective(WageDO record);

    public WageDO selectByPrimaryKey(WageDOKey key);

    public int updateByPrimaryKeySelective(WageDO record);

    public int updateByPrimaryKey(WageDO record);
}
