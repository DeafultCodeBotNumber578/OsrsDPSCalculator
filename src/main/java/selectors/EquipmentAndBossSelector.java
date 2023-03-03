package selectors;

import equipment.MeleeArmor;
import equipment.MeleeEquipmentLoadout;
import equipment.RangedEquipmentLoadout;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//Define the Equipment and Boss list setups you want in here
@NoArgsConstructor
public class EquipmentAndBossSelector {

    public List<MeleeEquipmentLoadout> defineMeleeEquipmentLoadouts() {
        List<MeleeEquipmentLoadout> meleeEquipmentLoadouts = new ArrayList<>();

        MeleeEquipmentLoadout meleeLoadout1 =  MeleeEquipmentLoadout.builder()
                .headgear(MeleeArmor.SERPENTINE_HELM)
                .build();

        return meleeEquipmentLoadouts;
    }

    public List<RangedEquipmentLoadout> defineRangedAndMageEquipmentLoadout() {
        List<RangedEquipmentLoadout> rangedEquipmentLoadouts = new ArrayList<>();

        //Build loadouts

        return rangedEquipmentLoadouts;
    }

    //TODO definePrayers();
    //TODO defineStats();
    //TODO definePotions();
    //TODO buildBossList();
    //TODO defineSpecWeapons();
    //TODO defineTOALevel();



}
