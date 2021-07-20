package com.ssscl.boot.oracle.springoraclecsv.runner;

import com.ssscl.boot.oracle.springoraclecsv.csv.CSVWriterService;
import com.ssscl.boot.oracle.springoraclecsv.dao.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class MainRunner implements CommandLineRunner {

    @Autowired
    DataService dataService;

    @Autowired
    CSVWriterService csvWriterService;

    @Override
    public void run(String... args) throws Exception {
        csvWriterService.write(dataService.getEmployees());

    }
}
