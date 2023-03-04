package playermodifiers;

import lombok.AllArgsConstructor;
import playermodifiers.equipment.mage.MageEquipmentLoadout;
import playermodifiers.equipment.melee.MeleeEquipmentLoadout;
import playermodifiers.equipment.ranged.RangedEquipmentLoadout;
import playermodifiers.statmodifiers.CombatStats;
import playermodifiers.statmodifiers.DefenceLoweringSpecs;
import playermodifiers.statmodifiers.StatBoosts;

@AllArgsConstructor
public class PlayerLoadout {
    MeleeEquipmentLoadout meleeEquipmentLoadout;
    RangedEquipmentLoadout rangedEquipmentLoadout;
    MageEquipmentLoadout mageEquipmentLoadout;
    DefenceLoweringSpecs defenceLoweringSpecs;
    StatBoosts statBoosts;
    CombatStats combatStats;
}
