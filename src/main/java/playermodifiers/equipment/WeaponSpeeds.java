package playermodifiers.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import playermodifiers.equipment.melee.MeleeCombatStyles;
import playermodifiers.equipment.melee.MeleeWeaponStyles;

@AllArgsConstructor
@Getter
public enum WeaponSpeeds {
    TWO_TICK(1.2),
    THREE_TICK(1.8),
    FOUR_TICK(2.4),
    FIVE_TICK(3),
    SIX_TICK(3.6),
    SEVEN_TICK(4.2);

    private final double speedInSeconds;



}
