package net.bkd.bank_account_service.web;

import net.bkd.bank_account_service.entities.BankAccount;
import net.bkd.bank_account_service.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api")
public class AccountRestController {

    //Injection de la couche repository pour acceder à la base de donnée
    private BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    //Consulter les comptes banquaires
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    //Consulter un compte
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccounts(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found", id)));
    }
    //Ajout d'un compte
    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        if(bankAccount.getId()==null) bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
    }
    //Maitre à jour un compte qui existe déjà
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount){
        //Chercher un compte qui existe déjà
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
       if (bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
       if (bankAccount.getCreateDate()!=null) account.setCreateDate(new Date());
       if (bankAccount.getType()!=null) account.setType(bankAccount.getType());
       if (bankAccount.getCurrency()!=null)account.setCurrency(bankAccount.getCurrency());

        return bankAccountRepository.save(account);
    }
    //delete
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);

    }
}