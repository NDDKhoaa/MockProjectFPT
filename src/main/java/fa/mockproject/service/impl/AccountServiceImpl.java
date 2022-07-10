package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Account;
import fa.mockproject.repository.AccountRepository;
import fa.mockproject.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public List<Account> listAll() {
		return (List<Account>) accountRepository.findAll();
	}

	public void save(Account account) {
		accountRepository.save(account);
	}

	public Account findById(long accountId) {
		Optional<Account> rs = accountRepository.findById(accountId);
		return rs.orElse(null);
	}

	public void delete(Account account) {
		accountRepository.delete(account);
	}

	public void deleteById(long accountId) {
		accountRepository.deleteById(accountId);
	}

}
