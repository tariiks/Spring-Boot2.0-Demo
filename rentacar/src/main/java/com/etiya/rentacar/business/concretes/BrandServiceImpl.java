package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.BrandService;
import com.etiya.rentacar.business.dtos.requests.CreateBrandRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.GetAllBrandResponse;
import com.etiya.rentacar.business.rules.BrandBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentacar.entities.Brand;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Service // Added service annotation
public class BrandServiceImpl implements BrandService {

    BrandRepository brandRepository;
    ModelMapperService modelMapperService;
    BrandBusinessRules brandBusinessRules;

    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.brandNameCanNotBeDuplicate(createBrandRequest.getName());
        Brand brand =modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        Brand createdBrand = brandRepository.save(brand); // save from JpaRepo
        CreatedBrandResponse createdBrandResponse = modelMapperService.forResponse().map(createdBrand,CreatedBrandResponse.class);
        return createdBrandResponse;
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        var result = brandRepository.findAll(); // findAll from JpaRepo
        List<GetAllBrandResponse> responses = result.stream().map(brand -> modelMapperService.forResponse().map(brand,GetAllBrandResponse.class)).collect(Collectors.toList());
        return responses;
    }
}
