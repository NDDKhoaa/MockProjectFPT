package fa.mockproject.entity;

import fa.mockproject.model.RoleModel;
import fa.mockproject.model.UserModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", unique = true, nullable = false)
    private long userId;

    @NotEmpty(message = "First name should not empty.")
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Email
    @NotEmpty(message = "Email should not empty.")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotEmpty(message = "Password should not empty.")
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id",
                    table = "roles")
    )
    private Set<Role> roles;

    public User() {
    }

    public User(String firstName, String email, String password, Set<Role> roles) {
        this.password = password;
        this.firstName = firstName;
        this.email = email;
        this.roles = roles;
    }

    public User(UserModel userModel) {
        this.userId = userModel.getUserId();
        this.password = userModel.getPassword();
        this.firstName = userModel.getFirstName();
        this.lastName = userModel.getLastName();
        this.phoneNumber = userModel.getPhoneNumber();
        this.email = userModel.getEmail();
        this.roles = mappingSetRole(userModel.getRoles());
    }

    public Set<Role> mappingSetRole(Set<RoleModel> roleModels) {
        Set<Role> roleMapping = new HashSet<>();
        for (RoleModel roleModel : roleModels) {
            roleMapping.add(new Role(roleModel));
        }
        return roleMapping;
    }
}
