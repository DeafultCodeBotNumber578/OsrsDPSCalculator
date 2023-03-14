package playermodifiers.statmodifiers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class StatBoosts {
    StatBoostingItems magicBoost;
    StatBoostingItems rangedBoost;
    StatBoostingItems meleeBoost;
}
