package com.iq.banking.bankingcore.controller;

import com.iq.banking.bankingcore.entity.Account;
import com.iq.banking.bankingcore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Create a new account
    // POST http://localhost:8080/api/accounts?holderName=Arislan&type=SAVINGS
    @PostMapping
    public Account createAccount(@RequestParam String holderName, @RequestParam String type) {
        return accountService.createAccount(holderName, type);
    }

    // Get account by ID
    // GET http://localhost:8080/api/accounts/1
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    // Get account by account number
    // GET http://localhost:8080/api/accounts/number/IQB123456789
    @GetMapping("/number/{accountNumber}")
    public Account getAccountByNumber(@PathVariable String accountNumber) {
        return accountService.getAccountByNumber(accountNumber);
    }

    // Get all accounts
    // GET http://localhost:8080/api/accounts
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}