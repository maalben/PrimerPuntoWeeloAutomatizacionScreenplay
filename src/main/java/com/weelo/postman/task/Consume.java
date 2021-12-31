package com.weelo.postman.task;

import com.weelo.postman.interactions.GetService;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Consume implements Task {
    private final String resource;

    public Consume(String resource) {
        this.resource = resource;
    }

    public static Consume service(String resource) {
        return Tasks.instrumented(Consume.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(GetService.service(resource));
    }
}
