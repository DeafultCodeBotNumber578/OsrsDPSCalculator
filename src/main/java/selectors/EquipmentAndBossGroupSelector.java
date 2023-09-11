package selectors;

import mobs.BossGroup;
import calculators.CombatStyle;
import playermodifiers.equipment.melee.MeleeLoadout;
import playermodifiers.equipment.melee.MeleeArmor;
import playermodifiers.equipment.melee.MeleeEquipmentLoadout;
import lombok.NoArgsConstructor;
import playermodifiers.equipment.melee.MeleeWeapons;
import playermodifiers.statmodifiers.DefenceLoweringSpecs;
import playermodifiers.statmodifiers.StatBoostingItems;
import playermodifiers.statmodifiers.StatBoosts;
import playermodifiers.statmodifiers.MeleeCombatStats;

import java.util.ArrayList;
import java.util.List;

//Define the Equipment and Boss list setups you want in here
@NoArgsConstructor
public class EquipmentAndBossGroupSelector {

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

    public List<MeleeLoadout> defineMeleePlayerLoadouts() {
        List<MeleeLoadout> meleeLoadouts = new ArrayList<>();

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
                .meleeWeapon(MeleeWeapons.ABYSSAL_TENTACLE)
                .build();


        DefenceLoweringSpecs defenceLoweringSpecs1 = DefenceLoweringSpecs.builder()
                .bgsSpecDamage(50)
                .numberOfDWHSpecs(2)
                .build();

        //TODO if these aren't present assume they're max
        MeleeCombatStats meleeCombatStats1 = MeleeCombatStats.builder()
                .attackLevel(99)
                .strengthLevel(99)
                .build();

        //TODO this can be simplified. No need to have it repeated because you're only going to be using all overloads, all salts, or all supers
        StatBoosts statBoosts1 = StatBoosts.builder()
                .statBoost(StatBoostingItems.SMELLING_SALTS)
                .build();

        CombatStyle combatStyle = CombatStyle.MELEE;

        meleeLoadouts.add(new MeleeLoadout(meleeEquipmentLoadout1, null, statBoosts1, 99, 99));
        //END-MELEE LOAD OUT 1-----------------------------------------------------

        //MELEE LOAD OUT 2------------------------------------------------------------
        MeleeEquipmentLoadout meleeEquipmentLoadout2 =  MeleeEquipmentLoadout.builder()
                .headgear(MeleeArmor.SERPENTINE_HELM)
                .cape(MeleeArmor.INFERNAL_CAPE)
                .necklace(MeleeArmor.AMULET_OF_TORTURE)
                .body(MeleeArmor.BANDOS_CHESTPLATE)
                .legs(MeleeArmor.BANDOS_TASSETS)
                .shield(MeleeArmor.AVERNIC_DEFENDER)
                .hands(MeleeArmor.FEROCIOUS_GLOVES)
                .feet(MeleeArmor.DRAGON_BOOTS)
                .ring(MeleeArmor.BERSERKER_RING)
                .meleeWeapon(MeleeWeapons.GHRAZI_RAPIER)
                .build();

        MeleeWeapons meleeWeapons2 = MeleeWeapons.GHRAZI_RAPIER;


        DefenceLoweringSpecs defenceLoweringSpecs2 = DefenceLoweringSpecs.builder()
                .bgsSpecDamage(50)
                .numberOfDWHSpecs(2)
                .build();

        //TODO if these aren't present assume they're max
        MeleeCombatStats meleeCombatStats2 = MeleeCombatStats.builder()
                .attackLevel(99)
                .strengthLevel(99)
                .build();

        //TODO this can be simplified. No need to have it repeated because you're only going to be using all overloads, all salts, or all supers
        StatBoosts statBoosts2 = StatBoosts.builder()
                .statBoost(StatBoostingItems.SMELLING_SALTS)
                .build();

        CombatStyle combatStyle2 = CombatStyle.MELEE;

        meleeLoadouts.add(new MeleeLoadout(meleeEquipmentLoadout2,null, statBoosts2, 99, 99));
        //END-MELEE LOAD OUT 2-----------------------------------------------------

        return meleeLoadouts;
    }

    //TODO from 8/24 - SUNSHINE - Add code probably elsewhere to turn a boss selection group into a whole boss list picker.
    //The boss definitions pojo isn't in good shape for that yet
    public List<BossGroup> selectBossGroups() {
        List<BossGroup> bossGroups = new ArrayList<>();
        BossGroup bossGroup1 = BossGroup.ALL;

        bossGroups.add(bossGroup1);

        return bossGroups;
    }

    //TODO definePrayers();
    //TODO defineStats();
    //TODO definePotions();
    //TODO buildBossList();
    //TODO defineTOALevel();



}
