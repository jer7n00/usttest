package com.example.demo.service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.model.EmployeePojo;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository empRepo;
    public EmployeeServiceImpl(EmployeeRepository empRepo)
    {
        this.empRepo=empRepo;
    }
    @Override
    public List<EmployeePojo> getAllEmployees() {
        List<EmployeeEntity> allEmpEntity = empRepo.findAll();
        List<EmployeePojo> allempPojo = new ArrayList<>();
        allEmpEntity.stream().forEach((eachEmpEntity)-> {
            EmployeePojo empPojo = new EmployeePojo();
            BeanUtils.copyProperties(eachEmpEntity, empPojo);
            allempPojo.add(empPojo);
        });
        return allempPojo;
    }

    @Override
    public EmployeePojo getAEmployee(long empId) {
        Optional<EmployeeEntity> fetchempEntity = empRepo.findById(empId);
        EmployeePojo empPojo = null;
        if(fetchempEntity.isPresent()) {
            empPojo = new EmployeePojo();
            BeanUtils.copyProperties(fetchempEntity.get(),empPojo);
        }
    return empPojo;
    }


    @Override
    public EmployeePojo addEmployee(EmployeePojo newDepPojo) {
        EmployeeEntity empEnti = new EmployeeEntity();
        BeanUtils.copyProperties(newDepPojo,empEnti);
        empRepo.saveAndFlush(empEnti);
        return newDepPojo;

    }

    @Override
    public EmployeePojo updateEmployee(EmployeePojo editDepPojo) {
        EmployeeEntity empEnti = new EmployeeEntity();
        BeanUtils.copyProperties(editDepPojo,empEnti);
       empRepo.saveAndFlush(empEnti);
        return editDepPojo;
    }

    @Override
    public void deleteEmployee(long empId) {
        empRepo.deleteById(empId);}

        public List<EmployeeEntity> getAllEmployeesByDeptId(long deptId) {
            //return empRepo.findByDeptId(deptId);
            List<EmployeeEntity> allEmpbyIdEntity = empRepo.findBydeptId(deptId);
//            List<EmployeePojo> allempbyIdPojo = new ArrayList<>();
//            allEmpbyIdEntity.stream().forEach((eachEmpEntity)-> {
//                EmployeePojo empPojo = new EmployeePojo();
//                BeanUtils.copyProperties(eachEmpEntity, empPojo);
//                allempbyIdPojo.add(empPojo);
//            });
            return allEmpbyIdEntity;


    }
}
