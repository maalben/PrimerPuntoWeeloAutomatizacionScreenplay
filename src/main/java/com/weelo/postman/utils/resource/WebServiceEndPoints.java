package com.weelo.postman.utils.resource;

import com.weelo.postman.utils.constants.Endpoints;

public enum WebServiceEndPoints {
    GET(Endpoints.URL_GET_SERVICE),
    ABC(Endpoints.URL_ABC_SERVICE),
    POST(Endpoints.URL_POST_SERVICE);

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
