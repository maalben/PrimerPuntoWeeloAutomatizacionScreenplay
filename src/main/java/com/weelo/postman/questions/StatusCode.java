package com.weelo.postman.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class StatusCode implements Question<Boolean> {

    private final int statusCode;

    public StatusCode(int statusCode) {
        this.statusCode =  statusCode;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Post service API response code",
                        response -> response.statusCode(statusCode)
                        .log().all()
                )
        );
        return true;
    }

    public static StatusCode is(int statusCode) {
        return new StatusCode(statusCode);
    }
}
