package selectors;

import equipment.MeleeEquipmentLoadout;
import equipment.RangedAndMageEquipmentLoadout;
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

    public List<RangedAndMageEquipmentLoadout> defineRangedAndMageEquipmentLoadout() {
        List<RangedAndMageEquipmentLoadout> rangedAndMageEquipmentLoadouts = new ArrayList<>();

        //Build loadouts

        return rangedAndMageEquipmentLoadouts;
    }

    //TODO definePrayers();
    //TODO defineStats();
    //TODO definePotions();
    //TODO buildBossList();
    //TODO defineSpecWeapons();
    //TODO defineTOALevel();



}
