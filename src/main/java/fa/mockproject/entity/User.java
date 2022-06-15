package fa.mockproject.entity;

import fa.mockproject.model.UserModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "User")
@Cacheable
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", unique = true, nullable = false)
    private long userId;

    @NotEmpty(message = "Email should not empty.")
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;

    @Email
    @NotEmpty(message = "Email should not empty.")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Email should not empty.")
    @Column(name = "password")
    private String password;

    private Role role;

    public User() {
    }

    public User(long userId, String password, String firstName, String lastName, String phoneNumber, String email, Role role) {
        this.userId = userId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
    }

    public User(UserModel userModel) {
        this.userId = userModel.getUserId();
        this.password = userModel.getPassword();
        this.firstName = userModel.getFirstName();
        this.lastName = userModel.getLastName();
        this.phoneNumber = userModel.getPhoneNumber();
        this.email = userModel.getEmail();
        this.role = userModel.getRole();
    }

}
