package net.bkd.bank_account_service.service;

import net.bkd.bank_account_service.dto.BankAccountRequestDTO;
import net.bkd.bank_account_service.dto.BankAccountResponseDTO;
import net.bkd.bank_account_service.entities.BankAccount;

public interface AccountService {
    public BankAccountResponseDTO addACCOUNT(BankAccountRequestDTO bankAccountDTO);
}
