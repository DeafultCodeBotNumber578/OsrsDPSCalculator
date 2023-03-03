package equipment;

import lombok.Data;

@Data
public class MageEquipmentLoadout {
    private RangedArmor headgear;
    private RangedArmor cape;
    private RangedArmor necklace;
    private RangedArmor body;
    private RangedArmor legs;
    private RangedArmor shield;
    private RangedArmor hands;
    private RangedArmor feet;
    private RangedArmor ring;
    private RangedWeapons rangedOrMageWeapon;
    private Spells spell;
}
