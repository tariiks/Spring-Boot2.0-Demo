package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.dtos.requests.CreateCarRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.GetAllCarResponse;
import com.etiya.rentacar.business.rules.CarBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.CarRepository;
import com.etiya.rentacar.entities.Car;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Service // Added service annotation
public class CarServiceImpl implements CarService {

    CarRepository carRepository;
    ModelMapperService modelMapperService;
    CarBusinessRules carBusinessRules;

    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {
        carBusinessRules.carNameCanNotBeDuplicate(createCarRequest.getName());
        Car car = modelMapperService.forResponse().map(createCarRequest,Car.class);
        Car createdCar = carRepository.save(car); // save from JpaRepo
        CreatedCarResponse createdCarResponse = modelMapperService.forResponse().map(createdCar,CreatedCarResponse.class);
        return createdCarResponse;
    }

    @Override
    public List<GetAllCarResponse> getAll() {
        var result = carRepository.findAll(); // findAll from JpaRepo
        List<GetAllCarResponse> responses = result.stream().map(car -> modelMapperService.forResponse().map(car, GetAllCarResponse.class)).collect(Collectors.toList());
        return responses;
    }
}
