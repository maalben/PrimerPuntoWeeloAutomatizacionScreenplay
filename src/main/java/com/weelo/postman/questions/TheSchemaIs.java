package com.weelo.postman.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class TheSchemaIs implements Question<Boolean> {

    private final String structure;

    public TheSchemaIs(String structure) {
        this.structure = structure;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.should(
                seeThatResponse("Validation Schema service",
                        response -> response.assertThat()
                                .body(matchesJsonSchemaInClasspath("schemas/"+structure+".json"))
                                .log().all()
                )
        );
        return true;
    }

    public static TheSchemaIs expected(String structure) {
        return new TheSchemaIs(structure);
    }
}
