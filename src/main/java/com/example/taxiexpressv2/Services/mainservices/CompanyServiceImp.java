package com.example.taxiexpressv2.Services.mainservices;

import com.example.taxiexpressv2.Entities.Company;
import com.example.taxiexpressv2.Entities.Taxi;
import com.example.taxiexpressv2.Repositories.CompanyRepository;
import com.example.taxiexpressv2.Services.mainservices.interfaces.iCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImp implements iCompanyService {
    @Autowired
    CompanyRepository companyRepository;


    @Override
    public List<Company> retrieveAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company add(Company e) {
        return companyRepository.save(e);
    }

    @Override
    public Company update(Company e) {
      return companyRepository.save(e);
    }

    @Override
    public Company retrieve(Integer integer) {
        return null;
    }

    @Override
    public Optional<Company> retrieveCompany(Integer idCompany) {
        return companyRepository.findById(idCompany);
    }

    @Override
    public void remove(Integer idCompany) {
       // Company c = companyRepository.findById(idCompany);
        //c.setStatus(False);
    }


}
