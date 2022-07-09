package fa.mockproject.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
