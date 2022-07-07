package fa.mockproject.entity;

import fa.mockproject.entity.enumtype.PrivilegesEnum;
import fa.mockproject.model.RoleModel;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")

public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "role_id", unique = true, nullable = false)
  private long roleId;

  @Column(name = "name", unique = true)
  private String name;

  @ElementCollection(targetClass = PrivilegesEnum.class, fetch = FetchType.EAGER)
  @Enumerated(EnumType.STRING)
  @Column(name = "privileges")
  private Set<PrivilegesEnum> privileges;

  @ManyToMany(mappedBy = "roles")
  private Set<User> users;

  public Role() {
  }

  public Role(long roleId, String name) {
    this.roleId = roleId;
    this.name = name;
  }

  public Role(String name, Set<PrivilegesEnum> privileges) {
    this.name = name;
    this.privileges = privileges;
  }

  public Role(RoleModel roleModel) {
    this.roleId = roleModel.getRoleId();
    this.name = roleModel.getName();
    this.privileges = roleModel.getPrivileges();

  }

public long getRoleId() {
	return roleId;
}

public void setRoleId(long roleId) {
	this.roleId = roleId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Set<PrivilegesEnum> getPrivileges() {
	return privileges;
}

public void setPrivileges(Set<PrivilegesEnum> privileges) {
	this.privileges = privileges;
}

public Set<User> getUsers() {
	return users;
}

public void setUsers(Set<User> users) {
	this.users = users;
}

@Override
public String toString() {
	return "Role [roleId=" + roleId + ", name=" + name + ", privileges=" + privileges + ", users=" + users + "]";
}

}