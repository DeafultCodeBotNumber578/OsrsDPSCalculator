package calculators;

import mobs.BossesAndMonsterStats;
import mobs.MobRestriction;
import playermodifiers.equipment.melee.MeleeLoadout;
import playermodifiers.equipment.melee.MeleeCombatStyles;
import playermodifiers.equipment.melee.MeleeEquipmentLoadout;
import playermodifiers.equipment.melee.MeleeWeaponStyles;
import playermodifiers.equipment.melee.MeleeWeapons;
import playermodifiers.statmodifiers.StatBoosts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MeleeDPSCalculator {

    //The fang's dps
    //If the accuracy roll is bigger than the defence roll then: 1-(def+2)*(2*def+3)/(acc+1)/(acc+1)/6
    //If the defence roll is bigger than the attack roll then: D28*(4*acc+5)/6/(acc+1)/(def+1))
    //I did the calculation in order and it really is that crazy, like 4 divisions in a row

    public List<BossToWeaponsDps> calculateMeleeDps(List<MeleeLoadout> meleeLoadouts, List<BossesAndMonsterStats> bossesAndMonsters) {
        List<BossToWeaponsDps> dpsMatrices = new ArrayList<>();
        for (MeleeLoadout meleeLoadout : meleeLoadouts) {
            MeleeEquipmentLoadout meleeEquipmentLoadout = meleeLoadout.getMeleeEquipmentLoadout();

            //Step 1 - get attack level and attack bonus to calculate attack roll
            double effectiveAttackLevel = calculateEffectiveAttackLevel(meleeEquipmentLoadout.getMeleeWeapon(),
                    meleeLoadout.getStatBoosts(), meleeLoadout.getAttackLevel());
            double equipmentAttackBonus = calculateEquipmentAttackBonus(meleeLoadout.getMeleeEquipmentLoadout(), meleeEquipmentLoadout.getMeleeWeapon());
            double finalAttackRoll = calculateFinalMeleeAttackRoll(effectiveAttackLevel, equipmentAttackBonus);

            //Step 2 - get strength level and strength bonus to calculate max hit
            double effectiveStrengthLevel = calculateEffectiveStrengthLevel(meleeEquipmentLoadout.getMeleeWeapon(), meleeLoadout.getStatBoosts(),
                    meleeLoadout.getStrengthLevel());
            double meleeEquipmentStrengthBonus = calculateEquipmentStrengthBonus(meleeLoadout.getMeleeEquipmentLoadout(), meleeEquipmentLoadout.getMeleeWeapon());
            double maxHit = calculateMaxHit(effectiveStrengthLevel, meleeEquipmentStrengthBonus);

            //Step 3 - calculate boss defence roll factoring in melee immune bosses
            Map<String, Double> mobDefenceRolls = new HashMap<>();
            for (BossesAndMonsterStats bossesAndMonsterStats : bossesAndMonsters) {
                if (!bossesAndMonsterStats.getMobRestriction().equals(MobRestriction.MELEE_IMMUNE)) {
                    mobDefenceRolls.put(bossesAndMonsterStats.name(), calculateTargetDefenceRoll(bossesAndMonsterStats, meleeEquipmentLoadout.getMeleeWeapon()));
                } else {
                    mobDefenceRolls.put(bossesAndMonsterStats.name(), null);

                }
            }

            //Step 4 - Loop through each boss and add the it to the running DPS matrix
            for (Map.Entry<String, Double> mobEntry : mobDefenceRolls.entrySet()) {
                double hitChance = calculateHiteChance(mobEntry.getValue(), finalAttackRoll);
                //If the boss isn't in the Matrix then add it
                if (dpsMatrices.stream().filter(bossToWeaponsDps -> bossToWeaponsDps.getBossName().equals(mobEntry.getKey())).collect(Collectors.toList()).isEmpty()) {
                    dpsMatrices.add(BossToWeaponsDps.builder()
                                    .bossName(mobEntry.getKey())
                                    .weaponToDpsMap(Map.of(meleeEquipmentLoadout.getMeleeWeapon().name(),
                                            calculateMeleeDps(maxHit, hitChance, meleeEquipmentLoadout.getMeleeWeapon()))).build());
                } else {
                    //if the boss is already in the Matrix then add this weapon
                    List<BossToWeaponsDps> bossToWeaponDps =
                            dpsMatrices.stream().filter(bossToWeaponsDps -> bossToWeaponsDps.getBossName().equals(mobEntry.getKey())).collect(Collectors.toList());
                    if (bossToWeaponDps.size() != 1) {
                        System.out.println("SOMETHING IS VERY WRONG PLEASE CHECK~1111111111111111111");
                    }
                    bossToWeaponDps.get(0).getWeaponToDpsMap().put(meleeEquipmentLoadout.getMeleeWeapon().name(),
                            calculateMeleeDps(maxHit, hitChance, meleeEquipmentLoadout.getMeleeWeapon()));
                }
            }
        }
        return dpsMatrices;

    }

    /**
     * Effective Melee Attack is -> (Attack level + Attack level boost) * prayer bonus - floor, +3/+1 for style, +8
     * @param meleeWeapons
     * @param statBoosts
     * @param attackLevel
     * @return
     */

    private double calculateEffectiveAttackLevel(MeleeWeapons meleeWeapons,
                                                 StatBoosts statBoosts, int attackLevel) {
        //Attack level boost is flatLevelBoost + (% level boost * base lvl) I.E. overloads are 6 flat + 16% * base level
        double attackLevelBoost = Math.floor(Float.valueOf(statBoosts.getStatBoost().flatLevelBoost) +
                ((Float.valueOf(attackLevel) * Float.valueOf(statBoosts.getStatBoost().percentageLevelBoost)/100f)));

        double effectiveMeleeAttackLevel = Math.floor((Float.valueOf(attackLevel) + attackLevelBoost));

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

    private double calculateEquipmentAttackBonus(MeleeEquipmentLoadout meleeEquipmentLoadout, MeleeWeapons meleeWeapons) {
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

    private double calculateEffectiveStrengthLevel(MeleeWeapons meleeWeapons, StatBoosts statBoosts, int strengthLevel) {
        //Melee Strength Level is (str lvl + str lvl boost) * prayer multi - floor, +3/+1 for style, +8

        double strengthLevelBoost = Math.floor(Float.valueOf(statBoosts.getStatBoost().flatLevelBoost) +
                (((float) strengthLevel * Float.valueOf(statBoosts.getStatBoost().percentageLevelBoost)/100f)));

        double effectiveMeleeStrengthLevel = Math.floor((Float.valueOf(strengthLevel) + strengthLevelBoost));

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

    private double calculateEquipmentStrengthBonus(MeleeEquipmentLoadout meleeEquipmentLoadout, MeleeWeapons meleeWeapons) {
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
