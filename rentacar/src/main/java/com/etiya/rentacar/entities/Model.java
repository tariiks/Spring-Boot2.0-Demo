package com.etiya.rentacar.entities;

import com.etiya.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity // Represents a table in the database
@Table(name = "models")

public class Model extends BaseEntity<Integer> {

    @Column(name = "name")
    private String name;

    @ManyToOne // An entity is related to multiple other entities
    @JoinColumn(name = "brandId")
    private Brand brand;

    @ManyToOne // An entity is related to multiple other entities
    @JoinColumn(name = "fuelId")
    private Fuel fuel;

    @ManyToOne // An entity is related to multiple other entities
    @JoinColumn(name = "transmissionId")
    private Transmission transmission;

    @OneToMany(mappedBy = "model") // Use @OneToMany(mappedBy ..) to List
    private List<Car> cars;

}
