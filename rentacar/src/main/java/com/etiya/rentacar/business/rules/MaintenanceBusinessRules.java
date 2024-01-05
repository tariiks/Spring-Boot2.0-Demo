package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.dataAccess.abstracts.CarRepository;
import com.etiya.rentacar.entities.Car;
import lombok.*;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@NoArgsConstructor
@Data

@Service // Be sure to add service annotation to the business rule
public class MaintenanceBusinessRules {

    CarRepository carRepository;
    public void carShouldBeAvailableToSentToMaintenance(int carId){
        Car car = carRepository.getById(carId);
        if (car.getState() != 1){
            throw new RuntimeException("There is no available car!");
        }
    }
}
