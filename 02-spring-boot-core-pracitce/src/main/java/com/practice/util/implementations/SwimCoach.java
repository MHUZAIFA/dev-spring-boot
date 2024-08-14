package com.practice.util.implementations;

import com.practice.util.interfaces.ICoach;

public class SwimCoach implements ICoach {

    public SwimCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 500 meters as warm up.";
    }
}
