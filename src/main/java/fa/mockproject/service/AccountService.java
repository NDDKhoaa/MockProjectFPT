package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.Account;

public interface AccountService {

	public List<Account> listAll();

	public void save(Account account);

	public Account findById(long accountId);

	public void delete(Account account);

	public void deleteById(long accountId);

}
