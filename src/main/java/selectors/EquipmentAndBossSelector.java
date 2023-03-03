package selectors;

import equipment.MeleeArmor;
import equipment.MeleeEquipmentLoadout;
import equipment.RangedEquipmentLoadout;
import lombok.NoArgsConstructor;
import statsandmodifiers.DefenceLoweringSpecs;

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

    public List<RangedEquipmentLoadout> defineRangedAndMageEquipmentLoadout() {
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
    //TODO definePrayers();
    //TODO defineStats();
    //TODO definePotions();
    //TODO buildBossList();
    //TODO defineTOALevel();



}
