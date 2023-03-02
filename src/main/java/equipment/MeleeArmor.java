package equipment;

public enum MeleeArmor {
    //Melee armor has 4 important properties. 1) stab accuracy, 2) slash accuracy, 3) crush accuracy, 4) strength
    BANDOS_CHESTPLATE(0, 0, 0, 4);

    public final int stabAccuracy;
    public final int slashAccuracy;
    public final int crushAccuracy;
    public final int strength;

    private MeleeArmor(int stabAccuracy, int slashAccuracy, int crushAccuracy, int strength) {
        this.stabAccuracy = stabAccuracy;
        this.slashAccuracy = slashAccuracy;
        this.crushAccuracy = crushAccuracy;
        this.strength = strength;
    }
}
