package playermodifiers.equipment.melee;

import lombok.AllArgsConstructor;
import lombok.Data;
import playermodifiers.statmodifiers.DefenceLoweringSpecs;
import playermodifiers.statmodifiers.StatBoosts;

@Data
@AllArgsConstructor
public class MeleeLoadout {
    private MeleeEquipmentLoadout meleeEquipmentLoadout;
    private DefenceLoweringSpecs defenceLoweringSpecs;
    private StatBoosts statBoosts;
    private int attackLevel;
    private int strengthLevel;
}
