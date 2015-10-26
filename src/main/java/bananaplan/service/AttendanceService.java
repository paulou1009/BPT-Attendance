package bananaplan.service;

import bananaplan.domain.dao.AccountDAO;
import bananaplan.domain.dao.AttendanceDAO;
import bananaplan.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by paulou on 10/20/15.
 * All rights are reserved by BPT
 */
@Service
@Transactional
public class AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    AccountService accountService;

    public void checkIn(Long userId){
        AccountDAO accountDAO = accountService.getById(userId);
        AttendanceDAO attendanceDAO = new AttendanceDAO();
        attendanceDAO.setAccountDAO(accountDAO);
        attendanceDAO.setStartTime(Timestamp.valueOf(LocalDateTime.now()));

        accountDAO.setIsCheckin(true);
        accountService.saveAccount(accountDAO);

        attendanceRepository.save(attendanceDAO);
    }

    public void checkOut(Long attendanceId){
        AttendanceDAO attendanceDAO = attendanceRepository.findById(attendanceId);
        attendanceDAO.setEndTime(Timestamp.valueOf(LocalDateTime.now()));

        AccountDAO accountDAO = attendanceDAO.getAccountDAO();
        accountDAO.setIsCheckin(false);
        accountService.saveAccount(accountDAO);

        attendanceRepository.save(attendanceDAO);
    }

}
