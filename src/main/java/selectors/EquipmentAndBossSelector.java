package selectors;

import playermodifiers.PlayerLoadout;
import playermodifiers.equipment.melee.MeleeArmor;
import playermodifiers.equipment.melee.MeleeEquipmentLoadout;
import lombok.NoArgsConstructor;
import playermodifiers.statmodifiers.DefenceLoweringSpecs;
import playermodifiers.statmodifiers.StatBoostingItems;
import playermodifiers.statmodifiers.StatBoosts;
import playermodifiers.statmodifiers.CombatStats;

import java.util.ArrayList;
import java.util.List;

//Define the Equipment and Boss list setups you want in here
@NoArgsConstructor
public class EquipmentAndBossSelector {

    /*
        .headgear()
        .cape()
        .necklace()
        .body()
        .legs()
        .shield()
        .hands()
        .feet()
        .ring()

        Classes: MeleeArmor, RangedArmor, MageArmor
     */

    public List<PlayerLoadout> defineMeleePlayerLoadouts() {
        List<PlayerLoadout> playerLoadouts = new ArrayList<>();

        //MELEE LOAD OUT 1------------------------------------------------------------
        MeleeEquipmentLoadout meleeLoadout1 =  MeleeEquipmentLoadout.builder()
                .headgear(MeleeArmor.SERPENTINE_HELM)
                .cape(MeleeArmor.INFERNAL_CAPE)
                .necklace(MeleeArmor.AMULET_OF_TORTURE)
                .body(MeleeArmor.BANDOS_CHESTPLATE)
                .legs(MeleeArmor.BANDOS_TASSETS)
                .shield(MeleeArmor.AVERNIC_DEFENDER)
                .hands(MeleeArmor.FEROCIOUS_GLOVES)
                .feet(MeleeArmor.DRAGON_BOOTS)
                .ring(MeleeArmor.BERSERKER_RING)
                .build();

        DefenceLoweringSpecs defenceLoweringSpecs1 = DefenceLoweringSpecs.builder()
                .bgsSpecDamage(50)
                .numberOfDWHSpecs(2)
                .build();

        CombatStats combatStats1 = CombatStats.builder()
                .magicLevel(99)
                .rangedLevel(99)
                .attackLevel(99)
                .strengthLevel(99)
                .build();

        //TODO this can be simplified. No need to have it repeated because you're only going to be using all overloads, all salts, or all supers
        StatBoosts statBoosts1 = StatBoosts.builder()
                .magicBoost(StatBoostingItems.SMELLING_SALTS)
                .rangedBoost(StatBoostingItems.SMELLING_SALTS)
                .meleeBoost(StatBoostingItems.SMELLING_SALTS)
                .build();

        playerLoadouts.add(new PlayerLoadout(meleeLoadout1, null, null,
                defenceLoweringSpecs1, statBoosts1, combatStats1));
        //END-MELEE LOAD OUT 1-----------------------------------------------------

        return playerLoadouts;
    }

    //TODO definePrayers();
    //TODO defineStats();
    //TODO definePotions();
    //TODO buildBossList();
    //TODO defineTOALevel();



}
