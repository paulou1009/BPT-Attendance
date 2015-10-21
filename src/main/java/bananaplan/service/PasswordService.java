package bananaplan.service;

import bananaplan.domain.EncryptedPassword;
import org.springframework.stereotype.Service;

/**
 * Created by paulou on 10/3/15.
 */
@Service
public class PasswordService {

    public EncryptedPassword encryptedPassword(String plainPassword){
        //TODO : choose random salt and encrypt password
        String salt = "salt";
        return new EncryptedPassword(plainPassword, salt);
    }
}
