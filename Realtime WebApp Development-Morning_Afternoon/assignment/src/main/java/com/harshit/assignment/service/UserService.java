package com.harshit.assignment.service;

import com.harshit.assignment.dao.UserDao;
import com.harshit.assignment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public String addUser(User user) {
        return this.userDao.addUser(user);
    }

    public  User getByAccountNumber(int accountNumber) {
        return this.userDao.getByAccountNumber(accountNumber);
    }

}