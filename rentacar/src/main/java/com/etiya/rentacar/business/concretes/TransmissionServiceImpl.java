package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.TransmissionService;
import com.etiya.rentacar.business.dtos.requests.CreateTransmissionRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedTransmissionResponse;
import com.etiya.rentacar.business.dtos.responses.GetAllTransmissionResponse;
import com.etiya.rentacar.business.rules.TransmissionBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.etiya.rentacar.entities.Transmission;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Service // Added service annotation
public class TransmissionServiceImpl implements TransmissionService {

    TransmissionRepository transmissionRepository;
    ModelMapperService modelMapperService;
    TransmissionBusinessRules transmissionBusinessRules;

    @Override
    public CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest) {
        transmissionBusinessRules.transmissionNameCanNotBeDuplicate(createTransmissionRequest.getName());
        Transmission transmission = modelMapperService.forRequest().map(createTransmissionRequest,Transmission.class);
        Transmission createdTransmission = transmissionRepository.save(transmission); // save from JpaRepo
        CreatedTransmissionResponse createdTransmissionResponse = modelMapperService.forResponse().map(createdTransmission,CreatedTransmissionResponse.class);
        return createdTransmissionResponse;
    }

    @Override
    public List<GetAllTransmissionResponse> getAll() {
        var result = transmissionRepository.findAll(); // findAll from JpaRepo
        List<GetAllTransmissionResponse> responses = result.stream().map(transmission -> modelMapperService.forResponse().map(result,GetAllTransmissionResponse.class)).collect(Collectors.toList());
        return responses;
    }
}
