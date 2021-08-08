package com.crossroadsinn.components.squads;

import com.crossroadsinn.components.roles.Role;
import com.crossroadsinn.components.roles.RoleCoverage;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoleRequirement {
    private final Role role;
    private final Integer requirement;

    public RoleRequirement(Role role, Integer requirement) {
        this.role = role;
        this.requirement = requirement;
    }

    public Role getRole() {
        return role;
    }

    public Integer getRequirement() {
        return requirement;
    }

    public boolean satisfies(List<Role> roleList) {
        AtomicInteger i = new AtomicInteger(0);
        roleList.forEach(
                role -> {
                    if (this.getRole().getName().equals(role.getName())) {
                        i.getAndAdd(1);
                    }
                }
        );
        return i.get() == requirement;
    }
}
