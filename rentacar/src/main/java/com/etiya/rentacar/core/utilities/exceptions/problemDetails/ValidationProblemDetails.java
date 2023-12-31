package com.etiya.rentacar.core.utilities.exceptions.problemDetails;

import lombok.Data;

import java.util.Map;

@Data
public class ValidationProblemDetails extends ProblemDetails{
    public ValidationProblemDetails() {
        setTitle("Validation Rule Violation");
        setDetail("Validation Problem");
        setType("https://mydomain.com/exceptions/validation");
        setStatus("500");
    }

    private Map<String,String> errors;

}
