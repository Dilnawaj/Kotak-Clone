package com.banking.controller;

import com.banking.dto.TransactionDTO;
import com.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity<TransactionDTO> deposit(@RequestBody Map<String, Object> request) {
        String accountNumber = (String) request.get("accountNumber");
        BigDecimal amount = new BigDecimal(request.get("amount").toString());
        String description = (String) request.get("description");

        TransactionDTO transaction = transactionService.deposit(accountNumber, amount, description);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<TransactionDTO> withdraw(@RequestBody Map<String, Object> request) {
        String accountNumber = (String) request.get("accountNumber");
        BigDecimal amount = new BigDecimal(request.get("amount").toString());
        String description = (String) request.get("description");

        TransactionDTO transaction = transactionService.withdraw(accountNumber, amount, description);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransactionDTO> transfer(@RequestBody Map<String, Object> request) {
        String fromAccountNumber = (String) request.get("fromAccountNumber");
        String toAccountNumber = (String) request.get("toAccountNumber");
        BigDecimal amount = new BigDecimal(request.get("amount").toString());
        String description = (String) request.get("description");

        TransactionDTO transaction = transactionService.transfer(fromAccountNumber, toAccountNumber, amount, description);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @GetMapping("/history/{accountNumber}")
    public ResponseEntity<List<TransactionDTO>> getTransactionHistory(@PathVariable String accountNumber) {
        List<TransactionDTO> transactions = transactionService.getTransactionHistory(accountNumber);
        return ResponseEntity.ok(transactions);
    }
}