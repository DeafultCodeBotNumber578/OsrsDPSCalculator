package equipment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Equipment {
    private String name;
    private int stabAttack;
    private int slashAttack;
    private int crushAttack;
    private int mageAttack;
    private int rangeAttack;

    private int stabDefence;
    private int slashDefence;
    private int crushDefence;
    private int mageDefence;
    private int rangeDefence;

    private int meleeStrength;
    private int rangeStrength;
    private int mageStrength;

    private int prayerBonus;

    private EquipmentSlot slot;

    // This can be used to categorize equipment in case you only want to show certain items like melee, range, mage, etc.
    List<String> equipmentCategories = new ArrayList();

    public static enum EquipmentSlot {
        HEAD, NECK, CAPE, BODY, LEGS, BOOTS, GLOVES, RING, AMMO, WEAPON_1HAND, WEAPON_2HAND, OFFHAND
    }

    public Equipment(String name,
                     int stabAttack,
                     int slashAttack,
                     int crushAttack,
                     int mageAttack,
                     int rangeAttack,
                     int stabDefence,
                     int slashDefence,
                     int crushDefence,
                     int mageDefence,
                     int rangeDefence,
                     int meleeStrength,
                     int rangeStrength,
                     int mageStrength,
                     int prayerBonus,
                     EquipmentSlot slot) {
        this.name = name;
        this.stabAttack = stabAttack;
        this.slashAttack = slashAttack;
        this.crushAttack = crushAttack;
        this.mageAttack = mageAttack;
        this.rangeAttack = rangeAttack;
        this.stabDefence = stabDefence;
        this.slashDefence = slashDefence;
        this.crushDefence = crushDefence;
        this.mageDefence = mageDefence;
        this.rangeDefence = rangeDefence;
        this.meleeStrength = meleeStrength;
        this.rangeStrength = rangeStrength;
        this.mageStrength = mageStrength;
        this.prayerBonus = prayerBonus;
        this.slot = slot;
    }
}
