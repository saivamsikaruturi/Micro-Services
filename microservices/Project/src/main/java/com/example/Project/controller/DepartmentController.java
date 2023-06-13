package com.example.Project.controller;

import com.example.Project.dto;
import com.example.Project.entity.Department;
import com.example.Project.repository.DepartmentRepository;
import com.example.Project.service.DepartmentService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
@Slf4j
@Log4j2
@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/saveDepartment")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long id) {
        log.info("Inside findByDepartment of DepartmentController");
        return departmentService.findDepartmentById(id);
    }

    @GetMapping("/byName/{name}")
    public Department findDepartmentByName(@PathVariable("name") String name) {

        return departmentService.findDepartmentByName(name);
    }

    @GetMapping("/findAll")
    public List<Department> findAll() {
        return departmentService.findAll ();
    }

    @PutMapping ("/update/{id}")
    @Transactional
    public Department updateDepartmentDetails(@PathVariable("id") Long id, @RequestBody Department departmentDetails){
        Department byId = departmentRepository.findById (id);
   Department department=new Department ();
//   byId.setId ((long)123);
        byId.setName ("test");
       byId.setAddress ("test");
        byId.setCode ("test");
        Department save = departmentRepository.save (byId);
        System.out.println (save);
        return save;
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDepartment(@PathVariable Long id){
       Department department = departmentRepository.findById(id);

       departmentRepository.delete(department);
        Map<String, Boolean> response = new HashMap<> ();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
