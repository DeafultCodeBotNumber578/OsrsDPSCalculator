package equipment;

public enum RangedArmor {
    //Magic and ranged items both have 2 important properties. 1) accuracy 2) strength
    AHRIMS_HOOD(30, 0);
    public final int accuracy;
    public final int strength;

    private RangedArmor(int accuracy, int strength) {
        this.accuracy = accuracy;
        this.strength = strength;
    }
}
