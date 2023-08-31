package mobs;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public enum BossesAndMonsterStats {
    //GWD
    KREEARA(255, 260, 200, 180, 180, 180, 200, 200, BossGroup.GWD, List.of(MobRestriction.MELEE_IMMUNE)),
    GRAARDOR(255, 250, 80, 90, 90, 90, 298, 90, BossGroup.GWD, List.of(MobRestriction.NONE)),
    KRIL_TSUTSAROTH(255, 270, 200, 80, 80, 80, 130, 80, BossGroup.GWD, List.of(MobRestriction.NONE)),
    COMMANDER_ZILYANA(255, 300, 300, 100, 100, 100, 100, 100, BossGroup.GWD, List.of(MobRestriction.NONE)),
    NEX(3400, 260, 230, 40, 140, 60, 300, 190, BossGroup.GWD, List.of(MobRestriction.NONE)),

    //Barrows
    AHRIM_THE_BLIGHTED(100, 100, 100, 103, 85, 117, 73, 0, BossGroup.BARROWS, List.of(MobRestriction.NONE)),
    KARIL_THE_TAINTED(100, 100, 1, 79, 71, 90, 106, 100, BossGroup.BARROWS, List.of(MobRestriction.NONE)),
    DHAROK_THE_WRETCHED(100, 100, 1, 252, 250, 244, -11, 249, BossGroup.BARROWS, List.of(MobRestriction.NONE)),
    GUTHAN_THE_INFESTED(100, 100, 1, 259, 257, 241, -11, 250, BossGroup.BARROWS,List.of( MobRestriction.NONE)),
    TORAG_THE_CORRUPTED(100, 100, 1, 221, 235, 222, 0, 221, BossGroup.BARROWS, List.of(MobRestriction.NONE)),
    VERAC_THE_DEFILED(100, 100, 1, 227, 230, 221, 0, 235, BossGroup.BARROWS, List.of(MobRestriction.NONE)),

    //One off solo bosses
    GAINT_MOLE(200, 200, 200, 60, 80, 100, 80, 60, BossGroup.SOLO_BOSS, List.of(MobRestriction.NONE)),
    DERANGED_ARCHAEOLOGIST(200, 280, 1, 20, 20, 50, 300, 300, BossGroup.SOLO_BOSS, List.of(MobRestriction.NONE)),
    SARACHNIS(400, 150, 150, 60, 40, 10, 150, 300, BossGroup.SOLO_BOSS, List.of(MobRestriction.NONE)),

    //Dag kings
    DAGANNOTH_SUPREME(255, 128, 255, 10, 10, 10, 255, 550, BossGroup.DAG_KINGS, List.of(MobRestriction.NONE)),
    DAGANNOTH_REX(255, 255, 0, 255, 255, 255, 10, 255, BossGroup.DAG_KINGS,List.of(MobRestriction.NONE)),
    DAGANNOTH_PRIME(255, 255, 255, 255, 255, 255, 255, 10, BossGroup.DAG_KINGS, List.of(MobRestriction.NONE)),
    //TODO KQ needs special attention as does the corp
    //KALPHITE_QUEEN(255, 300, 300, 100, 100, 100, 100, 100, BossGroup.GWD, MobRestriction.NONE),
    //CORPOREAL BEAST(255, 300, 300, 100, 100, 100, 100, 100, BossGroup.GWD, MobRestriction.NONE),

    //Minor wildy bosses
    CHAOS_FANATIC(225, 220, 200, 260, 260, 250, 280, 80, BossGroup.MINOR_WILDY, List.of(MobRestriction.NONE)),
    CRAZY_ARCHAEOLOGIST(225, 240, 1, 5, 5, 30, 250, 250, BossGroup.MINOR_WILDY, List.of(MobRestriction.NONE)),
    SCORPIA(200, 180, 1, 246, 284, 284, 44, 284, BossGroup.MINOR_WILDY, List.of(MobRestriction.NONE)),
    KING_BLACK_DRAGON(240, 240, 240, 70, 90, 90, 80, 70, BossGroup.MINOR_WILDY, List.of(MobRestriction.NONE)),
    CHAOS_ELEMENTAL(250, 270, 270, 70, 70, 70, 70, 70, BossGroup.MINOR_WILDY, List.of(MobRestriction.NONE)),

    //Major wildy bosses
    //TODO escape the ' in these guys names
    CALVARION(150, 225, 178, 130, 128, -10, 198, 211, BossGroup.MAJOR_WILDY, List.of(MobRestriction.NONE)),
    VETION(255, 395, 300, 201, 200, -10, 250, 270, BossGroup.MAJOR_WILDY, List.of(MobRestriction.NONE)),
    SPINDEL(515, 225, 205, 70, 70, 10, 205, 103, BossGroup.MAJOR_WILDY, List.of(MobRestriction.NONE)),
    VENENATIS(850, 321, 300, 100, 100, 10, 300, 150, BossGroup.MAJOR_WILDY, List.of(MobRestriction.NONE)),
    ARTIO(450, 150, 1, 125, 110, 110, 0, 40, BossGroup.MAJOR_WILDY, List.of(MobRestriction.NONE)),
    CALLISTO(1000, 225, 1, 150,
            130, 125, 0, 50, BossGroup.MAJOR_WILDY, List.of(MobRestriction.NONE));


    private final int hp;
    private final int baseDefence;
    private final int baseMagicLevel;
    private final int stabDefence;
    private final int slashDefence;
    private final int crushDefence;
    private final int magicDefence;
    private final int rangedDefence;
    private final BossGroup group;
    private final List<MobRestriction> mobRestriction;
}
