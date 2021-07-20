package com.ssscl.boot.oracle.springoraclecsv.dao;

import com.ssscl.boot.oracle.springoraclecsv.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String sql = "SELECT * FROM Employees";

    @Override
    public Employee getEmployee(int id) {
        final String sqlWithWhere = sql + " WHERE id=" + id;
        final List<Employee> employees = jdbcTemplate.query(sqlWithWhere,
                BeanPropertyRowMapper.newInstance(Employee.class));

        employees.forEach(System.out :: println);
        return employees!=null ? employees.get(0) : null;
    }

    @Override
    public List<Employee> getEmployees() {
        final List<Employee> employees = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Employee.class));

        employees.forEach(System.out :: println);
        return employees;
    }
}
