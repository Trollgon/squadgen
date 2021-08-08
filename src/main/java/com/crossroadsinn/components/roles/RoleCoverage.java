package com.crossroadsinn.components.roles;

public class RoleCoverage {
    private final Role role;
    private final Integer coverage;

    public RoleCoverage(Role role, Integer coverage) {
        this.role = role;
        this.coverage = coverage;
    }

    public Role getRole() {
        return role;
    }

    public Integer getCoverage() {
        return coverage;
    }
}
