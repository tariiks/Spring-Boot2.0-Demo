package com.etiya.rentacar.api.controller;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.dtos.requests.CreateCarRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.GetAllCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cars")
public class CarsController {

    CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreatedCarResponse add(CreateCarRequest createCarRequest){
        return carService.add(createCarRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<GetAllCarResponse> getAll(){
        return carService.getAll();
    }
}
