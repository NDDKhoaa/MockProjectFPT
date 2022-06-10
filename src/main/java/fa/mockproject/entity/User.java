package fa.mockproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "User")
@Cacheable
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", unique = true, nullable = false)
    private long  userId;
    @Column(name = "user_name")
    private String  userName;
    @Column(name = "password")
    private String  password;
    @Column(name = "first_name")
    private String  firstName;
    @Column(name = "last_name")
    private String  lastName;
    @Column(name = "phone_number")
    private String  phoneNumber;
    @Column(name = "email")
    private String  email;
    private Role role;

    public User() {
    }

    public User(long userId, String userName, String password, String firstName, String lastName, String phoneNumber, String email, Role role) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
    }

}
