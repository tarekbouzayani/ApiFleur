package com.fleur.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "fleurs")
public class Fleur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

}
