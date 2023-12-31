package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.ModelService;
import com.etiya.rentacar.business.dtos.requests.CreateModelRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedModelResponse;
import com.etiya.rentacar.business.dtos.responses.GetAllModelResponse;
import com.etiya.rentacar.business.rules.ModelBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.ModelRepository;
import com.etiya.rentacar.entities.Model;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Service // Added service annotation
public class ModelServiceImpl implements ModelService{

    ModelRepository modelRepository;
    ModelMapperService modelMapperService;
    ModelBusinessRules modelBusinessRules;

    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        modelBusinessRules.modelNameCanNotBeDuplicate(createModelRequest.getName());
        Model model = modelMapperService.forRequest().map(createModelRequest,Model.class);
        Model createdModel = modelRepository.save(model); // save from JpaRepo
        CreatedModelResponse createdModelResponse = modelMapperService.forResponse().map(createdModel,CreatedModelResponse.class);
        return createdModelResponse;
    }

    @Override
    public List<GetAllModelResponse> getAll() {
        var result = modelRepository.findAll(); // findAll from JpaRepo
        List<GetAllModelResponse> responses = result.stream().map(model -> modelMapperService.forResponse().map(model, GetAllModelResponse.class)).collect(Collectors.toList());
        return responses;
    }
}
