package com.etiya.rentacar.business.dtos.responses;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CreatedModelResponse {

    private int id;
    private String name;
    private LocalDateTime createdDate;

}
