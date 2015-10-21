package bananaplan.repository;

import bananaplan.domain.dao.AttendanceDAO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by paulou on 10/20/15.
 * All rights are reserved by BPT
 */
public interface AttendanceRepository extends JpaRepository<AttendanceDAO, Long> {
    AttendanceDAO findById(Long id);
}
