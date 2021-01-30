package com.harshit.assignment.controller;

import com.harshit.assignment.model.User;
import com.harshit.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<Object> authenticateAdmin(@RequestParam(name = "id") String id, @RequestParam(name = "password") String password) {
        return new ResponseEntity<>(id.equals("root") && id.equals("root") ? id : null, HttpStatus.OK);
    }


    @GetMapping("/getInfoByAccountNo/{account_number}")
    @CrossOrigin("*")
    public ResponseEntity<Object> getByAccountNumber(@PathVariable("account_number") int accountNumber) {
        Object result = userService.getByAccountNumber(accountNumber);
        return new ResponseEntity<>(result==null?null:result, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    @CrossOrigin("*")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);
    }
}
