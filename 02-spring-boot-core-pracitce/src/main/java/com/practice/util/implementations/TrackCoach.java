package com.practice.util.implementations;

import com.practice.util.interfaces.ICoach;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements ICoach {
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5 miles.";
    }
}
