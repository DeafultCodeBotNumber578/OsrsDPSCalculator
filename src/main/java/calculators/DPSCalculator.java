package calculators;

import mobs.BossesAndMonsterStats;
import mobs.MobRestriction;
import playermodifiers.CombatStyle;
import playermodifiers.PlayerLoadout;
import playermodifiers.equipment.melee.MeleeCombatStyles;
import playermodifiers.equipment.melee.MeleeEquipmentLoadout;
import playermodifiers.equipment.melee.MeleeWeaponStyles;
import playermodifiers.equipment.melee.MeleeWeapons;
import playermodifiers.statmodifiers.CombatStats;
import playermodifiers.statmodifiers.StatBoosts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DPSCalculator {

    public void orchestrateDPSCalcs(List<PlayerLoadout> playerLoadouts, List<BossesAndMonsterStats> bossesAndMonsters) {
        List< Map<String, Double>> dpsMatrix = new ArrayList<>();

        for (PlayerLoadout playerLoadout : playerLoadouts) {
            double effectiveMeleeAttackLevel = 0;

            //determine style of loadout
            if (playerLoadout.getCombatStyle() == CombatStyle.MELEE) {
                effectiveMeleeAttackLevel = calculateEffectiveMeleeAttackLevel(playerLoadout.getMeleeWeapons(),
                        playerLoadout.getStatBoosts(), playerLoadout.getCombatStats());

                double meleeEquipmentAttackBonus = calculateMeleeEquipmentAttackBonus(playerLoadout.getMeleeEquipmentLoadout(), playerLoadout.getMeleeWeapons());

                double finalAttackRoll = calculateFinalMeleeAttackRoll(effectiveMeleeAttackLevel, meleeEquipmentAttackBonus);

                double effectiveMeleeStrengthLevel = calculateEffectiveStrengthLevel(playerLoadout.getMeleeWeapons(), playerLoadout.getStatBoosts(),
                        playerLoadout.getCombatStats());

                double meleeEquipmentStrengthBonus = calculateMeleeEquipmentStrengthBonus(playerLoadout.getMeleeEquipmentLoadout(), playerLoadout.getMeleeWeapons());

                double maxHit = calculateMaxHit(effectiveMeleeStrengthLevel, meleeEquipmentStrengthBonus);

                Map<String, Double> mobDefenceRolls = new HashMap<>();
                for (BossesAndMonsterStats bossesAndMonsterStats : bossesAndMonsters) {
                    if (playerLoadout.getCombatStyle().equals(CombatStyle.MELEE) &&
                            !bossesAndMonsterStats.getMobRestriction().equals(MobRestriction.MELEE_IMMUNE)) {
                        mobDefenceRolls.put(bossesAndMonsterStats.name(), calculateTargetDefenceRoll(bossesAndMonsterStats, playerLoadout.getMeleeWeapons()));
                    }
                }

                Map<String, Double> finalDpsValues = new HashMap<>();
                for (Map.Entry<String, Double> mobEntry : mobDefenceRolls.entrySet()) {
                    double hitChance = calculateHiteChance(mobEntry.getValue(), finalAttackRoll);
                    finalDpsValues.put(mobEntry.getKey(), calculateMeleeDps(maxHit, hitChance, playerLoadout.getMeleeWeapons()));
                }
                dpsMatrix.add(finalDpsValues);
            }
        }

        Map<String, Double> dpsCalc1 = dpsMatrix.get(0);
        Map<String, Double> dpsCalc2 = dpsMatrix.get(1);

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

            System.out.println(paddedBossName + playerLoadouts.get(0).getMeleeWeapons().name() + " - "
             + trunateDecimalPoint(dpsCalc.getValue(), 2)
                    + "     " + playerLoadouts.get(1).getMeleeWeapons().name() + " - " + trunateDecimalPoint(dpsCalc2.get(dpsCalc.getKey()), 2));
        }



    }

    //TODO this is untested
    private double calculateEffectiveMeleeAttackLevel(MeleeWeapons meleeWeapons,
                                                      StatBoosts statBoosts, CombatStats combatStats) {
        //Effective Melee Attack is -> (Attack level + Attack level boost) * prayer bonus - floor, +3/+1 for style, +8

        //Attack level boost is flatLevelBoost + (% level boost * base lvl) I.E. overloads are 6 flat + 16% * base level
        //TODO I don't know where the take the floor value. need to check dps calulator
        double attackLevelBoost = Math.floor(Float.valueOf(statBoosts.getMeleeBoost().flatLevelBoost) +
                ((Float.valueOf(combatStats.attackLevel) * Float.valueOf(statBoosts.getMeleeBoost().percentageLevelBoost)/100f)));

        double effectiveMeleeAttackLevel = Math.floor((Float.valueOf(combatStats.attackLevel) + attackLevelBoost));

        //Add combat style bonus
        if (meleeWeapons.getCombatXpStyle().equals(MeleeCombatStyles.ACCURATE)) {
            effectiveMeleeAttackLevel = effectiveMeleeAttackLevel + 3;
        } else if (meleeWeapons.getCombatXpStyle().equals(MeleeCombatStyles.CONTROLLED)) {
            effectiveMeleeAttackLevel++;
        }
        //Obligatory +8 to the number just because
        effectiveMeleeAttackLevel = effectiveMeleeAttackLevel + 8;

        return effectiveMeleeAttackLevel;
    }

    private double calculateMeleeEquipmentAttackBonus(MeleeEquipmentLoadout meleeEquipmentLoadout, MeleeWeapons meleeWeapons) {
        double meleeEquipmentAttackBonus = 0;
        //TODO backup check for 2h weapons to not include the shield stats
        if (meleeWeapons.getWeaponStyle().equals(MeleeWeaponStyles.STAB)) {
            meleeEquipmentAttackBonus =
                    meleeEquipmentLoadout.getHeadgear().getStabAccuracy() +
                    meleeEquipmentLoadout.getCape().getStabAccuracy() +
                    meleeEquipmentLoadout.getNecklace().getStabAccuracy() +
                    meleeEquipmentLoadout.getBody().getStabAccuracy() +
                    meleeEquipmentLoadout.getLegs().getStabAccuracy() +
                    meleeEquipmentLoadout.getShield().getStabAccuracy() + //TODO back up shield stat check
                    meleeEquipmentLoadout.getHands().getStabAccuracy() +
                    meleeEquipmentLoadout.getFeet().getStabAccuracy() +
                    meleeEquipmentLoadout.getRing().getStabAccuracy() +
                    meleeWeapons.getStabAccuracy();

        } else if (meleeWeapons.getWeaponStyle().equals(MeleeWeaponStyles.SLASH)) {
            meleeEquipmentAttackBonus =
                    meleeEquipmentLoadout.getHeadgear().getSlashAccuracy() +
                            meleeEquipmentLoadout.getCape().getSlashAccuracy() +
                            meleeEquipmentLoadout.getNecklace().getSlashAccuracy() +
                            meleeEquipmentLoadout.getBody().getSlashAccuracy() +
                            meleeEquipmentLoadout.getLegs().getSlashAccuracy() +
                            meleeEquipmentLoadout.getShield().getSlashAccuracy() + //TODO back up shield stat check
                            meleeEquipmentLoadout.getHands().getSlashAccuracy() +
                            meleeEquipmentLoadout.getFeet().getSlashAccuracy() +
                            meleeEquipmentLoadout.getRing().getSlashAccuracy() +
                            meleeEquipmentLoadout.getRing().getSlashAccuracy() +
                            meleeWeapons.getSlashAccuracy();

        }
        return meleeEquipmentAttackBonus;
    }

    private double calculateFinalMeleeAttackRoll(double effectiveAttackLevel, double equipmentAttackBonus) {
        return Math.floor(effectiveAttackLevel * (equipmentAttackBonus + 64));
    }

    private double calculateEffectiveStrengthLevel(MeleeWeapons meleeWeapons, StatBoosts statBoosts, CombatStats combatStats) {
        //Melee Strength Level is (str lvl + str lvl boost) * prayer multi - floor, +3/+1 for style, +8

        //TODO I don't know where the take the floor value. need to check dps calulator
        double strengthLevelBoost = Math.floor(Float.valueOf(statBoosts.getMeleeBoost().flatLevelBoost) +
                ((Float.valueOf(combatStats.strengthLevel) * Float.valueOf(statBoosts.getMeleeBoost().percentageLevelBoost)/100f)));

        double effectiveMeleeStrengthLevel = Math.floor((Float.valueOf(combatStats.strengthLevel) + strengthLevelBoost));

        //Add combat style bonus
        if (meleeWeapons.getCombatXpStyle().equals(MeleeCombatStyles.AGGRESSIVE)) {
            effectiveMeleeStrengthLevel = effectiveMeleeStrengthLevel + 3;
        } else if (meleeWeapons.getCombatXpStyle().equals(MeleeCombatStyles.CONTROLLED)) {
            effectiveMeleeStrengthLevel++;
        }
        //Obligatory +8 to the number just because
        effectiveMeleeStrengthLevel = effectiveMeleeStrengthLevel + 8;

        return effectiveMeleeStrengthLevel;
    }

    private double calculateMeleeEquipmentStrengthBonus(MeleeEquipmentLoadout meleeEquipmentLoadout, MeleeWeapons meleeWeapons) {
        double meleeEquipmentStrengthBonus = 0;
        //TODO backup check for 2h weapons to not include the shield stats
        return
                meleeEquipmentLoadout.getHeadgear().getStrengthBonus() +
                        meleeEquipmentLoadout.getCape().getStrengthBonus() +
                        meleeEquipmentLoadout.getNecklace().getStrengthBonus() +
                        meleeEquipmentLoadout.getBody().getStrengthBonus() +
                        meleeEquipmentLoadout.getLegs().getStrengthBonus() +
                        meleeEquipmentLoadout.getShield().getStrengthBonus() + //TODO back up shield stat check
                        meleeEquipmentLoadout.getHands().getStrengthBonus() +
                        meleeEquipmentLoadout.getFeet().getStrengthBonus() +
                        meleeEquipmentLoadout.getRing().getStrengthBonus() +
                        meleeWeapons.getStrengthBonus();
    }

    private double calculateMaxHit(double effectiveStrengthLevel, double meleeStrengthEquipmentBonus) {
        //Max hit is Floor(((eff str lvl * (str equip bonus + 64))+320)/640) * gear bonus (7/6 for slayer helm, 1.2 for salve)
        //TODO salve and slayer helm
       return Math.floor(((effectiveStrengthLevel * (meleeStrengthEquipmentBonus + 64)) + 320)/640);
    }

    private double calculateTargetDefenceRoll(BossesAndMonsterStats bossesAndMonsterStats, MeleeWeapons meleeWeapons) {
        //Target def level for mobs is (targ def lvl + 9) * (targ style def + 64)
        double targetDefenceLevelModifier = bossesAndMonsterStats.getBaseDefence() + 9;
        double targetStyleDefenceModifier = 0;
        if (meleeWeapons.getWeaponStyle().equals(MeleeWeaponStyles.STAB)) {
            targetStyleDefenceModifier = bossesAndMonsterStats.getStabDefence();
        } else if (meleeWeapons.getWeaponStyle().equals(MeleeWeaponStyles.SLASH)) {
            targetStyleDefenceModifier = bossesAndMonsterStats.getSlashDefence();
        }
        targetStyleDefenceModifier = targetStyleDefenceModifier + 64;

        return targetDefenceLevelModifier * targetStyleDefenceModifier;
    }

    private double calculateHiteChance(double defenceroll, double attackRoll) {
        double hitChance = 0;
        if (attackRoll > defenceroll) {
            hitChance = 1 - (
                    (defenceroll + 2)/(2 * (attackRoll + 1))
            );
        } else { //This is technically inclusive but the wiki doesn't cover the identical roll case. So potential bug here
            hitChance = attackRoll/(2 * (defenceroll + 1));
        }
        return hitChance;
    }

    private double calculateMeleeDps(double maxhit, double hitChance, MeleeWeapons meleeWeapons) {
        return ((maxhit * hitChance)/2)/meleeWeapons.getWeaponSpeed().getSpeedInSeconds();
    }

    static double trunateDecimalPoint(double value, int decimalpoint)
    {

        // Using the pow() method
        value = value * Math.pow(10, decimalpoint);
        value = Math.floor(value);
        value = value / Math.pow(10, decimalpoint);

        return value;
    }

}
