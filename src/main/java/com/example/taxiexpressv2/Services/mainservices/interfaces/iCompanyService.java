package com.example.taxiexpressv2.Services.mainservices.interfaces;

import com.example.taxiexpressv2.Entities.Company;
import com.example.taxiexpressv2.Entities.Taxi;
import com.example.taxiexpressv2.Services.BaseServiceInterface;

import java.util.Optional;

public interface iCompanyService extends BaseServiceInterface<Company, Integer> {
    Optional<Company> retrieveCompany(Integer idCompany);

}
