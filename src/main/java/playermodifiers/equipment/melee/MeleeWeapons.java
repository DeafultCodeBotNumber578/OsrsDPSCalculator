package playermodifiers.equipment.melee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import playermodifiers.equipment.WeaponSpeeds;

@AllArgsConstructor
@Getter
public enum MeleeWeapons {
    //Melee weapons have several important properties.
    // 1) stab accuracy, 2) slash accuracy, 3) crush accuracy, 4) strength
    // 5) weapon speed 6) combatStyle (Accurate/Aggressive/Defensive) 7) weaponStyle (Crush/Slash/Stab)
    //Most weapons have a single best combat style so it will be pre-determined.
    // In the event that there are more than 1 create unique entries such as FANG_SLASH && FANG_STAB
    GHRAZI_RAPIER(94, 55, 0, 89, WeaponSpeeds.FOUR_TICK, false, MeleeCombatStyles.AGGRESSIVE, MeleeWeaponStyles.STAB);

    private final int stabAccuracy;
    private final int slashAccuracy;
    private final int crushAccuracy;
    private final int strengthBonus;
    private final WeaponSpeeds weaponSpeed;
    private final boolean isTwoHanded;

    //This gives the damage or accuracy bonus
    private final MeleeCombatStyles combatXpStyle;
    //This is what determines which monster defence is rolled against
    private final MeleeWeaponStyles weaponStyle;

}
