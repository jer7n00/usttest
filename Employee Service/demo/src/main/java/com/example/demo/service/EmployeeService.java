package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.model.EmployeePojo;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    List<EmployeePojo> getAllEmployees();
    EmployeePojo getAEmployee(long empId);
    EmployeePojo addEmployee(EmployeePojo newDepPojo);
    EmployeePojo updateEmployee(EmployeePojo editDepPojo);
    List<EmployeeEntity> getAllEmployeesByDeptId(long deptId);
    void deleteEmployee(long empId);
}
