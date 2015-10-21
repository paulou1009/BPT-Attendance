package bananaplan.domain.dao;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by paulou on 10/20/15.
 * All rights are reserved by BPT
 */
@Entity
@Table(name = "attendance")
public class AttendanceDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="account_id")
    private AccountDAO accountDAO;

    private Timestamp startTime;

    private Timestamp endTime;

    public AttendanceDAO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
}
