package net.bkd.bank_account_service.mappers;

import net.bkd.bank_account_service.dto.BankAccountRequestDTO;
import net.bkd.bank_account_service.dto.BankAccountResponseDTO;
import net.bkd.bank_account_service.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component

public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}