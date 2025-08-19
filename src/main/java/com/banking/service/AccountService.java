package com.banking.service;

import com.banking.model.Account;
import com.banking.model.AccountType;
import com.banking.model.Customer;
import com.banking.model.AccountStatus;
import com.banking.dto.AccountDTO;
import com.banking.repository.AccountRepository;
import com.banking.repository.CustomerRepository;
import com.banking.exception.AccountNotFoundException;
import com.banking.exception.CustomerNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AccountDTO createAccount(Long customerId, AccountDTO accountDTO) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));

        Account account = new Account();
        account.setAccountNumber(generateAccountNumber());
        account.setAccountType(AccountType.valueOf(accountDTO.getAccountType()));
        account.setBalance(accountDTO.getInitialDeposit() != null ? accountDTO.getInitialDeposit() : BigDecimal.ZERO);
        account.setIfscCode("BANK0001234");
        account.setBranchName(accountDTO.getBranchName());
        account.setStatus(AccountStatus.ACTIVE);
        account.setCustomer(customer);

        Account savedAccount = accountRepository.save(account);
        return convertToDTO(savedAccount);
    }

    public AccountDTO getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with ID: " + accountId));
        return convertToDTO(account);
    }

    public AccountDTO getAccountByNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with number: " + accountNumber));
        return convertToDTO(account);
    }

    public List<AccountDTO> getAccountsByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AccountDTO updateAccountBalance(String accountNumber, BigDecimal amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with number: " + accountNumber));

        account.setBalance(account.getBalance().add(amount));
        Account updatedAccount = accountRepository.save(account);
        return convertToDTO(updatedAccount);
    }

    public void blockAccount(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with number: " + accountNumber));

        account.setStatus(AccountStatus.BLOCKED);
        accountRepository.save(account);
    }

    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder("ACC");
        for (int i = 0; i < 10; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }

    private AccountDTO convertToDTO(Account account) {
        AccountDTO dto = new AccountDTO();

        this.modelMapper.map(account,AccountDTO.class);

        dto.setAccountType(account.getAccountType().toString());

        dto.setStatus(account.getStatus().toString());
        dto.setCustomerId(account.getCustomer().getCustomerId());
        return dto;
    }
}