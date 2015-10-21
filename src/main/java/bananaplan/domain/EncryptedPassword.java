package bananaplan.domain;

/**
 * Created by paulou on 10/3/15.
 */
public class EncryptedPassword {
    private String encryptedPassword;
    private String salt;

    public EncryptedPassword(String encryptedPassword, String salt) {
        this.encryptedPassword = encryptedPassword;
        this.salt = salt;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
