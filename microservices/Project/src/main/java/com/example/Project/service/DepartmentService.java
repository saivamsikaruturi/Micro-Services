package com.example.Project.service;

import com.example.Project.entity.Department;
import com.example.Project.repository.DepartmentRepository;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@Slf4j
@Log4j2
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department){
        log.info("Inside saveDepartment method of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long id) {
        log.info("Inside findDepartmentById method of DepartmentService");
        return departmentRepository.findById(id);
    }

    public Department findDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll ();
    }
}
