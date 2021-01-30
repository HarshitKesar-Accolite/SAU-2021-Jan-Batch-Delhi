package com.harshit.assignment.rowmapper;

import com.harshit.assignment.model.Transaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRowMapper implements RowMapper<Transaction> {

    @Override
    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
        System.out.println(resultSet.toString());
        Transaction transaction = new Transaction();
        transaction.settId(resultSet.getInt("transaction_number"));
        transaction.setAccountNo(resultSet.getInt("account_number"));
        transaction.setCurrencySerialKey(resultSet.getInt("currency_serial_key"));
        transaction.setLegal(resultSet.getBoolean("legal"));
        return transaction;
    }
}
