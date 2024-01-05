package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.CreateMaintenanceRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedMaintenanceResponse;

public interface MaintenanceService {

    // Add Maintenance -> A vehicle under maintenance or a vehicle on rent cannot be sent to the service.
    // BI: CarService

    CreatedMaintenanceResponse add(CreateMaintenanceRequest createMaintenanceRequest);
}
