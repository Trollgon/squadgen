package com.crossroadsinn.components.raiders;

import com.crossroadsinn.components.roles.Role;

import java.util.List;

public class Trainee extends Raider {

    // TODO: is this still needed?

    public Trainee(String arenaNetAccount, String discordAccount, Integer tier, List<Role> availableRoles, Role role) {
        super(arenaNetAccount, discordAccount, tier, availableRoles, role);
    }
}
