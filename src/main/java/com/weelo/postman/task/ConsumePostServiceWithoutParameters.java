package com.weelo.postman.task;

import com.weelo.postman.interactions.PostServiceWithoutParameters;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumePostServiceWithoutParameters implements Task {
    private final String resource;

    public ConsumePostServiceWithoutParameters(String resource) {
        this.resource = resource;
    }

    public static ConsumePostServiceWithoutParameters service(String resource) {
        return Tasks.instrumented(ConsumePostServiceWithoutParameters.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(PostServiceWithoutParameters.service(resource));
    }
}
