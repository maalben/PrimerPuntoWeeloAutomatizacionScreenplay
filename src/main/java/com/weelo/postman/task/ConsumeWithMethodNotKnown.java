package com.weelo.postman.task;

import com.weelo.postman.interactions.GetServiceWithMethodNotKnown;
import com.weelo.postman.interactions.GetServiceWithoutParameters;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumeWithMethodNotKnown implements Task {
    private final String resource;

    public ConsumeWithMethodNotKnown(String resource) {
        this.resource = resource;
    }

    public static ConsumeWithMethodNotKnown service(String resource) {
        return Tasks.instrumented(ConsumeWithMethodNotKnown.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(GetServiceWithMethodNotKnown.service(resource));
    }
}
