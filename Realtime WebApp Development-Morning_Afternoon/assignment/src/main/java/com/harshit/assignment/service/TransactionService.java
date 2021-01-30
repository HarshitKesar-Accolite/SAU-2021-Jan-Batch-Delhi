package com.harshit.assignment.service;

import com.harshit.assignment.dao.TransactionDao;
import com.harshit.assignment.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionService {

    @Autowired
    TransactionDao transactionDao;

    public int addNewTransaction(Transaction transaction, int amount) {
        return this.transactionDao.addNewTransaction(transaction,amount);
    }

    public List<Transaction> getTransactionByAccount(int accountNumber) {
        return transactionDao.getTransactionByAccountNumber(accountNumber);
    }

    public List<Transaction> getTransactions() {
        return transactionDao.getTransactions();
    }

}