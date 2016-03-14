package be.ac.ulg.montefiore.group03.agilegame.gamelogic.Events;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import be.ac.ulg.montefiore.group03.agilegame.DateUtil;
import be.ac.ulg.montefiore.group03.agilegame.gamelogic.Programmer;

/**
 * Created by charybde on 14.03.16.
 */
public class Event_Builder {
    public static final int MAX_EVENT = 10;
    public static final double RANDOMNESS = 0.7;

    private static Event_Builder instance = null;
    private ArrayList<Integer> nrOfEvents;
    private Random gen;

    private Event_Builder(){
        this.gen = new Random();
        this.nrOfEvents = new ArrayList<Integer>();
        this.nrOfEvents.add(0);
        Event_Builder.instance = this;
    }

    public static Event_Builder getInstance(){
        if(Event_Builder.instance == null)
            return new Event_Builder();
        return Event_Builder.instance;
    }

    //could return null
    public Programmer_Event buildProgramingEvent(Date month, int turn){
        if(nrOfEvents.size() <= turn){
            for(int i=nrOfEvents.size(); i <= turn; ++i)
                nrOfEvents.add(0);
        }
       if (nrOfEvents.get(turn) > MAX_EVENT )
            return null;

        nrOfEvents.set(turn, nrOfEvents.get(turn)  + 1);

        double coin = gen.nextDouble();
        if(coin > 0.7)
            return null;

        int day = getADay(); //Select a day of the month
        System.out.println("" + day + "."+DateUtil.getMonth(month)+"."+DateUtil.getYear(month));
        Date ev = DateUtil.dateFromString(""+ day + "."+DateUtil.getMonth(month)+"."+DateUtil.getYear(month), "d.M.y");

        Programmer_Event p =  new Programmer_Event("Bull" + nrOfEvents.get(turn), ev);
        return p;

    }

    private int getADay(){
        return gen.nextInt(28) + 1; //Don't care of the month lol
    }
}
