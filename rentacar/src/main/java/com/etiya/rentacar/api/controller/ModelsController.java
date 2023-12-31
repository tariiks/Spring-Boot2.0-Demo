package com.etiya.rentacar.api.controller;

import com.etiya.rentacar.business.abstracts.ModelService;
import com.etiya.rentacar.business.dtos.requests.CreateModelRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedModelResponse;
import com.etiya.rentacar.business.dtos.responses.GetAllModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/models")
public class ModelsController {

    ModelService modelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreatedModelResponse add(CreateModelRequest createModelRequest){
        return modelService.add(createModelRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<GetAllModelResponse> getAll(){
        return modelService.getAll();
    }
}
