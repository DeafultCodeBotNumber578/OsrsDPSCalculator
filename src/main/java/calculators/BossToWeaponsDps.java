package calculators;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class BossToWeaponsDps {
    private String bossName;
    private Map<String, Double> weaponToDpsMap;
}
