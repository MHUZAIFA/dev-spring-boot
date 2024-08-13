package com.practice.util.implementations;

import com.practice.util.interfaces.ICoach;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements ICoach {

    public TennisCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice smash!";
    }
}
