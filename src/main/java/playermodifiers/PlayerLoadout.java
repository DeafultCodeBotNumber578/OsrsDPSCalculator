package playermodifiers;

import lombok.AllArgsConstructor;
import lombok.Data;
import playermodifiers.equipment.mage.MageEquipmentLoadout;
import playermodifiers.equipment.melee.MeleeEquipmentLoadout;
import playermodifiers.equipment.melee.MeleeWeapons;
import playermodifiers.equipment.ranged.RangedEquipmentLoadout;
import playermodifiers.statmodifiers.CombatStats;
import playermodifiers.statmodifiers.DefenceLoweringSpecs;
import playermodifiers.statmodifiers.StatBoosts;

@Data
@AllArgsConstructor
public class PlayerLoadout {
    private MeleeEquipmentLoadout meleeEquipmentLoadout;
    private RangedEquipmentLoadout rangedEquipmentLoadout;
    private MageEquipmentLoadout mageEquipmentLoadout;
    private DefenceLoweringSpecs defenceLoweringSpecs;
    private StatBoosts statBoosts;
    private CombatStats combatStats;
    private CombatStyle combatStyle;
}
