package calculators;

import playermodifiers.equipment.melee.MeleeLoadout;

import java.util.List;
import java.util.Map;

import static calculators.MeleeDPSCalculator.trunateDecimalPoint;

public class DPSOrchestrator {

    //I broke the thing
    public void orchecstrateDPSOutput(List<BossToWeaponsDps> bossToWeaponsDps, MeleeLoadout meleeLoadouts) {

        BossToWeaponsDps dpsCalc1 = bossToWeaponsDps.get(0);
        BossToWeaponsDps dpsCalc2 = bossToWeaponsDps.get(1);

        //TODO when doing other styles the lists won't be the same size if a boss is immune. This can be fixed with a null tracker maybe?
        //TODO Like add a null boss to the list. Or just do another idea
        for (Map.Entry<String, Double> dpsCalc : dpsCalc1.entrySet()) {
            StringBuilder paddedBossName = new StringBuilder(dpsCalc.getKey() + ":");
            if (paddedBossName.length() < 35) {
                Integer bossNameLength = Integer.valueOf(paddedBossName.length());
                for (int i = 0; i < (35 - bossNameLength); i++) {
                    paddedBossName.append(" ");
                }
            }
            Double.valueOf(trunateDecimalPoint(dpsCalc.getValue(), 2));

            System.out.println(paddedBossName + meleeLoadouts.get(0).getMeleeEquipmentLoadout().getMeleeWeapon().name() + " - "
                    + trunateDecimalPoint(dpsCalc.getValue(), 2)
                    + "     " + meleeLoadouts.get(1).getMeleeEquipmentLoadout().getMeleeWeapon().name()
                    + " - " + trunateDecimalPoint(dpsCalc2.get(dpsCalc.getKey()), 2));
        }
    }
}
