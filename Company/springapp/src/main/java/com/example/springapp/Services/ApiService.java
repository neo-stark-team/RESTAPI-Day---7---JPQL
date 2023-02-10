package com.example.springapp.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.Models.Employee;
import com.example.springapp.Repositories.EmployeeRepo;

@Service
public class ApiService {

    @Autowired
    public EmployeeRepo employeeRepo;

    public boolean addEmployee(Employee employee){
        return employeeRepo.save(employee) != null ? true : false;
    }

    public Employee getOneEmployee(int id){
        Optional<Employee> emp = employeeRepo.findById(id);
        if(emp.isPresent()){
            return emp.get();
        }else{
            return null;
        }
    }

    public List<Employee> getEmployeeByDepartment(String department){
        return employeeRepo.findEmployeeByDepartment(department);
    }

    public List<Employee> getEmployeesBySalaryHigher(int salary){
        return employeeRepo.findEmployeeBySalaryHigher(salary);
    }

    public List<Employee> getEmployeesBySalaryLower(int salary){
        return employeeRepo.findEmployeeBySalaryLower(salary);
    }
}
