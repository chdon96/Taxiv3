package com.example.taxiexpressv2.Repositories;

import com.example.taxiexpressv2.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
// Define MySQL DataSource 1 specific queries here




//@Repository
//public interface MySQLRepository2 extends JpaRepository<YourEntity, Long> {
    // Define MySQL DataSource 2 specific queries here
}