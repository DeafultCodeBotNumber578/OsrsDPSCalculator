package statsandmodifiers;

public enum StatBoostingItems {
    SUPER_COMBAT(5, 15),
    RANGED_POTION(4, 10),
    SATURATED_HEART(4, 10),
    OVERLOADS(6, 16),
    SMELLING_SALTS(11, 16);

    public final int flatLevelBoost;
    public final int percentageLevelBoost;

    private StatBoostingItems(int flatLevelBoost, int percentageLevelBoost) {
        this.flatLevelBoost = flatLevelBoost;
        this.percentageLevelBoost = percentageLevelBoost;
    }
}
