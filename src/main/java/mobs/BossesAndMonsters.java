package mobs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BossesAndMonsters {
    KREEARA(255, 260, 200, 180, 180, 180, 200, 200, "gwd"),
    GRAARDOR(255, 260, 200, 5, 180, 180, 200, 200, "gwd");

    private final int hp;
    private final int baseDefence;
    private final int baseMagicLevel;
    private final int stabDefence;
    private final int slashDefence;
    private final int crushDefence;
    private final int magicDefence;
    private final int rangedDefence;
    private final String group;
}
