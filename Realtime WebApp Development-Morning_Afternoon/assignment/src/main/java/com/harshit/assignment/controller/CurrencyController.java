package com.harshit.assignment.controller;

import com.harshit.assignment.model.Currency;
import com.harshit.assignment.model.User;
import com.harshit.assignment.service.CurrencyService;
import com.harshit.assignment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @PostMapping("/addCurrency")
    @CrossOrigin("*")
    public ResponseEntity<Object> addCurrency(@RequestParam(name = "key") int currencyKey, @RequestParam(name = "amt") int amt) {
        Currency currency = new Currency(currencyKey, amt);
        return new ResponseEntity<>(currencyService.addNewCurrency(currency), HttpStatus.OK);
    }
}
