package com.ssscl.boot.oracle.springoraclecsv.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private int deptId;
}
