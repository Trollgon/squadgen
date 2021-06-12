package com.crossroadsinn.components.roles;

import java.util.Collections;
import java.util.List;

public class Role {
    private final String name;
    private final List<BoonCoverage> boonCoverageList;
    private final List<Responsibility> responsibilityList;

    public Role(String name, List<BoonCoverage> boonCoverageList, List<Responsibility> responsibilityList) {
        this.name = name;
        this.boonCoverageList = boonCoverageList;
        this.responsibilityList = Collections.unmodifiableList(responsibilityList);
    }

    public String getName() {
        return name;
    }

    public List<BoonCoverage> getBoonCoverageList() {
        return boonCoverageList;
    }

    public List<Responsibility> getResponsibilityList() {
        return responsibilityList;
    }
}
