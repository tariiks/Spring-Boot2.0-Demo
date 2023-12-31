package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.FuelService;
import com.etiya.rentacar.business.dtos.requests.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedFuelResponse;
import com.etiya.rentacar.business.dtos.responses.GetAllFuelResponse;
import com.etiya.rentacar.business.rules.FuelBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.FuelRepository;
import com.etiya.rentacar.entities.Fuel;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Service // Added service annotation
public class FuelServiceImpl implements FuelService {

    FuelRepository fuelRepository;
    ModelMapperService modelMapperService;
    FuelBusinessRules fuelBusinessRules;

    @Override
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest) {
        fuelBusinessRules.fuelNameCanNotBeDuplicate(createFuelRequest.getName());
        Fuel fuel = modelMapperService.forRequest().map(createFuelRequest,Fuel.class);
        Fuel createdFuel = fuelRepository.save(fuel); // save from JpaRepo
        CreatedFuelResponse createdFuelResponse = modelMapperService.forResponse().map(createdFuel,CreatedFuelResponse.class);
        return createdFuelResponse;
    }

    @Override
    public List<GetAllFuelResponse> getAll() {
        var result = fuelRepository.findAll(); // findAll from JpaRepo
        List<GetAllFuelResponse> responses = result.stream().map(fuel -> modelMapperService.forResponse().map(fuel, GetAllFuelResponse.class)).collect(Collectors.toList());
        return responses;
    }
}
