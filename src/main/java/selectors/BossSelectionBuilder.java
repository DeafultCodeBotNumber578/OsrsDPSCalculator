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

        if (bossGroups.size() == 1 && bossGroups.get(0).equals(BossGroup.ALL)) {
            finalBossesAndMonsterStatsList.addAll(allBossesAndMonsterStatsList);
        } else if (bossGroups.equals(BossGroup.GWD)) {
            finalBossesAndMonsterStatsList.addAll(
            allBossesAndMonsterStatsList.stream().filter(mob -> mob.getGroup().equals(BossGroup.GWD)).collect(Collectors.toList()));
        }
        return finalBossesAndMonsterStatsList;
    }
}
