package selectors;

import lombok.Data;
import mobs.BossGroup;
import mobs.BossesAndMonsterStats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class BossSelectionBuilder {

    public List<BossesAndMonsterStats> buildBossAndMonsterList(List<BossGroup> bossGroups) {
        List<BossesAndMonsterStats> finalBossesAndMonsterStatsList = new ArrayList<>();
        BossesAndMonsterStats[] allBossesAndMonsters = BossesAndMonsterStats.class.getEnumConstants();
        List<BossesAndMonsterStats> allBossesAndMonsterStatsList = Arrays.asList(allBossesAndMonsters);

        if (bossGroups.contains(BossGroup.GWD)) {
            finalBossesAndMonsterStatsList.addAll(
            allBossesAndMonsterStatsList.stream().filter(mob -> mob.getGroup().equals(BossGroup.GWD)).collect(Collectors.toList()));
        }
        return finalBossesAndMonsterStatsList;
    }
}
