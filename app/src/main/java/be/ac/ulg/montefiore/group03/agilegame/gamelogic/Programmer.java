package be.ac.ulg.montefiore.group03.agilegame.gamelogic;

import java.util.List;

/**
 * Created by charybde on 08.03.16.
 */
public class Programmer extends Person {
    private List<Skills> skills;
    private List<Interest> interests;

    private Features workOn; // Work max on a task ?

    public Boolean like(Interest _i){
        return this.interests.contains(_i);
    }

    public Boolean hasSkill(SkillType type){
        return this.skills.contains(type);
    }
    public Skills getSkill(SkillType type){
        return skills.get(skills.indexOf(type));
    }


}