package com.renshiproject.Service;

import com.renshiproject.dataobject.ManagerInfoDO;
import org.springframework.stereotype.Service;


public interface IManagerService {
    public ManagerInfoDO checkManager(ManagerInfoDO managerInfoDO);
}
