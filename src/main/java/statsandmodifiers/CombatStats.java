package statsandmodifiers;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class CombatStats {
    public int magicLevel;
    public int rangedLevel;
    public int attackLevel;
    public int strengthLevel;

    //TODO defence level can come later
}
