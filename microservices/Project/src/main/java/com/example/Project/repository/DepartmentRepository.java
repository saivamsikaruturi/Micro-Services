package com.example.Project.repository;

import com.example.Project.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer>{
    Department findById(Long id);

    Department findByName(String name);
}

