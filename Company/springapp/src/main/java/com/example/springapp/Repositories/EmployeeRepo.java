package com.example.springapp.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springapp.Models.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

    @Query(value = "SELECT * FROM Employee u WHERE u.department = ?1", nativeQuery = true)
    public List<Employee> findEmployeeByDepartment(String department);

    @Query(value = "SELECT * FROM Employee u WHERE u.salary >= ?1", nativeQuery = true)
    public List<Employee> findEmployeeBySalaryHigher(int salary);

    @Query(value = "SELECT * FROM Employee u WHERE u.salary <= ?1", nativeQuery = true)
    public List<Employee> findEmployeeBySalaryLower(int salary);

}
