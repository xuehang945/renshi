package com.renshiproject.Service;

import com.renshiproject.dataobject.FileDO;

public interface IFileService {
    int deleteByPrimaryKey(Integer fileId);

    int insert(FileDO record);


    int insertSelective(FileDO record);

    FileDO selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKeySelective(FileDO record);


    int updateByPrimaryKey(FileDO record);
}
