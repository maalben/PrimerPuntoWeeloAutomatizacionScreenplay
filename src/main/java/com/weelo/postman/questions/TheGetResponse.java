package com.weelo.postman.questions;

import com.weelo.postman.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Collections;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class TheGetResponse implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        actor.should(seeThatResponse("Get service without parameters API is Success",
                response -> response
                        .assertThat()
                        .body("args", equalTo(Collections.emptyMap()))
                        .log().all()
        ));
        return "success";
    }

    public static TheGetResponse withoutParameters() {
        return new TheGetResponse();
    }
}
