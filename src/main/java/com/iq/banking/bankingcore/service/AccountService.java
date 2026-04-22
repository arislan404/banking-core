package com.iq.banking.bankingcore.service;

import com.iq.banking.bankingcore.entity.Account;
import com.iq.banking.bankingcore.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Create a new bank account
    public Account createAccount(String accountHolderName, String accountType) {
        // Generate a unique account number
        String accountNumber = generateAccountNumber();

        // Create new account object
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setAccountHolderName(accountHolderName);
        account.setBalance(0.0);           // New account starts with zero balance
        account.setAccountType(accountType);
        account.setCreatedAt(LocalDateTime.now());  // Current date and time
        account.setIsActive(true);          // Account is active

        // Save to database and return
        return accountRepository.save(account);
    }

    // Generate a unique account number
    private String generateAccountNumber() {
        // Format: IQB + current time in milliseconds + 4 random digits
        long timestamp = System.currentTimeMillis();
        int random = new Random().nextInt(10000);
        return "IQB" + timestamp + String.format("%04d", random);
    }

    // Get account by ID (like account ID 1, 2, 3...)
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
    }

    // Get account by account number (like IQB123456789)
    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found with number: " + accountNumber));
    }

    // Get all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}