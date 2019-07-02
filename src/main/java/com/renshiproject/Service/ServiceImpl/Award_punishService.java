package com.renshiproject.Service.ServiceImpl;

import com.renshiproject.Service.IAward_punishService;
import com.renshiproject.dao.Award_punishDOMapper;
import com.renshiproject.dataobject.Award_punishDO;
import org.springframework.stereotype.Service;

@Service
public class Award_punishService implements IAward_punishService {
    private Award_punishDOMapper award_punishDOMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return award_punishDOMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Award_punishDO record) {
        return award_punishDOMapper.insert(record);
    }

    @Override
    public int insertSelective(Award_punishDO record) {
        return award_punishDOMapper.insertSelective(record);
    }

    @Override
    public Award_punishDO selectByPrimaryKey(Integer id) {
        return award_punishDOMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Award_punishDO record) {
        return award_punishDOMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Award_punishDO record) {
        return award_punishDOMapper.updateByPrimaryKey(record);
    }
}
