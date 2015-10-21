package bananaplan.service;

import bananaplan.domain.EncryptedPassword;
import bananaplan.domain.dao.CompanyDAO;
import bananaplan.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by paulou on 10/3/15.
 * All Rights Reserved By BananaPlanTw
 */
@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    PasswordService passwordService;

    public void createCompany(CompanyDAO companyDAO){
        EncryptedPassword encryptedPassword = passwordService.encryptedPassword(companyDAO.getPassword());
        companyDAO.setPassword(encryptedPassword.getEncryptedPassword());
        companyDAO.setSalt(encryptedPassword.getSalt());
        companyRepository.save(companyDAO);
    }

    public CompanyDAO getCompany(String companyName){
        return companyRepository.findByName(companyName);
    }
}
