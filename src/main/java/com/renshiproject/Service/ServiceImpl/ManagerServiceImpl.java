package com.renshiproject.Service.ServiceImpl;

import com.renshiproject.Service.IManagerService;
import com.renshiproject.dao.ManagerInfoDOMapper;
import com.renshiproject.dataobject.ManagerInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ManagerServiceImpl implements IManagerService {

    @Autowired
    private ManagerInfoDOMapper managerInfoDOMapper;

    @Override
    public ManagerInfoDO checkManager(ManagerInfoDO managerInfoDO) {
        return managerInfoDOMapper.selectByIdAndPwd(managerInfoDO);
    }
}
