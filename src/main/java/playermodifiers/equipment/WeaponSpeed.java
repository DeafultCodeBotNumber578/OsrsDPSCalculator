package playermodifiers.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WeaponSpeed {
    TWO_TICK(1.2),
    THREE_TICK(1.8),
    FOUR_TICK(2.4),
    FIVE_TICK(3),
    SIX_TICK(3.6),
    SEVEN_TICK(4.2);

    private final double speedInSeconds;



}
