package components;

import com.crossroadsinn.components.raiders.Raider;
import com.crossroadsinn.components.raiders.StaffMember;
import com.crossroadsinn.components.roles.Boon;
import com.crossroadsinn.components.roles.BoonCoverage;
import com.crossroadsinn.components.roles.Responsibility;
import com.crossroadsinn.components.roles.Role;
import com.crossroadsinn.components.squads.BoonRequirement;
import com.crossroadsinn.components.squads.RoleRequirement;
import com.crossroadsinn.components.squads.SquadRequirement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComponentsTest {

    private static Boon Fury;
    private static Boon Might;
    private static Boon Alacrity;
    private static Boon Quickness;

    private static Responsibility Tank;
    private static Responsibility Healer;
    private static Responsibility DamageDealer;
    private static Responsibility PylonKiter;
    private static Responsibility Commander;
    private static Responsibility Aide;

    private static Role Druid;
    private static Role Banners;
    private static Role QuickFirebrand;
    private static Role HealFirebrand;
    private static Role HealFirebrandTank;
    private static Role Dps;
    private static Role ChronoTank;
    private static Role Tempest;
    private static Role Alacrigade;
    private static Role Scam;

    private static Raider Druid1;
    private static Raider Druid2;
    private static Raider Banners1;
    private static Raider Banners2;
    private static Raider QuickFirebrand1;
    private static Raider QuickFirebrand2;
    private static Raider HealFirebrand1;
    private static Raider HealFirebrand2;
    private static Raider Dps1;
    private static Raider Dps2;
    private static Raider Dps3;
    private static Raider Dps4;
    private static StaffMember DpsCom;
    private static StaffMember DpsAide;
    private static Raider ChronoTank1;
    private static Raider ChronoTank2;
    private static Raider Tempest1;
    private static Raider Tempest2;
    private static Raider Alacrigade1;
    private static Raider Alacrigade2;
    private static Raider Scam1;
    private static Raider Scam2;

    @BeforeAll
    static void initStuff() {
        Fury = new Boon("Fury");
        Might = new Boon("Might");
        Alacrity = new Boon("Alacrity");
        Quickness = new Boon("Quickness");

        Tank = new Responsibility("Tank");
        Healer = new Responsibility("Healer");
        DamageDealer = new Responsibility("DamageDealer");
        PylonKiter = new Responsibility("PylonKiter");
        Commander = new Responsibility("Commander");
        Aide = new Responsibility("Aide");

        Druid = new Role("Druid", Arrays.asList(new BoonCoverage(Fury, 5), new BoonCoverage(Might, 25)), new ArrayList<>(List.of(Healer)));
        Banners = new Role("Banners", null, new ArrayList<>(List.of(DamageDealer)));
        QuickFirebrand = new Role("QuickFirebrand", Arrays.asList(new BoonCoverage(Fury, 5), new BoonCoverage(Quickness, 5)), new ArrayList<>(List.of(DamageDealer)));
        HealFirebrand = new Role("HealFirebrand", Arrays.asList(new BoonCoverage(Fury, 5), new BoonCoverage(Quickness, 5)), new ArrayList<>(List.of(Healer)));
        HealFirebrandTank = new Role("HealFirebrand", Arrays.asList(new BoonCoverage(Fury, 5), new BoonCoverage(Quickness, 5)), new ArrayList<>(List.of(Healer, Tank)));
        Dps = new Role("DPS", null, new ArrayList<>(List.of(DamageDealer)));
        ChronoTank = new Role("ChronoTank", Collections.singletonList(new BoonCoverage(Quickness, 5)), new ArrayList<>(List.of(Tank)));
        Tempest = new Role("Tempest", Arrays.asList(new BoonCoverage(Fury, 5), new BoonCoverage(Might, 25)), new ArrayList<>(List.of(Healer)));
        Alacrigade = new Role("Alacrigade", Collections.singletonList(new BoonCoverage(Alacrity, 10)), new ArrayList<>(List.of(DamageDealer)));
        Scam = new Role("SCAM", Collections.singletonList(new BoonCoverage(Alacrity, 10)), new ArrayList<>(List.of(DamageDealer)));

        Druid1 = new Raider("", "", 0, null, Druid);
        Druid2 = new Raider("", "", 0, null, Druid);
        Banners1 = new Raider("", "", 0, null, Banners);
        Banners2 = new Raider("", "", 0, null, Banners);
        QuickFirebrand1 = new Raider("", "", 0, null, QuickFirebrand);
        QuickFirebrand2 = new Raider("", "", 0, null, QuickFirebrand);
        HealFirebrand1 = new Raider("", "", 0, null, HealFirebrand);
        HealFirebrand2 = new Raider("", "", 0, null, HealFirebrandTank);
        Dps1 = new Raider("", "", 0, null, Dps);
        Dps2 = new Raider("", "", 0, null, Dps);
        Dps3 = new Raider("", "", 0, null, Dps);
        Dps4 = new Raider("", "", 0, null, Dps);
        DpsCom = new StaffMember(Commander, "", null, Dps);
        DpsAide = new StaffMember(Aide, "", null, Dps);
        ChronoTank1 = new Raider("", "", 0, null, ChronoTank);
        ChronoTank2 = new Raider("", "", 0, null, ChronoTank);
        Tempest1 = new Raider("", "", 0, null, Tempest);
        Tempest2 = new Raider("", "", 0, null, Tempest);
        Alacrigade1 = new Raider("", "", 0, null, Alacrigade);
        Alacrigade2 = new Raider("", "", 0, null, Alacrigade);
        Scam1 = new Raider("", "", 0, null, Scam);
        Scam2 = new Raider("", "", 0, null, Scam);
    }

    @Test
    public void someTest() {
        SquadRequirement defaultComp = new SquadRequirement(
                "Default",
                Arrays.asList(
                        new BoonRequirement(Fury, 10),
                        new BoonRequirement(Might, 25),
                        new BoonRequirement(Alacrity, 10),
                        new BoonRequirement(Quickness, 10)
                ),
                Arrays.asList(
                        Commander,
                        Aide,
                        Tank,
                        Healer,
                        Healer
                ),
                Arrays.asList(
                        new RoleRequirement(Druid, 1),
                        new RoleRequirement(Banners, 1)
                )
        );

        List<Raider> squad1 = Arrays.asList(Druid1, Banners1, HealFirebrand1, Dps1, Dps2, Dps3, DpsCom, DpsAide, ChronoTank1, Alacrigade1);
        assertTrue(defaultComp.satisfies(squad1));

        List<Raider> squad2 = Arrays.asList(Druid1, Banners1, QuickFirebrand1, Dps1, Dps2, Dps3, DpsCom, DpsAide, ChronoTank1, Scam1);
        assertFalse(defaultComp.satisfies(squad2));

        List<Raider> squad3 = Arrays.asList(Druid1, Banners1, HealFirebrand1, Dps1, Dps2, Dps3, DpsCom, DpsAide, ChronoTank1);
        assertFalse(defaultComp.satisfies(squad3));

        List<Raider> squad4 = Arrays.asList(Druid1, DpsAide, HealFirebrand1, Dps1, Dps2, Dps3, DpsCom, DpsAide, ChronoTank1, Alacrigade1);
        assertFalse(defaultComp.satisfies(squad4));

        List<Raider> squad5 = Arrays.asList(Druid1, Banners1, QuickFirebrand1, Dps1, Dps2, Druid2, DpsCom, DpsAide, ChronoTank1, Alacrigade1);
        assertFalse(defaultComp.satisfies(squad5));
    }
}
