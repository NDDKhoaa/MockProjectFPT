package fa.mockproject.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import fa.mockproject.entity.enumtype.PrivilegesEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
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

}
