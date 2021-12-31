package com.weelo.postman.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.is;

public class TheQuantityFieldsService implements Question<Boolean> {

    private final int quantityFields;

    public TheQuantityFieldsService(int quantityFields) {
        this.quantityFields = quantityFields;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Validation quantity fields service",
                        response -> response
                                .assertThat()
                                .body("size()", is(quantityFields))
                                .log().all()
                    )
        );
        return true;
    }

    public static TheQuantityFieldsService are(int quantityFields) {
        return new TheQuantityFieldsService(quantityFields);
    }
}
