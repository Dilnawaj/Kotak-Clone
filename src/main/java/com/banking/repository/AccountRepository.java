package com.banking.repository;

import com.banking.model.Account;

import com.banking.model.AccountStatus;
import com.banking.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(String accountNumber);
    List<Account> findByCustomer(Customer customer);
    List<Account> findByStatus(AccountStatus status);

    @Query("SELECT a FROM Account a WHERE a.customer.customerId = ?1")
    List<Account> findByCustomerId(Long customerId);

    @Query("SELECT a FROM Account a WHERE a.customer.customerId = ?1 AND a.status = ?2")
    List<Account> findByCustomerIdAndStatus(Long customerId, AccountStatus status);

    boolean existsByAccountNumber(String accountNumber);
}