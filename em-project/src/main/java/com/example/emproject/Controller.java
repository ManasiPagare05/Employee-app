package com.example.emproject;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins={"http://localhost:3000/","http://employee-app-react.s3-website.ap-south-1.amazonaws.com/"})
public class Controller {
//    List<Employee> employees=new ArrayList<>();
    //EmployeeService emp=new EmployeeServiceImp() ;

    //Dependency injection
    @Autowired
    EmployeeService emp ;

    @GetMapping("/employees/test")
    public String test(){
        return "Welcome to backend api";
    }

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return emp.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeesById(@PathVariable Long id){
        return emp.readEmployee(id);

    }
    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee){
        return emp.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(emp.deleteEmployee(id)){
            return "Deleted Successfully";
        }else {
            return "Deletion UnSuccessful";
        }
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        return emp.updateEmployee(id,employee);
    }
}
