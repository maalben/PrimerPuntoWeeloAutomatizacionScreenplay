package com.weelo.postman.task;

import com.weelo.postman.interactions.PostService;
import com.weelo.postman.utils.constants.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumePost implements Task {
    private final String resource;

    public ConsumePost(String resource) {
        this.resource = resource;
    }

    public static ConsumePost service(String resource) {
        return Tasks.instrumented(ConsumePost.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = actor.recall(Constants.BODY).toString();
        actor.attemptsTo(PostService.service(resource, body));
    }
}
