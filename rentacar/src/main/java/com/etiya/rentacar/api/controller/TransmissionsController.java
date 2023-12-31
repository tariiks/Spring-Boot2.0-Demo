package com.etiya.rentacar.api.controller;

import com.etiya.rentacar.business.abstracts.TransmissionService;
import com.etiya.rentacar.business.dtos.requests.CreateTransmissionRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedTransmissionResponse;
import com.etiya.rentacar.business.dtos.responses.GetAllTransmissionResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/transmissions")
public class TransmissionsController {

    TransmissionService transmissionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest){
        return transmissionService.add(createTransmissionRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<GetAllTransmissionResponse> getAll(){
        return transmissionService.getAll();
    }
}
