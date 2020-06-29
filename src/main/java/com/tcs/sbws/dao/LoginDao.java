package com.tcs.sbws.dao;

import com.tcs.sbws.entity.LoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class LoginDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public boolean addUser(com.tcs.sbws.entity.LoginEntity login) {
        try {
            mongoTemplate.save(login);
        } catch (Exception e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
            return false;
        }
        return true;
    }

    public boolean login(Query query) {
        try {
            LoginEntity one = mongoTemplate.findOne(query, LoginEntity.class);
            if(one == null){
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
            return false;
        }
        return true;
    }
}
