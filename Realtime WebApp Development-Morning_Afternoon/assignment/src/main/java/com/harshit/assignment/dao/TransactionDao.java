package com.harshit.assignment.dao;

import com.harshit.assignment.model.Currency;
import com.harshit.assignment.model.Transaction;
import com.harshit.assignment.rowmapper.TransactionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class TransactionDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CurrencyDao currencyDao;

    public int addNewTransaction(Transaction transaction, int amount) {
        boolean illegalTransaction = false;
        if(!currencyDao.isDuplicate(transaction.getCurrencySerialKey())) {
            illegalTransaction = true;
            currencyDao.addCurrency(new Currency(transaction.getCurrencySerialKey(), amount));
        }

        KeyHolder keyHolder = new GeneratedKeyHolder();
        boolean finalIllegalTransaction = illegalTransaction;
        this.jdbcTemplate.update(connection -> {
            PreparedStatement stmt = connection.prepareStatement("Insert into transactions(account_number,note_serial_number,legal) values (?,?,?)", new String[]{"transaction_number"});
            stmt.setInt(1,transaction.getAccountNo());
            stmt.setInt(2, transaction.getCurrencySerialKey());
            stmt.setBoolean(3, finalIllegalTransaction);
            return stmt;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public List<Transaction> getTransactionByAccountNumber(int accountNumber) {
        final String get_transaction="select * from transactions where account_number= "+accountNumber;
        return this.jdbcTemplate.query(get_transaction,new TransactionRowMapper());
    }

    public List<Transaction> getTransactions() {
        return  this.jdbcTemplate.query("select * from transactions",new TransactionRowMapper());
    }

}
