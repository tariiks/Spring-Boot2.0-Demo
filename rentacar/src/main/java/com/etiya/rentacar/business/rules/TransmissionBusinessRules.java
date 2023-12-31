package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.business.messages.TransmissionMessages;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.etiya.rentacar.entities.Transmission;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Service //Be sure to add service annotation to the business rule
public class TransmissionBusinessRules {

    TransmissionRepository transmissionRepository;

    public void transmissionNameCanNotBeDuplicate(String name){
        Optional<Transmission> transmission = transmissionRepository.findByNameIgnoreCase(name);
        if (transmission.isPresent()){
            throw new BusinessException(TransmissionMessages.transmissionNameAlreadyExist);
        }
    }
}
