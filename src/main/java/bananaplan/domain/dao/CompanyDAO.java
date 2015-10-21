package bananaplan.domain.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by paulou on 10/3/15.
 * All Rights Reserved By BananaPlanTw
 */
@Entity
@Table(name = "companies")
public class CompanyDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String account;

    private String password;

    private String salt;

    @JsonIgnore
    @OneToMany(mappedBy="companyDAO")
    private Set<AccountDAO> accountDAOs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<AccountDAO> getAccountDAOs() {
        return accountDAOs;
    }

    public void setAccountDAOs(Set<AccountDAO> accountDAOs) {
        this.accountDAOs = accountDAOs;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "CompanyDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
