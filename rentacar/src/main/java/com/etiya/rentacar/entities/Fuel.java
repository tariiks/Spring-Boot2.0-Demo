package com.etiya.rentacar.entities;

import com.etiya.rentacar.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity // Represents a table in the database
@Table(name = "fuels")

public class Fuel extends BaseEntity<Integer> {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "fuel") // Use @OneToMany(mappedBy ..) to List
    private List<Model> models;

}
