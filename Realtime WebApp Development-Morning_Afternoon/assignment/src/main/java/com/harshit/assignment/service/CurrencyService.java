package com.harshit.assignment.service;

import com.harshit.assignment.dao.CurrencyDao;
import com.harshit.assignment.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CurrencyService {
    @Autowired
    CurrencyDao currencyDao;

    public int addNewCurrency(Currency currency) {
        return this.currencyDao.addNewCurrency(currency);
    }
}
