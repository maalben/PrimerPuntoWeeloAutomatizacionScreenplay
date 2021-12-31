package com.weelo.postman.questions;

import com.weelo.postman.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class TheGetService implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        actor.should(seeThatResponse("Get service API is Success",
                response -> response
                        .assertThat()
                        .body("args.test", equalTo(TestData.getData().get("test")))
                        .and()
                        .body("args.other", equalTo(TestData.getData().get("other")))
                        .log().all()
        ));
        return "success";
    }

    public static TheGetService response() {
        return new TheGetService();
    }
}
