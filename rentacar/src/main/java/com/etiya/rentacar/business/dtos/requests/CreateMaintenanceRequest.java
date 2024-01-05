package com.etiya.rentacar.business.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CreateMaintenanceRequest {

    @NotNull
    private int carId;

}
