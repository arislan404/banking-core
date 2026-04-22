package com.iq.banking.bankingcore.repository;

import java.util.List;
import com.iq.banking.bankingcore.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Find account by account number (custom query)
    Optional<Account> findByAccountNumber(String accountNumber);

    // Find all active accounts
    List<Account> findByIsActiveTrue();

    // Find accounts by holder name (partial match)
    List<Account> findByAccountHolderNameContaining(String name);
}