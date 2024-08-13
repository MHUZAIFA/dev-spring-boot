package com.practice.springcorepractice.implementations;

import com.practice.springcorepractice.interfaces.ICoach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements ICoach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 30minutes";
    }
}
