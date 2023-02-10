package com.example.springapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.Models.Employee;
import com.example.springapp.Services.ApiService;

@RestController
public class ApiController {
    @Autowired
    public ApiService apiService;

    @PostMapping("/")
    public boolean addEmployee(@RequestBody Employee employee){
        return apiService.addEmployee(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getOneEmployee(@PathVariable int id){
        return apiService.getOneEmployee(id);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getEmployeeByDepartmentAndRoll(@PathVariable String department){
        return apiService.getEmployeeByDepartment(department);
    }

    @GetMapping("/salary/{salary}/high")
    public List<Employee> getEmployeeBySalaryHigher(@PathVariable int salary){
        return apiService.getEmployeesBySalaryHigher(salary);
    }

    @GetMapping("/salary/{salary}/low")
    public List<Employee> getEmployeeBySalaryLower(@PathVariable int salary){
        return apiService.getEmployeesBySalaryLower(salary);
    }
}
