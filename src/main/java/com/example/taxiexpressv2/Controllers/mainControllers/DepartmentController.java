package com.example.taxiexpressv2.Controllers.mainControllers;

import com.example.taxiexpressv2.Entities.Company;
import com.example.taxiexpressv2.Entities.Department;
import com.example.taxiexpressv2.Services.mainservices.ExcelService;
import com.example.taxiexpressv2.Services.mainservices.interfaces.iDepartmentService;
import com.example.taxiexpressv2.Services.mainservices.interfaces.iExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/Department")
public class DepartmentController {
    @Autowired
    private iExcelService excelService;
    @Autowired
    private iDepartmentService departmentService;
    @PostMapping("/uploadExcel")
    public void uploadExcelFile(@RequestParam("file") MultipartFile file) {
        excelService.readEmployeesFromExcel(file);
    }
    @PostMapping("/addDepartment/{idCompany}")
    private Department addDepartment(@RequestBody Department d, @PathVariable("idCompany") Integer idCompany){
        departmentService.addDepartmentToCompany( d,idCompany )  ;
    return  d;
    }
    @GetMapping("get-department/{id}")
    public ResponseEntity getDepartment(@PathVariable int id) {
        System.out.println("ID"+id);

        Optional<Department> department = departmentService.retrieveDepartmentById(id) ;
        return new ResponseEntity<>(department, HttpStatus.CREATED);

    }


}
