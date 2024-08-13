package com.practice.springcorepractice.rest;

import com.practice.springcorepractice.interfaces.ICoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    private ICoach coach = null;

    @Autowired
    public DemoRestController(ICoach coach) {
        this.coach = coach;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout() {
        return this.coach.getDailyWorkout();
    }

}
