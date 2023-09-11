package playermodifiers.statmodifiers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
//TODO this might be unecessary
public class StatBoosts {
    StatBoostingItems statBoost;
}
