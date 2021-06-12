package com.crossroadsinn.components.squads;

import com.crossroadsinn.components.roles.Boon;
import com.crossroadsinn.components.roles.BoonCoverage;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BoonRequirement {
    private final Boon boon;
    private final Integer requirement;

    public BoonRequirement(Boon boon, Integer requirement) {
        this.boon = boon;
        this.requirement = requirement;
    }

    public Boon getBoon() {
        return boon;
    }

    public Integer getRequirement() {
        return requirement;
    }

    public boolean satisfies(BoonCoverage boonCoverage) {
        if (!boonCoverage.getBoon().getName().equals(boon.getName())) {
            return false;
        }
        return boonCoverage.getCoverage() >= requirement;
    }

    public boolean satisfies(List<BoonCoverage> boonCoverageList) {
        AtomicInteger i = new AtomicInteger(0);
        boonCoverageList.forEach(
                boonCoverage -> {
                    if (boonCoverage.getBoon().getName().equals(boon.getName())) {
                        i.getAndAdd(boonCoverage.getCoverage());
                    }
                }
        );
        return i.get() >= requirement;
    }
}
