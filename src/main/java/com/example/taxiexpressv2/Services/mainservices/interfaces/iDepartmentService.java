package com.example.taxiexpressv2.Services.mainservices.interfaces;

import com.example.taxiexpressv2.Entities.Company;
import com.example.taxiexpressv2.Entities.Department;

import java.io.IOException;
import java.util.Optional;

public interface iDepartmentService {

    public Department  addDepartmentToCompany(Department d , int idCompany);
    public Optional<Department> retrieveDepartmentById(int idDep);
    public void addDataFromCsv(String filePath) throws IOException;
}
