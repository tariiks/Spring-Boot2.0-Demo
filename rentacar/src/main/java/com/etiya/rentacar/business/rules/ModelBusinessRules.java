package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.business.messages.ModelMessages;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.dataAccess.abstracts.ModelRepository;
import com.etiya.rentacar.entities.Model;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Service //Be sure to add service annotation to the business rule
public class ModelBusinessRules {

    ModelRepository modelRepository;

    public void modelNameCanNotBeDuplicate(String name){
        Optional<Model> model = modelRepository.findByNameIgnoreCase(name);
        if (model.isPresent()){
            throw new BusinessException(ModelMessages.modelNameAlreadyExist);
        }
    }
}
