package com.crossroadsinn.components.roles;

public class BoonCoverage {
    private final Boon boon;
    private final Integer coverage;

    public BoonCoverage(Boon boon, Integer coverage) {
        this.boon = boon;
        this.coverage = coverage;
    }

    public Boon getBoon() {
        return boon;
    }

    public Integer getCoverage() {
        return coverage;
    }
}
