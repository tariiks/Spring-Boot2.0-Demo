package com.etiya.rentacar.business.dtos.responses;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CreatedCarResponse {

    private int id;
    private String name;
    private int state;
    private String plate;
    private double dailyPrice;
    private int modelYear;
    private String brandName;
    private String modelName;
    private String fuelName;
    private String transmissionName;
    private LocalDateTime createdDate;

}
