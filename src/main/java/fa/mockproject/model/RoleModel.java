package fa.mockproject.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import fa.mockproject.entity.enumtype.PrivilegesEnum;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
=======


import java.util.Set;


>>>>>>> origin/haidang
public class RoleModel {
    @JsonProperty("roleId")
    private long roleId;
    private String name;
    private Set<PrivilegesEnum> privileges;

    public RoleModel() {
    }

    public RoleModel(String name, Set<PrivilegesEnum> privileges) {
        this.name = name;
        this.privileges = privileges;
    }

    public RoleModel(long roleId) {
        this.roleId = roleId;
    }

<<<<<<< HEAD
}
=======
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

}
>>>>>>> origin/haidang
