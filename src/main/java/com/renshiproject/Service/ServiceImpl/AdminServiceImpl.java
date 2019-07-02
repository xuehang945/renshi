package com.renshiproject.Service.ServiceImpl;

import com.renshiproject.Service.IAdminService;
import com.renshiproject.dao.AdministratorInfoDOMapper;
import com.renshiproject.dataobject.AdministratorInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdministratorInfoDOMapper administratorInfoDOMapper;

    @Override
    public AdministratorInfoDO chechAdmin(AdministratorInfoDO administratorInfoDO) {
        return administratorInfoDOMapper.selectByIdAndPwd(administratorInfoDO);
    }
}
