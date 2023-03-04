package playermodifiers.equipment.mage;

public enum MageWeapons {
    //Ranged and Mage weapons have 3 important properties. 1) accuracy 2) strength 3) weapon speed
    //We will only be considering the fastest speed of ranged weapons. No need to bother with the worse styles.
    TOXIC_BLOWPIPE(30, 20, 2);

    public final int accuracy;
    public final int strength;
    public final int speed;

    private MageWeapons(int accuracy, int strength, int speed) {
        this.accuracy = accuracy;
        this.strength = strength;
        this.speed = speed;
    }
}
