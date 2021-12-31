package com.weelo.postman.task;

import com.weelo.postman.utils.templates.MergeFrom;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;

public class Create implements Task {
    private final String templete;
    private final Map<String, String> clientData;

    public Create(String templete, Map<String, String> clientData) {
        this.templete = templete;
        this.clientData = clientData;
    }

    public static Create messageBody(String template, Map<String, Object> clientData) {
        return Tasks.instrumented(Create.class, template, clientData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String templatePath = String.format("templates/%s", templete);
        String body = MergeFrom.template(templatePath).withFieldsFrom(clientData);
        actor.remember("body", body);
    }
}
