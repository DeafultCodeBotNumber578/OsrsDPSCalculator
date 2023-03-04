package playermodifiers.statmodifiers;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class StatBoosts {
    StatBoostingItems magicBoost;
    StatBoostingItems rangedBoost;
    StatBoostingItems meleeBoost;
}
