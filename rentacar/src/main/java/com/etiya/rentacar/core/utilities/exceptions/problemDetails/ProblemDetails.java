package com.etiya.rentacar.core.utilities.exceptions.problemDetails;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProblemDetails {

    // R.F.C.E. standard
    private String title;
    private String detail;
    private String Status;
    private String Type;

}

