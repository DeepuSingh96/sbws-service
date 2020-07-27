package com.tcs.sbws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.sbws.dao.UserDao;
import com.tcs.sbws.entity.addUserEntity;



@Service
public class addUserservice {
    @Autowired
    private UserDao addUserlogin;

    public  String addUser(addUserEntity login) {
        try {

            boolean result=addUserlogin.addUser(login);
            if(result){
                return "user created";
            }

        }
        catch (Exception e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        return "user not created";
    }

}
