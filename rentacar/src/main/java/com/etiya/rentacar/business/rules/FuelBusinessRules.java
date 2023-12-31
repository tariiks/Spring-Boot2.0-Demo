package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.business.messages.FuelMessages;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.dataAccess.abstracts.FuelRepository;
import com.etiya.rentacar.entities.Fuel;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Service //Be sure to add service annotation to the business rule
public class FuelBusinessRules {

    FuelRepository fuelRepository;

    public void fuelNameCanNotBeDuplicate(String name){
        Optional<Fuel> fuel = fuelRepository.findByNameIgnoreCase(name);
        if (fuel.isPresent()){
            throw new BusinessException(FuelMessages.fuelNameAlreadyExist);
        }
    }
}
