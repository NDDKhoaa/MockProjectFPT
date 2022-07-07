package fa.mockproject.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
=======



>>>>>>> origin/haidang
public class UserModel {

  private long userId;
  private String password;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String email;
  @JsonProperty("roles")
  private Set<RoleModel> roles;

  public UserModel() {
  }
<<<<<<< HEAD
}
=======

public long getUserId() {
	return userId;
}

public void setUserId(long userId) {
	this.userId = userId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Set<RoleModel> getRoles() {
	return roles;
}

public void setRoles(Set<RoleModel> roles) {
	this.roles = roles;
}
  
}
>>>>>>> origin/haidang
