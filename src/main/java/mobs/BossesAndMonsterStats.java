package mobs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BossesAndMonsterStats {
    KREEARA(255, 260, 200, 180, 180, 180, 200, 200, BossGroup.GWD, MobRestriction.MELEE_IMMUNE),
    GRAARDOR(255, 250, 80, 90, 90, 90, 298, 90, BossGroup.GWD, MobRestriction.NONE),
    KRIL_TSUTSAROTH(255, 270, 200, 80, 80, 80, 130, 80, BossGroup.GWD, MobRestriction.NONE),
    COMMANDER_ZILYANA(255, 300, 300, 100, 100, 100, 100, 100, BossGroup.GWD, MobRestriction.NONE),
    AHRIM_THE_BLIGHTED(100, 100, 100, 103, 85, 117, 73, 0, BossGroup.BARROWS, MobRestriction.NONE),
    KARIL_THE_TAINTED(100, 100, 1, 79, 71, 90, 106, 100, BossGroup.BARROWS, MobRestriction.NONE),
    DHAROK_THE_WRETCHED(100, 100, 1, 252, 250, 244, -11, 249, BossGroup.BARROWS, MobRestriction.NONE),
    GUTHAN_THE_INFESTED(100, 100, 1, 259, 257, 241, -11, 250, BossGroup.BARROWS, MobRestriction.NONE),
    TORAG_THE_CORRUPTED(100, 100, 1, 221, 235, 222, 0, 221, BossGroup.BARROWS, MobRestriction.NONE),
    VERAC_THE_DEFILED(100, 100, 1, 227, 230, 221, 0, 235, BossGroup.BARROWS, MobRestriction.NONE),
    GAINT_MOLE(200, 200, 200, 60, 80, 100, 80, 60, BossGroup.SOLO_BOSS, MobRestriction.NONE),
    DERANGED_ARCHAEOLOGIST(200, 280, 1, 20, 20, 50, 300, 300, BossGroup.NONE, MobRestriction.NONE),
    DAGANNOTH_SUPREME(255, 128, 255, 10, 10, 10, 255, 550, BossGroup.DAG_KINGS, MobRestriction.NONE),
    DAGANNOTH_REX(255, 255, 0, 255, 255, 255, 10, 255, BossGroup.DAG_KINGS, MobRestriction.NONE),
    DAGANNOTH_PRIME(255, 255, 255, 255, 255, 255, 255, 10, BossGroup.GWD, MobRestriction.NONE),
    SARACHNIS(400, 150, 150, 60, 40, 10, 150, 300, BossGroup.SOLO_BOSS, MobRestriction.NONE),
    //TODO KQ needs special attention as does the corp
    //KALPHITE_QUEEN(255, 300, 300, 100, 100, 100, 100, 100, BossGroup.GWD, MobRestriction.NONE),
    //CORPOREAL BEAST(255, 300, 300, 100, 100, 100, 100, 100, BossGroup.GWD, MobRestriction.NONE),
    NEX(3400, 260, 230, 40, 140, 60, 300, 190, BossGroup.GWD, MobRestriction.NONE);


    private final int hp;
    private final int baseDefence;
    private final int baseMagicLevel;
    private final int stabDefence;
    private final int slashDefence;
    private final int crushDefence;
    private final int magicDefence;
    private final int rangedDefence;
    private final BossGroup group;
    private final MobRestriction mobRestriction;
}
