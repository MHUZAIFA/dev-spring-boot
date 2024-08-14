package com.practice.util.implementations;

import com.practice.util.interfaces.ICoach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// For "prototype" scoped beans, Spring does not call the destroy method.
public class CricketCoach implements ICoach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define on init operations
    @PostConstruct
    public void OnInit() {
        System.out.println("In OnInit(): " + getClass().getSimpleName());
    }

    // define on destroy operations
    @PreDestroy
    public void OnDestroy() {
        System.out.println("In OnDestroy(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 30minutes...!";
    }
}
