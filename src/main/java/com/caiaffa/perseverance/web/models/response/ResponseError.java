package com.caiaffa.perseverance.web.models.response;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Arrays;
import java.util.List;

public class ResponseError {

    private String message;
    private Object errors;

    public ResponseError() {
        super();
    }

    public ResponseError(final String message, final List<String> errors) {
        super();
        this.message = message;
        this.errors = errors;
    }

    public ResponseError(final String message, final String error) {
        super();
        this.message = message;
        errors = List.of(error);
    }

    public ResponseError(final String message, final JsonNode error) {
        super();
        this.message = message;
        errors = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return (List<String>) errors;
    }

    public void setErrors(final List<String> errors) {
        this.errors = errors;
    }

    public void setError(final String error) {
        errors = List.of(error);
    }

}
