package playermodifiers.equipment.melee;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MeleeWeapons {
    //Melee weapons have several important properties.
    // 1) stab accuracy, 2) slash accuracy, 3) crush accuracy, 4) strength
    // 5) weapon speed 6) combatStyle (Accurate/Aggressive/Defensive) 7) weaponStyle (Crush/Slash/Stab)
    //Most weapons have a single best combat style so it will be pre-determined.
    // In the event that there are more than 1 create unique entries such as FANG_SLASH && FANG_STAB
    GHRAZI_RAPIER(94, 55, 0, 89, 4, false, MeleeCombatStyles.AGGRESSIVE, MeleeWeaponStyles.STAB);

    public final int stabAccuracy;
    public final int slashAccuracy;
    public final int crushAccuracy;
    public final int strength;
    public final int speed;
    public final boolean isTwoHanded;

    //This gives the damage or accuracy bonus
    public final MeleeCombatStyles combatXpStyle;
    //This is what determines which monster defence is rolled against
    public final MeleeWeaponStyles weaponStyle;

}
