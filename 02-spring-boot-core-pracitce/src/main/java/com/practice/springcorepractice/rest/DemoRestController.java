package com.practice.springcorepractice.rest;

import com.practice.util.interfaces.ICoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    /*
    Field injection
    - no need for constructor and setter injection
    - not recommended as makes it difficult to unit test
    */
    private ICoach coach = null;

    /* Setter injection - used for injecting optional dependencies */
    @Autowired
    public void setCoach(@Qualifier("baseballCoach") ICoach coach) {
        this.coach = coach;
    }

    /*
    Constructor injection - used for injecting required dependencies
    @Autowired
    public DemoRestController(ICoach coach) {
        this.coach = coach;
    }
    */

    @GetMapping("/daily-workout")
    public String getDailyWorkout() {
        return this.coach.getDailyWorkout();
    }

}
