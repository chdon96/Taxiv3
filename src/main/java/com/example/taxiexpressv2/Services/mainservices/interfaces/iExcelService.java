package com.example.taxiexpressv2.Services.mainservices.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface iExcelService {
    public void readEmployeesFromExcel(MultipartFile file);
}
