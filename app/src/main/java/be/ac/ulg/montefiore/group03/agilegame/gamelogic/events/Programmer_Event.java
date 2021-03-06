package be.ac.ulg.montefiore.group03.agilegame.gamelogic.events;

import java.util.Date;

import be.ac.ulg.montefiore.group03.agilegame.gamelogic.Interest;
import be.ac.ulg.montefiore.group03.agilegame.gamelogic.Programmer;
import be.ac.ulg.montefiore.group03.agilegame.gamelogic.Skills;

/**
 * Created by charybde on 08.03.16.
 */
public class Programmer_Event extends Event{

    private Interest depend;

    public Programmer_Event(String s, Date d) {
        super(s,d);
    }

    public Programmer_Event(String s, Date d, Interest i){
        super(s,d);
        this.depend = i;
    }

    public Programmer_Event(int  id, Date d, Interest i){
        super(id,d);
        this.depend = i;
    }

    public Programmer_Event(int i, Date d, Interest interest, Skills up, double delay){
        super(i,d,up, delay);
        this.depend = interest;
    }


    public void effect(Programmer _p) { //Could be inherited by special programmer_event
        if(_p.like(depend)){
            if (this.amelioration != null && _p.hasSkill(this.amelioration.getType())) { // TODO: bug null pointer resolved ?
                Skills s = _p.getSkill(this.amelioration.getType());
                boolean b = s.gainXp(this.amelioration.getXp());
                if (b)
                    _p.notifyObservers(s);
            }

            _p.setBonus(_p.getBonus() * this.delay);

            _p.notify(this);
        }
    }

}
