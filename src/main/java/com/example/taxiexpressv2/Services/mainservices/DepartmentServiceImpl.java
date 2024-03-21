package com.example.taxiexpressv2.Services.mainservices;

import com.example.taxiexpressv2.Entities.Company;
import com.example.taxiexpressv2.Entities.Department;
import com.example.taxiexpressv2.Entities.Employee;
import com.example.taxiexpressv2.Repositories.CompanyRepository;
import com.example.taxiexpressv2.Repositories.DepartmentRepository;
import com.example.taxiexpressv2.Repositories.EmployeeRepository;
import com.example.taxiexpressv2.Services.mainservices.interfaces.iDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class DepartmentServiceImpl implements iDepartmentService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private DepartmentRepository departmentRepository;


   @Override
    public Department addDepartmentToCompany(Department d, int idCompany) {
        Company company= companyRepository.findById(idCompany).get();

        d.setCompany(company);
        departmentRepository.save(d);
        return d ;

    }
    public List<Department> retrieveDepartmentCompany(int idCompany){
       return departmentRepository.getDepartmentByCompany(idCompany);
    }
    public Optional<Department> retrieveDepartmentById(int idDep){
       return departmentRepository.findById(idDep);
    }

    @Transactional
    public void addDataFromCsv(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<Employee> entities = lines.stream()
                .map(line -> {
                    String[] parts = line.split(","); // Assuming CSV format
                    // Create and populate YourEntity object based on CSV structure
                    Employee employee = new Employee();
                    employee.setEmail(parts[0]);
                    employee.setFirstName(parts[1]);
                    employee.setLastName(parts[2]);
                    employee.setHomeAdress(parts[3]);

                    return employee;
                })
                .collect(Collectors.toList());
        employeeRepository.saveAll(entities);
    }



}

