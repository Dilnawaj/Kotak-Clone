package com.banking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private Long transactionId;
    private String transactionReference;
    private String transactionType;
    private BigDecimal amount;
    private String description;
    private String status;
    private LocalDateTime transactionDate;
    private String fromAccountNumber;
    private String toAccountNumber;
}