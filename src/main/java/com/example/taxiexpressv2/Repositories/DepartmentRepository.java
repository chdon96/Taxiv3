package com.example.taxiexpressv2.Repositories;

import com.example.taxiexpressv2.Entities.Department;
import com.example.taxiexpressv2.Repositories.usr.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository  extends BaseRepository<Department, Integer> {
    @Query(value = "SELEC T * FROM Department d WHERE d.company_id_company = :idCompany",
            nativeQuery = true)
    List<Department> getDepartmentByCompany(@Param("idCompany") int idCompany);
}
