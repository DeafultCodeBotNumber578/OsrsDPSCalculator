package calculators;

import mobs.BossesAndMonsterStats;
import playermodifiers.CombatStyle;
import playermodifiers.PlayerLoadout;
import playermodifiers.equipment.melee.MeleeCombatStyles;
import playermodifiers.equipment.melee.MeleeEquipmentLoadout;
import playermodifiers.equipment.melee.MeleeWeaponStyles;
import playermodifiers.equipment.melee.MeleeWeapons;
import playermodifiers.statmodifiers.CombatStats;
import playermodifiers.statmodifiers.StatBoosts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DPSCalculator {

    public void orchestrateDPSCalcs(List<PlayerLoadout> playerLoadouts, List<BossesAndMonsterStats> bossesAndMonsters) {
        PlayerLoadout playerLoadout1 = playerLoadouts.get(0);

        double effectiveMeleeAttackLevel = 0;

        //determine style of loadout
        if (playerLoadout1.getCombatStyle() == CombatStyle.MELEE) {
           effectiveMeleeAttackLevel = calculateEffectiveMeleeAttackLevel(playerLoadout1.getMeleeWeapons(),
                    playerLoadout1.getStatBoosts(), playerLoadout1.getCombatStats());
            //Get attack roll
            System.out.println(effectiveMeleeAttackLevel);

            double meleeEquipmentAttackBonus = calculateMeleeEquipmentAttackBonus(playerLoadout1.getMeleeEquipmentLoadout(), playerLoadout1.getMeleeWeapons());

            double finalAttackRoll = calculateFinalMeleeAttackRoll(effectiveMeleeAttackLevel, meleeEquipmentAttackBonus);

            double effectiveMeleeStrengthLevel = calculateEffectiveStrengthLevel(playerLoadout1.getMeleeWeapons(), playerLoadout1.getStatBoosts(),
                    playerLoadout1.getCombatStats());

            double meleeEquipmentStrengthBonus = calculateMeleeEquipmentStrengthBonus(playerLoadout1.getMeleeEquipmentLoadout(), playerLoadout1.getMeleeWeapons());

            double maxHit = calculateMaxHit(effectiveMeleeStrengthLevel, meleeEquipmentStrengthBonus);

            Map<String, Double> mobDefenceRolls = new HashMap<>();
            for (BossesAndMonsterStats bossesAndMonsterStats : bossesAndMonsters) {
                mobDefenceRolls.put(bossesAndMonsterStats.name(), calculateTargetDefenceRoll(bossesAndMonsterStats, playerLoadout1.getMeleeWeapons()));
            }

            Map<String, Double> finalDpsValues = new HashMap<>();
            for (Map.Entry<String, Double> mobEntry : mobDefenceRolls.entrySet()) {
                double hitChance = calculateHiteChance(mobEntry.getValue(), finalAttackRoll);
                finalDpsValues.put(mobEntry.getKey(), calculateMeleeDps(maxHit, hitChance, playerLoadout1.getMeleeWeapons()));
                System.out.println("final dps: " + mobEntry.getKey() + " "
                        + calculateMeleeDps(maxHit, hitChance, playerLoadout1.getMeleeWeapons()));
            }

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

        //TODO void melee I guess but who cares
        System.out.println(effectiveMeleeAttackLevel);

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

        }
        return meleeEquipmentAttackBonus;
    }

    private double calculateFinalMeleeAttackRoll(double effectiveAttackLevel, double equipmentAttackBonus) {
        System.out.println( Math.floor(effectiveAttackLevel * (equipmentAttackBonus + 64)));
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

        //TODO void melee I guess but who cares
        System.out.println(effectiveMeleeStrengthLevel);

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

}
