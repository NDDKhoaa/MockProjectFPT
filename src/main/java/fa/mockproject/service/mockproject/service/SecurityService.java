package fa.mockproject.service.mockproject.service;

public interface SecurityService {
	String findLoggedInUsername();

	void autoLogin(String username, String password);
}
