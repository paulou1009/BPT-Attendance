package bananaplan.repository;

import bananaplan.domain.dao.AccountDAO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by paulou on 9/30/15.
 */
public interface AccountRepository extends JpaRepository<AccountDAO, Long> {
    AccountDAO findByUsernameAndPassword(String username, String password);

    AccountDAO findByUsername(String username);

    AccountDAO findById(Long id);
}
