package com.etiya.rentacar.business.dtos.responses;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CreatedMaintenanceResponse {

    private int id;

    private int carId;

    private LocalDateTime createdDate;

}
