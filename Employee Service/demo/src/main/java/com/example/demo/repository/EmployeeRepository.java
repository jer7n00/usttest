package com.example.demo.repository;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.model.EmployeePojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findBydeptId(long deptId);
}
