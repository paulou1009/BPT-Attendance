package bananaplan.repository;

import bananaplan.domain.dao.CompanyDAO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by paulou on 10/3/15.
 * All Rights Reserved By BananaPlanTw
 */
public interface CompanyRepository extends JpaRepository<CompanyDAO, Long> {
    CompanyDAO findByName(String name);
}
