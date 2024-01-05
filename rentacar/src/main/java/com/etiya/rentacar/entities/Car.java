package com.etiya.rentacar.entities;

import com.etiya.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity // Represents a table in the database
@Table(name = "cars")

public class Car extends BaseEntity<Integer> {

    @Column(name = "state")
    private int state;

    @Column(name = "name")
    private String name;

    @Column(name = "plate")
    private String plate;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "modelYear")
    private int modelYear;

    @ManyToOne // An entity is related to multiple other entities
    @JoinColumn(name = "brandId")
    private Brand brand;

    @ManyToOne // An entity is related to multiple other entities
    @JoinColumn(name = "modelId")
    private Model model;

    @ManyToOne // An entity is related to multiple other entities
    @JoinColumn(name = "fuelId")
    private Fuel fuel;

    @ManyToOne // An entity is related to multiple other entities
    @JoinColumn(name = "transmissionId")
    private Transmission transmission;

    @OneToMany(mappedBy = "car") // Use @OneToMany(mappedBy ..) to List
    private List<Maintenance> maintenances;

}
