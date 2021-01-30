package com.harshit.assignment.dao;

import com.harshit.assignment.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class CurrencyDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean isDuplicate(int serialKey) {
        Integer result = this.jdbcTemplate.queryForObject("Select count(*) from currencies where currency_serial_key = " + serialKey, Integer.class);
        return (result > 0);
    }

    public void addCurrency(Currency currency) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(connection -> {
            PreparedStatement stmt = connection.prepareStatement("insert into currencies(currency_amount, currency_serial_key) values(? , ?)");
            stmt.setInt(1,currency.getAmt());
            stmt.setInt(2, currency.getSerialKey());
            return stmt;
        }, keyHolder);
    }

    public int addNewCurrency(Currency currency) {
        final String SAVE_CURRENCY = "insert into currencies(currency_serial_key, currency_amount) values(?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(connection -> {
            PreparedStatement stmt = connection.prepareStatement(SAVE_CURRENCY);
            stmt.setInt(1, currency.getSerialKey());
            stmt.setInt(2, currency.getAmt());
            return stmt;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }
}
