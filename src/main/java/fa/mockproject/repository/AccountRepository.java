package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
