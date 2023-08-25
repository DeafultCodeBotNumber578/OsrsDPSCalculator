import mobs.BossGroup;
import calculators.DPSCalculator;
import playermodifiers.PlayerLoadout;
import selectors.EquipmentAndBossSelector;

import java.util.List;

public class DPSMain {

    public static void main(String args[]) {

        //Going to want to have a single file to define everything in so you don't have to switch around and make sure
        //That all of the playermodifiers.equipment is correct
        EquipmentAndBossSelector equipmentAndBossSelector = new EquipmentAndBossSelector();

        List<PlayerLoadout> playerLoadouts = equipmentAndBossSelector.defineMeleePlayerLoadouts();

        List<BossGroup> bossGroups = equipmentAndBossSelector.selectBossGroups();

        DPSCalculator dpsCalculator = new DPSCalculator();
        dpsCalculator.orchestrateDPSCalcs(playerLoadouts, bossGroups);

        //TODOFeed into DPS calculator
        //Dps calculator will, for each monster, determine the max hit and then average hit and use the averaged accuracy
        //roll by deriving it from the offensive roll vs defensive roll. DWH and BGS will be applied as well to every monster.
        //There will need to be a special rules checker for things like fang and the brimstone ring

        //Return a list of DPS comparisons for each monster. Make some indication of which weapon wins and figure out an easy way to identify all of them
    }

    /**
     * Todo list until I get the read.me up
     * Questions:
     * Should there be a "MeleeHeadGear" and etc. instead of just a single re-used "MeleeArmor" class? Feels like keeping it simple is best
     *
     * Critical:
     * slayer helm
     * salve
     * fang forumula
     * Shadow staff formula
     * TOA level
     * Crystal armor effect
     * Dragonhunter effect
     * Keris Effect
     * Twisted bow formula
     *
     * Important:
     * brimstone ring
     * Scythe formula
     * arclight formula
     * Ruby, diamond, and dragonstone bolts
     * Saved preset names such as (Maxed melee. My current Melee. Goal Melee)
     *
     * Nice to haves:
     * thrawls
     * arclight spec
     * Scythe and halberd monster size check
     * D claw spec
     * Also specs in general
     * est time to kill
     * Dps % difference between things
     * demonbane formula
     * Overkill DPS
     * Inquisitors full armor bonus
     * Dharok
     * Ice barrage (Just needs to be on a single target)
     * Justiciar/Buwlark and the melee defence items
     *
     * Big Stretch goals:
     * a fancy GUI
     * degredation of stats and dps loss over time for regular pots
     * wildy weapon DPS
     * Full void I guess but who cares
     * Display the superior style if there's more than one such as the scythe/fang
     * A 5 tick option for ranged because I guess like 5 tick bandos might be useful to know? Idk it sounds dumb
     * Melee lowering hits before dps increases have a large taper off. For instance 3 dwh makes the fang have <.1 dps increase with increased dwh specs
     * Thrawl
     * Volitile Orb Spec
     * Korasi's
     * Eldritch orb spec
     * Bulwark spec
     * Smoke staff
     * Vampire Weapons
     * There's something in the DPS calculator called "Nylo accuracy".... I have no idea what that is
     * Venerator bow? Idk if that's possible
     */
}
