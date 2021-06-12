package com.crossroadsinn.components.raiders;

import com.crossroadsinn.components.roles.Responsibility;
import com.crossroadsinn.components.roles.Role;

import java.util.ArrayList;
import java.util.List;

public class StaffMember extends Raider {

    public StaffMember(Responsibility responsibility, String discordAccount, List<Role> availableRoles, Role role) {
        super(responsibility.getName(), discordAccount, -1, availableRoles, role);

        this.addResponsibility(responsibility);
    }

    private void addResponsibility(Responsibility responsibility) {
        if (this.getResponsibilityList() == null) {
            this.setResponsibilityList(new ArrayList<>(List.of(responsibility)));
        }
        this.getResponsibilityList().add(responsibility);
    }
}
