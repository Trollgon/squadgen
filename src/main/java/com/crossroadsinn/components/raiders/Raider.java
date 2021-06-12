package com.crossroadsinn.components.raiders;

import com.crossroadsinn.components.roles.Responsibility;
import com.crossroadsinn.components.roles.Role;

import java.util.ArrayList;
import java.util.List;

public class Raider {
    private final String arenaNetAccount;
    private final String discordAccount;
    private final Integer tier;
    private final List<Role> availableRoles;
    private final Role role; // TODO: final?
    private List<Responsibility> responsibilityList;

    public Raider(String arenaNetAccount, String discordAccount, Integer tier, List<Role> availableRoles, Role role) {
        this.arenaNetAccount = arenaNetAccount;
        this.discordAccount = discordAccount;
        this.tier = tier;
        this.availableRoles = availableRoles;
        this.role = role;
        this.responsibilityList = new ArrayList<>(role.getResponsibilityList());
    }

    public String getArenaNetAccount() {
        return arenaNetAccount;
    }

    public String getDiscordAccount() {
        return discordAccount;
    }

    public Integer getTier() {
        return tier;
    }

    public List<Role> getAvailableRoles() {
        return availableRoles;
    }

    public Role getRole() {
        return role;
    }

    public List<Responsibility> getResponsibilityList() {
        return responsibilityList;
    }

    protected void setResponsibilityList(List<Responsibility> responsibilityList) {
        this.responsibilityList = responsibilityList;
    }
}
