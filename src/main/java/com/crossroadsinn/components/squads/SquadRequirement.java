package com.crossroadsinn.components.squads;

import com.crossroadsinn.components.raiders.Raider;
import com.crossroadsinn.components.roles.BoonCoverage;
import com.crossroadsinn.components.roles.Responsibility;
import com.crossroadsinn.components.roles.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SquadRequirement {
    private final String name;
    // private final int requiredTier; TODO: required?
    private final int squadSize;
    private final List<BoonRequirement> boonRequirements;
    private final List<Responsibility> responsibilityRequirements;
    private final List<Role> roleRequirements;

    public SquadRequirement(String name, List<BoonRequirement> boonRequirements, List<Responsibility> responsibilityRequirements, List<Role> roleRequirements) {
        this.name = name;
        this.squadSize = 10;
        this.boonRequirements = boonRequirements;
        this.responsibilityRequirements = new ArrayList<>(responsibilityRequirements);
        this.roleRequirements = roleRequirements;
    }

    public SquadRequirement(String name, int squadSize, List<BoonRequirement> boonRequirements, List<Responsibility> responsibilityRequirements, List<Role> roleRequirements) {
        this.name = name;
        this.squadSize = squadSize;
        this.boonRequirements = boonRequirements;
        this.responsibilityRequirements = new ArrayList<>(responsibilityRequirements);
        this.roleRequirements = roleRequirements;
    }

    public String getName() {
        return name;
    }

    public List<BoonRequirement> getBoonRequirements() {
        return boonRequirements;
    }

    public List<Role> getRoleRequirements() {
        return roleRequirements;
    }

    public int getSquadSize() {
        return squadSize;
    }

    public Boolean satisfies(List<Raider> raiderList) {
        List<Role> raidersRoleList = raiderList.stream().map(Raider::getRole).collect(Collectors.toList());

        List<BoonCoverage> raidersBoonCoverageList = new ArrayList<>();
        for (Role role : raidersRoleList) {
            if (role.getBoonCoverageList() != null) {
                for (BoonCoverage boonCoverage : role.getBoonCoverageList()) {
                    int i = raidersBoonCoverageList.indexOf(boonCoverage);
                    if (i == -1) {
                        raidersBoonCoverageList.add(boonCoverage);
                    }
                    else {
                        BoonCoverage oldBoonCoverage = raidersBoonCoverageList.get(i);
                        BoonCoverage newBoonCoverage = new BoonCoverage(oldBoonCoverage.getBoon(), oldBoonCoverage.getCoverage() + boonCoverage.getCoverage());
                        raidersBoonCoverageList.set(i, newBoonCoverage);
                    }
                }
            }
        }

        // TODO: handle this better - logging?
        System.out.println("--- New Squad ---");

        List<Responsibility> raidersResponsibilityList = new ArrayList<>();
        for (Raider raider : raiderList) {
            raidersResponsibilityList.addAll(raider.getResponsibilityList());
        }

        // enough raiders?
        if (raiderList.size() != this.squadSize){
            // TODO: handle this better
            System.out.println("Wrong size");
            return false;
        }

        // all required boons?
        for (BoonRequirement boonRequirement : this.boonRequirements) {
            if (!boonRequirement.satisfies(raidersBoonCoverageList)) {
                // TODO: handle this better
                System.out.println("Wrong Boons");
                return false;
            }
        }

        // all required roles?
        if (!raidersRoleList.containsAll(roleRequirements)) {
            // TODO: handle this better
            System.out.println("Wrong Roles");
            return false;
        }

        // all required responsibilities?
        List<Responsibility> tmpResponsibilityRequirements = new ArrayList<>(responsibilityRequirements);
        for (Responsibility responsibility : raidersResponsibilityList) {
            tmpResponsibilityRequirements.remove(responsibility);
        }

        if (!tmpResponsibilityRequirements.isEmpty()) {
            // TODO: handle this better
            System.out.println("Wrong Responsibilities");
            return false;
        }

        // everything works out
        // TODO: handle this better
        System.out.println("Acceptable");
        return true;
    }
}
