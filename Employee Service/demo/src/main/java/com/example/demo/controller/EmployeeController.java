package com.example.demo.controller;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.model.EmployeePojo;
import com.example.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    EmployeeService empService;
    public static final Logger LOG= LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    public EmployeeController(EmployeeService empService)
    {
        this.empService=empService;
    }

    @GetMapping("/employees")
    public List<EmployeePojo> getAllEmployees(){
        LOG.info("in getAllemployee()");
        return empService.getAllEmployees();}

    @GetMapping("/employees/{id}")
    public EmployeePojo getAEmployee (@PathVariable("id") long empId)
    {
        LOG.info("in getAemployee()");
        return empService.getAEmployee(empId);

    }

    @PostMapping("/employees")
    public EmployeePojo addEmployee(@RequestBody EmployeePojo newemp)
    {
        LOG.info("in addemployee()");
        return empService.addEmployee(newemp);
    }

    @PutMapping("/employees")
    public EmployeePojo updateEmployee(@RequestBody EmployeePojo editemp)
    {
        LOG.info("in updateemployee()");
        return empService.updateEmployee(editemp);
    }

    @DeleteMapping("/employees/{id}")
    public void removeEmployee(@PathVariable("id") long empId)
    {

        LOG.info("in deleteemployee()");
        empService.deleteEmployee(empId);
    }

    @GetMapping("/employees/departments/{did}")
    public List<EmployeeEntity> getAllEmployeesByDepartment(@PathVariable long did){
        return empService.getAllEmployeesByDeptId(did);
    }
}


