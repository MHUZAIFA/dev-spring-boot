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
    private ICoach anotherCoach = null;

    /* Setter injection - used for injecting optional dependencies
    @Autowired
    public void setCoach(ICoach coach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.coach = coach;
    }
    */


    /*
    Constructor injection - used for injecting required dependencies
    @Autowired
    public DemoRestController(@Qualifier("cricketCoach") ICoach coach,
                              @Qualifier("cricketCoach") ICoach anotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }
    */

    @Autowired
    public DemoRestController(@Qualifier("cricketCoach") ICoach coach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.coach = coach;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout() {
        return this.coach.getDailyWorkout();
    }

    /*
    this.coach == this.anotherCoach
    Singleton --> returns true as refers to same cached bean.
    Prototype --> returns false as refers to different cached beans.
    */
    @GetMapping("/check")
    public String check() {
        return "Comparing coach and anotherCoach bean: coach == anotherCoach, " + (this.coach == this.anotherCoach);
    }

}
