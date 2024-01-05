package com.etiya.rentacar.entities;

import com.etiya.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity // Represents a table in the database
@Table(name = "transmissions")

public class Transmission extends BaseEntity<Integer>{

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "transmission") // Use @OneToMany(mappedBy ..) to List
    private List<Model> models;

}
