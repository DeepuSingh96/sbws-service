package com.tcs.sbws.service;

import com.tcs.sbws.dao.LoginDao;
import com.tcs.sbws.utils.EncryptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoginDao loginDao;

    public  String addUser(com.tcs.sbws.entity.LoginEntity login) {
        try {
            String encryptedPass = EncryptionUtil.encryptText(login.getPassword());
            System.out.println("\n" + login.getPassword() + " : " + encryptedPass);
            login.setPassword(encryptedPass);
            boolean result=loginDao.addUser(login);
            if(result){
                return "user created";
            }

        }
        // For specifying wrong message digest algorithms
        catch (Exception e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        return "user not created";
    }
    public String login(com.tcs.sbws.entity.LoginEntity login) {
        try {
            LOG.info("Getting user with employeeNo: {}.",login.getEmployeeNo());
            String encryptedPass = EncryptionUtil.encryptText(login.getPassword());
            Query query = new Query();
            query.addCriteria(Criteria.where("employeeNo").is(login.getEmployeeNo()).andOperator(Criteria.where("password").is(encryptedPass)));
            boolean login1 = loginDao.login(query);
            if (login1){
                return "login success";
            }
        } catch (Exception e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        return "login fail";
    }
}
