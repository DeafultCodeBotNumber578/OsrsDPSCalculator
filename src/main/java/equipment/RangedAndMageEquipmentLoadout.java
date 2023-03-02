package equipment;

import lombok.Data;

@Data
public class RangedAndMageEquipmentLoadout {
    private RangedAndMageArmor headgear;
    private RangedAndMageArmor cape;
    private RangedAndMageArmor necklace;
    private RangedAndMageArmor body;
    private RangedAndMageArmor legs;
    private RangedAndMageArmor shield;
    private RangedAndMageArmor hands;
    private RangedAndMageArmor feet;
    private RangedAndMageArmor ring;
    private RangedAndMageWeapons rangedOrMageWeapon;
    private Ammo ammo;
    private Spells spell;
    //Quick check to see which of the two styles is being used
    private boolean isRanged;
}
