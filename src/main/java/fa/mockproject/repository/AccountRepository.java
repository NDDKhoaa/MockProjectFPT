package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
