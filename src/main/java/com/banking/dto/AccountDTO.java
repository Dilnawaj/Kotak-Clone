package com.banking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Long accountId;
    private String accountNumber;

    @NotBlank(message = "Account type is required")
    @Pattern(regexp = "SAVINGS|CURRENT|FIXED_DEPOSIT|RECURRING_DEPOSIT",
            message = "Account type must be SAVINGS, CURRENT, FIXED_DEPOSIT, or RECURRING_DEPOSIT")
    private String accountType;

    @DecimalMin(value = "0.0", inclusive = false, message = "Balance must be positive")
    private BigDecimal balance;

    @DecimalMin(value = "0.0", message = "Initial deposit must be non-negative")
    private BigDecimal initialDeposit;

    private String ifscCode;

    @NotBlank(message = "Branch name is required")
    private String branchName;

    private String status;

    @NotNull(message = "Customer ID is required")
    private Long customerId;
}