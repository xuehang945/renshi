package com.renshiproject.Service.ServiceImpl;

import com.renshiproject.Service.IFileService;
import com.renshiproject.dao.FileDOMapper;
import com.renshiproject.dataobject.FileDO;
import org.springframework.stereotype.Service;

@Service
public class FileService implements IFileService {
    private FileDOMapper fileDOMapper;

    @Override
    public int deleteByPrimaryKey(Integer fileId) {
        return fileDOMapper.deleteByPrimaryKey(fileId);
    }

    @Override
    public int insert(FileDO record) {
        return fileDOMapper.insert(record);
    }

    @Override
    public int insertSelective(FileDO record) {
        return fileDOMapper.insertSelective(record);
    }

    @Override
    public FileDO selectByPrimaryKey(Integer fileId) {
        return fileDOMapper.selectByPrimaryKey(fileId);
    }

    @Override
    public int updateByPrimaryKeySelective(FileDO record) {
        return fileDOMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FileDO record) {
        return fileDOMapper.updateByPrimaryKey(record);
    }
}
