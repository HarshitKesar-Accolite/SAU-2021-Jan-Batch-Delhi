package com.harshit.assignment.dao;

import com.harshit.assignment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String addUser(User user) {
        System.out.println(user.toString());
        if(getByAccountNumber(user.getAccountNo()) == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            this.jdbcTemplate.update(connection -> {
                PreparedStatement stmt = connection.prepareStatement("insert into users(username, account_number) values(? , ?)");
                stmt.setString(1, user.getUserName());
                stmt.setInt(2, user.getAccountNo());
                return stmt;
            }, keyHolder);
            return "Added Successfully";
        }
        return "Already Exists";
    }

    public User getByAccountNumber(int accountNumber) {
        try {
            return this.jdbcTemplate.queryForObject("select username,account_number from users where account_number = ?", this::mapRowToUser, accountNumber);
        }
        catch (Exception e) {
            return null;
        }
    }

    private User mapRowToUser(ResultSet resultSet, int rowNumber) throws SQLException {
        User user= new User();
        user.setUserName(resultSet.getString("username"));
        user.setAccountNo(resultSet.getInt("account_number"));
        return  user;
    }
}
