package com.etiya.rentacar.entities;

import com.etiya.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "maintenance")

public class Maintenance extends BaseEntity<Integer> {

    @Column(name = "dateSent")
    private LocalDateTime dateSent;

    @Column(name = "dataReturned")
    private LocalDateTime dataReturned;

    @ManyToOne // An entity is related to multiple other entities
    @JoinColumn(name = "carId")
    private Car car;

}
