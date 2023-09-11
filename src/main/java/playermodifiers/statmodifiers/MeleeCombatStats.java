package playermodifiers.statmodifiers;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class MeleeCombatStats {
    public int attackLevel;
    public int strengthLevel;

    //TODO defence level can come later
}
