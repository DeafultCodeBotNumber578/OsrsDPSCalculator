package mobs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BossesAndMonsterStats {
    //KREEARA(255, 260, 200, 180, 180, 180, 200, 200, BossGroup.GWD),
    GRAARDOR(255, 250, 80, 90, 90, 90, 298, 90, BossGroup.GWD),
    KRIL_TSUTSAROTH(255, 270, 200, 80, 80, 80, 130, 80, BossGroup.GWD),
    COMMANDER_ZILYANA(255, 300, 300, 100, 100, 100, 100, 100, BossGroup.GWD);

    private final int hp;
    private final int baseDefence;
    private final int baseMagicLevel;
    private final int stabDefence;
    private final int slashDefence;
    private final int crushDefence;
    private final int magicDefence;
    private final int rangedDefence;
    private final BossGroup group;
}
