package com.example.taxiexpressv2.Services.mainservices;

import com.example.taxiexpressv2.Entities.Employee;
import com.example.taxiexpressv2.Services.mainservices.interfaces.iExcelService;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class ExcelService  implements iExcelService {

    public void readEmployeesFromExcel(MultipartFile file) {
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                // Assuming each row contains data for an employee, adjust as needed
                String firstName = row.getCell(0).getStringCellValue();
                String lastName = row.getCell(1).getStringCellValue();
                String email = row.getCell(2).getStringCellValue();
                String phoneNumber = row.getCell(3).getStringCellValue();
                String password = row.getCell(3).getStringCellValue();
                // Add more fields as needed

                // Create Employee object or process the data accordingly
                Employee employee = new Employee(firstName, lastName, email, phoneNumber, password);

                // Do something with the employee data (e.g., save to database)
                System.out.println(employee);
            }
        } catch (IOException | EncryptedDocumentException e) {
            e.printStackTrace();
            // Handle exception as needed
        }
    }

}
