package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.CreateCarRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.GetAllCarResponse;
import com.etiya.rentacar.entities.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    CreatedCarResponse add(CreateCarRequest createCarRequest);
    List<GetAllCarResponse> getAll();

}
