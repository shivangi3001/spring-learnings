package com.springrest.app.entity;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    private Integer id;
    private String name;
    private String course;
    
    private Address address;

}
