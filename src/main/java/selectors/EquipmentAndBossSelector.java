package selectors;

import equipment.MeleeArmor;
import equipment.MeleeEquipmentLoadout;
import equipment.RangedEquipmentLoadout;
import lombok.NoArgsConstructor;
import statsandmodifiers.DefenceLoweringSpecs;
import statsandmodifiers.StatBoostingItems;
import statsandmodifiers.StatBoosts;
import statsandmodifiers.CombatStats;

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

    public List<MeleeEquipmentLoadout> defineMeleeEquipmentLoadouts() {
        List<MeleeEquipmentLoadout> meleeEquipmentLoadouts = new ArrayList<>();

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

        return meleeEquipmentLoadouts;
    }

    public List<RangedEquipmentLoadout> defineRangedEquipmentLoadout() {
        List<RangedEquipmentLoadout> rangedEquipmentLoadouts = new ArrayList<>();

        //Build loadouts

        return rangedEquipmentLoadouts;
    }

    public DefenceLoweringSpecs defineSpecWeaponHits() {
        return DefenceLoweringSpecs.builder()
                .bgsSpecDamage(50)
                .numberOfDWHSpecs(2)
            .build();
    }

    public CombatStats defineCombatStats() {
        return CombatStats.builder()
                .magicLevel(99)
                .rangedLevel(99)
                .attackLevel(99)
                .strengthLevel(99)
            .build();
    }

    public StatBoosts defineStatBoosts() {
        return StatBoosts.builder()
                .magicBoost(StatBoostingItems.SMELLING_SALTS)
                .rangedBoost(StatBoostingItems.SMELLING_SALTS)
                .meleeBoost(StatBoostingItems.SMELLING_SALTS)
            .build();
    }

    //TODO definePrayers();
    //TODO defineStats();
    //TODO definePotions();
    //TODO buildBossList();
    //TODO defineTOALevel();



}
