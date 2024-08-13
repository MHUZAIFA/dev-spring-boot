package com.practice.util.implementations;

import com.practice.util.interfaces.ICoach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements ICoach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 30minutes...!";
    }
}
