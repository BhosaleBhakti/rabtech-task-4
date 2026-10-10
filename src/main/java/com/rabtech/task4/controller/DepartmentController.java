package com.rabtech.task4.controller;

import com.rabtech.task4.entity.Department;
import com.rabtech.task4.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentRepository repository;

    public DepartmentController(DepartmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Department> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Department create(@RequestBody Department department) {
        return repository.save(department);
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Department not found"));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "Department deleted successfully";
    }
}