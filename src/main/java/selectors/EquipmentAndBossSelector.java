package selectors;

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

        //Build loadouts

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
