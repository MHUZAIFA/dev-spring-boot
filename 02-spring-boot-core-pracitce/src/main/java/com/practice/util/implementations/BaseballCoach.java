package com.practice.util.implementations;

import com.practice.util.interfaces.ICoach;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements ICoach {
    @Override
    public String getDailyWorkout() {
        return "Practice pitching for 1 hour";
    }
}
