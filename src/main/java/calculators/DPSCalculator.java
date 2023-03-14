package calculators;

import playermodifiers.CombatStyle;
import playermodifiers.PlayerLoadout;
import playermodifiers.equipment.melee.MeleeCombatStyles;
import playermodifiers.equipment.melee.MeleeEquipmentLoadout;
import playermodifiers.equipment.melee.MeleeWeapons;
import playermodifiers.statmodifiers.CombatStats;
import playermodifiers.statmodifiers.StatBoosts;

import java.util.List;

public class DPSCalculator {

    public void orchestrateDPSCalcs(List<PlayerLoadout> playerLoadouts) {
        PlayerLoadout playerLoadout1 = playerLoadouts.get(0);

        //determine style of loadout
        if (playerLoadout1.getCombatStyle() == CombatStyle.MELEE) {
            double effectiveMeleeAttackLevel = calculateEffectiveMeleeAttackLevel(playerLoadout1.getMeleeEquipmentLoadout(), playerLoadout1.getMeleeWeapons(),
                    playerLoadout1.getStatBoosts(), playerLoadout1.getCombatStats());
            //Get attack roll

        }



    }

    //TODO this is untested
    private double calculateEffectiveMeleeAttackLevel(MeleeEquipmentLoadout meleeEquipmentLoadout, MeleeWeapons meleeWeapons,
                                                      StatBoosts statBoosts, CombatStats combatStats) {
        //Calculate effective attack level
        //Base level + (flat level boost + percentage boost))
        double effectiveMeleeAttackLevel =
                Math.floor(Float.valueOf(combatStats.attackLevel) + (
                        Float.valueOf(statBoosts.getMeleeBoost().flatLevelBoost) +
                                (Float.valueOf(statBoosts.getMeleeBoost().percentageLevelBoost * Float.valueOf(combatStats.attackLevel)))
                        )
                );
        //Add combat style bonus
        if (meleeWeapons.combatXpStyle.equals(MeleeCombatStyles.ACCURATE)) {
            effectiveMeleeAttackLevel = effectiveMeleeAttackLevel + 3;
        } else if (meleeWeapons.combatXpStyle.equals(MeleeCombatStyles.CONTROLLED)) {
            effectiveMeleeAttackLevel++;
        }
        //Obligatory +8 to the number just because
        effectiveMeleeAttackLevel = effectiveMeleeAttackLevel + 8;

        //TODO void melee I guess but who cares

        return effectiveMeleeAttackLevel;
    }

//    private int calculateRangedAttackRoll() {
//
//    }
//
//    private int calculateMageAttackRoll() {
//
//    }

}
