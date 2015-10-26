package bananaplan.domain.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="accounts")
public class AccountDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    private String password;

    private String salt;

    private String employeeName;

    private Boolean isCheckin;

    public Boolean getIsCheckin() {
        return isCheckin;
    }

    public void setIsCheckin(Boolean isCheckin) {
        this.isCheckin = isCheckin;
    }

    public Set<AttendanceDAO> getAttendanceDAO() {
        return attendanceDAO;
    }

    public void setAttendanceDAO(Set<AttendanceDAO> attendanceDAO) {
        this.attendanceDAO = attendanceDAO;
    }

    @ManyToOne
    @JoinColumn(name="company_id")
    private CompanyDAO companyDAO;

    @JsonIgnore
    @OneToMany(mappedBy="accountDAO")
    private Set<AttendanceDAO> attendanceDAO;

    public AccountDAO() {
    }

    public AccountDAO(String username, String password, String salt, String employeeName, CompanyDAO companyDAO) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.employeeName = employeeName;
        this.companyDAO = companyDAO;
        this.isCheckin = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public CompanyDAO getCompanyDAO() {
        return companyDAO;
    }

    public void setCompanyDAO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "AccountDAO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", companyDAO=" + companyDAO +
                '}';
    }
}
