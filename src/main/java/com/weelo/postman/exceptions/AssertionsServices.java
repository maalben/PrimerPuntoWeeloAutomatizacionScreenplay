package com.weelo.postman.exceptions;

public class AssertionsServices extends AssertionError {

    private static final long serialVersionUID = 1L;

    public static final String THE_GET_SERVICE_IS_NOT_EXPECTED = "The get services response is not expected";
    public static final String THE_GET_SERVICE_WITH_MULTIPLES_PARAMETERS_IS_NOT_EXPECTED = "The get services response" +
            " with multiples parameters is not expected";
    public static final String THE_STATUS_CODE_GET_SERVICE_IS_NOT_EXPECTED = "The status code get services response is not expected";
    public static final String THE_FIELDS_GET_SERVICE_IS_NOT_EXPECTED = "The fields get services response is not expected";
    public static final String SCHEMA_SERVICE_IS_NOT_EXPECTED = "Schema service response is not expected";
    public static final String QUANTITY_FIELDS_SERVICE_IS_NOT_EXPECTED = "Quantity fields services is not expected";
    public static final String THE_GET_SERVICE_WITHOUT_PARAMETERS_IS_NOT_EXPECTED = "The get services without parameters response is not expected";
    public static final String THE_POST_SERVICE_IS_NOT_EXPECTED = "The post services response is not expected";
    public static final String THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED = "The status code services response is not " +
            "expected";
    public static final String THE_FIELDS_POST_SERVICE_IS_NOT_EXPECTED = "The fields post services response is not " +
            "expected";
    public static final String THE_FIELDS_AND_VALUES_POST_SERVICE_IS_NOT_EXPECTED = "The fields and values post " +
            "services response is not expected";



    public AssertionsServices(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionsServices(String message) {
        super(message);
    }

}
