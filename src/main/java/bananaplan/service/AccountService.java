package bananaplan.service;

import bananaplan.domain.dao.AccountDAO;
import bananaplan.domain.EncryptedPassword;
import bananaplan.domain.dao.CompanyDAO;
import bananaplan.domain.request.AccountRequest;
import bananaplan.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by paulou on 9/30/15.
 */
@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordService passwordService;

    @Autowired
    CompanyService companyService;

    public void createAccount(AccountRequest accountRequest) {
        AccountDAO existingAccountDAO = accountRepository.findByUsername(accountRequest.getUsername());
        if(existingAccountDAO != null) {
            //TODO : throw duplicate account error message
        }
        CompanyDAO companyDAO = companyService.getCompany(accountRequest.getCompanyName());
        if(companyDAO == null) {
            //TODO : throw non company exception
        }
        EncryptedPassword encryptedPassword = passwordService.encryptedPassword(accountRequest.getPassword());
        AccountDAO accountDAO = new AccountDAO(accountRequest.getUsername(), encryptedPassword.getEncryptedPassword(),
                encryptedPassword.getSalt(), accountRequest.getEmployeeName(), companyDAO);
        accountRepository.save(accountDAO);
    }

    public AccountDAO getAccount(String username, String password) {
        return accountRepository.findByUsernameAndPassword(username, password);
    }

    public void deleteAccount(String username) {
        AccountDAO accountDAO = accountRepository.findByUsername(username);
        if(accountDAO == null) {
            //TODO : throw account not existed error message
        }
        accountRepository.delete(accountDAO);
    }

    public AccountDAO getById(Long userId){
        return accountRepository.findById(userId);
    }

    public void saveAccount(AccountDAO accountDAO){ accountRepository.save(accountDAO);}
}
