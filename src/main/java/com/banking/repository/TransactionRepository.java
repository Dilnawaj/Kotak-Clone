package com.banking.repository;

import com.banking.model.Transaction;
import com.banking.model.Account;
import com.banking.model.TransactionStatus;
import com.banking.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByFromAccountOrderByTransactionDateDesc(Account account);
    List<Transaction> findByToAccountOrderByTransactionDateDesc(Account account);
    List<Transaction> findByStatus(TransactionStatus status);
    List<Transaction> findByTransactionType(TransactionType type);

    @Query("SELECT t FROM Transaction t WHERE t.fromAccount = ?1 OR t.toAccount = ?1 ORDER BY t.transactionDate DESC")
    Page<Transaction> findByAccountOrderByTransactionDateDesc(Account account, Pageable pageable);

    @Query("SELECT t FROM Transaction t WHERE (t.fromAccount = ?1 OR t.toAccount = ?1) AND t.transactionDate BETWEEN ?2 AND ?3")
    List<Transaction> findByAccountAndDateRange(Account account, LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT t FROM Transaction t WHERE t.transactionReference = ?1")
    Optional<Transaction> findByTransactionReference(String transactionReference);
}