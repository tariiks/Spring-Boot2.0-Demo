package com.etiya.rentacar.core.utilities.exceptions.problemDetails;

import lombok.Data;

@Data
public class BusinessProblemDetails extends ProblemDetails{

    public BusinessProblemDetails(){
        setTitle("Business Rule Violation");
        setDetail("Business Problem");
        setType("https://mydomain.com/exceptions/business");
        setStatus("400");
    }
}
