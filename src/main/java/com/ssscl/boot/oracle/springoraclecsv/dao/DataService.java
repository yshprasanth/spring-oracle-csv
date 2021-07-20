package com.ssscl.boot.oracle.springoraclecsv.dao;

import com.ssscl.boot.oracle.springoraclecsv.domain.Employee;

import java.util.List;

public interface DataService {
    Employee getEmployee(final int id);
    List<Employee> getEmployees();
}
