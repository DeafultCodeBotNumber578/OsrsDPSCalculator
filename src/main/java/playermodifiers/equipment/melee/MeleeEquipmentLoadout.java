package playermodifiers.equipment.melee;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MeleeEquipmentLoadout {
    private MeleeArmor headgear;
    private MeleeArmor cape;
    private MeleeArmor necklace;
    private MeleeArmor body;
    private MeleeArmor legs;
    private MeleeArmor shield;
    private MeleeArmor hands;
    private MeleeArmor feet;
    private MeleeArmor ring;
    private MeleeWeapons meleeWeapon;
    private MeleeCombatStyles meleeCombatStyle;
    private MeleeWeaponStyles meleeWeaponStyle;
}
