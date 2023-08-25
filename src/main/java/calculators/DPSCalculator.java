package calculators;

import mobs.BossGroup;
import playermodifiers.CombatStyle;
import playermodifiers.PlayerLoadout;
import playermodifiers.equipment.melee.MeleeCombatStyles;
import playermodifiers.equipment.melee.MeleeEquipmentLoadout;
import playermodifiers.equipment.melee.MeleeWeaponStyles;
import playermodifiers.equipment.melee.MeleeWeapons;
import playermodifiers.statmodifiers.CombatStats;
import playermodifiers.statmodifiers.StatBoosts;

import java.util.List;

public class DPSCalculator {

    public void orchestrateDPSCalcs(List<PlayerLoadout> playerLoadouts, List<BossGroup> bossGroups) {
        PlayerLoadout playerLoadout1 = playerLoadouts.get(0);

        double effectiveMeleeAttackLevel = 0;

        //determine style of loadout
        if (playerLoadout1.getCombatStyle() == CombatStyle.MELEE) {
           effectiveMeleeAttackLevel = calculateEffectiveMeleeAttackLevel(playerLoadout1.getMeleeWeapons(),
                    playerLoadout1.getStatBoosts(), playerLoadout1.getCombatStats());
            //Get attack roll
            System.out.println(effectiveMeleeAttackLevel);

            double meleeEquipmentAttackBonus = calculateMeleeEquipmentAttackBonus(playerLoadout1.getMeleeEquipmentLoadout(), playerLoadout1.getMeleeWeapons());

            double finalAttackRoll = calculateFinalMeleeAttackRoll(effectiveMeleeAttackLevel, meleeEquipmentAttackBonus, 123);
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
        if (meleeWeapons.combatXpStyle.equals(MeleeCombatStyles.ACCURATE)) {
            effectiveMeleeAttackLevel = effectiveMeleeAttackLevel + 3;
        } else if (meleeWeapons.combatXpStyle.equals(MeleeCombatStyles.CONTROLLED)) {
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
        if (meleeWeapons.weaponStyle.equals(MeleeWeaponStyles.STAB)) {
            meleeEquipmentAttackBonus =
                    meleeEquipmentLoadout.getHeadgear().stabAccuracy +
                    meleeEquipmentLoadout.getCape().stabAccuracy +
                    meleeEquipmentLoadout.getNecklace().stabAccuracy +
                    meleeEquipmentLoadout.getBody().stabAccuracy +
                    meleeEquipmentLoadout.getLegs().stabAccuracy +
                    meleeEquipmentLoadout.getShield().stabAccuracy + //TODO back up shield stat check
                    meleeEquipmentLoadout.getHands().stabAccuracy +
                    meleeEquipmentLoadout.getFeet().stabAccuracy +
                    meleeEquipmentLoadout.getRing().stabAccuracy +
                    meleeWeapons.stabAccuracy;

        }
        return meleeEquipmentAttackBonus;
    }

    private double calculateFinalMeleeAttackRoll(double effectiveAttackLevel, double equipmentAttackBonus, double targetStyleDefence) {
        System.out.println( Math.floor(effectiveAttackLevel * (equipmentAttackBonus + 64)));
        return Math.floor(effectiveAttackLevel * (equipmentAttackBonus + 64) * targetStyleDefence);
    }

    private double calculateEffectiveStrengthLevel(MeleeWeapons meleeWeapons, StatBoosts statBoosts, CombatStats combatStats) {
        //Melee Strength Level is (str lvl + str lvl boost) * prayer multi - floor, +3/+1 for style, +8
        double mine = 0;
        return mine;
    }

//
//    private int calculateMageAttackRoll() {
//
//    }

}
