package selectors;

import bosses.BossGroups;
import playermodifiers.CombatStyle;
import playermodifiers.PlayerLoadout;
import playermodifiers.equipment.melee.MeleeArmor;
import playermodifiers.equipment.melee.MeleeEquipmentLoadout;
import lombok.NoArgsConstructor;
import playermodifiers.equipment.melee.MeleeWeapons;
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
        MeleeEquipmentLoadout meleeEquipmentLoadout1 =  MeleeEquipmentLoadout.builder()
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

        MeleeWeapons meleeWeapons1 = MeleeWeapons.GHRAZI_RAPIER;

        DefenceLoweringSpecs defenceLoweringSpecs1 = DefenceLoweringSpecs.builder()
                .bgsSpecDamage(50)
                .numberOfDWHSpecs(2)
                .build();

        //TODO if these aren't there assume they're max
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

        CombatStyle combatStyle = CombatStyle.MELEE;

        playerLoadouts.add(new PlayerLoadout(meleeEquipmentLoadout1, meleeWeapons1, null, null,
                defenceLoweringSpecs1, statBoosts1, combatStats1, combatStyle));
        //END-MELEE LOAD OUT 1-----------------------------------------------------

        return playerLoadouts;
    }

    public List<BossGroups> definBossExclusionGroups() {
        List<BossGroups> bossExclusionGroups = new ArrayList<>();
        BossGroups exclusionGroup1 = BossGroups.XERIC;

        bossExclusionGroups.add(exclusionGroup1);

        return bossExclusionGroups;
    }

    //TODO definePrayers();
    //TODO defineStats();
    //TODO definePotions();
    //TODO buildBossList();
    //TODO defineTOALevel();



}
