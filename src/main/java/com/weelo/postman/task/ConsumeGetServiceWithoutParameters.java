package com.weelo.postman.task;

import com.weelo.postman.interactions.GetServiceWithoutParameters;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumeGetServiceWithoutParameters implements Task {
    private final String resource;

    public ConsumeGetServiceWithoutParameters(String resource) {
        this.resource = resource;
    }

    public static ConsumeGetServiceWithoutParameters service(String resource) {
        return Tasks.instrumented(ConsumeGetServiceWithoutParameters.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(GetServiceWithoutParameters.service(resource));
    }
}
