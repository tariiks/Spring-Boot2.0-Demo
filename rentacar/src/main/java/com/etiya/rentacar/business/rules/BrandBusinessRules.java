package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.business.messages.BrandMessages;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentacar.entities.Brand;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Service // Be sure to add service annotation to the business rule
public class BrandBusinessRules {

    BrandRepository brandRepository;

    public void brandNameCanNotBeDuplicate(String name){
        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(name);
        if (brand.isPresent()){
            throw new BusinessException(BrandMessages.brandNameAlreadyExist);
        }
    }
}
