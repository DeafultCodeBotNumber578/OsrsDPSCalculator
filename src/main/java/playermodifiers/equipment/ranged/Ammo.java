package playermodifiers.equipment.ranged;

public enum Ammo {
    //Ammo only has 2 important stats, accuracy and strength.
    RUNE_DARTS(0, 26);

    public final int accuracy;
    public final int strength;

    private Ammo(int accuracy, int strength) {
        this.accuracy = accuracy;
        this.strength = strength;
    }
}
