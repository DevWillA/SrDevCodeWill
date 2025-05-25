package com.devsenior.will.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private Integer id;

    @Column(name = "department_name", length = 30, nullable = false)
    private String name;

    @Column(name = "location_id")
    private String locationId;

}
