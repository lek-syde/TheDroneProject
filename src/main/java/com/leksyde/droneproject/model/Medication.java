package com.leksyde.droneproject.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@Entity
public class Medication extends AbstractEntity{


    @Pattern(regexp = "^[A-Za-z0-9_-]*$")
    String name;
    double weight;

    @Pattern(regexp = "/^[A-Z]*$/0-9_")
    String code;

    @NotNull
    @Lob
    String image;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Drone drone;



}
