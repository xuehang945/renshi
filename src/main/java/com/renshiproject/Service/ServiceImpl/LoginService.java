package com.renshiproject.Service.ServiceImpl;


import com.renshiproject.bean.administratorinfo;
import com.renshiproject.bean.employee;
import com.renshiproject.bean.manager_info;
import com.renshiproject.dao.ILoginDao;
import com.renshiproject.pojo.allEmployeeInfo;
import com.renshiproject.Service.ILoginService;
import com.renshiproject.Service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {
    @Autowired
    private ILoginDao loginDao;

    @Override
    public administratorinfo administratorinfoLogin(String id, String password) {
        return loginDao.administratorinfoLogin(id,password);
    }

    @Override
    public manager_info manager_infoLogin(String id, String password) {
        return loginDao.manager_infoLogin(id,password);
    }

    @Override
    public allEmployeeInfo employeeLogin(String id, String password) {
        return loginDao.employeeLogin(id,password);
    }
}
