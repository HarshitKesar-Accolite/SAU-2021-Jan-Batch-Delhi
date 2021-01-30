package com.harshit.assignment.controller;

import com.harshit.assignment.model.Transaction;
import com.harshit.assignment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/getTransactions")
    @CrossOrigin("*")
    public ResponseEntity<List<Transaction>> getTransactions() {
        return  new ResponseEntity<>(transactionService.getTransactions(), HttpStatus.OK);
    }

    @GetMapping("/getTransactionByAccountNo/{accountNo}")
    @CrossOrigin("*")
    public ResponseEntity<List<Transaction>> getTransactionByAccount(@PathVariable("accountNo") int accountNumber) {
        return new ResponseEntity<>(transactionService.getTransactionByAccount(accountNumber),HttpStatus.OK);
    }


    @PostMapping("/addTransaction")
    @CrossOrigin("*")
    public ResponseEntity<Integer> addTransaction(@RequestBody Transaction transaction, @RequestParam(name = "amt") int amt) {
        return new ResponseEntity<>(this.transactionService.addNewTransaction(transaction, amt),HttpStatus.OK);
    }


}
