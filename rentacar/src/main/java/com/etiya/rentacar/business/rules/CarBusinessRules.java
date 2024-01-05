package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.business.messages.BrandMessages;
import com.etiya.rentacar.business.messages.CarMessages;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.dataAccess.abstracts.CarRepository;
import com.etiya.rentacar.entities.Car;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Service //Be sure to add service annotation to the business rule
public class CarBusinessRules {

    CarRepository carRepository;

    public void carNameCanNotBeDuplicate(String name){
        Optional<Car> car = carRepository.findByNameIgnoreCase(name);
        if (car.isPresent()){
            throw new BusinessException(CarMessages.carNameAlreadyExist);
        }
    }

}
