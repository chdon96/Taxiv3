package com.example.taxiexpressv2.Controllers.mainControllers;

import com.example.taxiexpressv2.Entities.Company;
import com.example.taxiexpressv2.Entities.Taxi;
import com.example.taxiexpressv2.Repositories.CompanyRepository;
import com.example.taxiexpressv2.Repositories.TaxiRepository;
import com.example.taxiexpressv2.Services.mainservices.interfaces.iCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private iCompanyService companyService;

    @Autowired
    private CompanyRepository companyRepository;


    @PostMapping("/addCompany")
    private Company addCompany(@RequestBody Company company){
        System.out.println(company);
        companyService.add(company);
        //taxi.setCreatedAt();
        return company;
    }
    @GetMapping("get-Companies")
    public ResponseEntity getAllEvents() {
        List<Company> allcompanies = companyService.retrieveAll();
        return new ResponseEntity<>(allcompanies, HttpStatus.CREATED);
    }
    @GetMapping("getcompany/{id}")
    public ResponseEntity retrieveCompany(@PathVariable int id){

        System.out.println("ID"+id);
        Optional<Company> company = companyService.retrieveCompany(id);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }
}
