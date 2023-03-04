package playermodifiers.equipment.melee;

public enum MeleeArmor {
    //Melee armor has 4 important properties. 1) stab accuracy, 2) slash accuracy, 3) crush accuracy, 4) strength

    //Headgear
    TORVA_FULL_HELM(0, 0, 0, 8, -5,-5),
    HELM_OF_NEITIZNOT(0,0,0,3,0,0),
    NEITIZNOT_FACEGUARD(0,0,0,6,0,0),
    SERPENTINE_HELM(0,0,0,5,-5,-5),

    //Cape
    FIRE_CAPE(1,1,1,4,1,1),
    INFERNAL_CAPE(4,4,4,8,1,1),

    //Neckalce
    AMULET_OF_TORTURE(15,15,15,10,0,0),
    AMULET_OF_FURY(10,10,10,8,10,10),

    //Body
    BANDOS_CHESTPLATE(0, 0, 0, 4, -15, -10),
    TORVA_PLATEBODY(0,0,0,6,-18,-14),
    FIGHTERS_TORSO(0,0,0,4,-20,0),

    //Legs
    TORVA_PLATELEGS(0,0,0,4,-24,-11),
    BANDOS_TASSETS(0, 0, 0, 2, -21, -7),

    //Sheild
    DRAGONFIRE_SHIELD(0,0,0,8,-10, -5),
    DRAGON_DEFENDER(25,24,23,6,-3,-2),
    AVERNIC_DEFENDER(30,29,28,8,-5,-4),
    CRYSTAL_SHIELD(0,0,0,0,-10,-10),

    //Hands
    BARROWS_GLOVES(12,12,12,12,12,12),
    FEROCIOUS_GLOVES(16,16,16,14,-16,-16),

    //Feet
    DRAGON_BOOTS(0,0,0,5,-3,-1),
    PRIMORDIAL_BOOTS(2,2,2,5,-4,-1),

    //Ring
    BERSERKER_RING(0,0,0,8,0,0);

    public final int stabAccuracy;
    public final int slashAccuracy;
    public final int crushAccuracy;
    public final int mageAccuracy;
    public final int rangedAccuracy;
    public final int strength;

    private MeleeArmor(int stabAccuracy, int slashAccuracy, int crushAccuracy, int strength, int mageAccuracy, int rangedAccuracy) {
        this.stabAccuracy = stabAccuracy;
        this.slashAccuracy = slashAccuracy;
        this.crushAccuracy = crushAccuracy;
        this.strength = strength;
        this.rangedAccuracy = mageAccuracy;
        this.mageAccuracy = rangedAccuracy;
    }
}
