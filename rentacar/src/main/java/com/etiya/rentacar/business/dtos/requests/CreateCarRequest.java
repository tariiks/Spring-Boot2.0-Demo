package com.etiya.rentacar.business.dtos.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CreateCarRequest {

    @NotNull
    private int state;
    @NotNull
    @Size(min = 2,max = 30)
    private String name;
    @NotNull
    private String plate;
    @NotNull
    private double dailyPrice;
    @NotNull
    private int modelYear;
    @NotNull
    private int brandId;
    @NotNull
    private int modelId;
    @NotNull
    private int fuelId;
    @NotNull
    private int transmissionId;

}
