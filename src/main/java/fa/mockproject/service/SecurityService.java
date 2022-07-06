package fa.mockproject.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface SecurityService {
	UserDetails findLoggedInUsername();

	void autoLogin(String username, String password);
}