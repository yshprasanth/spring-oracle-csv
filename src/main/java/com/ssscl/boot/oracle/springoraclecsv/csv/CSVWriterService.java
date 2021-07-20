package com.ssscl.boot.oracle.springoraclecsv.csv;

import com.ssscl.boot.oracle.springoraclecsv.domain.Employee;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CSVWriterService {

    @Value("${csv.file.name}:employees")
    private String fileName;

    private final static String fileExtn = ".csv";

    public void write(List<Employee> employees) throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName +
                        System.currentTimeMillis() + fileExtn));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("Id", "Name", "Age", "Salary", "DeptId"));
        ) {
            csvPrinter.printRecords(employees);
            csvPrinter.flush();
        }
    }
}
