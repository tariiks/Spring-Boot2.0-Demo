package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.MaintenanceService;
import com.etiya.rentacar.business.dtos.requests.CreateMaintenanceRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedMaintenanceResponse;
import com.etiya.rentacar.business.rules.MaintenanceBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.MaintenanceRepository;
import com.etiya.rentacar.entities.Maintenance;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Service // Added service annotation
public class MaintenanceServiceImpl implements MaintenanceService {


    private MaintenanceRepository maintenanceRepository;
    private ModelMapperService modelMapperService;
    private MaintenanceBusinessRules maintenanceBusinessRules;

    @Override
    public CreatedMaintenanceResponse add(CreateMaintenanceRequest createMaintenanceRequest) {

        maintenanceBusinessRules.carShouldBeAvailableToSentToMaintenance(createMaintenanceRequest.getCarId());
        Maintenance maintenance = modelMapperService.forRequest().map(createMaintenanceRequest,Maintenance.class);
        maintenance.setCreatedDate(LocalDateTime.now());
        maintenance.setDateSent(LocalDateTime.now());
        Maintenance createdMaintenance = maintenanceRepository.save(maintenance); // save from JpaRepo
        CreatedMaintenanceResponse createdMaintenanceResponse = modelMapperService.forResponse().map(createdMaintenance,CreatedMaintenanceResponse.class);
        return createdMaintenanceResponse;
    }

}
