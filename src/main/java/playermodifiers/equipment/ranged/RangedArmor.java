package playermodifiers.equipment.ranged;

public enum RangedArmor {
    //Ranged items have 3 meaningful properties 1) accuracy 2) strength 3) magic accuracy


    //Headgear

    //Cape

    //Neckalce

    //Body
    MASORI_BODY(43,4,-4);

    //Legs

    //Sheild

    //Hands

    //Feet

    //Ring
    public final int accuracy;
    public final int strength;
    public final int mageAccuracy;

    private RangedArmor(int accuracy, int strength, int mageAccuracy) {
        this.accuracy = accuracy;
        this.strength = strength;
        this.mageAccuracy = mageAccuracy;
    }
}
